package SAAS.modelo;

import java.io.Serializable;

/**
 * Classe abstrata base que representa uma Pessoa no sistema.
 * Contém dados comuns a Alunos e Professores.
 * * @author Grupo 5
 */
public abstract class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cpf;
    private String nome;
    private String dataNascimento;

    public Pessoa(String cpf, String nome, String dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    
    @Override
    public String toString() { 
        return "Nome: " + nome + ", CPF: " + cpf; 
    }
}