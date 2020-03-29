package fr.uvsq21602618;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Classe de tests pour l'enumeration
 * Operation.
 * @author Nathalie
 *
 */
public class OperationTest {
    /**
     * Test de l'addition.
     * @throws DivisionParZeroException si division par zero
     */
    @Test
    public void testAddition() throws DivisionParZeroException {
        int d = Operation.PLUS.eval(5, 10);
        int exp = 15;
        assertEquals(exp, d);
    }
    /**
     * Test de la soustraction.
     * @throws DivisionParZeroException si division par zero
     */
    @Test
    public void testSoustraction() throws DivisionParZeroException {
        int d = Operation.MOINS.eval(10, 5);
        int exp = 5;
        assertEquals(exp, d);
    }
    /**
     * Test de la division.
     * @throws DivisionParZeroException si division par zero
     */
    @Test
    public void testDivision() throws DivisionParZeroException {
        int d = Operation.DIV.eval(10, 5);  
        int exp = 2;
        assertEquals(exp, d);
    }
    /**
     * Test de la multiplication.
     * @throws DivisionParZeroException si division par zero
     */
    @Test
    public void testMultiplication() throws DivisionParZeroException {
        int d = Operation.MULTI.eval(10, 2);
        int exp = 20;
        assertEquals(exp, d); 
    }
}
