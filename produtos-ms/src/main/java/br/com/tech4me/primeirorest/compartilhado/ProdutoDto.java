package br.com.tech4me.primeirorest.compartilhado;

import java.util.List;

public class ProdutoDto {
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
    public List<Venda> getVendas() {
        return vendas;
    }
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
   //#endregion
}
