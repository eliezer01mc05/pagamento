package com.eliezer.pagamento.servicos;

import com.eliezer.pagamento.entidades.Pagamento;
import com.eliezer.pagamento.entidades.Status;
import com.eliezer.pagamento.repositorios.PagamentoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoServico {

    private final PagamentoRepositorio pagamentoRepositorio;

    public PagamentoServico(PagamentoRepositorio pagamentoRepositorio) {
        this.pagamentoRepositorio = pagamentoRepositorio;
    }

    public Pagamento salvarPagamento(Pagamento pagamento){
        return pagamentoRepositorio.save(pagamento);
    }

    public List<Pagamento> buscar(Long id, String cpfCnpj, Long status){
        return pagamentoRepositorio.findPagamentoByFilters(id, cpfCnpj, status);
    }

    public String atualizarPagamento(Long idPagamento, Long idNovoStatus) {
        Pagamento pagamentoExistente = pagamentoRepositorio.findById(idPagamento).get();
        Pagamento pagamentoAtualizado = pagamentoExistente;
        String mensagemRetorno = "Desconhecido";

        if (pagamentoExistente.getStatus().getId() == 1 && idNovoStatus != 1){
            pagamentoAtualizado.setStatus(new Status(idNovoStatus));
            pagamentoRepositorio.save(pagamentoAtualizado);
            mensagemRetorno = "Status atualizado com sucesso!";
        } else if(pagamentoExistente.getStatus().getId() == 2) {
            mensagemRetorno = "O status atual é Processado e não pode ser atualizado!";
        } else if(pagamentoExistente.getStatus().getId() == 3 && idNovoStatus == 1){
            pagamentoRepositorio.save(pagamentoAtualizado);
            pagamentoAtualizado.setStatus(new Status(idNovoStatus));
            mensagemRetorno = "Status atualizado com sucesso! Processado com falha -> Pendente de Processamento";
        } else if(pagamentoExistente.getStatus().getId() == 3 && idNovoStatus == 2){
            mensagemRetorno = "O status não pode ser atualizado!";
        }

        return mensagemRetorno;
    }


    public String excluirPagamento(Long id){
        Pagamento pagamentoExistente = pagamentoRepositorio.findById(id).get();

        if(pagamentoExistente.getStatus().getId() == 1){
            pagamentoRepositorio.deleteById(id);
            return "Pagamento Excluído com sucesso!";
        } else {
            return "O pagamento não pode ser excluído";
        }


    }

}
