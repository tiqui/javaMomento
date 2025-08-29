package flerovio.codigos;
import java.util.Scanner;
public class Vetores 
{
 public static void main(String[] args)
    {
  Scanner entrada = new Scanner(System.in);
  int x1 = 0;
  int x2 = 0;
  int y1 = 0;
  int y2 = 0;
 
  System.out.print("Adicione o vetor x1: ");
  x1 = entrada.nextInt();
  System.out.print("Adicione o vetor y1: ");
  y1 = entrada.nextInt();
  System.out.print("Adicione o vetor x2: ");
  x2 = entrada.nextInt();
  System.out.print("Adicione o vetor y2: ");
  y2 = entrada.nextInt();
  
  int vetor1 = x2 - x1;
  double base1 = Math.pow(vetor1, 2.0);
  int vetor2 = y2 - y1;
  double base2 = Math.pow(vetor2, 2.0);
  double resultado = Math.sqrt(base1 + base2);
  
  System.out.print("Resultado: " + resultado);
    }   
}
/*7) Construa um algoritmo que, tendo como dados de entrada dois pontos quaisquer no plano, P(x1,y1) e
P(x2,y2), escreva a distância entre eles. A fórmula que efetua tal cálculo é: */