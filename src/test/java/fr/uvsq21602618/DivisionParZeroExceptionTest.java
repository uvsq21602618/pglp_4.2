package fr.uvsq21602618;

import org.junit.Test;
/**
 * Classe de test pour la division par zero.
 * @author Nathalie
 *
 */
public class DivisionParZeroExceptionTest {
    /**
     * Test pour la division par zero.
     * @throws DivisionParZeroException l'exception pour
     * une division par zero
     */
    @Test(expected = DivisionParZeroException.class)
    public void testDivParZero() throws DivisionParZeroException {
        Operation.DIV.eval(10, 0);
    }
}
