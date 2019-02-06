package com.example.annel.appbancodedados;

/**
 * Created by annel on 04/12/2017.
 */

// Classe Contato onde servirá para criação de objetos com os atributos referentes a classe
public class Contato {


    private String nome;
    private String endereco;
    private String empresa;

    public Contato(String nome, String endereco, String empresa)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.empresa = empresa;
    }


    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getEndereco()
    {
        return this.endereco;
    }

    public void setEmpresa(String empresa)
    {
        this.empresa = empresa;
    }

    public String getEmpresa()
    {
        return this.empresa;
    }
}
