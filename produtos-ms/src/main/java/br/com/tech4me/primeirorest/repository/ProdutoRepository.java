package br.com.tech4me.primeirorest.repository;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.primeirorest.compartilhado.ProdutoDto;
import br.com.tech4me.primeirorest.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

    ProdutoDto save(ProdutoDto produto);

    //List<Produto> findByOrderByNomeAsc();

    //Optional<Produto> findById(int idProduto);

}
