package com.example.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_items")
public class Item extends PanacheEntityBase {
    @Id
    @Column(name = "item_nom")
    private String nombre = "";

    @Column(name = "item_prop")
    private Integer quality = 0;

    @Column(name = "item_tipo")
    private String tipo;

    public String getNombre() {
        return nombre;
    }

    public Integer getQuality() {
        return quality;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setQuality(Integer prop) {
        this.quality = prop;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Item() {
    }
}
