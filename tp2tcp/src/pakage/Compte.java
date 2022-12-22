package pakage;

public class Compte {
	private static  int numC;;
	private Client c;
	private float Sold;
	private boolean etat;

	



	public void setEtat(boolean etat) {
		this.etat = etat;
	}



	public Compte() {}
	
		
	
	public Compte(Client c, Long sold) {
		super();
		this.c = c;
		Sold = sold;
	}
	public Compte(String nomc) {
		// TODO Auto-generated constructor stub
	}
	public static int getNumC() {
		return numC;
	}
	public static void setNumC(int numC) {
		Compte.numC = numC;
	}
	public Client getC() {
		return c;
	}
	public void setC(Client nomc) {
		this.c = nomc;
	}
	public float getSold() {
		return Sold;
	}
	public void setSold(float sold) {
		Sold = sold;
	}
	
	
	
	
	

}
