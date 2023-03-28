package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest {
				Stanza principale;
				Stanza adiacente;
				String direzioni[] = {"nord", "sud", "est", "ovest"};
				String attrezzi[] = {"osso", "spada", "lama", "lanterna", "coltello", "pietra", "chiavi", "pozione", "scudo", "pergamena"};

	@Before
	public void setUp(){
					principale = new Stanza("StanzaPrincipaleTest");
	   	adiacente = new Stanza("StanzaAdiacenteTest");
	}

//factory methods
	private Attrezzo attrezzoTest(int i){
					Attrezzo attrezzoTest = new Attrezzo(attrezzi[i],1);
	}
//da completare
	private Stanza stanzaAdiacenteStessoNome(int i){
					Stanza stanzaStessoNome = new Stanza("");
	}

	@Test

	private 


	public void testImpostaStanze(){
	 /* Stanza stanzaCentrale = new Stanza("Stanza Centrale");
	    Stanza stanzaNord= new Stanza("Stanza Nord");
	    Stanza stanzaSud= new Stanza("Stanza Sud");
	    Stanza stanzaEst= new Stanza("Stanza Est");
	    Stanza stanzaOvest= new Stanza("Stanza Ovest");
	 */ 
	    stanzaCentrale.impostaStanzaAdiacente("nord", stanzaNord);
	    stanzaCentrale.impostaStanzaAdiacente("sud", stanzaSud);
	    stanzaCentrale.impostaStanzaAdiacente("est", stanzaEst);
	    stanzaCentrale.impostaStanzaAdiacente("ovest", stanzaOvest);
	    
	    assertEquals(stanzaNord,stanzaCentrale.getStanzaAdiacente("nord"));
	    assertEquals(stanzaSud,stanzaCentrale.getStanzaAdiacente("sud"));
	    assertEquals(stanzaEst,stanzaCentrale.getStanzaAdiacente("est"));
	    assertEquals(stanzaOvest,stanzaCentrale.getStanzaAdiacente("ovest"));
	    
	    //per capire che fa Same
	    assertSame(stanzaNord,stanzaCentrale.getStanzaAdiacente("nord"));
	    assertSame(stanzaSud,stanzaCentrale.getStanzaAdiacente("sud"));
	    assertSame(stanzaEst,stanzaCentrale.getStanzaAdiacente("est"));
	    assertSame(stanzaOvest,stanzaCentrale.getStanzaAdiacente("ovest"));
	  }
	
	public void test() {
		fail("Not yet implemented");
	}

}