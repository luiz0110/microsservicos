package br.com.tech4me.primeirorest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.primeirorest.compartilhado.ProdutoDto;
import br.com.tech4me.primeirorest.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

    ProdutoDto save(ProdutoDto produto);
}
