package hn.unah.lenguajes.chinese.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Integer> {

    List<Factura> findAllByCliente_Personas_Correo(String email);

    Optional<Factura> findTopByCliente_Personas_CorreoOrderByFechaEmitidaDesc(String email);

}
