package hn.unah.lenguajes.chinese.services;

import java.util.List;

import hn.unah.lenguajes.chinese.models.Mesas;

public interface MesasService {
    public Mesas getMesaPorId(int id_mesa);

    public List<Mesas> getMesas();

    public List<Mesas> getMesasPorEstado(String estado);

    public String agregarMesa(Mesas mesa);

    public String editarMesa(int id_mesa);

    public String borrarMesa(int id_mesa);

}
