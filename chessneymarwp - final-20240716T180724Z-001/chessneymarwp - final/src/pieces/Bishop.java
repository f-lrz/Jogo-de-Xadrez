package pieces;
import java.awt.image.BufferedImage;
import main.Board;

public class Bishop extends Piece{

    public Bishop(Board board, int col, int line, boolean white) {
        super(board);
        this.col = col;					//define a coluna da peça
        this.line = line;				//define a linha da peça
        this.xp = col * board.tSize;		//define a posição x da peça de acordo com a coluna em que está	e com relação ao tamanho das casas do tabuleiro
        this.yp = line * board.tSize;	//define a posição y da peça de acordo com a linha em que está e com relação ao tamanho das casas do tabuleiro
        this.white = white;				//define a cor da peça

        this.name = "Bishop";

        this.sprite = sheet.getSubimage(2*sheetScale, white? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tSize, board.tSize, BufferedImage.SCALE_SMOOTH);
        //usando o tamanho da escala, posição da peça cavalo e cor da peça, pega o devido sprite dentro da imagem inteira
    }

    public boolean isValid(int col, int line){    //funcao que verifica se a jogada é valida
        return Math.abs(this.col-col)==Math.abs(this.line-line);
    }

    public boolean moveCollide(int col, int line){   //verifica se tem peça inimiga nas casas que ela pode anda

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

        return false;

    }
}
