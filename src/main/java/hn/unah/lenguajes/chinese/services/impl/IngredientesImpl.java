package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Ingredientes;
import hn.unah.lenguajes.chinese.repositories.IngredientesRepository;
import hn.unah.lenguajes.chinese.services.IngredientesService;

@Component

public class IngredientesImpl implements IngredientesService {

    @Autowired
    IngredientesRepository ingredientesRepository;

    @Override
    public Ingredientes guardarIngrediente(Ingredientes ingrediente) {
        return ingredientesRepository.save(ingrediente);
    }

    @Override
    public Optional<Ingredientes> buscar(int id_ingrediente) {
        return ingredientesRepository.findById(id_ingrediente);
    }

    @Override
    public String cambiarStockIngrediente(int id_ingrediente, int stockNuevo) {
        Optional<Ingredientes> optionalIngredientes = ingredientesRepository.findById(id_ingrediente);

        if (optionalIngredientes.isPresent()) {
            Ingredientes ingrediente = optionalIngredientes.get();
            ingrediente.setStock(stockNuevo);
            ingredientesRepository.save(ingrediente);
            return "Stock fue actualizado.";
        } else {
            return "Ingrediente no existe.";
        }
    }

    @Override
    public String borrarIngrediente(int id_ingrediente) {
        Optional<Ingredientes> optionalIngrediente = ingredientesRepository.findById(id_ingrediente);

        if (optionalIngrediente.isPresent()) {
            ingredientesRepository.delete(optionalIngrediente.get());
            return "Ingrediente borrado.";
        } else {
            return "Ingrediente no existe.";
        }
    }

    @Override
    public List<Ingredientes> getAllIngredientes() {
        return (List<Ingredientes>) ingredientesRepository.findAll();
    }

}
