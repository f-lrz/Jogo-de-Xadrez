package aplicacao;

import mesa.*;


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
		
		t.imprimetab();
		System.out.println("   a b c d e f g h");

	}

}
