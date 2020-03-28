package fr.uvsq21602618;
/**
 * Classe pour la commande quit.
 * La commande stoppe le programme.
 * @author Nathalie
 *
 */
public class QuitCommand implements Commande {
    /**
     * la saisie.
     */
    private final Typing typing;
    /**
     * Commande pour quitter le programme.
     * @param t la classe du type de saisie
     */
    public QuitCommand(final Typing t) {
        this.typing = t;
    }
    /**
     * Application du 'quit'.
     */
    public void apply() {
        typing.typeQuit();
    }
}
