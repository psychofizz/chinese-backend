package hn.unah.lenguajes.chinese.services;

import java.util.Optional;

import hn.unah.lenguajes.chinese.models.Ingredientes;

public interface IngredientesService {

    public Ingredientes guardarIngrediente(Ingredientes ingrediente);

    public Optional<Ingredientes> buscar(String id_ingrediente);

    public String cambiarStockIngrediente(String id_ingrediente, int stockNuevo);

    public String borrarIngrediente(int id_ingrediente);

}
