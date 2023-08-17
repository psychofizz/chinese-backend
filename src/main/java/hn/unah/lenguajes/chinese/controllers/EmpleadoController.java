package hn.unah.lenguajes.chinese.controllers;

import hn.unah.lenguajes.chinese.models.Empleados;
import hn.unah.lenguajes.chinese.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @PostMapping("/GuardarEmpleado")
    public ResponseEntity<Empleados> crearEmpleado(@RequestBody Empleados empleado) {
        Empleados nuevoEmpleado = empleadoService.guardarEmpleado(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    @GetMapping("/ObtenerPorId/{id}")
    public ResponseEntity<Empleados> obtenerEmpleadoPorId(@PathVariable int id) {
        Empleados empleado = empleadoService.buscarEmpleadoPorId(id);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/BorrarporId/{id}")
    public ResponseEntity<Void> borrarEmpleadoPorId(@PathVariable int id) {
        Empleados empleadoBorrado = empleadoService.borrarEmpleadoPorId(id);
        if (empleadoBorrado != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("(/ModificarporId/{id}")
    public ResponseEntity<Empleados> actualizarEmpleado(@PathVariable int id, @RequestBody Empleados empleado) {
        Empleados empleadoActualizado = empleadoService.actualizarEmpleado(id, empleado);
        if (empleadoActualizado != null) {
            return new ResponseEntity<>(empleadoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Empleados")
    public ResponseEntity<List<Empleados>> obtenerTodosEmpleados() {
        List<Empleados> empleados = empleadoService.obtenerTodosEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
}
