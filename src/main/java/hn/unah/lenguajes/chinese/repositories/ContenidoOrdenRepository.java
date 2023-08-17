package hn.unah.lenguajes.chinese.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import hn.unah.lenguajes.chinese.models.Contenido_orden;

public interface ContenidoOrdenRepository extends CrudRepository<Contenido_orden, Integer> {

    @Query("SELECT SUM(menu.precio) FROM Contenido_orden co JOIN co.menu menu WHERE co.ordenes.id = :ordenId")
    Double calculateTotalPriceByOrdenId(@Param("ordenId") int ordenId);

}
