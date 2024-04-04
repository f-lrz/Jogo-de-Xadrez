package aplicacao;

import mesa.*;
import java.util.Scanner;

//import javax.print.attribute.SupportedValuesAttribute;
//import javax.swing.event.SwingPropertyChangeSupport;
//import javax.swing.plaf.synth.SynthSplitPaneUI;

//import java.io.IOException;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("Bem vindo ao Xadrez dos Crias.");
		System.out.println();


		// criação e instanciação do tabulerio com suas casas
		Tabuleiro t = new Tabuleiro();


		// criação e instanciação dos jogadores
		String n;
		System.out.println("Informe o nome do jogador preto:");
		n = sc.nextLine();
		Jogador j1 = new Jogador(n, "preto");
		System.out.println("Informe o nome do jogador branco:");
		n = sc.nextLine();
		Jogador j2 = new Jogador(n, "branco");

		
		// criação e instanciação dos peões
		Peca peao[] = new Peca[16];
		for(int i = 0; i < 8; i++) {
		    peao[i] = new Peca(/*"peao",*/ "branco", 1, "inativo");
		}
		for(int i = 8; i < 16; i++) { 
		    peao[i] = new Peca(/*"peao",*/ "preto", 1, "inativo");
		}


		// criação das torres
		Peca torre[] = new Peca[4];
		//instanciação das torres
		torre[0] = new Peca(/*"torre",*/ "branco", 2, "inativo");
		torre[1] = new Peca(/*"torre",*/ "branco", 2, "inativo");
		torre[2] = new Peca(/*"torre",*/ "preto", 2, "inativo");
		torre[3] = new Peca(/*"torre",*/ "preto", 2, "inativo");


		// criação dos cavalos
		Peca cavalo[] = new Peca[4];
		// instanciação dos cavalos
		cavalo[0] = new Peca(/*"cavalo",*/ "branco", 3, "inativo");
		cavalo[1] = new Peca(/*"cavalo",*/ "branco", 3, "inativo");
		cavalo[2] = new Peca(/*"cavalo",*/ "preto", 3, "inativo");
		cavalo[3] = new Peca(/*"cavalo",*/ "preto", 3, "inativo");


		// criação dos bispos
		Peca bispo[] = new Peca[4];
		//instanciação dos bispos
		bispo[0] = new Peca(/*"bispo",*/ "branco", 4, "inativo");
		bispo[1] = new Peca(/*"bispo",*/ "branco", 4, "inativo");
		bispo[2] = new Peca(/*"bispo",*/ "preto", 4, "inativo");
		bispo[3] = new Peca(/*"bispo",*/ "preto", 4, "inativo");


		// criação dos reis
		Peca rei[] = new Peca[2];
		// instanciação dos reis
		rei[0] = new Peca(/*"rei",*/ "branco", 5, "inativo");
		rei[1] = new Peca(/*"rei",*/ "preto", 5, "inativo");


		// criação das rainhas
		Peca rainha[] = new Peca[2];
		//instanciação das rainhas
		rainha[0] = new Peca(/*"rainha",*/ "preto", 6, "inativo");
		rainha[1] = new Peca(/*"rainha",*/ "branco", 6, "inativo");



		int r;
		boolean v1 = true;

		while(v1){
			System.out.println();
			System.out.println("Digite '1' para visualizar os jogadores.");
			System.out.println("Digite '2' para visualizar o tabuleiro.");
			System.out.println("Digite '3' para visualizar as peça.");
			System.out.println();
			r = sc.nextInt();

			if(r != 1 && r != 2 && r != 3) System.out.println("Entrada invalida.");
			
			else{
				if(r == 1){
					j1.imprimeJogador();
					j2.imprimeJogador();
					System.out.println();
				}
				if(r == 2){
					t.imprimetab();
					System.out.println();
				}
				if(r == 3){
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
							peao[i].imprimePeca(r);
							System.out.println();
						}
					}
					else if(r == 2){
						System.out.println();
						for(int i = 0; i < 4; i++){
							torre[i].imprimePeca(r);
							System.out.println();
						}
					}
					else if(r == 3){
						System.out.println();
						for(int i = 0; i < 4; i++){
							cavalo[i].imprimePeca(r);
							System.out.println();
						}
					}
					else if(r == 4){
						System.out.println();
						for(int i = 0; i < 4; i++){
							bispo[i].imprimePeca(r);
							System.out.println();
						}
					}
					else if(r == 5){
						System.out.println();
						for(int i = 0; i < 2; i++){
							rei[i].imprimePeca(r);
							System.out.println();
						}
					}
					else if(r == 6){
						System.out.println();
						for(int i = 0; i < 2; i++){
							rainha[i].imprimePeca(r);
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

		sc.close();
	}
}