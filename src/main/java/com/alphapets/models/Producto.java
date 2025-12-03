package com.alphapets.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_producto")
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "tipo"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Alimento.class, name = "ALIMENTO"),
    @JsonSubTypes.Type(value = Accesorio.class, name = "ACCESORIO")
})
public abstract class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected int stock;
    protected String imagenUrl;

    public Producto() {}
    
    // Devuelve info específica según la subclase
    public abstract String obtenerDetallesEtiqueta();
}