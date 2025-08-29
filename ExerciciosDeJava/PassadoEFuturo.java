package flerovio.codigos;
import java.util.Scanner;
public class PassadoEFuturo 
{
    public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        
     int RaidBaseAgua = 0;
     
     System.out.print("Adicione um número: ");
     RaidBaseAgua = entrada.nextInt();
    
     int antes = RaidBaseAgua - 1;
     int pos = RaidBaseAgua + 1;
     
     System.out.printf("O seu número é: %d, o antecessor é %d e o sucessor é: %d", RaidBaseAgua, antes, pos);
    
           
    }
 
}

/* 8) Desenvolva um algoritmo em Java que leia um número inteiro e imprima o seu antecessor e seu sucessor.  */