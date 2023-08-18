package hn.unah.lenguajes.chinese.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.chinese.models.Factura;
import hn.unah.lenguajes.chinese.services.impl.FacturasImpl;

@RestController
@RequestMapping("/facturas")
public class FacturasController {
    @Autowired
    private FacturasImpl facturasImpl;

    @GetMapping("/")
    private List<Factura> getFacturas() {
        return facturasImpl.getFacturas();
    }

    @GetMapping("/cliente")
    public List<Factura> getFacturasCliente(@RequestParam String email) {
        return facturasImpl.getFacturasPorCliente(email);
    }

    @GetMapping("/mas-reciente")
    public Optional<Factura> getFacturaMasReciente(@RequestParam String email) {
        return facturasImpl.getFacturaMasReciente(email);
    }
}
