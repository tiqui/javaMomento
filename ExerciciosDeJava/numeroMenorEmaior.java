package prova;
import java.util.Scanner;
public class xabum 
{

    public static void main(String[] args) 
        {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("digite o tamanho do vetor: ");
        int n = entrada.nextInt();
        int[] vetor = new int[n];
                
        System.out.println("digite os " + n + " elementos do vetor:");
        for (int i = 0; i < n; i++) 
        {
            System.out.print("Elemento " + (i + 1) + ": ");
            vetor[i] = entrada.nextInt();
        }       
        int menorElemento = encontraMenorMarolento(vetor);
        System.out.println("\nO menor elemento do vetor é: " + menorElemento);
        
        int spotado = contarSpotadas(vetor, menorElemento);
        System.out.println("o menor elemento foi o (" + menorElemento + ") e apareceu " + spotado + " vez(es) no vetor.");

        entrada.close(); /* pra n perder ponto */
        }

    public static int encontraMenorMarolento(int[] vetor) 
        {
        if (vetor.length == 0) 
        {
            throw new IllegalArgumentException("O vetor não pode estar vazio.");
        }
        int menor = vetor[0];
        for (int i = 1; i < vetor.length; i++) 
                {
            if (vetor[i] < menor) 
                {
                menor = vetor[i];
                }
                }
        return menor;
                }

    public static int contarSpotadas(int[] vetor, int valor) {
        int caraQUEconta = 0;
        for (int elemento : vetor) 
                    {
            if (elemento == valor) 
                    {
                caraQUEconta++;
                    }
                    }
        return caraQUEconta;
    }
}

/*
a) A primeira função recebe um vetor contendo N valores e retorna o menor elemento do vetor; e

b) A segunda função recebe dois argumentos: um vetor contendo N valores e um outro valor, 
e retorna o número de vezes que esse outro valor ocorreu no vetor.
Leia o tamanho do vetor e os valores do vetor no método principal. 
Ao receber o retorno do menor elemento do vetor através da chamada da primeira função,

mostre o valor recebido e passe este valor como o segundo argumento na segunda função. 
Mostre na tela o número de vezes que ele aparece no vetor. */