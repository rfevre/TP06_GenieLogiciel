package comptes ;
/** La classe <code>CompteEpargne</code> décrit le fonctionnement
 * d'un compte d'épargne quel qu'il soit (PEL, PEA, Livret A, Codevi...),
 * c'est-à-dire un compte qui rapporte mensuellement des intérêts. En 
 * contrepartie, le solde doit rester positif. Cette classe dérive de 
 * <code>CompteGenerique</code> donc la plupart des méthodes sont automatiquement 
 * héritées. Elle est <B>abstraite</B> car, bien que toutes ses méthodes soient 
 * concrètes, en créer des instances n'aurait pas de sens : un "Compte d'Epargne"
 * en tant que tel n'existe pas, il n'existe que des livrets A, des PEL, etc.
 */
public abstract class CompteEpargne extends CompteGenerique 
{
    /** Le taux d'intérêt de l'épargne */
    protected double taux ;

    /** Constructeur permettant d'initialiser les attributs d'un compte
     * d'épargne avec le numéro spécifié, pour un certain taux d'intérêt. */
    public CompteEpargne(int numero, double taux)
    {
	super(numero) ;   
	this.taux = taux ;
    }

    /** Méthode calculant les intérêts du mois */
    protected double calculerInterets()
    {
	return montant * taux ;
    }

    /** Tente d'effectuer un retrait de la somme spécifiée sur le compte.
     * Dans le cas présent il faut que le solde du compte reste positif.
     */
    public void retirer(double somme)
    {
	if (somme <= montant)
	    montant = montant - somme ;
    }

    /** Effectue les opérations mensuelles de maintenance du compte. Cette méthode est
     *  susceptible de déclencher des exceptions si des anomalies sont détectées. 
     *  Dans le cas d'un compte d'épargne, il faut d'abord effectuer les opérations
     *  propres à tous les comptes (la méthode définie dans la superclasse), puis
     *  capitaliser les intérêts (i.e. les ajouter au montant).
     */
    public void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc 
    {
	double interets ;
	super.operationsMensuelles() ;
	interets = this.calculerInterets() ;
	System.out.println("Intérêts du compte n° "+ numero + " = " + interets) ;
	this.ajouter(interets) ;
    }    
}

