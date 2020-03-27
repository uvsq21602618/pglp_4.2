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
    public LinkedList<Integer> pile;
    /**
     * Constructeur du moteur.
     */
    public MoteurRPN() {
        pile=new LinkedList<Integer>();
    }
    /**
    Mettre l'opérande sur la pile.
    @param op L'opérande.
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
        int res = 0;
        switch (op) 
        {
            case PLUS:
                res = op.eval(pile.get(pile.size()-2),pile.get(pile.size()-1));
                //System.out.print(ope1+"+"+ope2+"\n");
            break;
            
            case MOINS:
                res = op.eval(pile.get(pile.size()-2),pile.get(pile.size()-1));
                //System.out.print(ope1+"-"+ope2+"\n");
            break;
            
            case MULTI:
                res = op.eval(pile.get(pile.size()-2),pile.get(pile.size()-1));
                //System.out.print(ope1+"*"+ope2+"\n");
            break;
            
            case DIV:
                res = op.eval(pile.get(pile.size()-2),pile.get(pile.size()-1));
                //System.out.print(ope1+"/"+ope2+"\n");
            break;
        
        }
        
        pile.removeLast(); 
        pile.removeLast();
        this.saveOperande(res);
        
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
    Récupérer la liste.
    */
    public LinkedList<Integer> getList()
    {
        return pile;
    }
}
