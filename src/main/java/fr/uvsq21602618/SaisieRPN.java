package fr.uvsq21602618;

import java.util.Scanner;
/**
 * Classe qui gere les interactions avec l'utilisateur
 * et invoque le moteur RPN.
 * @author Nathalie
 *
 */
public class SaisieRPN {
    /**
     * Le moteur RPN de la calculatrice RPN.
     */
    private final MoteurRPN moteur;
    private Scanner scanner;
    private final Typing typing;
    private final Commande undo;
    private final Commande quit;
    private final Interpreteur interpreteur;
    /**
     * Le constructeur de la saisie.
     * @throws Exception
     */
    public SaisieRPN() throws Exception {
        this.moteur = new MoteurRPN();
        this.scanner = new Scanner(System.in);
        this.typing = new Typing();
        this.undo = new UndoCommand(typing);
        this.quit = new UndoCommand(typing);
        this.interpreteur = new Interpreteur();
        
        this.interpreteur.addCommande("undo", undo);
        this.interpreteur.addCommande("quit", quit);
    }
    /**
     * Traitement de la saisie.
     * @throws BinaireOpsException 
     * @throws DivisionParZeroException 
     * @throws PileVideException 
     */
    public void traitement() throws BinaireOpsException, DivisionParZeroException, PileVideException {
        
        while (!scanner.hasNext("quit")) {
            if (scanner.hasNextInt()) { 
                moteur.saveOperande(scanner.nextInt());
            /*} else if (scanner.hasNext("undo")) {
                this.interpreteur.executeCommand("undo");*/
            } else {
                String s;
                Operation op;
                s = scanner.next();
                if (!s.isEmpty()) {
                    op = moteur.conversion(s.charAt(0));
                    moteur.applyOperation(op);
                }else {
                    if (moteur.getList().size() > 0) {
                        moteur.AfficherOperandes();
                        System.out.println("resultat:" + moteur.getList().getFirst()); 
                    } 
                    else {
                        throw new PileVideException();
                    }
                }
            }
            moteur.AfficherOperandes();
        }
        
        this.interpreteur.executeCommand("quit");
        System.out.println("resultat:" + moteur.getList().getFirst());
    }
    /**
     * Méthode qui récupère le moteur.
     * @return le moteur RPN
     */
    public MoteurRPN getMoteur() {
        return moteur;
    }
    /**
     * Méthode qui récupère le scanner.
     * @return le moteur scanner
     */
    public Scanner getScanner() {
        return scanner;
    }
    /**
     * Méthode qui redéfinit le scanner.
     * @param scanner le scanner utilise
     */
    public void setScanner(final Scanner scan) {
        this.scanner = scan;
    }
    /**
     * Méthode pour récupérer le Typing
     * @return typing courant
     */
    public Typing getTyping() {
        return typing;
    }
}
