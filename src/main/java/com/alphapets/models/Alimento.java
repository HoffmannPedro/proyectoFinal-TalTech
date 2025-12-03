package com.alphapets.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@DiscriminatorValue("ALIMENTO")
public class Alimento extends Producto {
    private double pesoKg;
    private boolean esHipoalergenico;

    @Override
    public String obtenerDetallesEtiqueta() {
        return "Alimento: " + nombre + " - " + pesoKg + "kg";
    }
}

