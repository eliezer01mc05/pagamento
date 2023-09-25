package com.eliezer.pagamento.entidades;

public class AtualizacaoStatusPagamento {
    private Long idPagamento;
    private Long idNovoStatus;

    public AtualizacaoStatusPagamento() {
    }

    public AtualizacaoStatusPagamento(Long idPagamento, Long idNovoStatus) {
        this.idPagamento = idPagamento;
        this.idNovoStatus = idNovoStatus;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Long getIdNovoStatus() {
        return idNovoStatus;
    }

    public void setIdNovoStatus(Long idNovoStatus) {
        this.idNovoStatus = idNovoStatus;
    }
}
