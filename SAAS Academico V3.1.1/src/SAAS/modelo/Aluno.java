package SAAS.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa um Aluno no sistema acadêmico.
 * Herda de Pessoa e adiciona o atributo de matrícula.
 * * @author Grupo 5
 * @version 1.0
 */
public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String matricula;

    /**
     * Construtor padrão para criar um novo aluno.
     * * @param cpf            CPF do aluno
     * @param nome           Nome completo
     * @param dataNascimento Data de nascimento
     * @param matricula      Número de matrícula (único)
     */
    public Aluno(String cpf, String nome, String dataNascimento, String matricula) {
        super(cpf, nome, dataNascimento);
        this.matricula = matricula;
    }

    /**
     * Obtém a matrícula do aluno.
     * @return String com a matrícula
     */
    public String getMatricula() {
        return matricula;
    }
    
    /**
     * Retorna uma representação em texto do Aluno.
     */
    @Override
    public String toString() {
        return "Aluno [Matrícula: " + matricula + ", " + super.toString() + "]";
    }

    /**
     * Compara se dois objetos Aluno são iguais com base na matrícula.
     * Requisito obrigatório do projeto.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno outro = (Aluno) obj;
        return Objects.equals(matricula, outro.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}