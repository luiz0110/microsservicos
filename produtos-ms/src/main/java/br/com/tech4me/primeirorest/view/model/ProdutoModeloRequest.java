package br.com.tech4me.primeirorest.view.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdutoModeloRequest {
    @NotNull(message = "O Código não pode ficar em branco!")
    private Integer codigo;

    @NotBlank(message = "O nome do produto deve possuir caracteres não brancos")
    @NotEmpty(message = "O nome do produto deve ser preenchido")
    @Size(min = 3, message = "O nome do produto deve conter no mínimo 3 caracteres")
    private String nome;

    @NotNull(message = "O Valor Unitário do produto deve ser informado!")
    private double valorUnit;

    @NotNull(message = "A Quantidade em estoque de ser Informada")
    @Min(value = 1, message = "A quantidade NÂO pode ser menor que Um")
    private Integer qtdEstoque;

    //#region Get/Set
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
