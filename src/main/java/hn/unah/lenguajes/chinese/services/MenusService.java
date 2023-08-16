package hn.unah.lenguajes.chinese.services;

import java.util.List;

import hn.unah.lenguajes.chinese.models.Ingredientes;
import hn.unah.lenguajes.chinese.models.Menus;

public interface MenusService {

    public List<Menus> getMenuDisponible();

    public List<Menus> getMenuTodo();

    public String guardarMenuItem(Menus menu, List<Ingredientes> arregloIngredientes);

    public String editarMenuItem(int id_menu, Menus menu, List<Ingredientes> arregloIngredientes);

    public String borrarMenuItem(int id_menu);

}
