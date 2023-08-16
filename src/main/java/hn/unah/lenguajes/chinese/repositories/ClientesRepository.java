package hn.unah.lenguajes.chinese.repositories;

import org.springframework.data.repository.CrudRepository;
import hn.unah.lenguajes.chinese.models.Cliente;


public interface ClientesRepository extends CrudRepository<Cliente, Integer> {

}
