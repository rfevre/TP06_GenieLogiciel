package comptes;

public class CompteCourant extends CompteGenerique {
    private double decouvert=0;
    private double aggios=0;

    public CompteCourant (double montant,double decouvert){
	super(montant);
	this.decouvert=decouvert;
    }

    public void retirer(double somme){
	if (getMontant() + somme < getMontant()+decouvert)
	    super.retirer(somme);
    }

    public void operationsMensuel() throws DepassementDecouvertExc{
	anciennete++;
	if (getMontant() < 0) {
	    if (getAnciennete() < 60)
		aggios=0.1;
	    else
		aggios=0.06;
	    double montantAggios = Math.abs(getMontant()) * aggios; 
	    System.out.println("Montant Aggios = "+montantAggios);
	    super.retirer(montantAggios);
	}
	if (getMontant() < -(decouvert)) {
	    throw new DepassementDecouvertExc((int)decouvert);
	}
    }

    public String toString() {
	return super.toString() + " Decouvert autorisé : " +decouvert;
    }
}
