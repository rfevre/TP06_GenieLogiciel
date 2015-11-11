package comptes;
import java.util.Date;

public abstract class CompteGenerique implements Compte {
    private int numCompte;
    protected int anciennete;
    private double montant;
    private static int num = 0;

    public CompteGenerique (double montant){
	this.numCompte=num;
	num++;
	anciennete=0;
	montant=montant;
    }

    public void ajouter(double somme){
	montant += somme;
    }

    public void retirer(double somme){
	montant -= somme;
    }

    public int getNumero() {
	return numCompte;
    }

    public double getMontant() {
	return montant;
    }

    public int getAnciennete() {
	return anciennete;
    }

    public String toString() {
	return "Numéro de compte : "+numCompte+" Montant : "+montant;
    }
    
    abstract void operationsMensuel() throws DepassementDecouvertExc, VersementsInsuffisantsExc;

}
