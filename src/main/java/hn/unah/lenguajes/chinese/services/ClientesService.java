package hn.unah.lenguajes.chinese.services;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.unah.lenguajes.chinese.models.Cliente;

@Service
public interface ClientesService {
    
    Cliente guardarCliente(Cliente cliente);
    
    Cliente buscarPorId(int id);
    
    Cliente borrarPorId(int id);
    
    List<Cliente> regresarTodo();
}
