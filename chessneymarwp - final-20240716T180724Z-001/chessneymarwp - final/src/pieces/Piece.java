package pieces;

import javax.imageio.ImageIO;

import main.Board;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.IOException;


public abstract class Piece {
	public int col, line;		//linha e coluna da peça
	public int xp, yp;			//posicao da peça
	
	public boolean white;		//definir time da peça
	public String name;			//nome da peça
	public int val;				//valor da peça
	
	
	BufferedImage sheet;
	{
		try {
			sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("Pieces.png"));  //pega a imagem das peças
		}catch (IOException e) {
			System.out.println("HAHAHAHAHAHA");		//exception para o caso de erro
			e.printStackTrace();
		}
	}
	protected int sheetScale = sheet.getHeight()/2; //escala de cada peça dentro da imagem inteira
	
	
	Image sprite;		//sprite da peça
	
	Board board;		//tabuleiro

	public Piece(Board board) {		//construtor
		this.board = board;
	}

	public abstract boolean isValid(int col, int line);		//função a ser implementada nas classes filhas

	public abstract boolean moveCollide(int col, int line);		//função a ser implementada nas classes filhas


	public void paint(Graphics2D g2d) {		//função para pintar as imagens das peças
		g2d.drawImage(sprite, xp, yp,null);
		
		
	}
	public boolean turn(int a){		//função para verificar se o turno é daquela peça
		if (white? a==1: a==-1)return true;
		return false;
	}


}
