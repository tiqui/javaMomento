package Lista2;
import java.util.Scanner;
public class Indeterminado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precoCobre = 2.00;
        double precoAluminio = 4.00;
        int quantidadeCobre, quantidadeAluminio;
        int quantidadeTotal;
        double valorTotalSemDesconto;
        double descontoPercentual = 0;
        double valorTotalComDesconto;

        System.out.print("Digite a quantidade de hastes de cobre: ");
        quantidadeCobre = scanner.nextInt();
        
        System.out.print("Digite a quantidade de hastes de aluminio: ");
        quantidadeAluminio = scanner.nextInt();
        
        quantidadeTotal = quantidadeCobre + quantidadeAluminio;

        if (quantidadeTotal > 20) {
            descontoPercentual = 0.20; // 20%
        } else if (quantidadeTotal >= 16) {
            descontoPercentual = 0.15; // 15%
        } else if (quantidadeTotal >= 5) {
            descontoPercentual = 0.10; // 10%
        } else {
            descontoPercentual = 0; // 0%
        }

        valorTotalSemDesconto = (quantidadeCobre * precoCobre) + (quantidadeAluminio * precoAluminio);

        valorTotalComDesconto = valorTotalSemDesconto * (1 - descontoPercentual);

        System.out.printf("Quantidade total de hastes: %d%n", quantidadeTotal);
        System.out.printf("Desconto aplicado: %.0f%%%n", descontoPercentual * 100);
        System.out.printf("Valor total a pagar: R$ %.2f%n", valorTotalComDesconto);

        scanner.close();
    }
}
/*1. Construa um algoritmo que leia dois números inteiros e verifique se a divisão seja indeterminada
(denominador igual a zero). Em caso afirmativo, imprima a seguinte mensagem: “Divisão indeterminada”, 
do contrário, imprima o resultado da divisão. Considere a divisão do primeiro pelo segundo.*/