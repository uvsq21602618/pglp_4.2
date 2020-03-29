package fr.uvsq21602618;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * La classe Interpreteur qui supporte uniquement
 * les commandes undo et quit.
 * @author Nathalie
 *
 */
public class Interpreteur {
    /**
     * La table de hachage qui associe une chaine
     * de caractere a une commande.
     */
    private final HashMap<String, Commande> commandes;
    /**
     * Le constructeur de l'interpréteur.
     */
    public Interpreteur() {
        this.commandes = new HashMap<String, Commande>();
    }
    /**
     * Ajout d'une commande associé à son nom.
     * @param nom de la commande
     * @param commande l'instance
     */
    public void addCommande(final String nom,
            final Commande commande) {
        this.commandes.put(nom, commande);
    }
    /**
     * Méthode d'execution de la commande
     * en fonction du nom en parametre.
     * @param nom celui de la commande
     */
    public void executeCommand(final String nom) {
        Commande commande = commandes.get(nom);
        if (commande == null) {
            throw new IllegalStateException("La commande :"
                    + " " + nom + " n'existe pas !");
        }
        commande.apply();
    }
    /**
     * Méthode pour retourner la table de hachage
     * sans qu'elle puisse etre modifiee.
     * @return commandes non modifiable
     */
    public Map<String, Commande> getCommandes() {
        Map<String, Commande> unmodifiable =
                Collections.unmodifiableMap(this.commandes);
        return unmodifiable;
    }
}
