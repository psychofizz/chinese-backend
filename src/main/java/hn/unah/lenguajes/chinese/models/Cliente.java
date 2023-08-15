package hn.unah.lenguajes.chinese.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clientes")
public class Cliente {
    @Id
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    private Personas personas;

    private boolean cliente_preferencial;

}
