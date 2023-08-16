package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;

import hn.unah.lenguajes.chinese.models.Ingredientes;
import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.services.MenusService;

public class MenusImpl implements MenusService {

    @Override
    public List<Menus> getMenuDisponible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMenuDisponible'");
    }

    @Override
    public List<Menus> getMenuTodo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMenuTodo'");
    }

    @Override
    public String guardarMenuItem(Menus menu, List<Ingredientes> arregloIngredientes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarMenuItem'");
    }

    @Override
    public String editarMenuItem(int id_menu, Menus menu, List<Ingredientes> arregloIngredientes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarMenuItem'");
    }

    @Override
    public String borrarMenuItem(int id_menu) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarMenuItem'");
    }

}
