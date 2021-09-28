package br.com.tech4me.primeirorest.compartilhado;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.tech4me.primeirorest.model.Produto;

@Document("vendas")
public class Venda {
    
    @Id
    private Integer id;
    private LocalDate data;
    private Produto produto;
    private Integer quantidade;
 
    public Venda() {}
 
    public Venda(Produto produto) {
        this.produto = produto;
    }
 
    public Venda(LocalDate data, Produto produto, Integer quantidade) {
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
    }
 
      //#region Get/Set
     public Integer getId() {
         return id;
     }
 
     public void setId(Integer id) {
         this.id = id;
     }
 
     public LocalDate getData() {
         return data;
     }
 
     public void setData(LocalDate data) {
         this.data = data;
     }
 
     public Produto getProduto() {
         return produto;
     }
 
     public void setProduto(Produto produto) {
       this.produto = produto;
     }
 
     public Integer getQuantidade() {
        return quantidade;
     }
 
     public void setQuantidade(Integer quantidade) {
     this.quantidade = quantidade;
     }
     //#endregion
 
     @Override
     public boolean equals(Object obj) {
         if(obj != null && obj instanceof Venda) {
             Venda v = ((Venda)obj);
             return data.equals(v.getData()) && produto.equals(v.getProduto());
         } else {
             return false;
         }
     }
 
     @Override
     public String toString() {
         return String.format("Data: %s __ Produto: [%s] __ Quantidade: %d", 
                              data, produto.toString(), quantidade);
     }
 }