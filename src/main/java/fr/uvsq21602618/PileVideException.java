package fr.uvsq21602618;
/**
 * Classe pour l'exception lors d'une pile vide.
 * @author natha
 *
 */
public class PileVideException extends ExceptionPile{
	/**
     * SerialID.
     */
    private static final long serialVersionUID = 1L;

    /**
	 * Message liee a l'exception.
	 */
	public PileVideException() {
		super("La Pile est vide!");
	}

}
