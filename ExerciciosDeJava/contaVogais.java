package Testes;

import java.util.Scanner;

public class Exercicio {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String texto;
		
		System.out.println("Informe o texto: ");
		texto = entrada.nextLine().toLowerCase();
	
		System.out.println("Quantidade de vogais: "+contaVogal(texto));

		System.out.println("Fim de programa!");
		entrada.close();
	}
	
	public static int contaVogal(String texto){
		int cont = 0;
		char c;
		for(int i=0; i<texto.length(); i++){
			c = texto.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
				cont++;
			}
		}
		return cont;
	}
}
