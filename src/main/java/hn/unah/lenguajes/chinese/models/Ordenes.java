package hn.unah.lenguajes.chinese.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_chef", referencedColumnName = "id")
    private Empleados chef;

    @ManyToOne
    @JoinColumn(name = "id_mesero")
    private Empleados mesero;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_mesa", referencedColumnName = "id")
    private Mesas mesa;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_estado_orden", referencedColumnName = "id")
    private Estado_orden estado_orden;

    @Column(name = "fecha_creada")
    private LocalDateTime fechaCreada;

    @PrePersist
    protected void onCreate() {
        fechaCreada = LocalDateTime.now();
    }
}
