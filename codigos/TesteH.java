package flerovio.codigos;

import java.util.Scanner;

public class TesteH {
    public static void main(String[] args) 
{
        
        Scanner ler = new Scanner(System.in);

        
        System.out.print("Informe a altura: ");
        int altura = ler.nextInt();

        System.out.print("Informe a largura: ");
        int largura = ler.nextInt();

                            /*saida*/
        int i = 0;
        while (i < altura) 
    {
            int j = 0;
            while (j < largura) 
            {
                if (i == 0 || i == altura - 1 || j == 0 || j == largura - 1) {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
                j++;
            }
            System.out.println();
            i++;
        }

ler.close();
    }
}
