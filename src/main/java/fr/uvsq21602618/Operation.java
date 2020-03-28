package fr.uvsq21602618;
/**
 * Classe contenant les actions liees
 * aux calculs lors de la saisie d'un
 * operateur.
 * @author Nathalie
 *
 */
public enum Operation {
    /**
     * l'addition.
     */
    PLUS('+') {
        /**
         * Obtenir la somme de deux nombres.
         * @param ope1 Le premier nombre
         * @param ope2 Le deuxieme nombre
         * @return La valeur de la somme des deux nombres specifies.
         */
        @Override
        public int eval(final int ope1, final int ope2) {
            int res = ope1 + ope2;
            return res;
        }
    },
    /**
     * La soustraction.
     */
    MOINS('-') {
        /**
         *Obtenir la soustraction de deux nombres.
         *@param ope1 Le premier nombre.
         *@param ope2 Le deuxieme nombre.
         *@return La valeur de la soustraction des deux nombres specifies.
         */
        @Override
        public int eval(final int ope1, final int ope2) {
            int res = ope1 - ope2;
            return res;
        }
    },
    /**
     * La multiplication.
     */
    MULTI('*') {
        /**
         *Obtenir la multiplication de deux nombres.
         *@param ope1 Le premier nombre.
         *@param ope2 Le deuxieme nombre.
         *@return La valeur de la multiplication des deux nombres specifies.
         */
        @Override
        public int eval(final int ope1, final int ope2) {
            int res = ope1 * ope2;
            return res;
        }
    },
    /**
     * La division.
     */
    DIV('/') {
        /**
         *Obtenir la division de deux nombres.
         *@param ope1 Le premier nombre.
         *@param ope2 Le deuxieme nombre.
         *@return La valeur de la division des deux nombres specifies.
         */
        @Override
        public int eval(final int ope1, final int ope2)
                throws DivisionParZeroException {
            if (ope2 == 0) {
                throw new DivisionParZeroException();
            }
            int res = ope1 / ope2;
            return res;
        }
    };
    /**
     * L'opérateur.
     */
    private char symbole;

    /**
     * Mettre dans la variable symbole l'operateur en argument.
     *@param symb L'operateur.
     */
    Operation(final char symb) {
        this.setSymbole(symb);
    }
    /**
     * Méthode pour réaliser une opération entre 2 entiers.
     * @param ope1 premier entier
     * @param ope2 deuxieme entier
     * @return le resultat
     * @throws DivisionParZeroException Si on
     * a une division par zero
     */
    public abstract int eval(int ope1, int ope2)
            throws DivisionParZeroException;
    /**
     * Méthode pour récupérer l'opérateur.
     * @return l'opérateur
     */
    public char getSymbole() {
        return symbole;
    }
    /**
     * Méthode pour définir le symbole.
     * @param sbl l'opérateur
     */
    public void setSymbole(final char sbl) {
        this.symbole = sbl;
    }
}
