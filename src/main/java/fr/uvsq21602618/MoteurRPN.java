package fr.uvsq21602618;

import java.util.LinkedList;
/**
 * Classe MoteurRPN qui dérive de la classe Interpeteur.
 * @author Nathalie
 *
 */
public class MoteurRPN extends Interpreteur {
    /**
     * Pile contenant les opérandes saisies.
     */
    private LinkedList<Integer> pile;
    /**
     * Historique contenant les saisies de nombres (true)
     * ou de d'operateurs (false).
     */
    private LinkedList<Boolean> historiqueType;
    /**
     * Historique des commandes.
     */
    private LinkedList<Historique> historiqueOpe;
    /**
     * Constructeur du moteur.
     */
    public MoteurRPN() {
        pile = new LinkedList<Integer>();
        historiqueType = new LinkedList<Boolean>();
        historiqueOpe = new LinkedList<Historique>();
    }
    /**
    Mettre l'operande sur la pile.
    @param op L'operande.
     */
    public void saveOperande(final int op) {
        pile.addLast(op); 
    }
    /**
    Vérification du nombre d'operandes inseree et des operateurs utilises.
    @param op operateur.
    @throws BinaireOpsException Si le nombre d'operateurs
    ou l'ordre des caracteres n'est pas le bon
     */
    private void operandeBinaire(final Operation op)throws BinaireOpsException {
        if (pile.size() - 1 < 0
                || pile.size() - 2 < 0
                || (op != Operation.PLUS && op != Operation.MOINS
                && op != Operation.MULTI && op != Operation.DIV)) {
            throw new BinaireOpsException();
        }
    }
    /**
    Applique l'operation en fonction de l'operateur.
    @param op operateur.
    @throws BinaireOpsException Si le nombre d'operateurs
    ou l'ordre des caracteres n'est pas le bon
    @throws DivisionParZeroException Si on tente une
    division par 0
     */
    public void applyOperation(final Operation op) throws BinaireOpsException,
    DivisionParZeroException {
        operandeBinaire(op);
        Historique hist = new Historique(pile.get(pile.size() - 2),
                pile.get(pile.size() - 1));
        this.historiqueOpe.add(hist);
        int res = 0;
        switch (op) {
        case PLUS:
            res = op.eval(pile.get(pile.size() - 2), pile.get(pile.size() - 1));
            break;

        case MOINS:
            res = op.eval(pile.get(pile.size() - 2), pile.get(pile.size() - 1));
            break;

        case MULTI:
            res = op.eval(pile.get(pile.size() - 2), pile.get(pile.size() - 1));
            break;

        case DIV:
            res = op.eval(pile.get(pile.size() - 2), pile.get(pile.size() - 1));
            break;

        default:
            throw new BinaireOpsException();
        }

        pile.removeLast();
        pile.removeLast();
        this.saveOperande(res);
    }
    /**
     * Retire le premier element de la pile.
     * Remet à jour les operandes 1 et 2.
     */
    public void removeFirstPile() throws PileVideException{
        if (pile.size() > 0) {
            this.pile.removeLast();
        } else {
            throw new PileVideException();
        }
    }
    /**
     * Annule le resultat de l'evaluation precedente.
     */
    public void cancelEval() {
        this.pile.removeLast();
        this.pile.add(historiqueOpe.getLast().getOperande1());
        this.pile.add(historiqueOpe.getLast().getOperande2());
        this.historiqueOpe.removeLast();
    }
    /**
    Afficher les operations dans la pile.
     */
    public void afficherOperandes() {
        System.out.print("Affichage Pile : [");
        for (Integer d : pile) {
            System.out.print(d + "=>");
        }
        System.out.print("] \n");
    }
    /**
     * Convertir le caractere en operande.
     * @param symbole l'opérande
     * @return Operation
     * @throws BinaireOpsException Si le nombre d'operateurs
    ou l'ordre des caracteres n'est pas le bon
     */
    public Operation conversion(final char symbole) throws BinaireOpsException {
        switch (symbole) {
        case '+':
            return Operation.PLUS;

        case '-':
            return Operation.MOINS;

        case '/':
            return Operation.DIV;

        case '*':
            return Operation.MULTI;

        default :
            throw new BinaireOpsException();
        }
    }
    /**
     * Retirer la saisier precedente si
     * c'est juste un nombre.
     */
    public void retirerSaisie() {
        this.pile.removeFirst();
    }
    /**
    Recuperer la pile.
     *@return pile la pile
     */
    public LinkedList<Integer> getList() {
        return pile;
    }
    /**
     * Recupere l'historique du type de saisie.
     * @return l' historique.
     */
    public LinkedList<Boolean> getHistoriqueType() {
        return historiqueType;
    }
}
