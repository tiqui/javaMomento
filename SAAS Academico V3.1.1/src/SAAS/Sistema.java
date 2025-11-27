package SAAS;

import SAAS.modelo.Aluno;
import SAAS.modelo.Disciplina;
import SAAS.modelo.Matricula;
import SAAS.modelo.Professor;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    // --- ARQUIVOS DE DADOS (BINÁRIOS) ---
    private static final String ARQ_ALUNOS = "alunos.dat";
    private static final String ARQ_PROFESSORES = "professores.dat";
    private static final String ARQ_DISCIPLINAS = "disciplinas.dat";
    private static final String ARQ_MATRICULAS = "matriculas.dat";

    // --- CARREGAMENTO INICIAL ---
    private static List<Aluno> alunos = GerenciadorArquivos.carregar(ARQ_ALUNOS);
    private static List<Professor> professores = GerenciadorArquivos.carregar(ARQ_PROFESSORES);
    private static List<Disciplina> disciplinas = GerenciadorArquivos.carregar(ARQ_DISCIPLINAS);
    private static List<Matricula> matriculas = GerenciadorArquivos.carregar(ARQ_MATRICULAS);
    
    private static final Scanner scanner = new Scanner(System.in);

    // --- MÉTODO PRINCIPAL (MAIN) ---
   
   public static void main(String[] args) {
        // Carrega as cargas iniciais (apenas se os dados estiverem vazios)
        importarAlunosDeTxt(); 
        importarProfessoresDeTxt();
        importarDisciplinasDeTxt();

        System.out.println("--- Sistema Acadêmico SAAS ---");
        System.out.println("Status: " + alunos.size() + " alunos, " + 
                           professores.size() + " professores e " + 
                           disciplinas.size() + " disciplinas cadastradas.");
        
        exibirMenuPrincipal();
    }

    // --- IMPORTAÇÃO DE DADOS (TXT) ---
    private static void importarProfessoresDeTxt() {
        File arquivo = new File("carga_professores.txt");
        if (!professores.isEmpty() || !arquivo.exists()) return;

        try (Scanner leitor = new Scanner(arquivo)) {
            while (leitor.hasNextLine()) {
                String[] dados = leitor.nextLine().split(";");
                // CPF;Nome;Data;Registro
                if (dados.length == 4) {
                    professores.add(new Professor(dados[0].trim(), dados[1].trim(), dados[2].trim(), dados[3].trim()));
                }
            }
            System.out.println(">> Professores importados.");
            salvarTudo();
        } catch (Exception e) {
            System.out.println("ERRO ao importar professores: " + e.getMessage());
        }
    }

    // --- IMPORTAÇÃO DE DISCIPLINAS ---
    private static void importarDisciplinasDeTxt() {
        File arquivo = new File("carga_disciplinas.txt");
        if (!disciplinas.isEmpty() || !arquivo.exists()) return;

        try (Scanner leitor = new Scanner(arquivo)) {
            while (leitor.hasNextLine()) {
                String[] dados = leitor.nextLine().split(";");
                // Código;Nome;Limite
                if (dados.length == 3) {
                    int limite = Integer.parseInt(dados[2].trim());
                    disciplinas.add(new Disciplina(dados[0].trim(), dados[1].trim(), limite));
                }
            }
            System.out.println(">> Disciplinas importadas.");
            salvarTudo();
        } catch (Exception e) {
            System.out.println("ERRO ao importar disciplinas: " + e.getMessage());
        }
    }
    private static void importarAlunosDeTxt() {
        File arquivo = new File("carga_alunos.txt");

        // Se já tem alunos carregados (do .dat) ou não tem arquivo .txt, não faz nada
        if (!alunos.isEmpty() || !arquivo.exists()) {
            return; 
        }

        System.out.println(">> Detectado 'carga_alunos.txt'. Iniciando importação...");

        try (Scanner leitor = new Scanner(arquivo)) {
            int cont = 0;
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                // Formato esperado: CPF;Nome;Data;Matricula
                String[] dados = linha.split(";"); 

                if (dados.length == 4) {
                    String cpf = dados[0].trim();
                    String nome = dados[1].trim();
                    String data = dados[2].trim();
                    String mat = dados[3].trim();

                    alunos.add(new Aluno(cpf, nome, data, mat));
                    cont++;
                }
            }
            System.out.println(">> Sucesso! " + cont + " alunos importados.");
            
            // Salva imediatamente para criar o arquivo .dat
            salvarTudo(); 

        } catch (Exception e) {
            System.out.println("ERRO na importação: " + e.getMessage());
        }
    }

    // --- SALVAMENTO GERAL ---
    private static void salvarTudo() {
        GerenciadorArquivos.salvar(alunos, ARQ_ALUNOS);
        GerenciadorArquivos.salvar(professores, ARQ_PROFESSORES);
        GerenciadorArquivos.salvar(disciplinas, ARQ_DISCIPLINAS);
        GerenciadorArquivos.salvar(matriculas, ARQ_MATRICULAS);
    }

    // --- MENU PRINCIPAL ---
        private static void exibirMenuPrincipal() {
            int opcao = -1;
        do {
            System.out.println("\n=== MENU SAAS ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Disciplina");
            System.out.println("4. Realizar Matrícula");
            System.out.println("5. Lançar Notas e Faltas");
            System.out.println("6. Atribuir Professor a Disciplina"); // <--- NOVA OPÇÃO
            System.out.println("7. Listar Tudo");
            System.out.println("0. Sair e Salvar");
            System.out.print("Opção: ");
            
            try {
                String linha = scanner.nextLine().trim();
                // aceita entradas como "3" ou "3. Cadastrar Disciplina"
                java.util.regex.Matcher m = java.util.regex.Pattern.compile("^(\\d+)").matcher(linha);
                if (m.find()) {
                    opcao = Integer.parseInt(m.group(1));
                } else {
                    throw new NumberFormatException();
                }

                switch (opcao) {
                    case 1: cadastrarAluno(); break;
                    case 2: cadastrarProfessor(); break;
                    case 3: cadastrarDisciplina(); break;
                    case 4: realizarMatricula(); break;
                    case 5: lancarNotasEFaltas(); break;
                    case 6: atribuirProfessor(); break; // <--- CHAMA O NOVO MÉTODO
                    case 7: listarTudo(); break;        // <--- VIROU OPÇÃO 7
                    case 0: 
                        System.out.println("Salvando dados...");
                        salvarTudo(); 
                        System.out.println("Dados salvos. Tchau!"); 
                        break;
                    default: System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
                opcao = -1;
            }
        } while (opcao != 0);
        scanner.close();
    }

    // --- LÓGICA DE CADASTROS E NEGÓCIO ---
    
    private static void cadastrarAluno() {
        System.out.println("\n--- Cadastro de Aluno ---");
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine().trim();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine().trim();
        
        if (buscarAlunoPorMatricula(matricula) != null) { System.out.println("ERRO: Matrícula já existe."); return; }
        if (cpfJaCadastrado(cpf)) { System.out.println("ERRO: CPF já cadastrado."); return; }

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String data = scanner.nextLine().trim();
        
        alunos.add(new Aluno(cpf, nome, data, matricula));
        salvarTudo();
        System.out.println(">>> Aluno cadastrado!");
    }

    private static void cadastrarProfessor() {
        System.out.println("\n--- Cadastro de Professor ---");
        System.out.print("Registro Funcional: ");
        String registro = scanner.nextLine().trim();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine().trim();

        if (buscarProfessorPorRegistro(registro) != null) { System.out.println("ERRO: Registro já existe."); return; }
        if (cpfJaCadastrado(cpf)) { System.out.println("ERRO: CPF já cadastrado."); return; }

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Data de Nascimento: ");
        String data = scanner.nextLine().trim();
        
        professores.add(new Professor(cpf, nome, data, registro));
        salvarTudo();
        System.out.println(">>> Professor cadastrado!");
    }

    private static void cadastrarDisciplina() {
        System.out.println("\n--- Cadastro de Disciplina ---");
        System.out.print("Código: ");
        String codigo = scanner.nextLine().trim();
        
        if (buscarDisciplinaPorCodigo(codigo) != null) { System.out.println("ERRO: Código já existe."); return; }

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Limite de Alunos: ");
        try {
            int limite = Integer.parseInt(scanner.nextLine().trim());
            if (limite <= 0) throw new NumberFormatException();
            disciplinas.add(new Disciplina(codigo, nome, limite));
            salvarTudo();
            System.out.println(">>> Disciplina cadastrada!");
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Limite deve ser número positivo.");
        }
    }
    
    private static void realizarMatricula() {
        System.out.println("\n--- Realizar Matrícula ---");
        System.out.print("Matrícula do Aluno: ");
        String matAluno = scanner.nextLine().trim();
        System.out.print("Código da Disciplina: ");
        String codDisc = scanner.nextLine().trim();
        
        Aluno aluno = buscarAlunoPorMatricula(matAluno);
        Disciplina disciplina = buscarDisciplinaPorCodigo(codDisc);
        
        if (aluno == null || disciplina == null) {
            System.out.println("ERRO: Aluno ou Disciplina não encontrados.");
            return;
        }
        
        // Verifica duplicidade
        for (Matricula m : matriculas) {
            if (m.getAluno().equals(aluno) && m.getDisciplina().equals(disciplina)) {
                System.out.println("ERRO: Aluno já matriculado.");
                return;
            }
        }
        
        if (!disciplina.adicionarAluno(aluno)) {
             System.out.println("ERRO: Disciplina lotada.");
             return;
        }

        matriculas.add(new Matricula(aluno, disciplina, LocalDate.now().toString()));
        salvarTudo();
        System.out.println(">>> Matrícula realizada com sucesso!");
    }

    private static void lancarNotasEFaltas() {
        System.out.println("\n--- Lançamento de Notas ---");
        System.out.print("Matrícula do Aluno: ");
        String matAluno = scanner.nextLine().trim();
        System.out.print("Código da Disciplina: ");
        String codDisc = scanner.nextLine().trim();

        Matricula mat = null;
        for (Matricula m : matriculas) {
            if (m.getAluno().getMatricula().equalsIgnoreCase(matAluno) && 
                m.getDisciplina().getCodigo().equalsIgnoreCase(codDisc)) {
                mat = m;
                break;
            }
        }

        if (mat == null) {
            System.out.println("ERRO: Matrícula não encontrada.");
            return;
        }

        try {
            System.out.print("Nota Final (0-10): ");
            double nota = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("% de Faltas (0-100): ");
            double faltas = Double.parseDouble(scanner.nextLine().trim());

            if (nota < 0 || nota > 10 || faltas < 0 || faltas > 100) {
                System.out.println("ERRO: Valores inválidos.");
                return;
            }

            mat.setNotaFinal(nota);
            mat.setPorcentagemFaltas(faltas);
            salvarTudo();
            System.out.println(">>> Atualizado: " + mat.getSituacao());

        } catch (NumberFormatException e) {
            System.out.println("ERRO: Digite apenas números.");
        }
    }
    private static void atribuirProfessor() {
        System.out.println("\n--- Atribuir Professor a Disciplina ---");
        System.out.print("Código da Disciplina: ");
        String codDisc = scanner.nextLine().trim();
        
        Disciplina disciplina = buscarDisciplinaPorCodigo(codDisc);
        if (disciplina == null) {
            System.out.println("ERRO: Disciplina não encontrada.");
            return;
        }

        System.out.print("Registro Funcional do Professor: ");
        String regProf = scanner.nextLine().trim();

        Professor professor = buscarProfessorPorRegistro(regProf);
        if (professor == null) {
            System.out.println("ERRO: Professor não encontrado.");
            return;
        }

        // Realiza o vínculo
        disciplina.setProfessor(professor);
        salvarTudo();
        System.out.println(">>> Sucesso! Professor " + professor.getNome() + 
                           " atribuído à disciplina " + disciplina.getNome());
    }
    private static void listarTudo() {
        System.out.println("\n--- ALUNOS ---");
        if (alunos.isEmpty()) System.out.println("Nenhum aluno cadastrado.");
        else alunos.forEach(System.out::println);

        // --- AQUI ESTAVA FALTANDO: ---
        System.out.println("\n--- PROFESSORES ---");
        if (professores.isEmpty()) System.out.println("Nenhum professor cadastrado.");
        else professores.forEach(System.out::println);
        // -----------------------------

        System.out.println("\n--- DISCIPLINAS ---");
        if (disciplinas.isEmpty()) System.out.println("Nenhuma disciplina cadastrada.");
        else disciplinas.forEach(System.out::println);

        System.out.println("\n--- MATRÍCULAS ---");
        if (matriculas.isEmpty()) System.out.println("Nenhuma matrícula registrada.");
        else matriculas.forEach(System.out::println);
    }
    

    // --- HELPERS DE BUSCA ---
    private static Aluno buscarAlunoPorMatricula(String mat) {
        for (Aluno a : alunos) if (a.getMatricula().equalsIgnoreCase(mat)) return a;
        return null;
    }
    private static Professor buscarProfessorPorRegistro(String reg) {
        for (Professor p : professores) if (p.getRegistroFuncional().equalsIgnoreCase(reg)) return p;
        return null;
    }
    private static Disciplina buscarDisciplinaPorCodigo(String cod) {
        for (Disciplina d : disciplinas) if (d.getCodigo().equalsIgnoreCase(cod)) return d;
        return null;
    }
    private static boolean cpfJaCadastrado(String cpf) {
        for (Aluno a : alunos) if (a.getCpf().equalsIgnoreCase(cpf)) return true;
        for (Professor p : professores) if (p.getCpf().equalsIgnoreCase(cpf)) return true;
        return false;
    }
}