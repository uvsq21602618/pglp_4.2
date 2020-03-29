package fr.uvsq21602618;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

/**
 * Classe Test pour l'interpreteur.
 * @author Nathalie
 *
 */
public class InterpreteurTest {
    /**
     * Instance d'interpreteur.
     */
    private Interpreteur inter;
    /**
     * Instance de Commande.
     */
    private Commande commande;
    /**
     * Instance de typing pour l'affichage
     * associee a une commande.
     */
    private Typing typing;
    /**
     * Test de la méthode addCommande.
     */
    @Test
    public void addCommandeTest() {
        typing = new Typing();
        commande = new QuitCommand(typing);
        inter = new Interpreteur();
        inter.addCommande("quit", commande);

        String expNom = "quit";
        Commande expCom = inter.getCommandes().get(expNom);
        assertEquals(expCom, commande);
    }
    /**
     * Test de la méthode executeCommand avec quit.
     */
    @Test
    public void executeCommandTest() {
        typing = new Typing();
        commande = new QuitCommand(typing);
        inter = new Interpreteur();
        inter.addCommande("quit", commande);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        inter.executeCommand("quit");
        String expected = "Fin du programme!";

        assertEquals(expected, outContent.toString().trim());
    }
    /**
     * Test de executeCommand lorsque
     * la commande n'existe pas.
     */
    @Test(expected = IllegalStateException.class)
    public void executeCommand2Test() {
        typing = new Typing();
        commande = new QuitCommand(typing);
        inter = new Interpreteur();
        inter.addCommande("quit", commande);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        inter.executeCommand("test");
    }
}
