package fr.uvsq21602618;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Classe Test pour UndoCommand.
 * @author Nathalie
 *
 */
public class UndoCommandTest {
    /**
     * Instance de saisieRPN.
     */
    private SaisieRPN s;
    /**
     * Test du apply de la saisie 'undo'
     * lorsque la saisie precedente est
     * un operateur.
     * @throws Exception liee a la calculatrice
     */
    @Test
    public void undoApplyTest() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String test = "1 2 3 + - undo undo undo\n";
        ByteArrayInputStream in =
                new ByteArrayInputStream(test.getBytes());
        System.setIn(in);
        s = new SaisieRPN();
        s.traitement();

        String[] lines = outContent.toString().split("\n");
        String exp1 = "Affichage Pile : [1=>]";
        String exp2 = "Affichage Pile : [1=>2=>]";
        String exp3 = "Affichage Pile : [1=>2=>3=>]";
        String exp4 = "Affichage Pile : [1=>5=>]";
        String exp5 = "Affichage Pile : [-4=>]";
        String exp6 = "Annulation de la saisie précédente!";
        String exp7 = "Affichage Pile : [1=>2=>3=>]";

        assertEquals(exp1, lines[0].trim());
        assertEquals(exp2, lines[1].trim());
        assertEquals(exp3, lines[2].trim());
        assertEquals(exp4, lines[3].trim());
        assertEquals(exp5, lines[4].trim());
        assertEquals(exp6, lines[5].trim());
        assertEquals(exp4, lines[6].trim());
        assertEquals(exp6, lines[7].trim());
        assertEquals(exp7, lines[8].trim());
        assertEquals(exp6, lines[9].trim());
        assertEquals(exp2, lines[10].trim());
    }
}
