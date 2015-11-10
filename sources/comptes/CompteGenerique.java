package comptes;
import java.util.Date;

public abstract class CompteGenerique implements Compte {
    private int numCompte,anciennete;
    private double montant;
    private static num=0;

    public CompteGenerique (){
	this.numCompte=num;
	num++;
	anciennete=0;
	montant=0;
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

    public int getMontant() {
	return montant;
    }

    public int getAnciennete() {
	return anciennete;
    }

    public String toString() {
	return "Numéro de compte : "+numCompte+" Montant : "+montant;
    }
    
    public abstract void operationsMensuel() throws DepassementDecouvertExc, VersementsInsuffisantsExc {}

}
