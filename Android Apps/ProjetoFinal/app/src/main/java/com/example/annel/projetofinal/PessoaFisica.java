package com.example.annel.projetofinal;
//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluna...........: Anne Livia da Fonseca Macedo

//******************************************************

/**
 * Created by annel on 09/12/2017.
 */

// Classe no qual contém os atributos necessarios para que se possa obter as informações da pessoa física e armazenar no banco de dados
public class PessoaFisica {
    private String nome, email, telefone, cpf; // Declaração dos atributos do tipo string
    private int idade; // Declaração do atributo do tipo Inteiro

    // Construtor da classe PessoaFisica
    public PessoaFisica(String nome, int idade, String cpf, String telefone, String email)
    {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    // Abaixo segue os metodos getters e setters de todos os atributos

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setIdade(int idade)
    {
        this.idade = idade;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getTelefone()
    {
        return this.telefone;
    }

    public void setCpf(String cpf)
    {
        this.cpf = cpf;
    }

    public String getCpf()
    {
        return this.cpf;
    }
}
