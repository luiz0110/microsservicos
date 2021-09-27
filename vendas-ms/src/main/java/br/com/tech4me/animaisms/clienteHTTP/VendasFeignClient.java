package br.com.tech4me.animaisms.clienteHTTP;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tech4me.animaisms.model.dtos.AcertoDeEstoque;
import br.com.tech4me.animaisms.model.dtos.ProdutoDto;

@FeignClient(name = "produto-ms", fallback = AcertoDeEstoqueFallback.class)
public interface VendasFeignClient {
  @PostMapping(value = "/api/produtos/{id}/acertoestoque", consumes = "application/json")
  ProdutoDto alterarEstoque(@RequestBody AcertoDeEstoque acerto, @PathVariable int id);
}

@Component
class AcertoDeEstoqueFallback implements VendasFeignClient{

  @Override
  public ProdutoDto alterarEstoque(AcertoDeEstoque acerto, int id) {
    return null;
  }  
}
