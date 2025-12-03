package com.alphapets.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@DiscriminatorValue("ACCESORIO")
public class Accesorio extends Producto {
    private String talla; // S, M, L
    private String material;

    @Override
    public String obtenerDetallesEtiqueta() {
        return "Accesorio: " + nombre + " Talla: " + talla;
    }
}