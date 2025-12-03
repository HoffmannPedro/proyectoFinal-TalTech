package com.alphapets.controllers;

import com.alphapets.models.Pedido;
import com.alphapets.models.Producto;
import com.alphapets.services.PedidoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*") // Permitir que el front acceda
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidoService.listarPedidos();
    }
    

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido) {
        try {
            Pedido pedidoGuardado = pedidoService.crearPedido(pedido);
            return ResponseEntity.ok(pedidoGuardado);
        } catch (com.alphapets.exceptions.StockInsuficienteException e) {
            // Retornar error 400 (Bad Request) con el mensaje de la excepción
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al procesar pedido");
        }
    }
}