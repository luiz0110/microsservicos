package br.com.tech4me.animaisms.compartilhado;

import java.time.LocalDate;

public class VendaDto {
    private int id;
    private LocalDate data;
    private Produto produto;
    private int quantidade;

    //#region
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    //#endregion
    
}
