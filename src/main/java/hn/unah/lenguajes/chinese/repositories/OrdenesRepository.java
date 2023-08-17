package hn.unah.lenguajes.chinese.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Ordenes;

public interface OrdenesRepository extends CrudRepository<Ordenes, Integer> {

    List<Ordenes> findAllByCliente_Personas_Correo(String email);

}
