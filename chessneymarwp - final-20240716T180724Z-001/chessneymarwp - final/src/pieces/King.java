package pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class King extends Piece {
    public King(Board board, int col, int line, boolean white) {
        super(board);
        this.col = col;					//define a coluna da peça
        this.line = line;				//define a linha da peça
        this.xp = col * board.tSize;		//define a posição x da peça de acordo com a coluna em que está	e com relação ao tamanho das casas do tabuleiro
        this.yp = line * board.tSize;	//define a posição y da peça de acordo com a linha em que está e com relação ao tamanho das casas do tabuleiro
        this.white = white;				//define a cor da peça

        this.name = "Knight";

        this.sprite = sheet.getSubimage(0, white? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tSize, board.tSize, BufferedImage.SCALE_SMOOTH);
        //usando o tamanho da escala, posição da peça cavalo e cor da peça, pega o devido sprite dentro da imagem inteira
    }

    public boolean isValid(int col, int line) {   //funcao que verifica se a jogada é valida

        if (Math.abs(this.col - col) == 1 && Math.abs(this.line - line) == 1) return true;  //movimentando para as diagonais
        if (Math.abs(this.col - col) == 1 && this.line == line) return true;        //movimentando para os lados
        if (Math.abs(this.line - line) == 1 && this.col == col) return true;        //movimentando para cima e para baixo

        return false;

    }
    public boolean moveCollide(int col, int line){
        return false;
    }       //sobrescrevendo o método abstrato
}
