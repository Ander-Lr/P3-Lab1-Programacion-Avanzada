package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> porEstado(@RequestParam String estado) {
        return pedidoService.obtenerPorEstado(estado);
    }

    @org.springframework.web.bind.annotation.PostMapping
    public org.springframework.http.ResponseEntity<Pedido> crear(@org.springframework.web.bind.annotation.RequestBody Pedido pedido) {
        Pedido creado = pedidoService.crearPedido(pedido);
        return org.springframework.http.ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body(creado);
    }
}
