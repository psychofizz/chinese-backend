package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Estado_orden;
import hn.unah.lenguajes.chinese.models.Estados_mesa;
import hn.unah.lenguajes.chinese.repositories.EstadoMesaRepository;
import hn.unah.lenguajes.chinese.repositories.EstadoOrdenRepostory;
import hn.unah.lenguajes.chinese.services.EstadosService;

@Component
public class EstadosImpl implements EstadosService {

    @Autowired
    private EstadoMesaRepository estadoMesaRepo;
    @Autowired
    private EstadoOrdenRepostory estadoOrdenRepo;

    @Override
    public List<Estado_orden> getEstadosOrden() {
        return (List<Estado_orden>) estadoOrdenRepo.findAll();

    }

    @Override
    public List<Estados_mesa> getEstadosMesa() {
        return (List<Estados_mesa>) estadoMesaRepo.findAll();
    }

}
