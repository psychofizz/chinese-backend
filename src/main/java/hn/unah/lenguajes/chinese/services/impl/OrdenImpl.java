package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Contenido_orden;
import hn.unah.lenguajes.chinese.models.Empleados;
import hn.unah.lenguajes.chinese.models.Estado_orden;
import hn.unah.lenguajes.chinese.models.Factura;
import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.models.Ordenes;
import hn.unah.lenguajes.chinese.repositories.ContenidoOrdenRepository;
import hn.unah.lenguajes.chinese.repositories.EmpleadosRepository;
import hn.unah.lenguajes.chinese.repositories.EstadoOrdenRepostory;
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
    public Ordenes postOrden(Ordenes ordenes) {
        if (ordenes == null) {
            return null;
        }

        return ordenesRepository.save(ordenes);
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
        Estado_orden estado_orden = estadoOrdenRepostory.findByEstado("Entregable");

        if (orden.isPresent()) {
            Ordenes ordenPresente = orden.get();
            ordenPresente.setEstado_orden(estado_orden);
            ordenesRepository.save(ordenPresente);

            Factura factura = new Factura();
            factura.setCliente(ordenPresente.getCliente());
            factura.setIsv(0.15);
            factura.setOrden(ordenPresente);
            factura.setSub_total(contenidoOrdenRepository.calculateTotalPriceByOrdenId(ordenPresente.getId()));

            return "Se actualizo el estado de la orden a En Curso";
        } else {
            return "No se encontro la orden";
        }
    }

}
