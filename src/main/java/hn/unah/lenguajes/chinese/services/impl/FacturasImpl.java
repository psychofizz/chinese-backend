package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Factura;
import hn.unah.lenguajes.chinese.repositories.FacturaRepository;
import hn.unah.lenguajes.chinese.services.FacturaService;

@Component
public class FacturasImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepo;

    @Override
    public List<Factura> getFacturas() {
        return (List<Factura>) facturaRepo.findAll();
    }

    @Override
    public List<Factura> getFacturasPorCliente(String email) {
        return (List<Factura>) facturaRepo.findAllByCliente_Personas_Correo(email);
    }

    @Override
    public Optional<Factura> getFacturaMasReciente(String email) {
        return facturaRepo.findTopByCliente_Personas_CorreoOrderByFechaEmitidaDesc(email);
    }

}
