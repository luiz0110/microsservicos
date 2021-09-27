package br.com.tech4me.animaisms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.animaisms.model.Venda;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {

	List<Venda> findByOrderByDataAsc();
    List<Venda> findByDataBetweenOrderByDataAsc(LocalDate dataInicio, LocalDate dataFim);
        
}
