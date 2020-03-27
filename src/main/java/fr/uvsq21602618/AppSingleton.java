package fr.uvsq21602618;
/**
 * Singleton contenant le main.
 * @author Nathalie
 */
public enum AppSingleton {
    /**
     * L'enum qui contient le code du main.
     */
    ENVIRONNEMENT;
    /**
     * Execution du programme.
     */
    public void run() {
        Typing typing = new Typing();
        
        Commande undo = new UndoCommand(typing);
        Commande quit = new QuitCommand(typing);
        
        Interpreteur interpreteur = new Interpreteur();
        interpreteur.addCommande("undo", undo);
        interpreteur.addCommande("quit", quit);
        
        interpreteur.executeCommand("undo");
        interpreteur.executeCommand("quit");

    }
    /**
     * Main.
     */
    public static void main() {
        ENVIRONNEMENT.run();
    }

}
