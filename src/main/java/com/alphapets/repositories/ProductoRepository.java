package com.alphapets.repositories;

import com.alphapets.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Método personalizado para buscar por parte del nombre (Buscador)
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}