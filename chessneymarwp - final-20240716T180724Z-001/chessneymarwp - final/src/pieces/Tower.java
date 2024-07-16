package pieces;

import java.awt.image.BufferedImage;
import main.Board;

public class Tower extends Piece {
    public Tower(Board board, int col, int line, boolean white) {
        super(board);
        this.col = col;					//define a coluna da peça
        this.line = line;				//define a linha da peça
        this.xp = col * board.tSize;		//define a posição x da peça de acordo com a coluna em que está	e com relação ao tamanho das casas do tabuleiro
        this.yp = line * board.tSize;	//define a posição y da peça de acordo com a linha em que está e com relação ao tamanho das casas do tabuleiro
        this.white = white;				//define a cor da peça

        this.name = "Tower";

        this.sprite = sheet.getSubimage(4*sheetScale, white? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tSize, board.tSize, BufferedImage.SCALE_SMOOTH);
        //usando o tamanho da escala, posição da peça cavalo e cor da peça, pega o devido sprite dentro da imagem inteira
    }

    public boolean isValid(int col, int line){   //funcao que verifica se a jogada é valida
        return this.col==col||this.line==line;
    } //movimentação da torre seguindo a mesma linha ou mesma coluna

    public boolean moveCollide(int col, int line){      //verifica colisão

        //verifica para a esquerda
        if(this.col>col)
            for(int c=this.col-1; c>col;c--){
                if(board.getPiece(c, this.line)!=null)return true;
            }

        //verifica para a direita
        if(this.col<col)
            for(int c=this.col+1; c<col;c++){
                if(board.getPiece(c, this.line)!=null)return true;
            }

        //verifica para baixo
        if(this.line<line)
            for(int l=this.line+1; l<line;l++){
                if(board.getPiece(this.col, l)!=null)return true;
            }

        //verifica para cima
        if(this.line>line)
            for(int l=this.line-1; l>line;l--){
                if(board.getPiece(this.col, l)!=null)return true;
            }
        //retora falso por padrão
        return false;
    }

}
