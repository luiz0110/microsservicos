package br.com.tech4me.animaisms.model.dtos;

import java.util.List;

import br.com.tech4me.animaisms.model.Venda;

public class ProdutoDto {
    private String id;
    private String nome;
    private int codigo;
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
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
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
