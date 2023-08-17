package hn.unah.lenguajes.chinese.services;

import java.util.List;
import java.util.Optional;

import hn.unah.lenguajes.chinese.models.Mesas;

public interface MesasService {

    public Optional<Mesas> getMesaPorId(int id_mesa);

    public List<Mesas> getMesas();

    public List<Mesas> getMesasPorEstado(String estado);

    public Mesas agregarMesa(Mesas mesa);

    public String editarMesa(int id_mesa, Mesas mesaActualizada);

    public String borrarMesa(int id_mesa);

}
