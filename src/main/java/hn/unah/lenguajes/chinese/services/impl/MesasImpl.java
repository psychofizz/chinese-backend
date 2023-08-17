package hn.unah.lenguajes.chinese.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Mesas;
import hn.unah.lenguajes.chinese.repositories.MesasRepository;
import hn.unah.lenguajes.chinese.services.MesasService;

@Component
public class MesasImpl implements MesasService {

    @Autowired
    private MesasRepository mesasRepository;

    @Override
    public Optional<Mesas> getMesaPorId(int id_mesa) {
        return mesasRepository.findById(id_mesa);
    }

    @Override
    public List<Mesas> getMesas() {
        return (List<Mesas>) mesasRepository.findAll();
    }

    @Override
    public List<Mesas> getMesasPorEstado(String estado) {
        return mesasRepository.findByEstadoMesaEstado(estado);
    }

    @Override
    public Mesas agregarMesa(Mesas mesa) {
        return mesasRepository.save(mesa);
    }

    @Override
    public String editarMesa(int id_mesa, Mesas mesaActualizada) {
        Optional<Mesas> optionalMesa = mesasRepository.findById(id_mesa);

        if (optionalMesa.isPresent()) {
            Mesas mesaExistente = optionalMesa.get();

            // Assuming you want to update the estadoMesa field
            mesaExistente.setEstadoMesa(mesaActualizada.getEstadoMesa());

            mesasRepository.save(mesaExistente);

            return "Mesa edited successfully.";
        } else {
            return "Mesa with ID " + id_mesa + " not found.";
        }
    }

    @Override
    public String borrarMesa(int id_mesa) {
        Optional<Mesas> optionalMesa = mesasRepository.findById(id_mesa);

        if (optionalMesa.isPresent()) {
            mesasRepository.deleteById(id_mesa);
            return "Mesa deleted successfully.";
        } else {
            return "Mesa with ID " + id_mesa + " not found.";
        }
    }

}
