package br.com.tech4me.animaisms.service;

import java.time.LocalDate;
import java.util.List;

import com.google.common.reflect.TypeToken;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.animaisms.clienteHTTP.VendasFeignClient;
import br.com.tech4me.animaisms.compartilhado.VendaDto;
import br.com.tech4me.animaisms.model.AcertoDeEstoque;
import br.com.tech4me.animaisms.model.Venda;
import br.com.tech4me.animaisms.repository.VendaRepository;

@Service
public class VendaService {
    @Autowired
    private VendaRepository repo;

    @Autowired
    private VendasFeignClient produtoClient;

    public List<VendaDto> obterTodasAsVendas() {
        List<Venda> vendas = repo.findByOrderByDataAsc();
        TypeToken<List<VendaDto>> tipo = new TypeToken<>(){};
        List<VendaDto> saida = new ModelMapper().map(vendas, tipo.getType());
    
        return saida;
      }
    
      public List<VendaDto> obterPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        List<Venda> vendas = repo.findByDataBetweenOrderByDataAsc(dataInicio, dataFim);
        TypeToken<List<VendaDto>> tipo = new TypeToken<>() {};
        List<VendaDto> saida = new ModelMapper().map(vendas, tipo.getType());
    
        return saida;
      }
    
      public VendaDto criarVenda(VendaDto novaVenda) {
        Venda venda = new ModelMapper().map(novaVenda, Venda.class);
        venda = repo.save(venda);
    
        AcertoDeEstoque acerto = new AcertoDeEstoque();
        acerto.setQuantidadeVendida(venda.getQuantidade());
    
        produtoClient.alterarEstoque(acerto, venda.getProduto().getId());
        
        novaVenda.setId(venda.getId());
    
        return novaVenda;
      }
   
}
