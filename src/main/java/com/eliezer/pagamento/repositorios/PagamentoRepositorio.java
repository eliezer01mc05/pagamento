package com.eliezer.pagamento.repositorios;

import com.eliezer.pagamento.entidades.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PagamentoRepositorio extends JpaRepository<Pagamento, Long> {
    @Query("SELECT p FROM Pagamento p WHERE (:id IS NULL OR p.id = :id) " +
            "AND (:cpfCnpj IS NULL OR p.cpfCnpj = :cpfCnpj) " +
            "AND (:status IS NULL OR p.status.id = :status)")
    List<Pagamento> findPagamentoByFilters(Long id, String cpfCnpj, Long status);
}
