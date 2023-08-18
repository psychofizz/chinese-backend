package hn.unah.lenguajes.chinese.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.unah.lenguajes.chinese.models.Estados_mesa;
import hn.unah.lenguajes.chinese.models.Mesas;
import hn.unah.lenguajes.chinese.repositories.EstadoMesaRepository;
import hn.unah.lenguajes.chinese.repositories.MesasRepository;
import hn.unah.lenguajes.chinese.services.MesasService;

@Component
public class MesasImpl implements MesasService {

    @Autowired
    private MesasRepository mesasRepository;
    @Autowired
    private EstadoMesaRepository estadoMesaRepository;

    @Override
    public Optional<Mesas> getMesaPorId(int id_mesa) {
        return mesasRepository.findById(id_mesa);
    }

    @Override
    public List<Mesas> getMesas() {
        return (List<Mesas>) mesasRepository.findAll();
    }

    @Override
    public ArrayList<Mesas> getMesasDisponibles() {
        List<Mesas> mesas = (List<Mesas>) mesasRepository.findAll();
        ArrayList<Mesas> mesasDisponibles = new ArrayList<Mesas>();
        for (Mesas mesa : mesas) {
            if ("Disponible".equals(mesa.getEstadoMesa().getEstado())) {
                mesasDisponibles.add(mesa);
            }
        }
        return mesasDisponibles;
    }

    @Override
    public Mesas agregarMesa(Mesas mesa) {
        Optional<Estados_mesa> estados_mesa = estadoMesaRepository.findById(1);

        if (estados_mesa.isPresent()) {
            Estados_mesa est_mes = estados_mesa.get();
            mesa.setEstadoMesa(est_mes);
            return mesasRepository.save(mesa);
        }
        return null;
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
