package flerovio.codigos;
import java.util.Scanner;
public class IPI 
{
    public static void main(String[] args)
    {
    Scanner entrada = new Scanner(System.in);
    int quanti1 = 0;
    int quanti2 = 0;
    int ip = 0;
    double valor1 = 170.00;
    double valor2 = 120.00;
        
    System.out.print("Quantos produtos 1: ");
    quanti1 = entrada.nextInt();
    System.out.print("Quantos produtos 2: ");
    quanti2 = entrada.nextInt();
    System.out.print("Porcentagem do IPI: ");
    ip = entrada.nextInt();
   
        
    double valores1 = valor1 * quanti1;
    double valores2 = valor2 * quanti2;
    
    double Soma = valores1 + valores2;
    
    double porcento = ip/100.0 + 1;
    
    double conta = Soma*porcento;
    
    System.out.print("total: " + conta);
    
      
    
    }
       
}
/* 9) Escrever um algoritmo que lê:
a) a porcentagem do IPI a ser acrescido no valor das peças
b) o código da peça 1, valor unitário da peça 1, quantidade de peças 1
c) o código da peça 2, valor unitário da peça 2, quantidade de peças 2
O algoritmo deve calcular o valor total a ser pago e apresentar o resultado.
Fórmula: (valor1*quant1 + valor2*quant2)*(IPI/100 + 1) */