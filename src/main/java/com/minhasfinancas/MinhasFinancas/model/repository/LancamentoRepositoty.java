package com.minhasfinancas.MinhasFinancas.model.repository;

import com.minhasfinancas.MinhasFinancas.model.entity.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepositoty extends JpaRepository<Lancamento, Long> {
}
