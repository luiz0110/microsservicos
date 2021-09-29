package br.com.tech4me.animaisms.clienteHTTP;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tech4me.animaisms.compartilhado.Produto;
import br.com.tech4me.animaisms.model.AcertoDeEstoque;


@FeignClient(name = "produto-ms", fallback = AcertoDeEstoqueFallback.class)
public interface VendasFeignClient {
  @PostMapping(value = "/api/produtos/{id}/acertoestoque", consumes = "application/json")
  Produto alterarEstoque(@RequestBody AcertoDeEstoque acerto, @PathVariable int id);
}

@Component
class AcertoDeEstoqueFallback implements VendasFeignClient{

  @Override
  public Produto alterarEstoque(AcertoDeEstoque acerto, int id) {
    return null;
  }  
}
