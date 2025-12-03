package com.alphapets.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lineas_pedido")
public class LineaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long productoId;
    
    // Persistimos el nombre y precio al momento de la compra
    // por si cambian en el futuro en la tabla Producto.
    private String nombreProducto;
    private double precioUnitario;
    
    private int cantidad;
    private double subtotal;

    public LineaPedido() {}

    public LineaPedido(Long productoId, String nombreProducto, double precioUnitario, int cantidad) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.subtotal = precioUnitario * cantidad;
    }
}