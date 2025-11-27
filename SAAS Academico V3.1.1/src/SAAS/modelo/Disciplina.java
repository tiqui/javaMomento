package SAAS.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe que representa uma Disciplina (Matéria) no sistema.
 * Contém informações sobre o professor responsável e a lista de alunos.
 * * @author Grupo 5
 * @version 1.0
 */
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nome;
    private Professor professor;
    private int limiteAlunos;
    private final List<Aluno> alunosMatriculados;

    /**
     * Construtor da Disciplina.
     * * @param codigo       Código único da disciplina (ex: MAT01)
     * @param nome         Nome da disciplina
     * @param limiteAlunos Capacidade máxima da turma
     */
    public Disciplina(String codigo, String nome, int limiteAlunos) {
        this.codigo = codigo;
        this.nome = nome;
        this.limiteAlunos = limiteAlunos;
        this.alunosMatriculados = new ArrayList<>();
    }

    // --- Getters e Setters ---
    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getLimiteAlunos() { return limiteAlunos; }
    public List<Aluno> getAlunosMatriculados() { return alunosMatriculados; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }
    
    /**
     * Tenta adicionar um aluno na lista da disciplina.
     * @param aluno Aluno a ser inserido
     * @return true se foi adicionado, false se a turma estiver cheia
     */
    public boolean adicionarAluno(Aluno aluno) {
        if (alunosMatriculados.size() < limiteAlunos) {
            alunosMatriculados.add(aluno);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String profNome = (professor != null) ? professor.getNome() : "Não Atribuído";
        return "Disciplina [Código: " + codigo + ", Nome: " + nome + 
               ", Professor: " + profNome + ", Alunos: " + alunosMatriculados.size() + "/" + limiteAlunos + "]";
    }

    /**
     * Compara disciplinas pelo Código.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Disciplina outro = (Disciplina) obj;
        return Objects.equals(codigo, outro.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}