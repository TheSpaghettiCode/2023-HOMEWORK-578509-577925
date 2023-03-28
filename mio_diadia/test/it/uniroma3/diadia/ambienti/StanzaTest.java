package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest {

	@Test
	public void testImpostaStanze(){
	    Stanza stanzaCentrale = new Stanza("Stanza Centrale");
	    Stanza stanzaNord= new Stanza("Stanza Nord");
	    Stanza stanzaSud= new Stanza("Stanza Sud");
	    Stanza stanzaEst= new Stanza("Stanza Est");
	    Stanza stanzaOvest= new Stanza("Stanza Ovest");
	    
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