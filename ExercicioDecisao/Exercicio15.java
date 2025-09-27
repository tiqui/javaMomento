package Lista2;
import java.util.Scanner;
public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int horaInicial, minutoInicial;
        int horaFinal, minutoFinal;
        int duracaoHoras, duracaoMinutos;

        System.out.print("Entrada da hora inicial do jogo: ");
        horaInicial = scanner.nextInt();
        System.out.print("Entrada do minuto inicial do jogo: ");
        minutoInicial = scanner.nextInt();

        System.out.print("Entrada da hora final do jogo: ");
        horaFinal = scanner.nextInt();
        System.out.print("Entrada do minuto final do jogo: ");
        minutoFinal = scanner.nextInt();

        if (horaInicial < 0 || horaInicial > 23 || horaFinal < 0 || horaFinal > 23 || 
            minutoInicial < 0 || minutoInicial > 59 || minutoFinal < 0 || minutoFinal > 59) {
            System.out.println("Entrada de dados não é válida.");
        } else {
            int totalMinutosInicial = horaInicial * 60 + minutoInicial;
            int totalMinutosFinal = horaFinal * 60 + minutoFinal;
            
            int duracaoTotalMinutos;

            if (totalMinutosFinal >= totalMinutosInicial) {
                duracaoTotalMinutos = totalMinutosFinal - totalMinutosInicial;
            } else {
                duracaoTotalMinutos = (24 * 60 - totalMinutosInicial) + totalMinutosFinal;
            }

            duracaoHoras = duracaoTotalMinutos / 60;
            duracaoMinutos = duracaoTotalMinutos % 60;

            System.out.printf("Duração do jogo: %d hora(s) e %d minuto(s)%n", duracaoHoras, duracaoMinutos);
        }
    }
}