package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> obtenerPorEstado(String estado) {
        return pedidoRepository.findByEstado(estado);
    }
}
