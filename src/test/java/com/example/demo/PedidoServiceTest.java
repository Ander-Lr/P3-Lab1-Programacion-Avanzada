package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository pedidoRepository;

    @InjectMocks
    private PedidoService pedidoService;

    @Test
    void should_save_new_pedido_with_valid_data() {
        // Arrange
        Pedido nuevo = new Pedido("Luis", 40.0, "PENDIENTE");
        given(pedidoRepository.save(any(Pedido.class))).willReturn(nuevo);
        // Act
        Pedido resultado = pedidoService.crearPedido(nuevo);
        // Assert
        assertThat(resultado.getCliente()).isEqualTo("Luis");
        verify(pedidoRepository).save(nuevo);
    }
}
