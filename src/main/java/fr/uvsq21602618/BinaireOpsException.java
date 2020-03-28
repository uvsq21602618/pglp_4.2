package fr.uvsq21602618;
/**
 * Classe pour l'exception concernant l'évaluation
 * deux par deux des opérandes connues.
 * @author Nathalie
 *
 */
public class BinaireOpsException extends ExceptionCalculatrice {
    /**
     * SerialID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Message associé à l'exception.
     */
    public BinaireOpsException() {
        super("Assurez vous d'avoir 2 operandes "
                + "au moins et d'utiliser les operateurs demandes!");
    }
}
