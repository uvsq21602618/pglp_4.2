package fr.uvsq21602618;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Classe de test pour l'historique des
 * duo d'operandes de l'evaluation.
 * @author Nathalie
 *
 */
public class HistoriqueTest {
    /**
     * Instance de la classe historique.
     */
    private Historique hist;
    /**
     * Test de la creation d'une instance
     * de historique.
     */
    @Test
    public void historiqueTest() {
        hist = new Historique(1, 2);
        int expOp1 = 1;
        int expOp2 = 2;

        assertEquals(expOp1, hist.getOperande1());
        assertEquals(expOp2, hist.getOperande2());
    }
    /**
     * Test du setOperande pour
     * les deux attributs de classe.
     */
    @Test
    public void historiqueSetTest() {
        hist = new Historique(1, 2);
        hist.setOperande1(3);
        hist.setOperande2(4);
        int expOp1 = 3;
        int expOp2 = 4;

        assertEquals(expOp1, hist.getOperande1());
        assertEquals(expOp2, hist.getOperande2());
    }

}
