package fr.uvsq21602618;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Classe d'exception pour typing.
 * @author Nathalie
 *
 */
public class TypingTest {
    /**
     * Instance d'affichage.
     */
    private Typing type;
    /**
     * Test de l'affichage texte
     * de la commande undo.
     */
    @Test
    public void testTypeUndo() {
        type = new Typing();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        type.typeUndo();
        String expected = "Annulation de la saisie précédente!";

        assertEquals(expected, outContent.toString().trim());
    }

    /**
     * Test de l'affichage texte
     * de la commande quit.
     */
    @Test
    public void testTypeQuit() {
        type = new Typing();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        type.typeQuit();
        String expected = "Fin du programme!";

        assertEquals(expected, outContent.toString().trim());
    }
}
