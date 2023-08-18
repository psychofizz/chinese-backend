package hn.unah.lenguajes.chinese.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.MenuIngredientes;
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
    public List<MenuIngredientes> getMenuTodo() {
        return menusImpl.getMenuTodo();
    }

    @PostMapping("/agregar-ingrediente-menu/id-menu/{id_menu}/id-ingrediente/{id_ingrediente}")
    public String guardarMenuItem(@PathVariable int id_menu, @PathVariable int id_ingrediente) {
        return menusImpl.agregarIngredientesAMenu(id_menu, id_ingrediente);
    }

    @PostMapping("/guardar-menu")
    public String guardarMenu(@RequestBody Menus menus) {
        return menusImpl.guardarMenuItem(menus);
    }

}
