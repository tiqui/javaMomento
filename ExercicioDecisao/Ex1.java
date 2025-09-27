package Decisoes;
import java.util.Scanner;
public class Ex1 
{
    public static void main(String[] args)
    {
    Scanner entrada = new Scanner(System.in);
    
    int num1;
    int num2;    
            
    System.out.print("VALOR 1: ");
    num1 = entrada.nextInt();
    
    System.out.print("VALOR 2: ");
    num2 = entrada.nextInt();
            
    if(num2 <= 0){        
        System.out.print("Divisao indeterminada.");
    }else{
        int calculo = num1 / num2;
        System.out.print(calculo);
        }
            
    } 
}

/*1. Construa um algoritmo que leia dois números inteiros e verifique se a divisão seja indeterminada
(denominador igual a zero). Em caso afirmativo, imprima contrário, imprima o resultado da divisão. Considere a divisão do primeiro pelo segundo. */

