package hn.unah.lenguajes.chinese.services;

import java.util.List;
import java.util.Optional;

import hn.unah.lenguajes.chinese.models.Factura;

public interface FacturaService {

    public List<Factura> getFacturas();

    public List<Factura> getFacturasPorCliente(String email);

    public Optional<Factura> getFacturaMasReciente(String email);

}
