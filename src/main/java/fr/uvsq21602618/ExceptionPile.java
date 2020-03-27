package fr.uvsq21602618;
/**
 * Classe mère des exceptions liées à la pile.
 * @author Nathalie
 *
 */
public class ExceptionPile extends Exception {
	/**
     * SerialID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Message correspondant à l'exception.
     * @param message pour l'exception
     */
    public ExceptionPile(final String message) {
		super(message);
	}
}
