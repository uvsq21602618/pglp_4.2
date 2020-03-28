package fr.uvsq21602618;
/**
 * Classe d'exception pour la calculatrice.
 * @author Nathalie
 *
 */
public class ExceptionCalculatrice extends Exception {
    /**
     * SerialID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Message associée à l'exception.
     * @param message l'erreur associé
     */
    public ExceptionCalculatrice(final String message) {
        super(message);
    }

}
