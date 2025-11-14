package Bloco;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class BlocoDeNotas extends JFrame implements ActionListener {
    
    private JTextArea areaTexto;
    private JFileChooser seletorArquivos;
    private File arquivoAtual = null; // Pra saber qual arquivo ta sendo editado

    public BlocoDeNotas() {
        super("Bloco de Notas by Flavio");
        
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        areaTexto = new JTextArea();
        add(new JScrollPane(areaTexto));
        
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");
        
        JMenuItem itemNovo = new JMenuItem("Novo");
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemSalvarComo = new JMenuItem("Salvar Como...");
        JMenuItem itemSair = new JMenuItem("Sair");
        
        itemNovo.addActionListener(this);
        itemAbrir.addActionListener(this);
        itemSalvar.addActionListener(this);
        itemSalvarComo.addActionListener(this);
        itemSair.addActionListener(this);
        
        menuArquivo.add(itemNovo);
        menuArquivo.add(itemAbrir);
        menuArquivo.add(itemSalvar);
        menuArquivo.add(itemSalvarComo);
        menuArquivo.addSeparator();
        menuArquivo.add(itemSair);
        
        barraMenu.add(menuArquivo);
        setJMenuBar(barraMenu);
        
        seletorArquivos = new JFileChooser();
        
        setVisible(true);
    }
        
    /*     A LÓGICA DE CADA BOTÃO DO MENU    */
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch (comando) {
            
            case "Novo":
                areaTexto.setText("");
                arquivoAtual = null;
                setTitle("Bloco de Notas by Flavio");
                break;

            case "Abrir":
                abrirArquivo();
                break;

            case "Salvar":
                salvarArquivo();
                break;

            case "Salvar Como...":
                salvarComo();
                break;
                
            case "Sair":
                System.exit(0);
                break;
        }
    }

    /*            PRA O ABRIR ARQUIVO          */
    private void abrirArquivo() {
        int escolha = seletorArquivos.showOpenDialog(this);

        if (escolha == JFileChooser.APPROVE_OPTION) {
            arquivoAtual = seletorArquivos.getSelectedFile();

            try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoAtual))) {
                areaTexto.setText(""); // limpa antes
                String linha;

                while ((linha = leitor.readLine()) != null) {
                    areaTexto.append(linha + "\n");
                }

                setTitle("Editando - " + arquivoAtual.getName());

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Erro ao abrir arquivo!", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /*               SALVAR ARQUIVO    */
    private void salvarArquivo() {
        // Se o arquivo já existe, sobrescreve
        if (arquivoAtual != null) {
            try (FileWriter escritor = new FileWriter(arquivoAtual)) {
                escritor.write(areaTexto.getText());
                JOptionPane.showMessageDialog(this, "Arquivo salvo!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            salvarComo();
        }
    }
    
    /*             SALVAR COMO...   */
    private void salvarComo() {
        int escolha = seletorArquivos.showSaveDialog(this);

        if (escolha == JFileChooser.APPROVE_OPTION) {
            arquivoAtual = seletorArquivos.getSelectedFile();

            try (FileWriter escritor = new FileWriter(arquivoAtual)) {
                escritor.write(areaTexto.getText());
                JOptionPane.showMessageDialog(this, "Arquivo salvo!");
                setTitle("Editando - " + arquivoAtual.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BlocoDeNotas());
    }
}
