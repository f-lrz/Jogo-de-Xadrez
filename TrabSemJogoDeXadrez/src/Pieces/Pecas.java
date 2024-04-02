package Pieces;

public class Pecas {
    private String cor;
    private String status;

    public Pecas(String cor, String status){
        setCor(cor);
        setStatus(status);
    }

    public String getCor(){
        return cor;
    } 
    public void setCor(String cor){
        this.cor = cor;
    }
    public String getStatus(){
        return status;
    } 
    public void setStatus(String status){
        this.status = status;
    }

    public void imprime(int t){
        System.out.println("Cor: " + cor);
        System.out.println("Status: " + status);
    }
}
