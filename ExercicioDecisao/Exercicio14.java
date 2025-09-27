package Lista2;
import java.util.Scanner;
public class Exercicio14 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        char tipoConsumidor;
        double consumo;
        double valorPago;

        System.out.print("Digite o tipo de consumidor (I - Industrial, C - Comercial, R - Residencial): ");
        tipoConsumidor = scanner.next().charAt(0);
        
        System.out.print("Digite a quantidade de energia consumida em kWh: ");
        consumo = scanner.nextDouble();

            if (tipoConsumidor == 'I' || tipoConsumidor == 'i') {
            valorPago = 0.68 * consumo + 34;
            System.out.printf("O valor a ser pago pelo consumidor Industrial é: R$ %.2f%n", valorPago);
            } else if (tipoConsumidor == 'C' || tipoConsumidor == 'c') 
        {
            valorPago = 0.37 * consumo + 45;
            System.out.printf("O valor a ser pago pelo consumidor Comercial é: R$ %.2f%n", valorPago);
            } else if (tipoConsumidor == 'R' || tipoConsumidor == 'r') 
        {
            valorPago = 0.77 * consumo - 22;
            System.out.printf("O valor a ser pago pelo consumidor Residencial é: R$ %.2f%n", valorPago);
            } else 
            {
            System.out.println("Tipo de consumidor inválido. Por favor, digite I, C ou R.");
            }

    }
}
