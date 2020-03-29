package fr.uvsq21602618;
/**
 * Une interface commande.
 * @author Nathalie
 *
 */
public interface Commande {
    /**
     * Méthode d'application de la commande.
     * @throws PileVideException  quand la pile est vide
     */
    void apply() throws PileVideException;
}
