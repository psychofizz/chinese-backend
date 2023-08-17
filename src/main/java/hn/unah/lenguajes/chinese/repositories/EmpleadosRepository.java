package hn.unah.lenguajes.chinese.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import hn.unah.lenguajes.chinese.models.Empleados;

public interface EmpleadosRepository extends CrudRepository<Empleados, Integer> {

}
