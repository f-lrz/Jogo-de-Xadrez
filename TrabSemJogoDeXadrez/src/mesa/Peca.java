package mesa;

//import Pieces.*;

public class Peca {

    //atributos da classe Peca
    private String cor;
    private int movimentacao;
    private String status;
    //private String nome;

    //construtor da classe Peca
    public Peca(/*String nome,*/ String cor, int m, String status){
        setCor(cor);
        setMovimentacao(m);
        setStatus(status);
        //setNome(nome);
    }

    //getters e setters da classe Peca
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
    
    /*public String getNome(){
        return nome;
    } 
    public void setNome(String n){
        nome = n;
    }*/


    //função de imprimir os dados da classe Peca
    public void imprimePeca(){
        if(getMovimentacao() == 1) {
            System.out.println("Nome: Peao");
            System.out.println("Movimentação: avanço de 1 ou 2 casas a frente.");
        }
        else if(getMovimentacao() == 2) {
            System.out.println("Nome: Torre");
            System.out.println("Movimentação: deslocar-se às casas para frente, para traz ou para os lados.");
        }
        else if(getMovimentacao() == 3){
            System.out.println("Nome: Cavalo");
            System.out.println("Movimentação: deslocar-se em L para qualquer direção.");
        }
        else if(getMovimentacao() == 4) {
            System.out.println("Nome: Bispo");
            System.out.println("Movimentação: deslocar-se na diagional para qualquer direção.");
        }
        else if(getMovimentacao() == 5) {
            System.out.println("Nome: Rei");
            System.out.println("Movimentação: deslocar-se para as casas visinhas.");
        }
        else if(getMovimentacao() == 6) {
            System.out.println("Nome: Rainha");
            System.out.println("Movimentação: movimentação da Torre, do Bispo e do Rei juntas.");
        }
        System.out.println("Cor: " + cor);
        System.out.println("Status: " + status);
       
   }

}
