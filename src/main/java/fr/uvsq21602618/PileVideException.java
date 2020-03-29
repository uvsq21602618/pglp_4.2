package fr.uvsq21602618;
/**
 * Classe Exception pour pile vide.
 * @author Nathalie
 *
 */
public class PileVideException extends ExceptionCalculatrice{
    /**
     * SerialID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Message associé à l'exception.
     */
    public PileVideException() {
        super("La pile d'operandes est vide!");
    }
}
