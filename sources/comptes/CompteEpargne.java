package comptes;

public class CompteEpargne extends CompteGenerique {
    private double tauxInteret;

    public CompteEpargne (double montant){
	super(montant);
    }

    public void retirer(double somme){
	if (getMontant() - somme < 0)
	    break;
	else
	    super.retirer(somme);
    }

    public void operationsMensuel() {
	anciennete++;
	double interet = tauxInteret*montant;
	System.out.println("Calcul interet = "+interet);
        ajouter(interet);
    }

    public String toString() {
	return super.toString() + " Taux d'interet : " +tauxInteret;
    }
}
