 package mesa;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Tabuleiro {
	
	private int[][]sensorp;
	private String[][]casa;

	public Tabuleiro(){
		sensorp = new int[9][9]; 
        casa = new String[9][9];
		
		for(int i = 1; i <= 8; i++){
			for(int j = 1; j <= 8; j++){
				sensorp[i][j] = 0;
				casa[i][j] = "i + j";
			}
		}
	}

	public int getSensorp(int x, int y){
		return sensorp[x][y];
	}
	public void setSensorp(int sensorp, int x, int y){
		this.sensorp[x][y] = sensorp;
	}
	
	public String getCasa(int x, int y){
		return casa[x][y];
	}
	public void setCasa(String casa, int x, int y){
		this.casa[x][y] = casa;
	}

	public void imprimetab() {
	    System.out.println("   a b c d e f g h");
	    for (int i = 0; i < 8; i++) {
	        System.out.print((i + 1) + " |"); 
	        for (int j = 0; j < 8; j++) {
	            if (getSensorp(i, j) == 0) System.out.print(" ");
	            else if (getSensorp(i, j) == 1) System.out.print("1");
	            else if (getSensorp(i, j) == 2) System.out.print("2");
	            else if (getSensorp(i, j) == 3) System.out.print("3");
	            else if (getSensorp(i, j) == 4) System.out.print("4");
	            else if (getSensorp(i, j) == 5) System.out.print("5");
	            else if (getSensorp(i, j) == 6) System.out.print("6");
	            System.out.print("|");
	        }
	        System.out.println();
	    }
	}

}





/*		System.out.println("   a b c d e f g h");
		System.out.println("1 | | | | | | | | |");
		System.out.println("2 | | | | | | | | |");
		System.out.println("3 | | | | | | | | |");
		System.out.println("4 | | | | | | | | |");
		System.out.println("5 | | | | | | | | |");
		System.out.println("6 | | | | | | | | |");
		System.out.println("7 | | | | | | | | |");
		System.out.println("8 | | | | | | | | |");
		*/
