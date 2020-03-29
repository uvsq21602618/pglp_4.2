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
    /**
     * Le scanner pour la console.
     */
    private Scanner scanner;
    /**
     * Le type de saisie.
     */
    private final Typing typing;
    /**
     * La commande undo.
     */
    private final Commande undo;
    /**
     * La commande quit.
     */
    private final Commande quit;
    /**
     * Historique contenant les saisies de nombres (true)
     * ou de d'operateurs (false).
     * @throws Exception liée a la calculatrice
     */
    public SaisieRPN() throws Exception {
        this.moteur = new MoteurRPN();
        this.scanner = new Scanner(System.in);
        this.typing = new Typing();
        this.undo = new UndoCommand(typing, this.moteur);
        this.quit = new QuitCommand(typing);

        this.moteur.addCommande("undo", undo);
        this.moteur.addCommande("quit", quit);
    }
    /**
     * Traitement de la saisie.
     * Si on saisie 'undo', on annule la saisie précédente.
     * Si on saisie 'quit', on termine le programme.
     * @throws BinaireOpsException Si la saisie n'est
     * pas correcte
     * @throws DivisionParZeroException si on divise par zero
     * @throws PileVideException si la pile est vide
     */
    public void traitement()
            throws BinaireOpsException, DivisionParZeroException,
            PileVideException {
        while (!scanner.hasNext("quit") && scanner.hasNext()) {
            String s;
            if (scanner.hasNextInt()) {
                moteur.getHistoriqueType().add(true);
                moteur.saveOperande(scanner.nextInt());
            } else if (scanner.hasNext("undo")) {
                s = scanner.next();
                this.moteur.executeCommand("undo");
            } else {
                Operation op;
                s = scanner.next();
                if (!s.isEmpty()) {
                    moteur.getHistoriqueType().add(false);
                    op = moteur.conversion(s.charAt(0));
                    moteur.applyOperation(op);
                }
            }
            moteur.afficherOperandes();
        }
        if (scanner.hasNext("quit")) {
            this.moteur.executeCommand("quit");
            } else if (!moteur.pileIsEmpty()) {
            System.out.println("resultat:" + moteur.getPileFirstInt());
        }
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
     * @param scan le scanner utilise
     */
    public void setScanner(final Scanner scan) {
        this.scanner = scan;
    }
    /**
     * Méthode pour récupérer le Typing.
     * @return typing courant
     */
    public Typing getTyping() {
        return typing;
    }
}
