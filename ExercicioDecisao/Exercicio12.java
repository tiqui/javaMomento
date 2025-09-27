package Lista2;
import java.util.Scanner;
public class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char sexo;
        int idade;

        System.out.print("Digite o sexo (M para masculino, F para feminino): ");
        sexo = scanner.next().charAt(0);
        
        System.out.print("Digite a idade: ");
        idade = scanner.nextInt();

        if (sexo == 'M' || sexo == 'm') {
            if (idade >= 21) {
                System.out.println("Pessoa do sexo masculino e maior de idade.");
            } else {
                System.out.println("Pessoa do sexo masculino e menor de idade.");
            }
        } else if (sexo == 'F' || sexo == 'f') {
            if (idade >= 18) {
                System.out.println("Pessoa do sexo feminino e maior de idade.");
            } else {
                System.out.println("Pessoa do sexo feminino e menor de idade.");
            }
        } else {
            System.out.println("Sexo inválido. Por favor, digite M ou F.");
        }

    }
}

/* Leia sexo e idade de uma pessoa e imprima maior idade ou menor idade, considerando que sexo masculino
e maior idade se maior igual a 21 anos e sexo feminino e maior idade se maior igual a 18 anos. */