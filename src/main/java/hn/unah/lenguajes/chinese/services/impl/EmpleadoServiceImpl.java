package hn.unah.lenguajes.chinese.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.chinese.models.Empleados;
import hn.unah.lenguajes.chinese.models.Personas;
import hn.unah.lenguajes.chinese.models.Tipo_empleados;
import hn.unah.lenguajes.chinese.repositories.EmpleadosRepository;
import hn.unah.lenguajes.chinese.repositories.PersonasRepository;
import hn.unah.lenguajes.chinese.repositories.Tipo_empleadosRepository;
import hn.unah.lenguajes.chinese.services.EmpleadoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    private final EmpleadosRepository empleadoRepository;
    private final PersonasRepository personasRepository;
    private final Tipo_empleadosRepository tipoEmpleadosRepository;

    @Autowired
    public EmpleadoServiceImpl(EmpleadosRepository empleadoRepository,
                               PersonasRepository personasRepository,
                               Tipo_empleadosRepository tipoEmpleadosRepository) {
        this.empleadoRepository = empleadoRepository;
        this.personasRepository = personasRepository;
        this.tipoEmpleadosRepository = tipoEmpleadosRepository;
    }



    @Override
    public Empleados guardarEmpleado(Empleados empleado) {
        Personas personaGuardada = personasRepository.save(empleado.getPersonas());
        Tipo_empleados tipoEmpleado = empleado.getTipoEmpleado();
        if (tipoEmpleado != null) {
            tipoEmpleado.getEmpleados().add(empleado);
            tipoEmpleadosRepository.save(tipoEmpleado);
        }
        empleado.setPersonas(personaGuardada);
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
    public Empleados actualizarEmpleado(int id, Empleados empleado) {
        Empleados empleadoExistente = empleadoRepository.findById(id).orElse(null);
        if (empleadoExistente != null) {
            empleado.setId(id);
            empleado.setPersonas(empleadoExistente.getPersonas());
            empleado.setTipoEmpleado(empleadoExistente.getTipoEmpleado());
            return empleadoRepository.save(empleado);
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

   
}
