package br.com.tech4me.primeirorest.compartilhado;


//import java.util.List;

public class ProdutoDto {
    
    private String id;
    private Integer codigo;
    private String nome;
    private double valorUnit;
    private Integer qtdEstoque;
    //private List<Venda> vendas;

    //#region Get/Set
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValorUnit() {
        return valorUnit;
    }
    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }
    public Integer getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    
   //#endregion
}
