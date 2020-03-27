package fr.uvsq21602618;
/**
 * Classe pour la commande undo.
 * Supprime la dernière commande de l'historique.
 * @author Nathalie
 *
 */
public class UndoCommand implements Commande{
    private final Typing typing;

    public UndoCommand(Typing t) {
        this.typing = t;
    }
    
    public void apply() {
        typing.typeUndo();
    }
}
