package SAAS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivos {

    @SuppressWarnings("unchecked")
    public static <T> List<T> carregar(String nomeArquivo) {
        File f = new File(nomeArquivo);
        if (!f.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            return (List<T>) obj;
        } catch (Exception e) {
            System.out.println("Aviso: falha ao carregar '" + nomeArquivo + "' - usando lista vazia. " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static <T> void salvar(List<T> lista, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            System.out.println("Aviso: falha ao salvar '" + nomeArquivo + "': " + e.getMessage());
        }
    }
}
