package hn.unah.lenguajes.chinese.services;

import java.util.List;

import hn.unah.lenguajes.chinese.models.MenuIngredientes;
import hn.unah.lenguajes.chinese.models.Menus;

public interface MenusService {

    public List<Menus> getMenuDisponible();

    public List<MenuIngredientes> getMenuTodo();

    public String guardarMenuItem(Menus menu);

    public String agregarIngredientesAMenu(int id_menu, int ingrediente);

    public String borrarMenuItem(int id_menu);

}
