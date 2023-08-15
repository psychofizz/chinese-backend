package hn.unah.lenguajes.chinese.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ordenes")
public class Ordenes {
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_chef")
    private Empleados chef;

    @ManyToOne
    @JoinColumn(name = "id_mesero")
    private Empleados mesero;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesas mesa;

    @ManyToOne
    @JoinColumn(name = "id_estado_orden")
    private Estado_orden estado_orden;
}
