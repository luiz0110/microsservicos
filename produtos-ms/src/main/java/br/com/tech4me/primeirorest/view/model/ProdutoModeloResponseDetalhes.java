package br.com.tech4me.primeirorest.view.model;

import java.util.List;

import br.com.tech4me.primeirorest.compartilhado.Venda;


public class ProdutoModeloResponseDetalhes {
    private String id;
    private String nome;
    private Integer codigo;
    private List<Venda> vendas;

    //#region Get/Set
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public List<Venda> getVendas() {
        return vendas;
    }
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    //#endregion       
}
