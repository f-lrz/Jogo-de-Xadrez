package aplicacao;

import mesa.Peca;
import mesa.Tabuleiro;
import java.util.Scanner;


public class Programa {

	public static void main(String[] args) {

		// criação e instanciação do tabulerio com suas casas
		
		Tabuleiro t = new Tabuleiro();

		
		// criação e instanciação dos peões
		Peca peao[] = new Peca[16];
		for(int i = 0; i < 8; i++) {
		    peao[i] = new Peca(/*"peao",*/ "branca", 1, "inativo");
		}
		for(int i = 8; i < 16; i++) { 
		    peao[i] = new Peca(/*"peao",*/ "preta", 1, "inativo");
		}

		// criação e instanciação das torres
		Peca torre1 = new Peca(/*"torre",*/ "branca", 2, "inativo");
		Peca torre2 = new Peca(/*"torre",*/ "branca", 2, "inativo");
		Peca torre3 = new Peca(/*"torre",*/ "preta", 2, "inativo");
		Peca torre4 = new Peca(/*"torre",*/ "preta", 2, "inativo");

		// criação e instanciação dos cavalos
		Peca cavalo1 = new Peca(/*"cavalo",*/ "branca", 3, "inativo");
		Peca cavalo2 = new Peca(/*"cavalo",*/ "branca", 3, "inativo");
		Peca cavalo3 = new Peca(/*"cavalo",*/ "preta", 3, "inativo");
		Peca cavalo4 = new Peca(/*"cavalo",*/ "preta", 3, "inativo");

		// criação e instanciação dos bispos
		Peca bispo1 = new Peca(/*"bispo",*/ "branca", 4, "inativo");
		Peca bispo2 = new Peca(/*"bispo",*/ "branca", 4, "inativo");
		Peca bispo3 = new Peca(/*"bispo",*/ "preta", 4, "inativo");
		Peca bispo4 = new Peca(/*"bispo",*/ "preta", 4, "inativo");

		// criação e instanciação dos reis
		Peca rei1 = new Peca(/*"rei",*/ "branca", 5, "inativo");
		Peca rei2 = new Peca(/*"rei",*/ "branca", 5, "inativo");

		// criação e instanciação das rainhas
		Peca rainha1 = new Peca(/*"rainha",*/ "preta", 6, "inativo");
		Peca rainha2 = new Peca(/*"rainha",*/ "preta", 6, "inativo");

		Scanner sc = new Scanner(System.in);
		int r;
		boolean v1 = true;
		boolean v2 = true;

		do {
		    System.out.println();
		    System.out.println("Digite '1' para visualizar o tabuleiro (vazio).");
	
	System.out.println("Digite '2' para visualizar alguma peça.");
		    do {
		        r = sc.nextInt();
		        if (r == 1) {
		            t.imprimetab();
		            System.out.println();
		        } else if (r == 2) {
		            v2 = false;
		            do {
		                System.out.println("Digite '1' para visualizar os peões.");
		                System.out.println("Digite '2' para visualizar as torres.");
		                System.out.println("Digite '3' para visualizar os cavalos.");
		                System.out.println("Digite '4' para visualizar os bispos.");
		                System.out.println("Digite '5' para visualizar a rainhas.");
		                System.out.println("Digite '6' para visualizar o rei.");
		                
		                r = sc.nextInt();
		                if (r == 1) {
		                    for (int i = 0; i < 16; i++) {
		                    	// Impressão das torres
		                        System.out.println("Peão " + (i + 1) + ":");
		                        peao[i].imprimepeca();
		                        System.out.println();
		                    }
		                } else if (r == 2) {
		                    // Impressão das torres
		                    torre1.imprimepeca();
		                    System.out.println();
		                    torre2.imprimepeca();
		                    System.out.println();
		                    torre3.imprimepeca();
		                    System.out.println();
		                    torre4.imprimepeca();
		                    System.out.println();
		                } else if(r == 3){
		                	// Impressão dos cavalos
		                	cavalo1.imprimepeca();
		                	System.out.println();	
		                	cavalo2.imprimepeca();
		                	System.out.println();
		                	cavalo3.imprimepeca();
		                	System.out.println();
		                	cavalo4.imprimepeca();
		                	System.out.println();		
		                	}
		                else if(r == 4){
		                	// Impressão dos bispos
		                	bispo1.imprimepeca();
		                	System.out.println();	
		                	bispo2.imprimepeca();
		                	System.out.println();
		                	bispo3.imprimepeca();
		                	System.out.println();
		                	bispo4.imprimepeca();
		                	System.out.println();	
		                }
		                else if(r == 5){
		                	// Impressão das rainhas
		                	rainha1.imprimepeca();
		                	System.out.println();	
		                	rainha2.imprimepeca();
		                	System.out.println();	
		                	}
		                else if(r == 6){
		                	// Impressão dos reis
		                	rei1.imprimepeca();
		                	System.out.println();	
		                	rei2.imprimepeca();
		                	System.out.println();	
		                }
		                
		                System.out.println("Deseja visualizar outra peça? ('1' = sim, '0' = não)");
		                int resposta = sc.nextInt();
		                if (resposta == 0) {
		                    v2 = true;
		                }
		            } while (!v2);
		        } else {
		            System.out.println("Entrada inválida. Digite novamente");
		            System.out.println("'1' para visualizar o tabuleiro (vazio).");
		            System.out.println("'2' para visualizar alguma peça.");
		        }
		    } while (r != 1 && r != 2); 
		    
		    System.out.println("Deseja ver voltar ao início? ('1' = sim, '0' = não)");
		    r = sc.nextInt();
		    if (r == 1) {
		        v1 = false;
		    } else if (r == 0) {
		        v1 = true;
		        System.out.println();
		        System.out.println("Obrigado <3");
		        System.out.println();
		    }
		} while (!v1);
	}

}

