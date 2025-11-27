package SAAS.modelo;

import java.io.Serializable;

public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L; // Boa prática para evitar erros de arquivo
    
    private Aluno aluno;
    private Disciplina disciplina;
    private String dataMatricula;
    
    // Novos Atributos para Regra de Negócio
    private double notaFinal;
    private double porcentagemFaltas; 

    public Matricula(Aluno aluno, Disciplina disciplina, String dataMatricula) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.dataMatricula = dataMatricula;
        this.notaFinal = 0.0;
        this.porcentagemFaltas = 0.0;
    }

    // --- Getters e Setters Necessários ---
    public Aluno getAluno() { return aluno; }
    public Disciplina getDisciplina() { return disciplina; }
    
    public void setNotaFinal(double nota) {
        this.notaFinal = nota;
    }

    public void setPorcentagemFaltas(double faltas) {
        this.porcentagemFaltas = faltas;
    }

    // --- Regra de Negócio: Cálculo de Aprovação ---
    public String getSituacao() {
        // Regra: Reprova se faltar mais de 25% OU tirar menos de 6.0
        if (porcentagemFaltas > 25.0) {
            return "REPROVADO POR FALTA";
        } else if (notaFinal >= 6.0) {
            return "APROVADO";
        } else {
            return "REPROVADO POR NOTA";
        }
    }

    @Override
    public String toString() {
        return String.format("Aluno: %-20s | Disc: %-10s | Nota: %5.2f | Faltas: %5.2f%% | Status: %s", 
                aluno.getNome(), 
                disciplina.getNome(), 
                notaFinal, 
                porcentagemFaltas, 
                getSituacao());
    }
}