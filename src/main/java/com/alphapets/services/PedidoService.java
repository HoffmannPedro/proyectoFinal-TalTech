package com.alphapets.services;

import com.alphapets.exceptions.StockInsuficienteException;
import com.alphapets.models.*;
import com.alphapets.repositories.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    @Transactional // Rollback si falla alguna validación de stock
    public Pedido crearPedido(Pedido nuevoPedido) {
        
        for (LineaPedido linea : nuevoPedido.getLineas()) {
            Producto productoEnBD = productoRepository.findById(linea.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + linea.getProductoId()));

            // Verificar disponibilidad
            if (productoEnBD.getStock() < linea.getCantidad()) {
                throw new StockInsuficienteException(
                    productoEnBD.getNombre(), 
                    productoEnBD.getStock(), 
                    linea.getCantidad()
                );
            }

            // Actualizar stock y asegurar precios actualizados
            productoEnBD.setStock(productoEnBD.getStock() - linea.getCantidad());
            productoRepository.save(productoEnBD);
            
            linea.setPrecioUnitario(productoEnBD.getPrecio());
            linea.setSubtotal(productoEnBD.getPrecio() * linea.getCantidad());
        }

        nuevoPedido.setFecha(java.time.LocalDateTime.now());
        nuevoPedido.setEstado("CONFIRMADO");
        nuevoPedido.recalcularTotal();
        
        return pedidoRepository.save(nuevoPedido);
    }
}