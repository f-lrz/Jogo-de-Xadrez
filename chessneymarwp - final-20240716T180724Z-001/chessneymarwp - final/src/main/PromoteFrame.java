package main;

import pieces.Piece;
import pieces.promotesPos;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.IOException;
import java.util.ArrayList;

public class PromoteFrame extends JFrame {
    protected int size;         // tamanho do jFrame
    Board board;                //armazenar o tabuleiro


    public PromoteFrame(int size, boolean isWhite, Board board, Piece p){       //construtor para o frame
       //carrega o tema Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            System.err.println(ex);		//printa o ex caso ocorra exception
        }
        catch (InstantiationException ex) {
            System.err.println(ex);		//printa o ex caso ocorra exception
        }
        catch (IllegalAccessException ex) {
            System.err.println(ex);		//printa o ex caso ocorra exception
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);			//printa o ex caso ocorra exception
        }
        this.size = size;           //coloca a variavel size do JFrame com o tamanho recebido
        this.getContentPane().setBackground(Color.gray);        //coloca o fundo do JFrame como cinza
        this.setSize(size-22, size);                               //altera o tamanho do JFrame
        this.setLayout(null);                                   //coloca o layout como null
        this.setMinimumSize(new Dimension(size-22, size));         //tamanho minimo do JFrame
        this.setLocationRelativeTo(board);                    //posicao para centralizar o JFrame no board
        BufferedImage sheet = null;                             //inicializa a variavel sheet
        {
            try {
                sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("Pieces.png"));  //pega a imagem das peças
            }catch (IOException e) {
                System.out.println("HAHAHAHAHAHA");		//exception para o caso de erro
                e.printStackTrace();
            }
        }
        int sheetScale = sheet.getHeight()/2;               //escala da imagem com as peças
        //pega a imagem da rainha usando o get subimage e o getscaled instance para cortar a imagem original e colocar no tamanho adequado
        ImageIcon rainha = new ImageIcon(sheet.getSubimage(sheetScale,0,sheetScale,sheetScale).getScaledInstance(85, 85, BufferedImage.SCALE_SMOOTH));
        //cria o botão passando o ImageIcon como parametro
        JButton queen = new JButton(rainha);
        //define o tamanho e a posição do botão
        queen.setBounds(0, 0,85, 85);

        //pega a imagem da rainha usando o get subimage e o getscaled instance para cortar a imagem original e colocar no tamanho adequado
        ImageIcon bispo = new ImageIcon(sheet.getSubimage(sheetScale*2,0,sheetScale,sheetScale).getScaledInstance(85, 85, BufferedImage.SCALE_SMOOTH));
        //cria o botão passando o ImageIcon como parametro
        JButton bishop = new JButton(bispo);
        //define o tamanho e a posição do botão
        bishop.setBounds(85, 0,85, 85);


        //pega a imagem da rainha usando o get subimage e o getscaled instance para cortar a imagem original e colocar no tamanho adequado
        ImageIcon cavalo = new ImageIcon(sheet.getSubimage(sheetScale*3,0,sheetScale,sheetScale).getScaledInstance(85, 85, BufferedImage.SCALE_SMOOTH));
        //cria o botão passando o ImageIcon como parametro
        JButton knight = new JButton(cavalo);
        //define o tamanho e a posição do botão
        knight.setBounds(0, 85,85, 85);

        //pega a imagem da rainha usando o get subimage e o getscaled instance para cortar a imagem original e colocar no tamanho adequado
        ImageIcon torre = new ImageIcon(sheet.getSubimage(sheetScale*4,0,sheetScale,sheetScale).getScaledInstance(85, 85, BufferedImage.SCALE_SMOOTH));
        //cria o botão passando o ImageIcon como parametro
        JButton tower = new JButton(torre);
        //define o tamanho e a posição do botão
        tower.setBounds(85, 85,85, 85);

        //adiciona os botões no frame
        this.add(queen);
        this.add(bishop);
        this.add(knight);
        this.add(tower);

        //coloca o frame como visivel
        this.setVisible(true);

        this.setJMenuBar(null);
        this.setMenuBar(null);
        this.setResizable(false);

        //listenner do botao do cavalo
        knight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.a = promotesPos.Knight;                //define o enum do board com a peça para fazer o promote
                board.trocaPeça(board.a, p);                //chama a funcao para trocar a peca
                board.repaint();                               //repinta o tabuleiro para mostrar a nova peça
                PromoteFrame.super.dispose();                   //fecha o frame após o promote
            }
        });

        //listenner do botao da rainha
        queen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.a = promotesPos.Queen;        //define o enum do board com a peça para fazer o promote
                board.trocaPeça(board.a, p);         //chama a funcao para trocar a peca
                board.repaint();                     //repinta o tabuleiro para mostrar a nova peça
                PromoteFrame.super.dispose();            //fecha o frame após o promote
            }
        });

        //listenner do botao do bispo
        bishop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.a = promotesPos.Bishop;            //define o enum do board com a peça para fazer o promote
                board.trocaPeça(board.a, p);            //chama a funcao para trocar a peca
                board.repaint();                        //repinta o tabuleiro para mostrar a nova peça
                PromoteFrame.super.dispose();           //fecha o frame após o promote
            }
        });

        //adiciona o listenner para o botao da torre
        tower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.a = promotesPos.Tower;        //define o enum do board com a peça para fazer o promote
                board.trocaPeça(board.a, p);        //chama a funcao para trocar a peca
                board.repaint();                    //repinta o tabuleiro para mostrar a nova peça
                PromoteFrame.super.dispose();       //fecha o frame após o promote
            }
        });


    }


}
