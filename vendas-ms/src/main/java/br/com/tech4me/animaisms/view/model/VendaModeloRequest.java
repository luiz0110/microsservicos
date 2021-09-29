package br.com.tech4me.animaisms.view.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.tech4me.animaisms.compartilhado.Produto;

public class VendaModeloRequest {
    @NotNull(message = "A data deve ser Informada!")
    private LocalDate data;

    @NotNull(message = "O Produto deve ser Informado!")
    private Produto produto;

    @NotNull(message = "A Quantidade em estoque de ser Informada")
    @Min(value = 1, message = "A quantidade NÂO pode ser menor que Um")
    private int quantidade;

    //#region Get/Set
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    //#endregion    
}
