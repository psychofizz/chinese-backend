package hn.unah.lenguajes.chinese.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.models.menu_ingredientes;

public interface MenuIngredientesRepository extends CrudRepository<menu_ingredientes, Integer> {

    List<Object[]> findMenuIngredientesStockAboveZero();

    void deleteByMenus(Menus existingMenu);

}