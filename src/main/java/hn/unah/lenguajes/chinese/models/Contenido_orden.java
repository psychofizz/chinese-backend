package hn.unah.lenguajes.chinese.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "contenido_orden")
public class Contenido_orden {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_orden", referencedColumnName = "id")
    private Ordenes ordenes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu", referencedColumnName = "id")
    private Menus menu;

    private int cantidad;
}
