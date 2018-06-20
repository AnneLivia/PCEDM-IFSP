/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomesobrenome;

/**
 *
 * @author annel
 */
public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setSobrenome(String sobrenome)
    {
        this.sobrenome = sobrenome;
    }
    
    public void setIdade(int idade)
    {
        this.idade = idade;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getSobrenome()
    {
        return this.sobrenome;
    }
    
    public int getIdade()
    {
        return this.idade;
    }
    
    // Função especial do java que especifica como os objetos serão impressos na tela pelo print, etc. similar ao _toString no php e a sobrecarga de operadas no c++ que é feito com o << e o >>
    public String toString()
    {
        return (this.nome + ", " + this.sobrenome + ", " + this.idade);
    }
}
