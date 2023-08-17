package hn.unah.lenguajes.chinese.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.Estado_orden;
import hn.unah.lenguajes.chinese.models.Estados_mesa;
import hn.unah.lenguajes.chinese.services.impl.EstadosImpl;

@RestController
@RequestMapping("/estados")
public class EstadosController {
    @Autowired
    private EstadosImpl estadosImpl;

    @GetMapping("/orden")
    public List<Estado_orden> getEstadosOrden() {
        return estadosImpl.getEstadosOrden();
    }

    @GetMapping("/mesa")
    public List<Estados_mesa> getEstadosMesa() {
        return estadosImpl.getEstadosMesa();
    }

}
