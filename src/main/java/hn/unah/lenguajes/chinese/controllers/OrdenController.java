package hn.unah.lenguajes.chinese.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.Ordenes;
import hn.unah.lenguajes.chinese.services.impl.OrdenImpl;

@RestController
@RequestMapping("/orden")

public class OrdenController {

    @Autowired
    private OrdenImpl ordenImpl;

    @GetMapping("/email/{email}")
    public List<Ordenes> getOrdenesPorEmail(@PathVariable String email) {
        return ordenImpl.getOrdenesDeClientePorEmail(email);
    }

    @GetMapping("/")
    public List<Ordenes> getOrdenes() {
        return ordenImpl.getTodasOrdenesCreadas();
    }

    @DeleteMapping("/id/{id}")
    public String cancelacionOrden(@PathVariable int id) {
        return ordenImpl.cancelacionOrden(id);
    }

    @PutMapping("/avanzar-chef/id/{id}")
    public String avanzarOrdenChef(@PathVariable int id) {
        return ordenImpl.avanzarOrdenChef(id);
    }

    @PutMapping("/avanzar-mesero/id/{id}")
    public String avanzarOrdenMesero(@PathVariable int id) {
        return ordenImpl.avanzarOrdenMesero(id);
    }

    @PutMapping("/avanzar-pago/id/{id}")
    public String avanzarOrdenPago(@PathVariable int id) {
        return ordenImpl.avanzarOrdenPago(id);
    }

    @PostMapping("/crear")
    public Ordenes postearOrden(@RequestBody Ordenes ordenes) {
        return ordenImpl.postOrden(ordenes);
    }

}
