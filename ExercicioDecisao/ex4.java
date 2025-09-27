package Decisoes;
import java.util.Scanner;
public class ex4 
{
    public static void main(String[] args)    
    {
        Scanner entrada = new Scanner(System.in);
        
        int opcoes;
        double salario;
        int codigoFunc;        
        
        System.out.println("-- Bem vindo a alteracao de salarios -- ");
        System.out.println("-- Selecione um codigo para alterar -- ");
        System.out.println("101- Gerente ");
        System.out.println("102- Engenheiro");
        System.out.println("103- Engenheiro");
        opcoes = entrada.nextInt();
                
        
        /* System.out.println("adicione o salario: ");
        salario = entrada.nextInt();
        System.out.println("codigo do funcionario");
        codigoFunc = entrada.nextInt(); */
        
        
        switch(opcoes){
            case 101:
                System.out.println("Adicione o valor para a alteracao: ");
                salario = entrada.nextDouble();
                double att = salario * 1.1;
                System.out.println("Salario atualizado é: " + att);
                System.out.print("salario antigo era: " + salario + " e o salario novo agora é: " + att);
                
                break;
            case 102:
                System.out.println("Adicione o valor para a alteracao: ");
                salario = entrada.nextDouble();
                double att2 = salario * 1.2;
                System.out.println("Salario atualizado é: " + att2);
                System.out.println("salario antigo era: " + salario + " e o salario novo agora é: " + att2);
                
                break;                
            case 103:
                System.out.println("Adicione o valor para a alteracao: ");
                salario = entrada.nextDouble();
                double att3 = salario * 1.3;
                System.out.println("Salario atualizado é: " + att3);
                System.out.println("salario antigo era: " + salario + " e o salario novo agora é: " + att3);
                
                break;
            default: System.out.print("opcao invalida");
                    break;
        
        }
    }
}


/* 

Código do Cargo Percentual
101 (Gerente) 10%
102 (Engenheiro) 20%
103 (Técnico) 30%


Uma empresa concederá um aumento de salário aos seus funcionários, que varia de acordo com o cargo,
conforme a tabela. 

Faça um algoritmo que leia o salário
e o código do cargo de um funcionário 
e calcule o novo salário. 

Se o cargo do funcionário não estiver na tabela, ele deverá receber 5% de aumento. 

Imprima o salário antigo, o novo salário e a diferença. (utilize a estrutura ESCOLHA)
*/