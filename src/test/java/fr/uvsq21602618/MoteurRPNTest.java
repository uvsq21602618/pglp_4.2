package fr.uvsq21602618;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Classe Test pour moteurRPN.
 * @author natha
 *
 */
public class MoteurRPNTest {
    /**
     * Instance de MoteurRPN.
     */
    private MoteurRPN moteur = new MoteurRPN();
    /**
     * Test de la methode saveOperande.
     */
    @Test
    public void saveOperandeTest() {
        int exp = 2;
        moteur.saveOperande(2);
        int test = moteur.getPileFirstInt();
        assertEquals(test, exp);
    }
    /**
     * Test de la methode applyOperation.
     * @throws BinaireOpsException mauvaise saisie
     * @throws DivisionParZeroException division par zero
     */
    @Test
    public void applyOperationTest() throws BinaireOpsException,
    DivisionParZeroException {
        moteur.saveOperande(1);
        moteur.saveOperande(2);
        moteur.applyOperation(Operation.PLUS);
        int exp = 3;
        int test = moteur.getPileFirstInt();
        assertEquals(test, exp);

        moteur.saveOperande(1);
        moteur.saveOperande(2);
        moteur.applyOperation(Operation.MOINS);
        exp = -1;
        test = moteur.getPileFirstInt();
        assertEquals(test, exp);

        moteur.saveOperande(3);
        moteur.saveOperande(2);
        moteur.applyOperation(Operation.MULTI);
        exp = 6;
        test = moteur.getPileFirstInt();
        assertEquals(test, exp);

        moteur.saveOperande(5);
        moteur.saveOperande(2);
        moteur.applyOperation(Operation.DIV);
        exp = 2;
        test = moteur.getPileFirstInt();
        assertEquals(test, exp);
    }
    /**
     * Test de la methode removeFirstPile.
     * @throws PileVideException si la pile est vide
     */
    @Test
    public void removeFirstPileTest() throws PileVideException {
        moteur.saveOperande(1);
        moteur.saveOperande(2);
        moteur.removeFirstPile();
        int exp = 1;
        int test = moteur.getPileFirstInt();
        assertEquals(test, exp);
    }
    /**
     * Test de la methode AfficherOperande.
     */
    @Test
    public void afficherOperandeTest() {
        moteur.saveOperande(3);
        moteur.saveOperande(64);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        moteur.afficherOperandes();
        String expected = "Affichage Pile : [" + 3 + "=>"
                + 64 + "=>" + "] \n";

        assertEquals(outContent.toString(), expected);
    }
    /**
     * Test de la methode conversionTest.
     * @throws BinaireOpsException si mauvaise saisie
     */
    @Test
    public void conversionTest() throws BinaireOpsException {
        char plus = '+';
        char moins = '-';
        char fois = '*';
        char div = '/';

        Operation test;
        test = moteur.conversion(plus);
        Operation expected = Operation.PLUS;
        assertEquals(expected, test);

        test = moteur.conversion(moins);
        expected = Operation.MOINS;
        assertEquals(expected, test);

        test = moteur.conversion(fois);
        expected = Operation.MULTI;
        assertEquals(expected, test);

        test = moteur.conversion(div);
        expected = Operation.DIV;
        assertEquals(expected, test);
    }
    /**
     * Test de retirerSaisie.
     */
    @Test
    public void retirerSaisieTest() {
        moteur.saveOperande(1);
        moteur.retirerSaisie();
        assertTrue(moteur.pileIsEmpty());
    }
    /**
     * Test de cancelEval.
     * @throws BinaireOpsException si mauvaise saisie
     * @throws DivisionParZeroException si division par zero
     * @throws PileVideException si pile vide
     */
    @Test
    public void cancelEvalTest() throws BinaireOpsException,
    DivisionParZeroException, PileVideException {
        moteur.saveOperande(4);
        moteur.saveOperande(10);
        moteur.applyOperation(Operation.MULTI);
        moteur.cancelEval();
        int exp = 10;
        int test = moteur.getPileFirstInt();
        assertEquals(exp, test);

        moteur.removeFirstPile();
        exp = 4;
        test = moteur.getPileFirstInt();
        assertEquals(exp, test);
    }
}
