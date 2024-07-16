package main;

import pieces.King;
import pieces.Piece;

public class Move {
    int oldCol;     //armazena a coluna em que a peça está
    int oldLine;       //armazena a linha em que a peça está

    int newCol;         //coluna em que a peça pode ou não ir
    int newLine;        //linha em que a peça pode ou não ir

    Piece piece;        //variável do tipo peça para armazenar a peça a ser movida
    Piece capture;      //variável para a peça que pode ser capturada

    public Move(Board board, Piece piece, int newCol, int newLine){     //construtor

        this.oldCol = piece.col;        //armazena a coluna atual da peça
        this.oldLine = piece.line;      //armazena a linha atual da peça
        this.newCol = newCol;           //coluna em q a peça pode ir
        this.newLine = newLine;         //linha em q a peça pode ir

        this.piece = piece;         //armazena a peça
        this.capture = board.getPiece(newCol, newLine);         //armazena a possibilidade de captura (a função getPiece pode returnar null)
    }
}
