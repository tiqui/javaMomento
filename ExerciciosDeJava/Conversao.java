package flerovio.codigos;
import java.util.Scanner;
public class Conversao 
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner (System.in);
                
        double Cels=0;
        
        System.out.print("Informe os graus em Cels: " );
        Cels = entrada.nextDouble();
        
        double Faren = (Cels * 9/5) + 32;
               
        System.out.print("Em F: " + Faren);
        
        
    }
  
}

/*5) A conversão de graus Fahrenheit para Celsius é obtida pela fórmula abaixo. Faça um algoritmo que leia um
valor em graus Centígrados e imprima seu correspondente em graus Fahrenheit. */