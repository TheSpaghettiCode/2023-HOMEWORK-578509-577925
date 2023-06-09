package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;
	
	public Partita(){
		labirinto = new Labirinto();
		giocatore = new Giocatore();
		this.finita = false;
		}
		
		/**
		 * Restituisce vero se e solo se la partita e' finita
		 * @return vero se partita finita
		 */
		public boolean isFinita() {
			return finita || this.vinta() || (giocatore.getCfu() == 0);
		}

		/**
		 * Imposta la partita come finita
		 *
		 */
		public void setFinita() {
			this.finita = true;
		}
		
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	*/
		public boolean vinta() {
			//dopo cambio getStanzaCorrente in static, prima era this.labirinto. etc.
			return Labirinto.getStanzaCorrente() == this.labirinto.getStanzaVincente();
		}
		
		public Labirinto getLabirinto(){
			return this.labirinto;
		}
		
		public Giocatore getGiocatore(){
			return this.giocatore;
		}
		
	}
