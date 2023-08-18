package hn.unah.lenguajes.chinese.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.Mesas;
import hn.unah.lenguajes.chinese.services.impl.MesasImpl;

@RestController
@RequestMapping("/mesas")
public class MesasController {
    @Autowired
    private MesasImpl mesasImpl;

    @GetMapping("/id/{id}")
    public Optional<Mesas> getMesaPorId(@PathVariable int id) {
        return mesasImpl.getMesaPorId(id);
    }

    @GetMapping("/get")
    public List<Mesas> getMesas() {
        return mesasImpl.getMesas();
    }

    @GetMapping("/estado/disponible")
    public ArrayList<Mesas> getMesasPorEstado() {
        return mesasImpl.getMesasDisponibles();
    }

    @PostMapping("/agregar")
    public Mesas agregarMesas(@RequestBody Mesas mesa) {
        return mesasImpl.agregarMesa(mesa);
    }

    @PutMapping("/id/{id}")
    public String editarMesa(@PathVariable int id, @RequestBody Mesas mesa) {
        return mesasImpl.editarMesa(id, mesa);
    }

    @DeleteMapping("/id/{id}")
    public String borrarMesa(@PathVariable int id) {
        return mesasImpl.borrarMesa(id);
    }
}
