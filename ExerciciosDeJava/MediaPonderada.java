package flerovio.codigos;
import java.util.Scanner;
public class MediaPonderada 
{
 public static void main(String[] args)
    {
    Scanner entrada = new Scanner(System.in); 
int peso1 = 2;  
int peso2 = 3;  
int peso3 = 5;  
int N = 0;
int M = 0;
int P = 0;  
    System.out.print("Valor 1: ");
    N = entrada.nextInt();
    System.out.print("Valor 2: ");
    M = entrada.nextInt();
    System.out.print("Valor 3: ");
    P = entrada.nextInt();
    
    int N1 = N*peso1;
    int M1 = M*peso2;
    int P1 = P*peso3;
    
    int somaCima = N1 + M1 + P1;
    int SomaBaixo = peso1 + peso2 + peso3;
    
    double resultado = somaCima / SomaBaixo;
    
    System.out.print("Resultado: " + resultado);
 
    }   
}
/* Faça um programa que leia três valores inteiros, e calcule e exiba a sua média ponderada. A primeira nota
tem peso 2, a segunda tem peso 3 e a terceira tem peso 5. 
 */