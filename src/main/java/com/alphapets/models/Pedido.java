package com.alphapets.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime fecha;
    private double total;
    private String estado; // "PENDIENTE", "CONFIRMADO"

    // Relación Uno a Muchos con LineaPedido
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pedido_id") // Crea FK en la tabla linea_pedido
    private List<LineaPedido> lineas = new ArrayList<>();

    public void agregarLinea(LineaPedido linea) {
        lineas.add(linea);
        recalcularTotal();
    }

    public void recalcularTotal() {
        this.total = 0;
        for (LineaPedido linea : lineas) {
            this.total += linea.getSubtotal(); // Operador aritmético
        }
    }
}
