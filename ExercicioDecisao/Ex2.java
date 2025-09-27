
package Decisoes;
import java.util.Scanner;
public class Ex2 
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);        
        int num1;                
        System.out.print("valor1: ");
        num1 = entrada.nextInt();                               
        if(num1 == 0){        
            System.out.print("zero");        
        }else if(num1 % 2 == 0){        
        System.out.print("par");        
        }else{
        System.out.print("impar");        
        }            
    }
}


/*2. Faça um algoritmo que leia um número inteiro e verifique se ele é par ou ímpar. Imprima uma mensagem
correspondente ao resultado. Se o número for zero, imprima: “o valor é zero”.*/