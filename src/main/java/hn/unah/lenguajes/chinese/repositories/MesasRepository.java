package hn.unah.lenguajes.chinese.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Mesas;

public interface MesasRepository extends CrudRepository<Mesas, Integer> {

    List<Mesas> findByEstadoMesaEstado(String estadoMesa);

}
