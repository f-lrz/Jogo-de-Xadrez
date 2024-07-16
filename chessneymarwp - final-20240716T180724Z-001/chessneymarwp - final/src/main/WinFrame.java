package main;

import pieces.promotesPos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WinFrame extends JFrame {
    public WinFrame(Board board, boolean white) {
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
        this.setSize(new Dimension(800, 600));
        this.setLayout(null);
        this.setLocationRelativeTo(board);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel txt = new JLabel("Parabéns Jogador" + (white ?  " Branco!" : " Preto!"));
        txt.setFont(new Font("Tahoma", Font.PLAIN, 50));
        JButton button = new JButton("Encerrar");
        button.setBackground(Color.red);
        button.setForeground(Color.black);
        button.setOpaque(true);
        button.setBounds(100, 400,100, 50);
        JButton button2 = new JButton("Jogadas");
        button2.setBackground(Color.green);
        button2.setForeground(Color.black);
        button2.setOpaque(true);
        button2.setBounds(600, 400,100, 50);
        txt.setBounds(100, 100, 600,100);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        this.add(button);
        this.add(button2);
        this.add(txt);
        this.setVisible(true);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedReader b = null;
                try {
                    b = new BufferedReader(new FileReader("SavePlays.txt"));
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                String line = "";
                System.out.println(line);

                while(true) {
                    try {
                        if (!((line = b.readLine()) != null)) break;
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(line);
                }

                try {
                    b.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                System.out.println("Digite 0 para encerrar.");
                Scanner sc = new Scanner(System.in);
                int x = sc.nextInt();
                if(x == 0)
                    System.exit(0);


            }
        });


    }
}
