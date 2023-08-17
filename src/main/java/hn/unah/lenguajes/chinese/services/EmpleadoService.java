package hn.unah.lenguajes.chinese.services;

import hn.unah.lenguajes.chinese.models.Empleados;

import java.util.List;

public interface EmpleadoService {

    Empleados guardarEmpleado(Empleados empleado);

    Empleados buscarEmpleadoPorId(int id);

    Empleados borrarEmpleadoPorId(int id);

    Empleados actualizarEmpleado(int id, Empleados empleado);

    List<Empleados> obtenerTodosEmpleados();

    Empleados regresarEmpleadoPorTipoEmpleado(String tipo);

}
