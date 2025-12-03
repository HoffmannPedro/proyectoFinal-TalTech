package com.alphapets.services;

import com.alphapets.models.Producto;
import com.alphapets.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }
    
    public List<Producto> buscarPorNombre(String termino) {
        return productoRepository.findByNombreContainingIgnoreCase(termino);
    }

    public Producto guardarProducto(Producto producto) {
        // Validar datos coherentes
        if (producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
    
    public void descontarStock(Long productoId, int cantidad) {
        Producto p = productoRepository.findById(productoId).orElseThrow();
        p.setStock(p.getStock() - cantidad);
        productoRepository.save(p);
    }
}