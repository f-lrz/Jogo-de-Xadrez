package mesa;

//import mesa.*;

public class Jogador {
    //atributos da classe jogador
    private String nome; 
    private String cor;

    //construtor da classe jogador
    public Jogador(String nome, String cor){
        setNome(nome);
        setCor(cor);
    }

    //getters e setters da classe jogador
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
    
    //função de imprimir os dados da classe jogador
    public void imprimeJogador(){
        System.out.print("Nome do jogador " + getCor() + ": ");
        System.out.print(getNome());
        System.out.println();
    }       
}
