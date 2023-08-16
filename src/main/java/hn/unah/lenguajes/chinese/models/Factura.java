package hn.unah.lenguajes.chinese.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
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
    @JoinColumn(name = "id_orden", referencedColumnName = "id")
    private Ordenes orden;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    private double sub_total;
    private double isv = 0.15;
    private double total;

    @Column(name = "fecha_emitida")
    private LocalDateTime fechaEmitida;

    // ... other fields, getters, setters, etc.

    @PrePersist
    protected void onCreate() {
        fechaEmitida = LocalDateTime.now();
    }

    public Factura() {
        // Constructor
    }

    public void calcularTotal() {
        total = sub_total * (1 + isv);
    }

}
