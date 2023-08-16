package hn.unah.lenguajes.chinese.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import hn.unah.lenguajes.chinese.models.Ingredientes;
import hn.unah.lenguajes.chinese.repositories.IngredientesRepository;
import hn.unah.lenguajes.chinese.services.IngredientesService;

public class IngredientesImpl implements IngredientesService {

    @Autowired
    IngredientesRepository ingredientesRepository;

    @Override
    public Ingredientes guardarIngrediente(Ingredientes ingrediente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarIngrediente'");
    }

    @Override
    public Optional<Ingredientes> buscar(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public String cambiarStockIngrediente(String id, int stockNuevo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarStockIngrediente'");
    }

    @Override
    public String borrarIngrediente(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarIngrediente'");
    }

}
