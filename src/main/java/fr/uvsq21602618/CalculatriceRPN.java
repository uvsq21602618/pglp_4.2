package fr.uvsq21602618;
/**
 * Singleton contenant le main.
 * @author Nathalie
 */
public enum CalculatriceRPN {
    /**
     * L'enum qui contient le code du main.
     */
    ENVIRONNEMENT;
    /**
     * Execution du programme.
     * @throws Exception 
     */
    public void run() throws Exception {
        /*Typing typing = new Typing();
        
        Commande undo = new UndoCommand(typing);
        Commande quit = new QuitCommand(typing);
        
        Interpreteur interpreteur = new Interpreteur();
        interpreteur.addCommande("undo", undo);
        interpreteur.addCommande("quit", quit);
        
        interpreteur.executeCommand("undo");
        interpreteur.executeCommand("quit");*/
        try{
            SaisieRPN saisie= new SaisieRPN();
            saisie.traitement();
        }catch(ExceptionPile e ) { 
            System.out.println(e.getMessage());
        }
        

    }
    /**
     * Main.
     * @throws Exception 
     */
    public static void main(String args[]) throws Exception {
        ENVIRONNEMENT.run();
    }

}
