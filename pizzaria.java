import java.util.Scanner;
public class pizzaria
{
 public static void main(String[] args)
        {    
       Scanner entrada = new Scanner(System.in);
              /* valores pedidos e taxa garcom */
       int qtdChopp=0, qtdCobertura=0, qtdePessoa=0, qtdePizzas=0;
       double valorConta=0.0;      
            /* entrada de valores */
            System.out.print("Quantidade de Chopp: ");
            qtdChopp = entrada.nextInt();
            System.out.print("Quantidade de Cobertura: ");
            qtdCobertura = entrada.nextInt();
            System.out.print("Quantidade de Pizzas: ");
            qtdePizzas = entrada.nextInt();            
            System.out.print("Quantidade de pessoas: ");
            qtdePessoa = entrada.nextInt();           
            
            /* calculo da conta */
    valorConta = qtdePizzas*25 + qtdChopp*1.8 + qtdCobertura*3.5; 
    
            /* resultado das contas */    
            System.out.printf("O valor total da conta: R$ %.2f\n",(1.1*valorConta));
            System.out.printf("Valor do servico do garcom: R$ %.2f\n",(0.1*valorConta));
            System.out.printf("Valor por pessoa: R$ %.2f\n",(1.1*valorConta/qtdePessoa));
        }
}
      
          
 
    
    
    
    
