package flerovio.codigos;
import java.util.Scanner;
public class ler 
{
  public static void main(String[] args)
    {
    Scanner entrada = new Scanner(System.in);
    
    int Num=0;
    
    System.out.print("Adicione um numero: ");
    Num = entrada.nextInt();  
    double raiz = Math.cbrt(Num); 
    double base = Num;
    double expoente = 2.0/3.0;
    double potencia = Math.pow(base, expoente);        
    int triplo = Num*3; 
    double metade = Num / 2.0;
    
    System.out.println("Triplo: " + triplo);
    System.out.println("Metade: " + metade);
    System.out.println("Raiz cubica: " + raiz);
    System.out.println("Potencia 2/3: " + potencia);  
    }
                                    
}

/*Fazer um programa que 
leia um número inteiro e mostre o seu triplo, 
sua metade, a sua raiz cúbica, e por fim, 
o número elevado a potência fracionária 2/3.   */