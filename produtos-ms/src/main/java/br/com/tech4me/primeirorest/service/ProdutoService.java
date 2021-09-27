package br.com.tech4me.primeirorest.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.primeirorest.compartilhado.ProdutoDto;

public interface ProdutoService {
    ProdutoDto criarProduto(ProdutoDto produto);
    List<ProdutoDto> obterTodos();
    Optional<ProdutoDto> obterPorId(String id);
    void removerProduto(String id);
    
}
