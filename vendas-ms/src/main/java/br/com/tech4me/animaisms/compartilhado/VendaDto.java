package br.com.tech4me.animaisms.compartilhado;

import java.time.LocalDate;

public class VendaDto {
    private Integer id;
    private LocalDate data;
    private Produto produto;
    private Integer quantidade;

    //#region
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
    
}
