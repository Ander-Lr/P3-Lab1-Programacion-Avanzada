package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PedidoController.class)
class PedidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PedidoService pedidoService;

    @Test
    void should_return_pedidos_pendientes() throws Exception {
        // Arrange: given(pedidoService.obtenerPorEstado("PENDIENTE"))
        //          .willReturn(List.of(new Pedido(1L, "Ana", 25.0, "PENDIENTE")));
        given(pedidoService.obtenerPorEstado("PENDIENTE"))
                .willReturn(List.of(new Pedido(1L, "Ana", 25.0, "PENDIENTE")));

        // Act: mockMvc.perform(get("/api/pedidos").param("estado", "PENDIENTE"))
        // Assert: .andExpect(status().isOk())
        //         .andExpect(jsonPath("$[0].cliente").value("Ana"));
        mockMvc.perform(get("/api/pedidos").param("estado", "PENDIENTE"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cliente").value("Ana"));
    }
}
