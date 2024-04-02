package aplicacao;

import mesa.*;
import java.util.Scanner;

import javax.print.attribute.SupportedValuesAttribute;
import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import java.io.IOException;

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


		// criação das torres
		Peca torre[] = new Peca[4];
		//instanciação das torres
		torre[0] = new Peca(/*"torre",*/ "branca", 2, "inativo");
		torre[1] = new Peca(/*"torre",*/ "branca", 2, "inativo");
		torre[2] = new Peca(/*"torre",*/ "preta", 2, "inativo");
		torre[3] = new Peca(/*"torre",*/ "preta", 2, "inativo");


		// criação dos cavalos
		Peca cavalo[] = new Peca[4];
		// instanciação dos cavalos
		cavalo[0] = new Peca(/*"cavalo",*/ "branca", 3, "inativo");
		cavalo[1] = new Peca(/*"cavalo",*/ "branca", 3, "inativo");
		cavalo[2] = new Peca(/*"cavalo",*/ "preta", 3, "inativo");
		cavalo[3] = new Peca(/*"cavalo",*/ "preta", 3, "inativo");


		// criação dos bispos
		Peca bispo[] = new Peca[4];
		//instanciação dos bispos
		bispo[0] = new Peca(/*"bispo",*/ "branca", 4, "inativo");
		bispo[2] = new Peca(/*"bispo",*/ "branca", 4, "inativo");
		bispo[2] = new Peca(/*"bispo",*/ "preta", 4, "inativo");
		bispo[3] = new Peca(/*"bispo",*/ "preta", 4, "inativo");


		// criação dos reis
		Peca rei[] = new Peca[2];
		// instanciação dos reis
		rei[0] = new Peca(/*"rei",*/ "branca", 5, "inativo");
		rei[1] = new Peca(/*"rei",*/ "preta", 5, "inativo");


		// criação das rainhas
		Peca rainha[] = new Peca[2];
		//instanciação das rainhas
		rainha[0] = new Peca(/*"rainha",*/ "preta", 6, "inativo");
		rainha[1] = new Peca(/*"rainha",*/ "branca", 6, "inativo");


		Scanner sc = new Scanner(System.in);
		int r;
		boolean v1 = true;

		while(v1){
			System.out.println();
			System.out.println("Digite '1' para visualizar o tabuleiro.");
			System.out.println("Digite '2' para visualizar as peça.");
			r = sc.nextInt();

			if(r != 1 && r != 2) System.out.println("Entrada invalida.");
			
			else{
				if(r == 1){
					t.imprimetab();
					System.out.println();
				}
				if(r == 2){
					System.out.println();
					System.out.println("Digite '1' para ver o peão.");
					System.out.println("Digite '2' para ver o torre.");
					System.out.println("Digite '3' para ver o cavalo.");
					System.out.println("Digite '4' para ver o bispo.");
					System.out.println("Digite '5' para ver o rei.");
					System.out.println("Digite '6' para ver o rainha.");

					r = sc.nextInt();

					if(r == 1){
						System.out.println();
						for (int i = 0; i < 16; i++) {   // Impressão dos peões
							System.out.println("Peão " + (i + 1) + ":");
							peao[i].imprimepeca(r);
							System.out.println();
						}
					}
					else if(r == 2){
						System.out.println();
						for(int i = 0; i < 4; i++){
							torre[i].imprimepeca(r);
							System.out.println();
						}
					}
					else if(r == 3){
						System.out.println();
						for(int i = 0; i < 4; i++){
							cavalo[i].imprimepeca(r);
							System.out.println();
						}
					}
					else if(r == 4){
						System.out.println();
						for(int i = 0; i < 4; i++){
							bispo[i].imprimepeca(r);
							System.out.println();
						}
					}
					else if(r == 5){
						System.out.println();
						for(int i = 0; i < 2; i++){
							rei[i].imprimepeca(r);
							System.out.println();
						}
					}
					else if(r == 6){
						System.out.println();
						for(int i = 0; i < 2; i++){
							rainha[i].imprimepeca(r);
							System.out.println();
						}
	            	}	
				}
			

			System.out.println("Deseja ver voltar ao inicio? ('1' = sim, '0' = nao)");
			r = sc.nextInt();

			if(r == 1) {
				v1 = true;
			}
			else{
				v1 = false;
				System.out.println();
				System.out.println("Obrigado <3");
				System.out.println();
			}
	
			}

    	}
	}
}
