package comptes ;
/** La classe <code>CompteGenerique</code> regroupe les attributs et 
 * fonctionnalités communs à toutes les sortes de comptes bancaires. Elle 
 * implémente l'interface Compte qui exige la présence de certaines 
 * fonctionnalités. Cette classe est abstraite pour deux raisons :
 * <UL><LI>Un Compte générique n'a pas d'existence propre, il ne doit pas
 * être instanciéw</LI>
 * <LI>La méthode <code>retirer</code> est abstraite (car les conditions
 * de retrait sont très variables d'un compte à un autre).</LI></UL>
 */
public abstract class CompteGenerique implements Compte
{
    /** Le montant de l'argent disponible sur le compte. */
    protected double montant ;
    /** Le numéro du compte, qui l'identifie. */
    protected int numero ;
    /** L'ancienneté du compte, en nombre de mois écoulés depuis
     * l'ouverture (depuis l'instanciation). */
    protected int anciennete ;
    
    /** Crée un compte de numéro spécifié. Même dans une classe abstraite,
     * il faut prévoir des constructeurs qui seront appelés lors de 
     * l'instanciation de sous-classes concrètes. Ces constructeurs doivent
     * initialiser les attributs de la classe. */
    public CompteGenerique(int numero) 
    { 
	this.numero = numero ;
	montant = 0 ;
	anciennete = 0 ;
    }

    /** Retourne le numéro identifiant le compte */
    public     int getNumero() { return numero ; }

    /** Retourne le nombre de mois écoulés depuis l'ouverture */
    public int getAnciennete() { return anciennete ; }

    /** Retourne le numéro du compte et le montant */
    public String toString()
    {
	return "Compte n° " + numero + "\t" + montant + " euros" ;
    }

    /** Effectue un ajout de la somme spécifiée sur le compte */
    public void ajouter(double somme)
    {
	montant = montant + somme ;
    }

    /** Tente d'effectuer un retrait de la somme spécifiée sur le compte.
     * L'implémentation dépend de la nature du compte, cette méthode est
     * donc abstraite ! 
     * <P>Une alternative consisterait à dire qu'il existe une méthode abstraite
     * <code>protected abstract boolean conditionRetrait(double somme)</code> et écrire
     * alors la méthode <code>retirer</code> comme suit :
     * <P><code>
     * public void retirer(double somme) 
     * {
     *    if (this.conditionRetrait(somme))
     *       { montant = montant - somme ; }
     * }
     *</code>
     *<BR>et redéfinir <code>conditionRetrait</code> dans chaque sous-classe.
     */    
    public abstract void retirer(double somme) ;

    /** Effectue les opérations mensuelles de maintenance du compte. Cette méthode est
     *  susceptible de déclencher des exceptions si des anomalies sont détectées. 
     *  Dans le cas du compte générique, il faut mettre à jour les attributs
     *  qui sont sujets à des variations mensulles : en l'occurrence, l'ancienneté
     *  du compte. */
    public void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc 
    {
	anciennete++ ;
    }
}
