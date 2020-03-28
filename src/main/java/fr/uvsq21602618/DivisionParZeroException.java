package fr.uvsq21602618;
/**
 * Classe pour l'exception quand on divise par 0.
 * @author Nathalie
 *
 */
public class DivisionParZeroException extends ExceptionCalculatrice {
	/**
     * SerialID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Message associé à l'exception.
     */
    public DivisionParZeroException() {
		super("Division par 0 non autorisee!");
	}
}
