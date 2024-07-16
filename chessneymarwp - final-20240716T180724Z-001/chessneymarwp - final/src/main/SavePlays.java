package main;

import pieces.*;
import java.io.*;
import java.nio.Buffer;

public class SavePlays {

    private String nomearq;
    private File arq;

    public String getNomearq() {
        return nomearq;
    }
    public void setNomearq(String nomearq) {
        this.nomearq = nomearq;
    }

    public void deleteSaves (){
        if(arq.delete())
        {
            System.out.println("Arquivo deletado.");
        }
        else
        {
            System.out.println("Falha ao deletar.");
        }
    }

    public void createFile() throws IOException {
        setNomearq("C:\\Users\\Teste\\Downloads\\chessneymarwp\\SavePlays.txt");
        arq = new File(getNomearq());
        if (arq.createNewFile()) {
            System.out.println("Arquivo criado: " + arq.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    public void saveBuffered(Move m, Board board) throws IOException {
        BufferedWriter b = new BufferedWriter(new FileWriter(getNomearq(), true));

        if(m.piece.col == 0) {
            String A = "A";
        }
        if(m.piece.col == 1) {
            String B = "B";
        }
        if(m.piece.col == 2) {
            String C = "C";
        }
        if(m.piece.col == 3) {
            String D = "D";
        }
        if(m.piece.col == 4) {
            String E = "E";
        }
        if(m.piece.col == 5) {
            String F = "F";
        }
        if(m.piece.col == 6) {
            String G = "G";
        }
        if(m.piece.col == 7) {
            String H = "H";
        }

        String cor = m.piece.white? "Branco" : "Preto";
        String corad = m.piece.white? "Preta" : "Branco";

        if(m.piece.getClass() == Pawn.class) {
            b.write("Peão " + cor + " " + m.oldCol + m.oldCol + " -> " + m.newCol + m.newLine + ".");
        }
        if(m.piece.getClass() == Bishop.class) {
            b.write("Bispo " + cor + " " + m.oldCol + m.oldCol + " -> " + m.newCol + m.newLine + ".");
        }
        if(m.piece.getClass() == Tower.class) {
            b.write("Torre " + cor + " " + m.oldCol + m.oldCol + " -> " + m.newCol + m.newLine + ".");
        }
        if(m.piece.getClass() == Knight.class) {
            b.write("Cavalo " + cor + " " + m.oldCol + m.oldCol + " -> " + m.newCol + m.newLine + ".");
        }
        if(m.piece.getClass() == Queen.class) {
            b.write("Rainha " + cor + " " + m.oldCol + m.oldCol + " -> " + m.newCol + m.newLine + ".");
        }
        if(m.piece.getClass() == King.class) {
            b.write("Rei " + cor + " " + m.oldCol + m.oldCol + " -> " + m.newCol + m.newLine + ".");
        }

        if(board.getPiece(m.newCol, m.newLine) != null){
            if(m.capture.getClass() == Pawn.class) {
                b.write(" Peão " + corad + " " + m.newCol + m.newLine + " foi morto. " + "\n");
            }
            if(m.capture.getClass() == Bishop.class) {
                b.write(" Bispo " + corad + " " + m.newCol + m.newLine + " foi morto. " + "\n");
            }
            if(m.capture.getClass() == Tower.class) {
                b.write(" Torre " + corad + " " + m.newCol + m.newLine + " foi morto. " + "\n");
            }
            if(m.capture.getClass() == Knight.class) {
                b.write(" Cavalo " + corad + " " + m.newCol + m.newLine + " foi morto. " + "\n");
            }
            if(m.capture.getClass() == Queen.class) {
                b.write(" Rainha " + corad + " " + m.newCol + m.newLine + " foi morto. " + "\n");
            }
            if(m.capture.getClass() == King.class) {
                b.write(" Rei " + corad + " " + m.newCol + m.newLine + " foi morto. " + "\n");
            }
        }

        b.close();

    }



}
