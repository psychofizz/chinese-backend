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
@Table(name = "clientes")
public class Cliente extends Personas {

    private boolean cliente_preferencial;

}
