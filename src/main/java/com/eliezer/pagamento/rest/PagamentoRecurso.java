package com.eliezer.pagamento.rest;

import com.eliezer.pagamento.servicos.PagamentoServico;
import com.eliezer.pagamento.entidades.AtualizacaoStatusPagamento;
import com.eliezer.pagamento.entidades.Pagamento;
import com.eliezer.pagamento.entidades.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoRecurso {

    @Autowired
    private PagamentoServico pagamentoServico;

    @PostMapping
    public ResponseEntity<Pagamento> salvar(@RequestBody Pagamento pagamento) {
        pagamento.setNumCartao((pagamento.getMetodoPagamento() == 1 || pagamento.getMetodoPagamento() == 2) ? null : pagamento.getNumCartao());
        return ResponseEntity.ok(pagamentoServico.salvarPagamento(pagamento));
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>>buscar(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String cpfCnpj,
            @RequestParam(required = false) Long status) {
        return new ResponseEntity<>(pagamentoServico.buscar(id, cpfCnpj, status), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Resposta> atualizar(@RequestBody AtualizacaoStatusPagamento atualizacaoStatusPagamento) {
        Resposta resposta = new Resposta(pagamentoServico.atualizarPagamento(atualizacaoStatusPagamento.getIdPagamento(), atualizacaoStatusPagamento.getIdNovoStatus()));

        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Resposta> excluir(@PathVariable Long id) {
        Resposta resposta = new Resposta(pagamentoServico.excluirPagamento(id));
        return ResponseEntity.ok(resposta);
    }

}
