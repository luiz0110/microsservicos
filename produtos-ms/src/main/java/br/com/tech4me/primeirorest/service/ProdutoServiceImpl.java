package br.com.tech4me.primeirorest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.primeirorest.compartilhado.ProdutoDto;
import br.com.tech4me.primeirorest.model.Produto;
import br.com.tech4me.primeirorest.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{
    @Autowired
    private ProdutoRepository repositorio;

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();
        Produto produtoEntidade = mapper.map(produto, Produto.class);
        produtoEntidade = repositorio.save(produtoEntidade);

        return mapper.map(produtoEntidade, ProdutoDto.class);
    }

     @Override
    public Optional<ProdutoDto> obterPorId(String id) {
        Optional<Produto> produto = repositorio.findById(id);
        
        if (produto.isPresent()) {
            return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
        }
        return Optional.empty();
    }

    @Override
    public List<ProdutoDto> obterTodos(){
        List<Produto> produtos = repositorio.findAll();

        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public void removerProduto(String id) {
        repositorio.deleteById(id);
        
    }

   

    /*@Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        return salvarProduto(produto);
    }
    
    @Override
    public List<ProdutoDto> obterTodos() {
        List<Produto> produtos = repo.findAll();

        return produtos.stream()
            .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> obterPorId(String id) {
       Optional<Produto> produto = repo.findById(id);

        
       if(produto.isPresent()) {
           return Optional.of(new ModelMapper().map(produto, ProdutoDto.class));
       }

       return Optional.empty();
    }

    @Override
    public void removerProduto(String id) {
        repo.deleteById(id);
    }

    private ProdutoDto salvarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();
        Produto produtoEntidade = mapper.map(produto, Produto.class);
        produtoEntidade = repo.save(produtoEntidade);

        return mapper.map(produtoEntidade, ProdutoDto.class);
    }*/
              
}
