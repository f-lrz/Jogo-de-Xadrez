package mesa;

//import mesa.*;

public class Jogador {
    private String nome;
    private String cor;

    public Jogador(String nome, String cor){
        setNome(nome);
        setCor(cor);
    }

    public String getNome(){
        return nome;
    } 
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCor(){
        return cor;
    } 
    public void setCor(String c){
        cor = c;
    }

    public void imprimeJogador(){
        System.out.print("Nome do jogador " + getCor() + ": ");
        System.out.print(getNome());
        System.out.println();
    }       
}
