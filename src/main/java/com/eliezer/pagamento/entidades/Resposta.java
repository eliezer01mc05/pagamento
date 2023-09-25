package com.eliezer.pagamento.entidades;

public class Resposta {
    private String mensagem;

    public Resposta(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
