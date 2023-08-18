package hn.unah.lenguajes.chinese.models;

import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "empleados")
public class Empleados extends Personas {
    private String tipoEmpleado;
}
