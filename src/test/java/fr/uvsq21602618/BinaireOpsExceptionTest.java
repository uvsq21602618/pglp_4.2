package fr.uvsq21602618;

import java.io.ByteArrayInputStream;

import org.junit.Test;
/**
 * Classe pour liee aux erreurs de saisie.
 * @author Nathalie
 *
 */
public class BinaireOpsExceptionTest {
    /**
     * Classe qui gere les interactions avec l'utilisateur
     * et invoque le moteur RPN.
     */
    private SaisieRPN s;
    /**
     * Test la detection d'une erreur de saisie.
     * Une lettre aleatoire.
     * @throws Exception liee a la mauvaise saisie.
     */
    @Test(expected = BinaireOpsException.class)
    public void mauvaiseSaisieException() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1 2 o\n".getBytes());
        System.setIn(in);
        s = new SaisieRPN();
        s.traitement();
    }

    /**
     * Test la detection d'une erreur de saisie.
     * Mauvais nombre d'operande pour l'evaluation.
     * @throws Exception liee a la mauvaise saisie.
     */
    @Test(expected = BinaireOpsException.class)
    public void mauvaiseSaisieException2() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1 +\n".getBytes());
        System.setIn(in);
        s = new SaisieRPN();
        s.traitement();
    }
}
