package main;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.util.Objects;
import javax.swing.*;
import pieces.*;

public class Board extends JPanel {

	protected promotesPos a;		//enum para quando possa haver um promte

	public int tSize = 85;		//tamanho do quadrado de cada casa
	
	public int col = 8;		//numero de colunas
	public int line = 8;		//numero de linhas
	
	ArrayList<Piece> pList = new ArrayList<>();		//arrayList para armazenar as peças no tabuleiro

	public Piece selPiece;	//variavel para a peça selecionada

	Input input = new Input(this);

	private String nomearq;
	private File arq = new File("arq");

	public String getNomearq() {
		return nomearq;
	}
	public void setNomearq(String nomearq) {
		this.nomearq = nomearq;
	}

	public Board() throws IOException {
		this.setPreferredSize(new Dimension(col * tSize, line * tSize));	//defini o tamanho do tabuleiro separadamente (numero de colunas*tamanho de cada casa e numero de linhas*tamanho de cada casa)
		this.addMouseListener(input);		//adiciona o mouse listener
		this.addMouseMotionListener(input);		//adiciona o listener para o movimento do mouse

		addP();		//chama a função para add as peças no tabuleiro


		this.setBackground(Color.green);				//assumi uma cor aleatória para o fundo do tabuleiro, apenas para ver sua posição no frame

		setNomearq("SavePlays.txt");
		arq = new File(getNomearq());
		if(arq.exists())
			arq.delete();
		setNomearq("SavePlays.txt");
		arq = new File(getNomearq());
		if (arq.createNewFile()) {
			System.out.println("Arquivo criado: " + arq.getName());
		} else {
			System.out.println("File already exists.");
		}

	}


	public Piece getPiece(int col, int line){		//verifica se existe uma peça em determinada posição
		for (Piece p : pList){		//percore a lista de peças
			if (p.col == col && p.line == line) {		//se coincidir com a posição de uma peça, retorna a peça
				return p;
			}
		}

		return null;		//caso nao encontre uma peça nessa posição, retorna null
	}

	Pawn aux;
	Queen aux1;

