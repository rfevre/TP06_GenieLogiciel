package comptes;

public class LivretA extends CompteEpargne {
    
    public LivretA(double montant) {
	super(montant);
	super.tauxInteret=0.02;
    }
}
