package comptes ;
/** La classe <code>CompteCourant</code> décrit le fonctionnement
 * d'un compte de retrait courant (celui par exemple sur lequel on
 * dispose d'une carte bleue). Elle dérive de <code>CompteGenerique</code>
 * donc la plupart des méthodes sont automatiquement héritées.
 */
public class CompteCourant extends CompteGenerique
{
    /** Constante facultative donnant le taux d'aggios pour les comptes récents */
    public static double AGGIOS1 = 0.1 ;
    /** Constante facultative donnant le taux d'aggios pour les comptes anciens */
    public static double AGGIOS2 = 0.06 ;
    /** Constante facultative donnant le nombre de mois à partir duquel un
     * compte est considéré comme ancien */
    public static int AGE_CHARNIERE = 60 ;

    /** Le niveau du découvert autorisé */
    protected double decouvert_autorise ;

    /** Constructeur permettant d'instancier un compte courant d'un
     * numéro spécifié, pour un certain découvert autorisé. */
    public CompteCourant(int numero, double decouvert_autorise) 
    { 
	// première étape : appeler le code du constructeur de CompteGenerique
	super(numero) ;
	// puis on stocke le paramètre dans l'attribut
	this.decouvert_autorise = decouvert_autorise ;
    }

    /** Tente d'effectuer un retrait de la somme spécifiée sur le compte.
     * Dans le cas présent il faut que le compte reste au-dessus de 
     * (-decouvert_autorise), ce qui revient à dire que la somme doit être
     * inférieure au montant + découvert. 
     */
    public void retirer(double somme) 
    {
	if (somme <= montant + decouvert_autorise)
	    montant = montant - somme ;
    }

    /** Méthode calculant les aggios en cas de découvert */
    protected double calculerAggios()
    {
	if (anciennete < AGE_CHARNIERE)
	    return AGGIOS1 * montant ;
	return AGGIOS2 * montant ;
    }

    /** Effectue les opérations mensuelles de maintenance du compte. Cette méthode est
     *  susceptible de déclencher des exceptions si des anomalies sont détectées. 
     *  Dans le cas d'un compte courant, il faut d'abord effectuer les opérations
     *  propres à tous les comptes (la méthode définie dans la superclasse), puis
     *  vérifier s'il y a des aggios à débiter, et enfin déclencher une exception si
     *  le montant du compte est passé en dessous (en négatif) du découvert autorisé. 
     */
    public void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc 
    {
	super.operationsMensuelles() ; // incrémente l'ancienneté
	if (montant < 0) // si le solde est négatif il faut payer des aggios
	    {
		double aggios = this.calculerAggios() ; // nombre négatif !
		System.out.println("Aggios débités ce mois : " + aggios) ;
		this.ajouter(aggios) ; // ajout car négatif ; il ne faut 
		// de toute façon pas utiliser retirer car cette méthode comporte
		// des conditions qui conduisent parfois à ne pas retirer les aggios
		if (Math.abs(montant) > decouvert_autorise)
		    throw new DepassementDecouvertExc(this.getNumero()) ;
	    }
    }
}
