package hn.unah.lenguajes.chinese.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.Cliente;
import hn.unah.lenguajes.chinese.services.impl.ClientesServiceImpl;


@RestController
@RequestMapping("/clientes")
public class ClientesController {
    
    @Autowired
    private ClientesServiceImpl clientesService;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clientesService.guardarCliente(cliente);
    }

    @GetMapping("/buscar/{id}")
    public Cliente buscarCliente(@PathVariable int id) {
        return clientesService.buscarPorId(id);
    }

    @GetMapping("/todo-cliente")
    public List<Cliente> todoCliente() {
        return clientesService.regresarTodo();
    }

    @DeleteMapping("/borrar/{id}")
    public Cliente borrarCliente(@PathVariable int id) {
        return clientesService.borrarPorId(id);
    }

}
