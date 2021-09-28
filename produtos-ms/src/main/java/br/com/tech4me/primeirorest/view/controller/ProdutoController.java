package br.com.tech4me.primeirorest.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.primeirorest.compartilhado.ProdutoDto;

import br.com.tech4me.primeirorest.service.ProdutoServiceImpl;
import br.com.tech4me.primeirorest.view.model.ProdutoModeloResponse;



@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoServiceImpl servico;

    @PostMapping
    public ResponseEntity<ProdutoDto> criarProduto(@RequestBody @Valid ProdutoDto produto){
        ModelMapper mapper = new ModelMapper();
        ProdutoDto dto = mapper.map(produto, ProdutoDto.class);
        dto = servico.criarProduto(dto);
        return new ResponseEntity<>(mapper.map(dto,ProdutoDto.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModeloResponse>> obterTodos(){
        ModelMapper mapper = new ModelMapper();
        List<ProdutoDto> dtos = servico.obterTodos();
        List<ProdutoModeloResponse> resp = dtos.stream()
            .map(dto -> mapper.map(dto, ProdutoModeloResponse.class)).collect(Collectors.toList());

            return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<ProdutoModeloResponse> obterPorId(@PathVariable String id){
        Optional<ProdutoDto> produto = servico.obterPorId(id);

        if (produto.isPresent()) {
          return new ResponseEntity<>(
            new ModelMapper().map(produto.get(),
              ProdutoModeloResponse.class), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable String id) {
        servico.removerProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
