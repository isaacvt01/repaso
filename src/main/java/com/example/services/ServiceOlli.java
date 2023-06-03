package com.example.services;

import com.example.domain.Item;
import com.example.domain.Orden;
import com.example.domain.Usuaria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class ServiceOlli {
    public ServiceOlli() {
    }

    public Usuaria cargaUsuaria(String nombre) {
        Optional<Usuaria> usuaria =  Usuaria.find("nombre", nombre).firstResultOptional();
        return usuaria.isPresent()? usuaria.get() : new Usuaria();
    }

    public Item cargaItem(String nombre) {
        Optional<Item> item =  Item.find("nombre", nombre).firstResultOptional();
        return item.isPresent()? item.get() : new Item();
    }

    public List<Orden> cargaOrden(String name) {
        return Orden.find("user.nombre", name).list();
    }

    @Transactional
    public Orden comanda(String nombre, String item_nombre) {
        Orden orden = null;
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(nombre);
        Optional<Item> item = Usuaria.findByIdOptional(item_nombre);
        if (usuaria.isPresent() && item.isPresent()) {
            orden = new Orden(usuaria.get(), item.get());
            orden.persist();
        }

        return orden;
    }


}
