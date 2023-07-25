package com.dev.java17;

import java.math.BigDecimal;

public record ProdutoRecord(Long id, String descricao, BigDecimal valor) {

    public ProdutoRecord mudarDescricao(String descricao) {
        return new ProdutoRecord(id(), descricao, valor());
    }

    public ProdutoRecord mudarValor(BigDecimal valor) {
        return new ProdutoRecord(id(), descricao(), valor);
    }
}
