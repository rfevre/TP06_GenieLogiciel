package comptes ;
/** La classe <code>LivretA</code> décrit le fonctionnement d'un compte 
 * d'épargne particulier, le livret A, sur lequel les intérêts sont 
 * relativement minces mais où l'on peut ajouter et retirer à volonté 
 * (pourvu que le solde reste positif). Cette classe dérive de 
 * <code>CompteEpargne</code> et toutes les méthodes sont héritées
 * (il n'y a pas de fonctionnalité particulière, seul la valeur du taux
 * d'intérêt doit être initialisée correctement).
 */
public class LivretA extends CompteEpargne
{
    /** Constante facultative donnant la valeur du taux d'intérêt d'un 
     * livret A. Cette constante doit bien sûr avoir un autre nom que 
     * l'attribut <code>taux</code> de la superclasse. */
    public static final double TAUX_LIVRET_A = 0.02 ;

    /** Constructeur permettant de créer une instance de Livret A. Il suffit
     * pour cela d'en spécifier le numéro, puisque le taux d'intérêt est fixé. */
    public LivretA(int numero)
    {
	super(numero, TAUX_LIVRET_A) ;   
    }
}
