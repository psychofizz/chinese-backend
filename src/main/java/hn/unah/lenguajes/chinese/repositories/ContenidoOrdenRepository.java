package hn.unah.lenguajes.chinese.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Contenido_orden;

public interface ContenidoOrdenRepository extends CrudRepository<Contenido_orden, Integer> {

    List<Contenido_orden> findAllByOrdenes_Id(int ordenId);

}
