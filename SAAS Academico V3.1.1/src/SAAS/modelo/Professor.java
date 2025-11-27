package SAAS.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa um Professor.
 * Identificado pelo seu Registro Funcional.
 * * @author Grupo 5
 * @version 1.0
 */
public class Professor extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String registroFuncional;

    /**
     * Construtor do Professor.
     * * @param cpf               CPF do professor
     * @param nome              Nome completo
     * @param dataNascimento    Data de nascimento
     * @param registroFuncional Código de registro do professor
     */
    public Professor(String cpf, String nome, String dataNascimento, String registroFuncional) {
        super(cpf, nome, dataNascimento);
        this.registroFuncional = registroFuncional;
    }

    public String getRegistroFuncional() {
        return registroFuncional;
    }
    
    @Override
    public String toString() {
        return "Professor [Registro: " + registroFuncional + ", " + super.toString() + "]";
    }

    /**
     * Compara dois professores pelo Registro Funcional.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Professor outro = (Professor) obj;
        return Objects.equals(registroFuncional, outro.registroFuncional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registroFuncional);
    }
}