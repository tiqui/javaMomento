package X;
import java.util.Scanner;
public class Gasolina 
{
 public static void main(String[] args)
    {
        Scanner entrada = new Scanner(System.in);
        int KMi=0, KMf=0;
        double LitroGasolina=0;
        double MediaTotal=0.0;
                               
        System.out.print("Km inicial: ");
        KMi = entrada.nextInt();
        System.out.print("Km final:");
        KMf = entrada.nextInt();
        System.out.print("Quantos litros de gasolina: ");
        LitroGasolina = entrada.nextDouble();
        
        /* consumo de combustivel */
        MediaTotal = (KMf - KMi) / LitroGasolina;
        
        /* resultado */
        System.out.print("O valor total de km por litro: "+MediaTotal);
                             
    }
    
}

/* 2) Realizarei uma viagem de vários dias em meu automóvel, e gostaria de saber a quilometragem média por
litro de gasolina. Para isto, anotarei a quilometragem no velocímetro ao sair de viagem, e depois ao chegar.
Também vou somar toda a gasolina que comprar para o carro. Você poderia fazer um programa que me
desse, com estes dados, quantos km fiz, em média, por litro de gasolina? */
