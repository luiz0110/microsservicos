package br.com.tech4me.animaisms.view.model;

import java.time.LocalDate;

import br.com.tech4me.animaisms.compartilhado.Produto;

public class VendaModeloResponse {
  private int id;
  private LocalDate data;
  private Produto produto;
  private int quantidade;

  //#region Get/Set
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
//#region
}
