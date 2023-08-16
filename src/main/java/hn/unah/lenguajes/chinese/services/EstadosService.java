package hn.unah.lenguajes.chinese.services;

import java.util.List;

import hn.unah.lenguajes.chinese.models.Estado_orden;
import hn.unah.lenguajes.chinese.models.Estados_mesa;

public interface EstadosService {

    public List<Estado_orden> getEstadosOrden();

    public List<Estados_mesa> getEstadosMesa();

}
