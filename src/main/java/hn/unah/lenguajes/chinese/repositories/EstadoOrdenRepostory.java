package hn.unah.lenguajes.chinese.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Estado_orden;

public interface EstadoOrdenRepostory extends CrudRepository<Estado_orden, Integer> {
    Estado_orden findByEstado(String estadoOrden);

}
