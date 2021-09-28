package br.com.tech4me.animaisms.view.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.google.common.reflect.TypeToken;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.animaisms.compartilhado.Produto;
import br.com.tech4me.animaisms.compartilhado.VendaDto;
import br.com.tech4me.animaisms.service.VendaService;
import br.com.tech4me.animaisms.view.model.VendaModeloRequest;
import br.com.tech4me.animaisms.view.model.VendaModeloResponse;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }    

    @PostMapping
    public ResponseEntity<VendaModeloResponse> criarVenda(@RequestBody @Valid VendaModeloRequest venda) {
        ModelMapper mapper = new ModelMapper();
        VendaDto vendaDto = mapper.map(venda, VendaDto.class);
        Produto produto = new Produto();
        
        produto.setId(venda.getProduto());
        vendaDto.setProduto(produto);

        vendaDto = service.criarVenda(vendaDto);
        System.out.println(vendaDto.getProduto());

        return new ResponseEntity<>(mapper.map(vendaDto, VendaModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<VendaModeloResponse>> obterTodos() {
        List<VendaDto> vendas = service.obterTodasAsVendas();

        if(vendas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<VendaModeloResponse> resp = vendas.stream()
                    .map(dto -> mapper.map(dto, VendaModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/{dataInicio}/{dataFim}/lista")
    public ResponseEntity<List<VendaModeloResponse>> getPorData(
        @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataInicio,
        @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataFim) {
      List<VendaDto> vendas = service.obterPorPeriodo(dataInicio, dataFim);
      TypeToken<List<VendaModeloResponse>> token = new TypeToken<>() {
      };
      List<VendaModeloResponse> saida = new ModelMapper().map(vendas, token.getType());
  
      return new ResponseEntity<>(saida, HttpStatus.OK);
    }
}
