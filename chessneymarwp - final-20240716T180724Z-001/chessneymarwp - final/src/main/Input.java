package main;

import pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Input extends MouseAdapter {

    Board board;

    public Input(Board board){
        this.board = board;
    }         //construtor
    @Override
    public void mousePressed(MouseEvent e) {    //listenner para o botão do mouse ser pressionado
        int col = e.getX()/ board.tSize;        //seleciona a coluna com base na posição x do mouse
        int line = e.getY()/ board.tSize;       //seleciona a linha com base na posição y do mouse

        Piece pieceXY = board.getPiece(col, line);      //tenta pegar a peça no local em que o cursor está
        if (pieceXY!= null){
            board.selPiece = pieceXY;       //caso a peça exista (!=null) marca ela como a peça selecionada no tabuleiro
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {        //listener para o mouse ser arrastado
        if (board.selPiece!= null){
            board.selPiece.xp = e.getX()- board.tSize/2;
            board.selPiece.yp = e.getY()- board.tSize/2;        //arrasta a peça mudando sua posição x e y(- board.tSize/2 serve para centralizar no mouse)

            board.repaint();        //repinta o tabuleiro e peças nos devidos locais
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {       //listenner para o botão do mouse ser solto
        int col = e.getX()/ board.tSize;
        int line = e.getY()/ board.tSize;           //verifica a linha e coluna atual da peça


        if(board.selPiece!=null){
            Move move = new Move(board, board.selPiece, col, line);     //cria um novo movimento com a linha e coluna atual da peça
            if(board.canMove(move)){        //caso possa mover
                board.makeMove(move);       //movimenta a peça para a coluna e linha criada
            }else {
                board.selPiece.xp = board.selPiece.col * board.tSize;
                board.selPiece.yp = board.selPiece.line * board.tSize;      //muda a posição x e y da peça para se enquadrar a sua nova casa
            }
        }

        board.selPiece = null;          //deseleciona a peça no tabuleiro
        board.repaint();        //repinta o tabuleiro e peças nos devidos locais
    }

}
