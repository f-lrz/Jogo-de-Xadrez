package mesa;

import Pieces.*;

public class Peca {
    //private String nome;
    private String cor;
    private int movimentacao;
    private String status;

    public Peca(/*String nome,*/ String cor, int m, String status){
        //setNome(nome);
        setCor(cor);
        setMovimentacao(m);
        setStatus(status);
    }

    /*public String getNome(){
        return nome;
    } 
    public void setNome(String n){
        nome = n;
    }*/

    public String getCor(){
        return cor;
    } 
    public void setCor(String c){
        cor = c;
    }

    public int getMovimentacao(){
        return movimentacao;
    } 
    public void setMovimentacao(int m){
        movimentacao = m;
    }

    public String getStatus(){
        return status;
    } 
    public void setStatus(String s){
        status = s;
    }

    public void imprimepeca(int m){
        if(m == 1) System.out.println("Nome: Peao");
        else if(m == 2) System.out.println("Nome: Torre");
        else if(m == 3) System.out.println("Nome: Cavalo");
        else if(m == 4) System.out.println("Nome: Bispo");
        else if(m == 5) System.out.println("Nome: Rei");
        else if(m == 6) System.out.println("Nome: Rainha");
        System.out.println("Cor: " + cor);
        System.out.println("Movimentação: " + movimentacao);
        System.out.println("Status: " + status);
       
   }

}
