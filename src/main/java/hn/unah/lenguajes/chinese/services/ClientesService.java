package hn.unah.lenguajes.chinese.services;

import hn.unah.lenguajes.chinese.models.Cliente;

import java.util.List;

public interface ClientesService {
    
    Cliente guardarCliente(Cliente cliente);
    
    Cliente buscarPorId(int id);
    
    Cliente borrarPorId(int id);
    
    List<Cliente> regresarTodo();
}
