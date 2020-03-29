package fr.uvsq21602618;
/**
 * Classe test pour PileVideException.
 * @author Nathalie
 *
 */

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PileVideExceptionTest {
    /**
     * Instance de moteurRPN.
     */
    private MoteurRPN moteur = new MoteurRPN();
    /**
     * Test du lancer de l'exception quand la
     * pile est vide.
     * @throws PileVideException si la pile est vide
     */
    @Test(expected = PileVideException.class) 
    public void testPileVide() throws PileVideException {
        moteur.removeFirstPile();
        assertTrue(moteur.getList().isEmpty());
    }
}
