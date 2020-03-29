package fr.uvsq21602618;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Classe Test pour la saisieRPN.
 * @author Nathalie
 *
 */
public class SaisieRPNTest {
    /**
     * Instance de saisieRPN.
     */
    private SaisieRPN s;
    /**
     * Test de la saisie 'undo'.
     * @throws Exception liee a la calculatrice
     */
    @Test
    public void saisieUndoTest() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ByteArrayInputStream in =
                new ByteArrayInputStream("undo\n".getBytes());
        System.setIn(in);
        s = new SaisieRPN();
        s.traitement();

        String[] lines = outContent.toString().split("\n");
        String exp1 = "Annulation de la saisie précédente!";
        String exp2 = "Affichage Pile : [] ";
        assertEquals(exp1, lines[0].trim());
        assertEquals(exp2.trim(), lines[1].trim());
    }
    /**
     * Test de la saisie 'quit'.
     * @throws Exception liee a la calculatrice
     */
    @Test
    public void saisieQuitTest() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ByteArrayInputStream in =
                new ByteArrayInputStream("quit\n".getBytes());
        System.setIn(in);
        s = new SaisieRPN();
        s.traitement();

        String[] lines = outContent.toString().split("\n");
        String exp1 = "Fin du programme!";
        assertEquals(exp1, lines[0].trim());
    }
    /**
     * Test de la saisie 'quit'.
     * @throws Exception liee a la calculatrice
     */
    @Test
    public void saisieEvalTest() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ByteArrayInputStream in =
                new ByteArrayInputStream("1 2 +\n".getBytes());
        System.setIn(in);
        s = new SaisieRPN();
        s.traitement();

        String[] lines = outContent.toString().split("\n");
        String exp1 = "Affichage Pile : [1=>]";
        String exp2 = "Affichage Pile : [1=>2=>]";
        String exp3 = "Affichage Pile : [3=>]";
        assertEquals(exp1, lines[0].trim());
        assertEquals(exp2, lines[1].trim());
        assertEquals(exp3, lines[2].trim());
    }

}
