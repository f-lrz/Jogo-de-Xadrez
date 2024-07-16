package pieces;

import main.Board;
import pieces.Tower;

import java.awt.image.BufferedImage;

public class Queen extends Piece {
    public Queen(Board board, int col, int line, boolean white) {
        super(board);
        this.col = col;					//define a coluna da peça
        this.line = line;				//define a linha da peça
        this.xp = col * board.tSize;		//define a posição x da peça de acordo com a coluna em que está	e com relação ao tamanho das casas do tabuleiro
        this.yp = line * board.tSize;	//define a posição y da peça de acordo com a linha em que está e com relação ao tamanho das casas do tabuleiro
        this.white = white;				//define a cor da peça

        this.name = "Queen";

        this.sprite = sheet.getSubimage(sheetScale, white? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tSize, board.tSize, BufferedImage.SCALE_SMOOTH);
        //usando o tamanho da escala, posição da peça cavalo e cor da peça, pega o devido sprite dentro da imagem inteira
    }

    public boolean isValid(int col, int line) {  //verifica se a jogada é válida
        return Math.abs(this.col-col)==Math.abs(this.line-line) || this.col==col||this.line==line;
    }

    public boolean moveCollide(int col, int line) {     //verifica se tem peça inimiga nas casas que ela pode anda

        if(this.col == col || this.line == line) {
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
        }

        else{
            //verifica para a digonal direita para baixo
            if(this.col < col && this.line < line){
                int c, l;
                for(c = this.col+1, l = this.line+1; c < col && l < line; c++, l++){
                    if(board.getPiece(c, l) != null) return true;
                }
            }

            //verifica para a diagonal direita para cima
            if(this.col < col && this.line > line){
                int c, l;
                for(c = this.col+1, l = this.line-1; c < col && l > line; c++, l--){
                    if(board.getPiece(c, l) != null) return true;
                }
            }

            //verifica para a diagonal esquerda para cima
            if(this.col > col && this.line > line){
                int c, l;
                for(c = this.col-1, l = this.line-1; c > col && l > line; c--, l--){
                    if(board.getPiece(c, l) != null) return true;
                }
            }

            //verifica para a diagonal esquerda para baixo
            if(this.col > col && this.line < line){
                int c, l;
                for(c = this.col-1, l = this.line+1; c > col && l < line; c--, l++){
                    if(board.getPiece(c, l) != null) return true;
                }
            }
        }

        return false;
    }
}
