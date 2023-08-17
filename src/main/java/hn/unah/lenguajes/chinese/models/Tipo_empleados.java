package hn.unah.lenguajes.chinese.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tipos_empleados")
public class Tipo_empleados {
     @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo_empleado;

    @OneToMany(mappedBy = "tipoEmpleado")
    @JsonBackReference // Maneja la referencia de vuelta en la serialización
    private List<Empleados> empleados;  // Este es el método getEmpleados()

    public List<Empleados> getEmpleados() {
        return empleados;
    }
}