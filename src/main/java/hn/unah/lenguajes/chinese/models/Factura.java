package hn.unah.lenguajes.chinese.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "facturas")
public class Factura {
    @Id
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "id_orden")
    private Ordenes orden;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private double sub_total;
    private double isv = 0.15;
    private double total;

    public Factura() {
        // Constructor
    }

    public void calcularTotal() {
        total = sub_total * (1 + isv);
    }

}
