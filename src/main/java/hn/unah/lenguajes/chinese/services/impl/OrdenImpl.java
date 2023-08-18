package hn.unah.lenguajes.chinese.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Cliente;
import hn.unah.lenguajes.chinese.models.Contenido_orden;
import hn.unah.lenguajes.chinese.models.Empleados;
import hn.unah.lenguajes.chinese.models.Estado_orden;
import hn.unah.lenguajes.chinese.models.Estados_mesa;
import hn.unah.lenguajes.chinese.models.Factura;
import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.models.Mesas;
import hn.unah.lenguajes.chinese.models.Ordenes;
import hn.unah.lenguajes.chinese.repositories.ClientesRepository;
import hn.unah.lenguajes.chinese.repositories.ContenidoOrdenRepository;
import hn.unah.lenguajes.chinese.repositories.EmpleadosRepository;
import hn.unah.lenguajes.chinese.repositories.EstadoMesaRepository;
import hn.unah.lenguajes.chinese.repositories.EstadoOrdenRepostory;
import hn.unah.lenguajes.chinese.repositories.FacturaRepository;
import hn.unah.lenguajes.chinese.repositories.MenusRepository;
import hn.unah.lenguajes.chinese.repositories.MesasRepository;
import hn.unah.lenguajes.chinese.repositories.OrdenesRepository;
import hn.unah.lenguajes.chinese.services.OrdenService;

@Component
public class OrdenImpl implements OrdenService {

    @Autowired
    private OrdenesRepository ordenesRepository;
    @Autowired
    private ContenidoOrdenRepository contenidoOrdenRepository;
    @Autowired
    private EstadoOrdenRepostory estadoOrdenRepostory;
    @Autowired
    private EmpleadosRepository empleadosRepository;
    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private MesasRepository mesasRepository;
    @Autowired
    private EstadoMesaRepository estadoMesaRepository;
    @Autowired
    private MenusRepository menusRepository;
    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Ordenes> getOrdenesDeClientePorEmail(String email) {
        return ordenesRepository.findAllByClienteCorreo(email);

    }

    @Override
    public List<Ordenes> getTodasOrdenesCreadas() {
        return (List<Ordenes>) ordenesRepository.findAll();
    }

    @Override
    public String cancelacionOrden(int id_orden) {
        Optional<Ordenes> ordenOptional = ordenesRepository.findById(id_orden);
        if (ordenOptional.isPresent()) {
            Ordenes orden = ordenOptional.get();
            if (orden.getEstado_orden().getEstado() == "Recibida") {
                return "No se puede cancelar la orden";
            } else {
                ordenesRepository.deleteById(id_orden);
                return "Se borro la orden";
            }
        } else {
            return "No se encontro la orden";
        }
    }

    @Override
    public Ordenes postOrden(int id_cliente, int id_mesa) {
        Ordenes ordenes = new Ordenes();

        Optional<Cliente> cliente_opt = clientesRepository.findById(id_cliente);
        Optional<Mesas> mesas_opt = mesasRepository.findById(id_mesa);
        Optional<Estados_mesa> estado_mesa_opt = estadoMesaRepository.findById(2);
        Optional<Estado_orden> estado_orden_opt = estadoOrdenRepostory.findById(1);

        if (cliente_opt.isPresent() && mesas_opt.isPresent() && estado_orden_opt.isPresent()
                && estado_mesa_opt.isPresent()) {

            Cliente cliente = cliente_opt.get();
            Mesas mesa = mesas_opt.get();
            Estado_orden estado_orden = estado_orden_opt.get();
            Estados_mesa estados_mesa = estado_mesa_opt.get();

            List<Empleados> empleadoList = (List<Empleados>) empleadosRepository.findAll();
            ArrayList<Empleados> chefList = new ArrayList<Empleados>();
            ArrayList<Empleados> meseroList = new ArrayList<Empleados>();

            for (Empleados empleado : empleadoList) {
                if ("Chef".equals(empleado.getTipoEmpleado())) {
                    chefList.add(empleado);
                }
                if ("Mesero".equals(empleado.getTipoEmpleado())) {
                    meseroList.add(empleado);
                }

            }
            Random random = new Random();
            int randomIndex = random.nextInt(chefList.size());
            int randomIndex2 = meseroList.isEmpty() ? -1 : random.nextInt(meseroList.size());

            Empleados chef = chefList.get(randomIndex);
            Empleados mesero = randomIndex2 != -1 ? meseroList.get(randomIndex2) : null;

            ordenes.setCliente(cliente);
            ordenes.setMesa(mesa);
            ordenes.setEstado_orden(estado_orden);
            ordenes.setChef(chef);
            ordenes.setMesero(mesero);

            mesa.setEstadoMesa(estados_mesa);
            mesasRepository.save(mesa);

            return ordenesRepository.save(ordenes);
        } else {
            return null;
        }
    }

