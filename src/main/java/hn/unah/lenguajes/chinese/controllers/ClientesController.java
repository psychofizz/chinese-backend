package hn.unah.lenguajes.chinese.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.Cliente;
import hn.unah.lenguajes.chinese.services.ClientesService;



@RestController
@RequestMapping("/clientes")
public class ClientesController {
    
      private final ClientesService clientesService;

    @Autowired
    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @PostMapping("/crearCliente")
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {
        try {
            Cliente clienteGuardado = clientesService.guardarCliente(cliente);
            if (clienteGuardado != null) {
                System.out.println("Cliente creado con éxito. ID: " + clienteGuardado.getId());
                return new ResponseEntity<>("Cliente creado con éxito", HttpStatus.CREATED);
            } else {
                System.out.println("Error al crear el cliente.");
                return new ResponseEntity<>("Error al crear el cliente", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            System.err.println("Error al crear el cliente: " + e.getMessage());
            return new ResponseEntity<>("Error al crear el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarCliente/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable int id) {
        Cliente cliente = clientesService.buscarPorId(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrarCliente/{id}")
    public ResponseEntity<String> borrarCliente(@PathVariable int id) {
        try {
            Cliente clienteBorrado = clientesService.borrarPorId(id);
            if (clienteBorrado != null) {
                System.out.println("Cliente borrado. ID: " + clienteBorrado.getId());
                return new ResponseEntity<>("Cliente borrado", HttpStatus.OK);
            } else {
                System.out.println("Cliente no encontrado para borrar.");
                return new ResponseEntity<>("Cliente no encontrado para borrar", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.err.println("Error al borrar el cliente: " + e.getMessage());
            return new ResponseEntity<>("Error al borrar el cliente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        List<Cliente> clientes = clientesService.regresarTodo();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }


}
