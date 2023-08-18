package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Ingredientes;
import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.models.MenuIngredientes;
import hn.unah.lenguajes.chinese.repositories.IngredientesRepository;
import hn.unah.lenguajes.chinese.repositories.MenuIngredientesRepository;
import hn.unah.lenguajes.chinese.repositories.MenusRepository;
import hn.unah.lenguajes.chinese.services.MenusService;

@Component
public class MenusImpl implements MenusService {
    @Autowired
    private MenuIngredientesRepository menuIngredientesRepo;
    @Autowired
    private MenusRepository menuRepo;

    @Autowired
    private IngredientesRepository ingredientesRepository;

    @Override
    public List<MenuIngredientes> getMenuTodo() {
        return (List<MenuIngredientes>) menuIngredientesRepo.findAll();
    }

    @Override
    public String guardarMenuItem(Menus menu) {
        menuRepo.save(menu);
        return "Menu item and ingredients saved successfully.";
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

    @Override
    public String agregarIngredientesAMenu(int id_menu, int ingrediente) {
        Optional<Menus> menu_opt = menuRepo.findById(id_menu);
        Optional<Ingredientes> ingredientes_opt = ingredientesRepository.findById(ingrediente);
        if (menu_opt.isPresent() && ingredientes_opt.isPresent()) {
            Menus menu_item = menu_opt.get();
            Ingredientes ingredientes = ingredientes_opt.get();
            MenuIngredientes menuing = new MenuIngredientes();
            menuing.setCantidad(1);
            menuing.setIngredientes(ingredientes);
            menuing.setMenus(menu_item);
            menuIngredientesRepo.save(menuing);
            return "Se guardo el ingrediente con el menu";
        } else {
            return "No se encontro por ID menu o ingrediente";
        }
    }

}