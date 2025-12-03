package com.alphapets.exceptions;

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String nombreProducto, int stockDisponible, int cantidadSolicitada) {
        super("Error de Stock: El producto '" + nombreProducto +
                "' solo tiene " + stockDisponible + " unidades. Solicitadas: " + cantidadSolicitada);
    }
}
