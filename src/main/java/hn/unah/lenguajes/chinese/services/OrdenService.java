package hn.unah.lenguajes.chinese.services;

import java.util.List;

import hn.unah.lenguajes.chinese.models.Contenido_orden;
import hn.unah.lenguajes.chinese.models.Ordenes;

public interface OrdenService {

    public List<Ordenes> getOrdenesDeClientePorEmail(String email);

    public List<Contenido_orden> getContenidoOrden(int id);

    public List<Ordenes> getTodasOrdenesCreadas();

    public String cancelacionOrden(int id_orden);

    public Ordenes postOrden(int id_cliente, int id_mesa);

    public String avanzarOrdenChef(int id_orden);

    public String avanzarOrdenMesero(int id_orden);

    public String avanzarOrdenPago(int id_orden);

    public String AgregarItemAOrden(int id_orden, int id_menu, int cantidad);

}
