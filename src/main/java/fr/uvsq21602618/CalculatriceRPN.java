package fr.uvsq21602618;
/**
 * Singleton contenant le main.
 * @author Nathalie
 */
public enum CalculatriceRPN {
    /**
     * L'enum qui contient le code du main.
     */
    ENVIRONNEMENT;
    /**
     * Execution du programme.
     * @throws Exception liee a la calculatrice
     */
    public void run() throws Exception {
        try {
            SaisieRPN saisie = new SaisieRPN();
            saisie.traitement();
        } catch (ExceptionCalculatrice e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Main.
     * @throws Exception liee a la calculatrice.
     * @param args arguments
     */
    public static void main(final String[] args) throws Exception {
        ENVIRONNEMENT.run();
    }

}
