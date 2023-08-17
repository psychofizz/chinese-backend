package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Ingredientes;
import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.models.MenuIngredientes;
import hn.unah.lenguajes.chinese.repositories.MenuIngredientesRepository;
import hn.unah.lenguajes.chinese.repositories.MenusRepository;
import hn.unah.lenguajes.chinese.services.MenusService;

@Component
public class MenusImpl implements MenusService {
    @Autowired
    private MenuIngredientesRepository menuIngredientesRepo;
    @Autowired
    private MenusRepository menuRepo;

    @Override
    public List<Menus> getMenuTodo() {
        return (List<Menus>) menuRepo.findAll();
    }

    @Override
    public String guardarMenuItem(Menus menu, List<Ingredientes> arregloIngredientes) {
        Menus savedMenu = menuRepo.save(menu);

        for (Ingredientes ingrediente : arregloIngredientes) {
            MenuIngredientes menuIngrediente = new MenuIngredientes();
            menuIngrediente.setMenus(savedMenu);
            menuIngrediente.setIngredientes(ingrediente);
            menuIngrediente.setCantidad(1);

            menuIngredientesRepo.save(menuIngrediente);
        }

        return "Menu item and ingredients saved successfully.";
    }

    @Override
    public String editarMenuItem(int id_menu, Menus menu, List<Ingredientes> arregloIngredientes) {
        Optional<Menus> existingMenuOptional = menuRepo.findById(id_menu);

        if (existingMenuOptional.isPresent()) {
            Menus existingMenu = existingMenuOptional.get();
            existingMenu.setNombre(menu.getNombre());
            existingMenu.setPrecio(menu.getPrecio());
            menuRepo.save(existingMenu);

            menuIngredientesRepo.deleteByMenus(existingMenu);

            for (Ingredientes ingrediente : arregloIngredientes) {
                MenuIngredientes menuIngrediente = new MenuIngredientes();
                menuIngrediente.setMenus(existingMenu);
                menuIngrediente.setIngredientes(ingrediente);
                menuIngrediente.setCantidad(1); // Set the desired quantity here

                menuIngredientesRepo.save(menuIngrediente);
            }

            return "Menu item and ingredients updated successfully.";
        } else {
            return "Menu item not found.";
        }
    }

    @Override
    public String borrarMenuItem(int id_menu) {
        Menus existingMenu = menuRepo.findById(id_menu).orElse(null);

        if (existingMenu != null) {
            menuIngredientesRepo.deleteByMenus(existingMenu);
            menuRepo.delete(existingMenu);

            return "Menu item and associated entries deleted successfully.";
        } else {
            return "Menu item not found.";
        }
    }

    @Override
    public List<Menus> getMenuDisponible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMenuDisponible'");
    }

}
