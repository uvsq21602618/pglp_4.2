package fr.uvsq21602618;

import java.util.LinkedList;
/**
 * Classe MoteurRPN qui dérive de la classe Interpeteur.
 * @author Nathalie
 *
 */
public class MoteurRPN extends Interpreteur{
    /**
     * Pile contenant les opérandes saisies.
     */
    private LinkedList<Integer> pile;
    /**
     * La premiere operande de la liste.
     */
    private int operande1;
    /**
     * La deuxieme operande de la liste.
     */
    private int operande2;
    /**
     * Constructeur du moteur.
     */
    public MoteurRPN() {
        pile = new LinkedList<Integer>();
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
    @param symbole operateur.
    */
    private void OperandeBinaire(final Operation op)throws BinaireOpsException {
        if(pile.size()-1 < 0 || pile.size()-2 < 0 ||
                (op != Operation.PLUS && op != Operation.MOINS &&
                op != Operation.MULTI && op != Operation.DIV))
            throw new BinaireOpsException();
    }
    /**
    Applique l'operation en fonction de l'operateur.
    @param symbole operateur.
    */
    public void applyOperation(final Operation op) throws BinaireOpsException,
    DivisionParZeroException {
        OperandeBinaire(op);
        setOperande1(pile.get(pile.size() - 2));
        setOperande2(pile.get(pile.size() - 1));
        int res = 0;
        switch (op) 
        {
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
        
        }
        
        pile.removeLast(); 
        pile.removeLast();
        this.saveOperande(res); 
    }
    /**
     * Retire le premier element de la pile.
     * Remet à jour les operandes 1 et 2.
     */
    public void removeFirstPile() {
        if (pile.size() > 0) {
            this.pile.removeLast();
        }
    }
    /**
     * Annule le resultat de l'evaluation.
     */
    public void cancelEval() {
        this.pile.removeLast();
        this.pile.add(operande1);
        this.pile.add(operande2);
        setOperande1(pile.get(pile.size()-2));
        setOperande2(pile.get(pile.size()-1));
    }
    /**
    Afficher les operations dans la pile.
    */
    public void AfficherOperandes() {
        System.out.print("Affichage Pile : [");
        for (Integer d : pile)
        {
            System.out.print(d + "=>");
        }
        
        System.out.print("] \n"); 
    }
    /**
     * Convertir le caractere en operande.
     * @param symbole l'opérande
     * @return Operation
     * @throws BinaireOpsException
     */
    public Operation conversion(final char symbole) throws BinaireOpsException {
        switch(symbole) {
            case '+':
                return Operation.PLUS;
            
            case '-':
                return Operation.MOINS;
            
            case '/':
                return Operation.DIV;
            
            case '*':
                return Operation.MULTI;
        }
        throw new BinaireOpsException(); 
    }
    
    public void retirerSaisie() {
        this.pile.removeFirst();
    }
    /**
    Recuperer la liste.
    */
    public LinkedList<Integer> getList()
    {
        return pile;
    }
    /**
     * Méthode pour recuperer la premiere operande.
     * @return operande1
     */
    public int getOperande1() {
        return operande1;
    }
    /**
     * Méthode pour redefinir la premiere operande.
     */
    public void setOperande1(final int ope1) {
        this.operande1 = ope1;
    }
    /**
     * Méthode pour recuperer la deuxieme operande.
     * @return operande1
     */
    public int getOperande2() {
        return operande2;
    }
    /**
     * Méthode pour redefinir la deuxieme operande.
     */
    public void setOperande2(final int ope2) {
        this.operande2 = ope2;
    }
}
