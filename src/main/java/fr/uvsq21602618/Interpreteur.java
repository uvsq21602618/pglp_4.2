package fr.uvsq21602618;

import java.util.HashMap;

/**
 * La classe Interpreteur qui supporte uniquement
 * les commandes undo et quit.
 * @author Nathalie
 *
 */
public class Interpreteur {
    private final HashMap<String, Commande> commandes;
    /**
     * Le constructeur de l'interpréteur.
     */
    public Interpreteur() {
        this.commandes = new HashMap<String, Commande>();
    }

    public void addCommande(String nom, Commande commande) {
        this.commandes.put(nom, commande);
    }

    public void executeCommand(String nom) {
        Commande commande = commandes.get(nom);
        if (commande == null) {
            throw new IllegalStateException("La commande : " + nom + " n'existe pas !");
        }
        commande.apply();
    }
}
