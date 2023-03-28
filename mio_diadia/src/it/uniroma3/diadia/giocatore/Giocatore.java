package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.*;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore () {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfuAttuali) {
		cfu = cfuAttuali;		
	}
	
	public String getDescrizione(){
		return toString();
	}
	
	public void setAttrezzo(Attrezzo attrezzo) {
		borsa.addAttrezzo(attrezzo);
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public String toString() {
		return ("Ti rimangono " + getCfu() + "cfu.");
	}
}
