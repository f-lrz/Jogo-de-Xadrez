package mesa;

public class Peca {
    //private String nome;
    private String cor;
    private int movimentacao;
    private String status;

    public Peca(/*String nome,*/ String cor, int m, String status){
        /*setNome(nome);*/
        setCor(cor);
        setMovimentacao(m);
        setStatus(status);
    }

    /*public String getNome(){
        return nome;
    } 
    public void setNome(String n){
        nome = n;
    }
*/
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
    
    public void imprimepeca() {
    	 /*System.out.println("nome: " + nome);*/
    	 System.out.println("Cor: " + cor);
         System.out.println("Movimentação: " + movimentacao);
         System.out.println("Status: " + status);
    	
    }
    
    
}



