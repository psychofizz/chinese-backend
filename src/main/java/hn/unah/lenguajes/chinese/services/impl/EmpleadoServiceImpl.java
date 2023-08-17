package hn.unah.lenguajes.chinese.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.chinese.models.Empleados;

import hn.unah.lenguajes.chinese.repositories.EmpleadosRepository;
import hn.unah.lenguajes.chinese.repositories.PersonasRepository;
import hn.unah.lenguajes.chinese.services.EmpleadoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadosRepository empleadoRepository;
    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public Empleados guardarEmpleado(Empleados empleado) {
        ;
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleados buscarEmpleadoPorId(int id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public Empleados borrarEmpleadoPorId(int id) {
        Optional<Empleados> optionalEmpleado = empleadoRepository.findById(id);
        if (optionalEmpleado.isPresent()) {
            Empleados empleado = optionalEmpleado.get();
            empleadoRepository.delete(empleado);
            return empleado;
        }
        return null;
    }

    @Override
    public List<Empleados> obtenerTodosEmpleados() {
        Iterable<Empleados> empleadosIterable = empleadoRepository.findAll();
        List<Empleados> empleadosList = new ArrayList<>();

        for (Empleados empleado : empleadosIterable) {
            empleadosList.add(empleado);
        }

        return empleadosList;
    }

    @Override
    public Empleados actualizarEmpleado(int id, Empleados empleado) {
        Optional<Empleados> empleadoViejoOptional = empleadoRepository.findById(id);
        if (empleadoViejoOptional.isPresent()) {
            return empleadoRepository.save(empleado);
        } else {
            return null;
        }

    }

}
