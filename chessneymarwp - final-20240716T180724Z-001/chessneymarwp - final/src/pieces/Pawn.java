package pieces;
import java.awt.image.BufferedImage;
import main.Board;

public class Pawn extends Piece{

    public Pawn(Board board, int col, int line, boolean white) {
        super(board);
        this.col = col;					//define a coluna da peça
        this.line = line;				//define a linha da peça
        this.xp = col * board.tSize;		//define a posição x da peça de acordo com a coluna em que está	e com relação ao tamanho das casas do tabuleiro
        this.yp = line * board.tSize;	//define a posição y da peça de acordo com a linha em que está e com relação ao tamanho das casas do tabuleiro
        this.white = white;				//define a cor da peça

        this.name = "Pawn";

        this.sprite = sheet.getSubimage(5*sheetScale, white? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tSize, board.tSize, BufferedImage.SCALE_SMOOTH);
        //usando o tamanho da escala, posição da peça cavalo e cor da peça, pega o devido sprite dentro da imagem inteira
    }

    public boolean isValid(int col, int line){
        //impede de mover para tras
        if(white? this.line<line: this.line>line)return false;

        //move uma casa
        if(this.col==col && Math.abs(this.line-line)==1 && board.getPiece(this.col, line)==null)return true;

        //move duas casas
        if(this.col==col)
            if(white? this.line == 6 : this.line == 1)
                if(Math.abs(this.line - line)==2)
                    if(white? board.getPiece(this.col, 4)==null:board.getPiece(this.col, 3)==null)return true;

        //come na diagonal direita
        if(col==this.col+1)
            if(Math.abs(this.line-line)==1)
                if (board.getPiece(col, line)!=null)return true;

        //come na diagonal esquerda
        if(col==this.col-1)
            if(Math.abs(this.line-line)==1)
                if (board.getPiece(col, line)!=null)return true;

        return false;
    }

    public boolean promotion(){
        if (this.line==0||this.line==7)return true;     //verifica se o peão está na posição para ser promovido
        return false;
    }

    public boolean moveCollide(int col, int line){      //não precisa de colisao no peão, ent o método foi apenas sobrescrito por ser do tipo abstrato


        return false;
    }
}