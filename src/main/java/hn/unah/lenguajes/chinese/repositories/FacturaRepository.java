package hn.unah.lenguajes.chinese.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Integer> {

    List<Factura> findAllByClienteCorreo(String email);

    Optional<Factura> findTopByClienteCorreoOrderByFechaEmitidaDesc(String email);

}
