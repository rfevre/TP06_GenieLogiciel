package comptes;

public class PEL extends CompteEpargne {
    private double versement;
    
    public PEL(double montant) {
	super(montant);
	super.tauxInteret=0.05;
	versement=0;
    }

    public void retirer(double somme){
	if (getAnciennete() < 48)
	    break;
	else
	    super.retirer(somme);
    }

    public void ajouter(double somme){
	versement += somme;
	super.ajouter(somme);
    }

    public void operationsMensuel() throws VersementsInsuffisantsExc {
	if (versement < 50) {
	    throw new VersementsInsuffisantsExc();
	}
	else {
	    super.operationsMensuel();
	}
	versement=0;
    }
}
