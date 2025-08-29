package flerovio.codigos;
import java.util.Scanner;
public class Corrida 
{
 public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in); 
                              
        double Distancia=0, Tempo=0;                            
                      
        System.out.print("Digite o nome do piloto: ");
        String nome = entrada.nextLine();
        
        System.out.print("Distancia percorrida em Km: ");
        Distancia = entrada.nextDouble();
        
        System.out.print("Tempo em Horas: ");
        Tempo = entrada.nextDouble();                              
               
        double velocidadeMedia = Distancia / Tempo;

        System.out.printf("A velocidade media de %s foi %.2f km/h\n", nome, velocidadeMedia);

    }
                                 
}

/* Faça um programa que leia o nome de um piloto, 
uma distância percorrida em km e o tempo que o piloto
levou para percorrê-la (em horas). 
O programa deve calcular a velocidade média em km/h, e exibir a seguinte frase: 
A velocidade média de XX foi YY km/h, onde XX é o nome do piloto, 
e YY é a velocidade média.*/