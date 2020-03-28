package fr.uvsq21602618;
/**
 * Classe pour la commande undo.
 * Supprime la dernière commande de l'historique.
 * @author Nathalie
 *
 */
public class UndoCommand implements Commande {
    /**
     * la saisie.
     */
    private final Typing typing;
    /**
     * moteur RPN.
     */
    private final MoteurRPN moteur;
    /**
     * Constructeur de l'annulation de la saisie.
     * @param t la saisie
     * @param m le moteur
     */
    public UndoCommand(final Typing t, final MoteurRPN m) {
        this.typing = t;
        this.moteur = m;
    }
    /**
     * Application de l'annulation.
     */
    public void apply() {
        if (!moteur.getList().isEmpty()) {
            if (moteur.getHistoriqueType().getLast()) {
                moteur.removeFirstPile();
            } else {
                moteur.cancelEval();
            }
            moteur.getHistoriqueType().removeLast();
        }
        typing.typeUndo();
    }
    /**
     * Recuperation du moteur.
     * @return moteur
     */
    public MoteurRPN getMoteur() {
        return moteur;
    }
}
