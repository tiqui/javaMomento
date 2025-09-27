package Decisoes;
import java.util.Scanner;
public class Ex3 
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        
        double num1, num2;
        int opcao;
        
        System.out.println("Calculadora: ");     
        System.out.println("1 - Somar: ");  
        System.out.println("2 - Subtrair: ");           
        System.out.println("3 - Multiplicar: ");          
        System.out.println("4 - Dividir: ");
        System.out.println("0 - Sair: ");
        System.out.println("Informe a opção: ");
        opcao = entrada.nextInt();
        
        
                switch(opcao)
                {
                    case 1:
                        System.out.println("Informe o primeiro número: ");
                        num1 = entrada.nextDouble();
                        System.out.println("Informe o segundo número: ");
                        num2 = entrada.nextDouble();
                        System.out.println(num1+"+"+num2+" = "+(num1+num2)); 
                        break;
                        
                    case 2:
                        System.out.println("Informe o primeiro número: ");
                        num1 = entrada.nextDouble();
                        System.out.println("Informe o segundo número: ");
                        num2 = entrada.nextDouble();
                        System.out.println(num1+"-"+num2+" = "+(num1-num2)); 
                        break;
                        
                    case 3:
                        System.out.println("Informe o primeiro número: ");
                        num1 = entrada.nextDouble();
                        System.out.println("Informe o segundo número: ");
                        num2 = entrada.nextDouble();
                        System.out.println(num1+"*"+num2+" = "+(num1*num2)); 
                        break;
                        
                    case 4:
                        System.out.println("Informe o primeiro número: ");
                        num1 = entrada.nextDouble();
                        System.out.println("Informe o segundo número: ");
                        num2 = entrada.nextDouble();
                        System.out.println(num1+"/"+num2+" = "+(num1/num2)); 
                        break;
                        
                    case 0:
                        System.out.println("Fim do programa: ");
                        break;
                        
                    default:
                        System.out.print("Opcao invalida.");
                }
        
    }
}
/* 3. Faça um algoritmo que leia dois números inteiros e mostre um menu com quatro operações (+, -, *, /) para o
usuário escolher. Imprima o resultado da opção escolhida. Caso o usuário digite uma opção inválida, mostrar
mensagem de erro. (utilize a estrutura ESCOLHA) */
