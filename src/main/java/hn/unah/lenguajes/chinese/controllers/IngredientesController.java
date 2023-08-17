package hn.unah.lenguajes.chinese.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.Ingredientes;
import hn.unah.lenguajes.chinese.services.impl.IngredientesImpl;

@RestController
@RequestMapping("/ingredientes")
public class IngredientesController {
    @Autowired
    private IngredientesImpl ingredientesImpl;

    @PostMapping("/")
    public Ingredientes postIngredientes(@RequestBody Ingredientes ingredientes) {
        return ingredientesImpl.guardarIngrediente(ingredientes);
    }

    @GetMapping("/")
    public List<Ingredientes> getAllIngredientes() {
        return ingredientesImpl.getAllIngredientes();
    }

    @PutMapping("/{id_ingrediente}/stock/{stockNuevo}")
    public String cambiarStock(@PathVariable int id_ingrediente, @PathVariable int stockNuevo) {
        return ingredientesImpl.cambiarStockIngrediente(id_ingrediente, stockNuevo);
    }

    @DeleteMapping("/{id_ingrediente}")
    public String borrarIngrediente(@PathVariable int id_ingrediente) {
        return ingredientesImpl.borrarIngrediente(id_ingrediente);
    }
}
