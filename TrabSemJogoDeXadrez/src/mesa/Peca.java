package mesa;

public class Peca {
    private String nome;
    private int movimentacao;
    private String status;

    public Peca(String nome, int m, String status){
        setNome(nome);
        setMovimentacao(m);
        setStatus(status);
    }

    public String getNome(){
        return nome;
    } 
    public void setNome(String n){
        nome = n;
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

}
