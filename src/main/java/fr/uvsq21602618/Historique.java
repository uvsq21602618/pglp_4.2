package fr.uvsq21602618;
/**
 * Classe historique des saisies avec evaluation.
 * @author Nathalie
 *
 */
public class Historique {
    /**
     * L'operande 1.
     */
    private int operande1;
    /**
     * L'operande 2.
     */
    private int operande2;
    /**
     * Constructeur de l'historique des evaluations.
     * @param ope1 la premiere operande
     * @param ope2 la deuxieme operande
     */
    public Historique(final int ope1, final int ope2) {
        this.setOperande1(ope1);
        this.operande2 = ope2;
    }
    /**
     * Recupere l'operande 1.
     * @return l'operande1
     */
    public int getOperande1() {
        return operande1;
    }
    /**
     * Redefinit l'operande 1.
     * @param ope1 la premiere operande.
     */
    public void setOperande1(final int ope1) {
        this.operande1 = ope1;
    }
    /**
     * Recupere l'operande 2.
     * @return l'operande2
     */
    public int getOperande2() {
        return operande2;
    }
    /**
     * Redefinit l'operande 2.
     * @param ope2  la deuxieme operande
     */
    public void setOperande2(final int ope2) {
        this.operande2 = ope2;
    }
}
