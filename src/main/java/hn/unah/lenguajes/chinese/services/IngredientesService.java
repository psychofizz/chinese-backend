package hn.unah.lenguajes.chinese.services;

import java.util.List;
import java.util.Optional;

import hn.unah.lenguajes.chinese.models.Ingredientes;

public interface IngredientesService {

    public List<Ingredientes> getAllIngredientes();

    public Ingredientes guardarIngrediente(Ingredientes ingrediente);

    public Optional<Ingredientes> buscar(int id_ingrediente);

    public String cambiarStockIngrediente(int id_ingrediente, int stockNuevo);

    public String borrarIngrediente(int id_ingrediente);

}
