package hn.unah.lenguajes.chinese.models;

import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clientes")
public class Cliente extends Personas {

    private boolean cliente_preferencial;

}
