package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest {
	Stanza principale;
	Stanza stanzeAdiacenti[] = {"stanzaNordTest", "stanzaSudTest", "stanzaEstTest", "stanzaOvestTest"};
	String direzioni[] = {"nord", "sud", "est", "ovest"};
	String attrezzi[] = {"osso", "spada", "lama", "lanterna", "coltello", "pietra", "chiavi", "pozione", "scudo", "pergamena"};

@Before
public void setUp(){
	principale = new Stanza("StanzaPrincipaleTest");
	adiacente = new Stanza("StanzaAdiacenteTest");
	attrezzo = new Attrezzo("spada",4)
}

//factory methods

private Stanza setStanzaAdiacenteTest(int i){
	principale.impostaStanzaAdiacente(direzioni[i],stanzeAdiacenti[i]);
	return stanzeAdiacenti[i];
}

/*private Stanza setTutteStanzeAdiacentiTest(){
	for(int i;i<direioni.length;i++){

	}
}*/

/*private Attrezzo creaAttrezzoTest(){
	return Attrezzo attrezzo = new Attrezzo ("")
}*/	
private Attrezzo creaAttrezzoTest(int i){
	return Attrezzo attrezzoTest = new Attrezzo(attrezzi[i],1);
}
//da completare
	/*private Stanza stanzaAdiacenteStessoNome(int i){
			Stanza stanzaStessoNome = new Stanza("");
	}*/
//#######################impostaStanze###################################
/*	@Test
	public void testImpostaStanzeConTutteLeDirezioni(){
		for(int i;i<direzioni.length;i++){
			assertSame(setStanzaAdiacenteTest(i),principale.getStanzaAdiacente(direzioni[i]));
		}
	}
*/

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
	

//########addAttrezzo#########
@test
public void testAddAttrezzoConStanzaSenzaAttrezzi(){
	assertTrue(principale.addAttrezzo(attrezzo));
}

public void testAddAttrezzoConAttrezziPresenti(){
	assertTrue(principale.addAttrezzo(attrezzo));
}

public void testAddAttrezzoConStanzaPiena(){
	principale.setNumeroAttrezzi(10);  //posso farlo anche creando nel factory un metodo "riempi stanza" dove inserisco 10 attrezzi
	assertFalse(principale.addAttrezzo(attrezzo));
}

//######hasAttrezzo########

@test
public void testHasAttrezzoSePresente(){
	assertTrue(principale.hasAttrezzo("spada"));
}

@test
public void testHasAttrezzoSeStanzaVuota(){
	assertFalse(adiacente.hasAttrezzo("spada"));
}

@test
public void testHasAttrezzoSeStanzaConAttrezziMaSenzaIlCercato(){
	assertFalse(principale.hasAttrezzo("coltello"));
}


//######getAttrezzo##############

@Test
public void testGetAttrezzoSePresente(){
	assertEquals(attrezzo,principale.getAttrezzo("spada"));
}
	
@Test
public void testGetAttrezzoSeNonPresente(){
	assertNull(principale.getAttrezzo("coltello"));
}

@Test
public void testGetAttrezzoSeStanzaVuota(){
	assertNull(adiacente.getAttrezzo("spada"));
}

/*@Test
public void testGetAttrezzoSeRiceveNull(){
	assertNull(principale.getAttrezzo());
*/}


//#####removeAttrezzo############
@Test
public void testRemoveAttrezzoSePresente(){
	assertTrue(principale.removeAttrezzo(attrezzo));
}

public void testRemoveAttrezzoSeNonPresente(){
	assertFalse(adiacente.removeAttrezzo(this.creaAttrezzoTest(3)));
}

public void 
	
	
	
	
	public void test() {
		fail("Not yet implemented");
	}

}