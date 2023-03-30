package it.uniroma3.diadia;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.*;
/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {
	private Labirinto labirinto;
	private Partita partita;
	private Giocatore giocatore;
	private Borsa borsa;
    private String nome;
    private String parametro;
    static final private String[] elencoComandi = {"aiuto", "vai", "prendi", "posa", "fine"};
    
    public Comando(String istruzione, Partita partita ) {
		try (Scanner scannerDiParole = new Scanner(istruzione)) {
			// prima parola: nome del comando
			if (scannerDiParole.hasNext())
				this.nome = scannerDiParole.next(); 

			// seconda parola: eventuale parametro
			if (scannerDiParole.hasNext())
				this.parametro = scannerDiParole.next();

		}
		this.partita = partita;
		this.setLabirinto();
		this.setGiocatore();
		this.setBorsa();
    }
    

    public String getNome() {
    	if(this.nome == null)
    		this.nome = "invalido";
    	
        return this.nome;
    }

    public String getParametro() {
        return this.parametro;
    }

    public boolean sconosciuto() {
        return (this.nome == null);
    }
    
    public void setLabirinto() {
		this.labirinto = partita.getLabirinto();
	}
    
    public void setGiocatore() {
		this.giocatore = partita.getGiocatore();
	}
    
    public void setBorsa() {
		this.borsa = giocatore.getBorsa();
	}
    
	//****INIZIO IMPLEMENTAZIONI DEI COMANDI DELL'UTENTE:****//

	/**
	 * Stampa informazioni di aiuto.
	 */
	public void aiuto(IOConsole console) {
		for(int i=0; i< elencoComandi.length; i++) 
			//System.out.print(elencoComandi[i]+" ");
			console.mostraMessaggio(elencoComandi[i]);
		//System.out.println();
		//console.mostraMessaggio();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	public void vai(IOConsole console) {
		if(this.parametro == null) {
			//System.out.println("Dove vuoi andare?");
			console.mostraMessaggio("Dove vuoi andare?\n");
			//Scanner ScannerDirezione = new Scanner(System.in);
			//this.parametro = ScannerDirezione.nextLine();
			this.parametro = console.leggiRiga();
		}
		Stanza prossimaStanza = null;
		//dopo cambio getStanzaCorrente in static, prima era this.labirinto. etc.
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(this.parametro);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente\n");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(--cfu);
		}
		//dopo cambio getStanzaCorrente in static, prima era this.labirinto. etc.
		/**System.out.println(Labirinto.getStanzaCorrente().getDescrizione());
		 * System.out.println(giocatore.getDescrizione());
		 * System.out.println(borsa.getDescrizione());
		 */
	}

	/**
	 * Comando "Fine".
	 */
	
	//Ho inserito lo static per usarla anche in vinta e persa
	public void fine(IOConsole console) {
		//System.out.println("Grazie di aver giocato!");  // si desidera smettere
		console.mostraMessaggio("Grazie di aver giocato!");
	}
	
	
	/**
	 * comando che raccoglie, se c'e', un oggetto nella stanza corrente
	 * e lo inserisce nella borsa  
	 */
	public void raccogliAttrezzo (IOConsole console){
		if(this.parametro == null) {
			console.mostraMessaggio("Che attrezzo vuoi prendere?\n");
			Scanner scannerAttrezzo = new Scanner(System.in);
			this.parametro = scannerAttrezzo.nextLine();
		}
		Attrezzo attrezzo = null;
		//dopo cambio getStanzaCorrente in static, prima era this.labirinto. etc.
		attrezzo = this.partita.getStanzaCorrente().getAttrezzo(this.parametro);
		if(attrezzo == null)
			console.mostraMessaggio("oggetto non trovato\n");
		else {
			this.giocatore.setAttrezzo(attrezzo);
			//dopo cambio getStanzaCorrente in static, prima era this.labirinto. etc.
			if(this.partita.getStanzaCorrente().removeAttrezzo(attrezzo))
				console.mostraMessaggio("Attrezzo aggiunto alla borsa!\n");
			else
				console.mostraMessaggio("Errore nella rimozione dell'oggetto\n");
		}
	}
	
	/**
	 * comando che posa, se c'e', un oggetto nella stanza corrente
	 * e lo rimuove dalla borsa
	 */
	public void posaAttrezzo(IOConsole console) {
		if(this.parametro == null) {
			console.mostraMessaggio("Che attrezzo vuoi posare?\n");
			Scanner scannerAttrezzo = new Scanner(System.in);
			this.parametro = scannerAttrezzo.nextLine();
		}
		if(this.borsa.getAttrezzo(this.parametro) == null)
			console.mostraMessaggio("oggetto non trovato nella borsa\n");
		else {
			this.borsa.removeAttrezzo(this.parametro, partita);
			console.mostraMessaggio("Attrezzo rimosso alla borsa!\n");
		}
	}
	
}
