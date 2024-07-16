package main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		//colocando o look and fell do Nimbus
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

		//________________________________________________________________________

		JFrame frame = new JFrame();						//instancia um JFrame
		frame.getContentPane().setBackground(Color.black);	//coloco o fundo fundo como preto
		frame.setLayout(new GridBagLayout());				//coloco o layout 
		frame.setMinimumSize(new Dimension(1000, 1000));	//coloco as dimensoes minimas da janela
		frame.setLocationRelativeTo(null);					//coloca a orientação do frame
		Board board = new Board();							//instancio o tabuleiro
		frame.add(board);									//insiro o tabuleiro no frame
		
		frame.setVisible(true);   //deixo o frame visivel
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //evita que o programa continue rodando após usar o x


	}

}
