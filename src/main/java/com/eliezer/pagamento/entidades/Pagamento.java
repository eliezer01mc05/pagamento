package com.eliezer.pagamento.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpfCnpj;
    private Integer metodoPagamento;
    private String numCartao;
    private Float valor;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Pagamento() {
    }

    public Pagamento(Long id, String cpfCnpj, Integer metodoPagamento, String numCartao, Float valor, Status status) {
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.metodoPagamento = metodoPagamento;
        this.numCartao = numCartao;
        this.valor = valor;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Integer getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(Integer metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(String numCartao) {
        this.numCartao = numCartao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