    @Override
    public String avanzarOrdenChef(int id_orden) {
        Optional<Ordenes> orden = ordenesRepository.findById(id_orden);
        Estado_orden estado_orden = estadoOrdenRepostory.findByEstado("En Curso");

        if (orden.isPresent()) {
            Ordenes ordenPresente = orden.get();
            ordenPresente.setEstado_orden(estado_orden);
            ordenesRepository.save(ordenPresente);
            return "Se actualizo el estado de la orden a En Curso";
        } else {
            return "No se encontro la orden";
        }
    }

    @Override
    public String avanzarOrdenMesero(int id_orden) {
        Optional<Ordenes> orden = ordenesRepository.findById(id_orden);
        Estado_orden estado_orden = estadoOrdenRepostory.findByEstado("Entregable");

        if (orden.isPresent()) {
            Ordenes ordenPresente = orden.get();
            ordenPresente.setEstado_orden(estado_orden);
            ordenesRepository.save(ordenPresente);
            return "Se actualizo el estado de la orden a En Curso";
        } else {
            return "No se encontro la orden";
        }
    }

    @Override
    public String avanzarOrdenPago(int id_orden) {
        Optional<Ordenes> orden = ordenesRepository.findById(id_orden);
        Estado_orden estado_orden = estadoOrdenRepostory.findByEstado("Pagado");
        Optional<Estados_mesa> estado_mesa_opt = estadoMesaRepository.findById(1);

        if (orden.isPresent()) {
            Ordenes orden_estado = orden.get();
            Optional<Mesas> mesas_opt = mesasRepository.findById(orden_estado.getMesa().getId());
            if (mesas_opt.isPresent() && estado_mesa_opt.isPresent()) {
                Mesas mesa = mesas_opt.get();
                Estados_mesa estado_mesa = estado_mesa_opt.get();
                mesa.setEstadoMesa(estado_mesa);

                orden_estado.setEstado_orden(estado_orden);
                List<Contenido_orden> cont_orden = contenidoOrdenRepository.findAllByOrdenes_Id(id_orden);

                double sub_total = cont_orden.stream()
                        .mapToDouble(contenidoOrden -> contenidoOrden.getMenu().getPrecio())
                        .sum();

                Ordenes ordenPresente = orden.get();
                ordenPresente.setEstado_orden(estado_orden);
                ordenesRepository.save(ordenPresente);

                Factura factura = new Factura();
                factura.setCliente(ordenPresente.getCliente());
                factura.setIsv(0.15);
                factura.setOrden(ordenPresente);
                factura.setSub_total(sub_total);
                factura.setTotal(sub_total * 1.15);

                facturaRepository.save(factura);

                return "Se actualizo el estado de la orden ";
            } else {

                return "No se encontro la mesa";
            }

        } else {
            return "No se encontro la orden";
        }
    }

    @Override
    public String AgregarItemAOrden(int id_orden, int id_menu, int cantidad) {
        Optional<Ordenes> orden_opt = ordenesRepository.findById(id_orden);
        Optional<Menus> menu_item_opt = menusRepository.findById(id_menu);

        if (orden_opt.isPresent() && menu_item_opt.isPresent()) {
            Contenido_orden cont_orden = new Contenido_orden();
            Ordenes orden = orden_opt.get();
            Menus menus = menu_item_opt.get();

            cont_orden.setCantidad(cantidad);
            cont_orden.setMenu(menus);
            cont_orden.setOrdenes(orden);
            contenidoOrdenRepository.save(cont_orden);
            return "Se agrego un item del menu a la factura";

        } else {
            return "No se completo la operacion";
        }
    }

    @Override
    public List<Contenido_orden> getContenidoOrden(int id) {
        return (List<Contenido_orden>) contenidoOrdenRepository.findAll();
    }

}
