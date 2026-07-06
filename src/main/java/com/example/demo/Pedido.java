package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private Double total;
    private String estado; // PENDIENTE, PAGADO, ENVIADO

    public Pedido() {
    }

    public Pedido(Long id, String cliente, Double total, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
        this.estado = estado;
    }

    public Pedido(String cliente, Double total, String estado) {
        this.cliente = cliente;
        this.total = total;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(cliente, pedido.cliente)
                && Objects.equals(total, pedido.total) && Objects.equals(estado, pedido.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, total, estado);
    }
}
