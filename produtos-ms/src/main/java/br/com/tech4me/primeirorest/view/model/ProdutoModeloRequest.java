package br.com.tech4me.primeirorest.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProdutoModeloRequest {
    @NotBlank(message = "O nome do produto deve possuir caracteres não brancos")
    @NotEmpty(message = "O nome do produto deve ser preenchido")
    @Size(min = 3, message = "O nome do produto deve conter no mínimo 3 caracteres")
    private String nome;

    //#region Get/Set
    public String getNome() {
        return nome;
    }

    public void SetNome(String nome) {
        this.nome = nome;
    }   

    //#endregion
}
