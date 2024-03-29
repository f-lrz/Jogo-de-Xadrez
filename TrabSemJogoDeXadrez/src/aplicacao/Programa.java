package aplicacao;

import mesa.*;
import java.util.Scanner;
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

		do{
			System.out.println();
			System.out.println("Digite '1' para visualizar o tabuleiro (vazio).");
			System.out.println("Digite '2' para visualizar alguma peça.");
			do{
				r = sc.nextInt();
				if(r == 1){
					t.imprimetab();
					System.out.println();
				}
				else if(r == 2){

				}
				else{
					System.out.println("Entrada invalida. Digite novamente");
					System.out.println("'1' para visualizar o tabuleiro (vazio).");
					System.out.println("'2' para visualizar alguma peça.");
					v2 = false;
				}
			}while(!v2);

			System.out.println("Deseja ver voltar ao inicio? ('1' = sim, '0' = nao)");
			r = sc.nextInt();
			if(r == 1) v1 = false;
			else if(r == 0){
				v1 = true;
				System.out.println();
				System.out.println("Obrigado <3");
				System.out.println();
				
			}

		}while(!v1);

	}

}
