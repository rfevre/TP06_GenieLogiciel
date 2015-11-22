package comptes ;
/** La classe <code>PEL</code> décrit le fonctionnement d'un compte 
 * d'épargne particulier, le PEL (plan d'épargne-logement), sur lequel
 * les intérêts sont assez élevés. En contrepartie l'argent est bloqué
 * 4 ans (pas de retrait possible) et un versement minimum est nécessaire
 * chaque mois. Cette classe dérive de <code>CompteEpargne</code> ; certaines
 * méthodes de la superclasse ou de <code>CompteGenerique</code> doivent
 * être redéfinies car elles ajoutent des fonctionnalités.
 */
public class PEL extends CompteEpargne
{

    /** Constante facultative donnant la valeur du taux d'intérêt d'un PEL.
     * Cette constante doit bien sûr avoir un autre nom que l'attribut 
     * <code>taux</code> de la superclasse. */
    public static final double TAUX_PEL = 0.05 ;

    /** Constante facultative donnant la durée pendant laquelle aucun retrait
     * n'est possible (en nombre de mois). */
    public static final int DUREE_BLOCAGE = 48 ;
    /** Constante facultative donnant le montant minimum qui doit être versé
     * chaque mois sur le PEL. */
    public static final double MINIMUM_MENSUEL = 50.0 ;

    /** Montant du versement mensuel. Chaque mois, cet attribut est remis à zéro,
     * et on l'incrémente à chaque ajout d'argent sur le compte. */
    protected double versement_mensuel ;

    /** Constructeur permettant de créer une instance de PEL. Il suffit pour cela
     * d'en spécifier le numéro, puisque le taux d'intérêt est fixé. */
    public PEL(int numero)
    {
	super(numero, TAUX_PEL) ;   
	versement_mensuel = 0 ;
    }

    /** Effectue un ajout de la somme spécifiée sur le compte. La somme
     * ajoutée est mémorisée dans l'attribut <code>versement_mensuel</code>
     * de façon à pouvoir effectuer les vérifications à la fin du mois. */
    public void ajouter(double somme)
    {
	super.ajouter(somme) ; // on se sert du code déjà écrit bien sûr !
	versement_mensuel = versement_mensuel + somme ;
    }

    /** Tente d'effectuer un retrait de la somme spécifiée sur le compte.
     * Dans le cas présent, le retrait s'effectue comme pour tout compte
     * d'épargne, <B>à condition que la période de blocage du compte soit terminée</B>.
     */
    public void retirer(double somme)
    {
	if (anciennete >= DUREE_BLOCAGE)
	    super.retirer(somme) ; // code de la superclasse
    }

    /** Effectue les opérations mensuelles de maintenance du compte. Cette méthode est
     *  susceptible de déclencher des exceptions si des anomalies sont détectées. 
     *  Dans le cas d'un PEL, il faut d'abord effectuer les opérations propres à tous
     *  les comptes d'épargne (la méthode définie dans la superclasse), puis
     *  vérifier que les versements du mois sont suffisants.
     */
    public void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc 
    {
	super.operationsMensuelles() ; // incrémente l'ancienneté, capitalise les intérêts
	if (versement_mensuel < MINIMUM_MENSUEL)
	    throw new VersementsInsuffisantsExc(this.getNumero()) ;
	versement_mensuel = 0 ; // ne pas oublier de remettre à zéro !
    }    
}
