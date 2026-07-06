package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PedidoRepositoryTest {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Test
    void should_find_pedidos_by_estado() {
        // Arrange guarda 2 pedidos PENDIENTE y 1 pedido PAGADO
        Pedido p1 = new Pedido("Cliente 1", 100.0, "PENDIENTE");
        Pedido p2 = new Pedido("Cliente 2", 200.0, "PENDIENTE");
        Pedido p3 = new Pedido("Cliente 3", 300.0, "PAGADO");
        pedidoRepository.save(p1);
        pedidoRepository.save(p2);
        pedidoRepository.save(p3);
        // Act invoca pedidoRepository.findByEstado("PENDIENTE")
        List<Pedido> resultados = pedidoRepository.findByEstado("PENDIENTE");
        // Assert verifica que el resultado contenga exactamente 2 pedidos
        assertThat(resultados).hasSize(2);
    }
}
