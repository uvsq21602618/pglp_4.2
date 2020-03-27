package fr.uvsq21602618;
/**
 * Classe pour la commande quit.
 * La commande stoppe le programme.
 * @author Nathalie
 *
 */
public class QuitCommand implements Commande{
    private final Typing typing;

    public QuitCommand(Typing t) {
        this.typing = t;
    }
    
    public void apply() {
        typing.typeQuit();
    }
}
