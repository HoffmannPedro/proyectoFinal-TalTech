package com.alphapets.controllers;

import com.alphapets.models.Producto;
import com.alphapets.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier navegador
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // 1. Obtener todos los productos (GET /api/productos)
    @GetMapping
    public List<Producto> obtenerTodos() {
        return productoService.listarProductos();
    }

    // 2. Obtener un producto por ID (GET /api/productos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {
        Optional<Producto> producto = productoService.buscarPorId(id);
        // Operador ternario o funcional para responder 404 si no existe
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Buscar productos por nombre (GET /api/productos/buscar?q=nombre)
    @GetMapping("/buscar")
    public List<Producto> buscarPorNombre(@RequestParam String q) {
        return productoService.buscarPorNombre(q);
    }

    // 4. Crear un nuevo producto (POST /api/productos)
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        try {
            Producto nuevo = productoService.guardarProducto(producto);
            return ResponseEntity.ok(nuevo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 5. Actualizar un producto existente (PUT /api/productos/{id})
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody Producto productoDetalles) {
        Optional<Producto> productoOptional = productoService.buscarPorId(id);

        if (productoOptional.isPresent()) {
            Producto productoExistente = productoOptional.get();

            // Actualizamos los campos
            productoExistente.setNombre(productoDetalles.getNombre()); // Asumiendo que agregaste getters/setters en
                                                                       // Producto
            productoExistente.setDescripcion(productoDetalles.getDescripcion());
            productoExistente.setPrecio(productoDetalles.getPrecio());
            productoExistente.setStock(productoDetalles.getStock());
            productoExistente.setImagenUrl(productoDetalles.getImagenUrl());

            Producto actualizado = productoService.guardarProducto(productoExistente);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 6. Eliminar un producto (DELETE /api/productos/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}