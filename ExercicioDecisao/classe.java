package Decisoes;
import java.util.Scanner;
public class classe 
{
    public static void main(String[] args)
    {
        Scanner ent = new Scanner(System.in);
    
        System.out.print("nome: ");
        String nome = ent.nextLine();
        System.out.print("idade: ");
        int idade = ent.nextInt();
        
        if(idade < 1){
            System.out.print("idade invalida");
        }else if(idade < 18){
            System.out.print(nome + " voce e menor de idade");        
        }else{
            System.out.print(nome+ " voce e maior de idade");
        
        }
        
    }
}
