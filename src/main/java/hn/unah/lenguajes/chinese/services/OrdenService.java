package hn.unah.lenguajes.chinese.services;

import java.util.List;
import hn.unah.lenguajes.chinese.models.Ordenes;

public interface OrdenService {

    public List<Ordenes> getOrdenesDeClientePorEmail(String email);

    public List<Ordenes> getTodasOrdenesCreadas();

    public String cancelacionOrden(int id_orden);

    public Ordenes postOrden(Ordenes ordenes);

    public String avanzarOrdenChef(int id_orden);

    public String avanzarOrdenMesero(int id_orden);

    public String avanzarOrdenPago(int id_orden);

}
