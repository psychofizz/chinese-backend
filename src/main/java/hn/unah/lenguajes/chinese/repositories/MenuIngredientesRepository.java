package hn.unah.lenguajes.chinese.repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.models.MenuIngredientes;

public interface MenuIngredientesRepository extends CrudRepository<MenuIngredientes, Integer> {

    void deleteByMenus(Menus existingMenu);

}