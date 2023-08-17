package hn.unah.lenguajes.chinese.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.Ingredientes;
import hn.unah.lenguajes.chinese.models.Menus;
import hn.unah.lenguajes.chinese.services.impl.MenusImpl;

@RestController
@RequestMapping("/menu")
public class MenusController {
    @Autowired
    private MenusImpl menusImpl;

    @GetMapping("/disponible")
    public List<Menus> getMenuDisponible() {
        return menusImpl.getMenuDisponible();
    }

    @GetMapping("/todo")
    public List<Menus> getMenuTodo() {
        return menusImpl.getMenuTodo();
    }

    @PostMapping("/guardar-menu-item")
    public String guardarMenuItem(@RequestBody Menus menu_item, @RequestBody List<Ingredientes> arregloIngredientes) {
        return menusImpl.guardarMenuItem(menu_item, arregloIngredientes);
    }

    @PutMapping("/editar-item/{id_menu}")
    public String editarMenuItem(@PathVariable int id_menu, @RequestBody Menus menu,
            @RequestBody List<Ingredientes> arregloIngredientes) {
        return menusImpl.editarMenuItem(0, menu, arregloIngredientes);
    }

}