	public void makeMove(Move move){		//troca a posição no tabuleiro e no JFrame

		move.piece.col = move.newCol;		//muda a coluna da peça
		move.piece.line = move.newLine;		//muda a linha da peça

		move.piece.xp = move.newCol * this.tSize;	//ajusta a posição x da peça a partir da sua nova coluna
		move.piece.yp = move.newLine * this.tSize;	//ajusta a posição y da peça a partir da sua nova linha
		capture(move);
		boolean winB = true;
		boolean winW = true;
		for(Piece p : pList){
			if (p.getClass()== King.class){
				if (p.white)winB = false;
				else winW = false;
			}
		}
		if(winB){
			new WinFrame(this, false);
		}
		if(winW){
			new WinFrame(this, true);
		}
		if(move.piece.getClass() == Pawn.class){		//verifica se a classe é do tipo peão
			aux = (Pawn) move.piece;					//faz o casting da classe Piece para peão
			if(aux.promotion()){//verifica se há promotion
				new PromoteFrame((this.tSize-15)*3, true, this, move.piece);	//chama o frame para escolher a peça nova
			}
		}
		whiteT *= -1;		//muda o turno para a próxima cor

        try {
            saveBufferedmove(move);
			//saveBufferedcapture(move);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

	}

	private int saveBufferedmove (Move move)  throws IOException {
		BufferedWriter b = new BufferedWriter(new FileWriter(getNomearq(), true));

		String cor = move.piece.white? "Branco" : "Preto";

		if(Objects.equals(move.piece.name, "Pawn")) {
			b.write("Peão " + cor + " " + move.oldCol + move.oldLine + " -> " + move.newCol + move.newLine + ".\n");
		}
		if(Objects.equals(move.piece.name, "Bishop")) {
			b.write("Bispo " + cor + " " + move.oldCol + move.oldLine + " -> " + move.newCol + move.newLine + ".\n");
		}
		if(Objects.equals(move.piece.name, "Tower")) {
			b.write("Torre " + cor + " " + move.oldCol + move.oldLine + " -> " + move.newCol + move.newLine + ".\n");
		}
		if(Objects.equals(move.piece.name, "Knight")) {
			b.write("Cavalo " + cor + " " + move.oldCol + move.oldLine + " -> " + move.newCol + move.newLine + ".\n");
		}
		if(Objects.equals(move.piece.name, "Queen")) {
			b.write("Rainha " + cor + " " + move.oldCol + move.oldLine + " -> " + move.newCol + move.newLine + ".\n");
		}
		if(Objects.equals(move.piece.name, "King")) {
			b.write("Rei " + cor + " " + move.oldCol + move.oldLine + " -> " + move.newCol + move.newLine + ".\n");
		}

		b.close();
        return 0;
    }

	//funcao para substituir a peça no promote
	protected void trocaPeça(promotesPos a, Piece p){
		//os if verificam qual a peça nova
		if (a==promotesPos.Queen){
			Piece p1 = new Queen(this, p.col, p.line, p.white);	//cria a nova peça com a posição da primeira
			pList.remove(p);					//remove a antiga
			pList.add(p1);						//add a nova
		}
		if (a==promotesPos.Tower){
			Piece p1 = new Tower(this, p.col, p.line, p.white);	//cria a nova peça com a posição da primeira
			pList.remove(p);		//remove a antiga
			pList.add(p1);			//add a nova
		}
		if (a==promotesPos.Bishop){
			Piece p1 = new Bishop(this, p.col, p.line, p.white);	//cria a nova peça com a posição da primeira
			pList.remove(p);		//remove a antiga
			pList.add(p1);			//add a nova
		}
		if (a==promotesPos.Knight){
			Piece p1 = new Knight(this, p.col, p.line, p.white);
			pList.remove(p);		//remove a antiga
			pList.add(p1);			//add a nova
		}
	}

	public void capture(Move move){
		pList.remove(move.capture);
	} //caso haja uma peça

	public boolean canMove(Move move){			//função para verificar se a peça pode se mover para cada casa
		if (sameT(move.piece, move.capture)) return false;		//retorna false caso a casa já possua uma peça de mesma cor
		if(!move.piece.turn(this.whiteT))return false;			//se n for o turno dessa peça, retorna false
		if(move.piece.xp>7.5*tSize||move.piece.xp<-this.tSize/2)return false;		//retorna falso caso a peça saia das dimensões x do tabuleiro
		if(move.piece.yp>7.5*tSize||move.piece.yp<-this.tSize/2)return false;		//retorna falso caso a peça saia das dimensões y do tabuleiro

		if(!move.piece.isValid(move.newCol, move.newLine))return false;				//se o movimento da peça não for válido retorna falso
		if(move.piece.moveCollide(move.newCol, move.newLine))return false;			//caso haja colisão, retorna falso

		return true; //retorna true por padrão (se passar pelos if's anteriores)
	}

	public boolean sameT(Piece p1, Piece p2){		//recebe duas peças e verifica se são do mesmo time
		if(p1 == null || p2 == null) return false;	//caso uma das peças seja nula, informa que não são do msm time
		return p1.white == p2.white;
	}

	int whiteT = 1;		//define o turno inicialmente para 1 (brancas jogam)

	public void addP() {		//adiciona cada peça ao tabuleiro, com sua devida cor e posição ja definida
		pList.add(new King(this, 4, 7, true));
		pList.add(new King(this, 4, 0, false));

		pList.add(new Queen(this, 3, 7, true));
		pList.add(new Queen(this, 3, 0, false));

		pList.add(new Knight(this, 1, 7, true));
		pList.add(new Knight(this, 1, 0, false));
		pList.add(new Knight(this, 6, 7, true));
		pList.add(new Knight(this, 6, 0, false));

		pList.add(new Bishop(this, 2, 7, true));
		pList.add(new Bishop(this, 2, 0, false));
		pList.add(new Bishop(this, 5, 7, true));
		pList.add(new Bishop(this, 5, 0, false));

		pList.add(new Tower(this, 0, 7, true));
		pList.add(new Tower(this, 0, 0, false));
		pList.add(new Tower(this, 7, 7, true));
		pList.add(new Tower(this, 7, 0, false));

		for (int i = 0; i<8; i++){		//adiciona os peões com um laço que muda apenas a coluna de cada um
			pList.add(new Pawn(this, i, 6, true));
			pList.add(new Pawn(this, i, 1, false));
		}

	}

	
	public void paintComponent(Graphics g) {	//sobrescreve o método paintComponent
		Graphics2D g2d = (Graphics2D) g;	//faz o casting de Graphics para Graphics 2D
		
		for(int l=0; l<line;l++)		//percorre as linhas
			for(int c=0; c<line;c++) {		//percorre as colunas
				g2d.setColor((c+l)%2==0? new Color(119, 71, 3) : new Color(234, 193, 123));		//dita a cor de cada parte do tabuleiro
				g2d.fillRect(c*tSize, l*tSize, tSize, tSize);				//"pinta" cada parte do tabuleiro
				
			}
		if(selPiece!= null)
		for(int l=0; l<line;l++)
			for(int c=0; c<line;c++){
				if (canMove(new Move(this, selPiece, c,l))){		//ao percorrer as casas do tabuleiro, verifica se o movimento é válido para cada um deles

					g2d.setColor(new Color(52, 245, 45, 111));	//define a cor de cada casa em que a peça pode se mover
					g2d.fillRect(c*tSize, l*tSize, tSize, tSize);		//pinta cada casa em que a peça pode se mover
				}
			}
		for (Piece piece : pList) {
			piece.paint(g2d);		//pinta cada peça usando o método dela mesma
		}
		
	}
}
