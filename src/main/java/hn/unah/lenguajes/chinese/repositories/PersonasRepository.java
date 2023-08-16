package hn.unah.lenguajes.chinese.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Personas;

public interface PersonasRepository extends CrudRepository<Personas, Integer>   {
    
}
