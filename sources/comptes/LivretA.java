package comptes;

public class LivretA extends CompteEpargne {
    private static final double TAUXINTERET = 0.02;
    
    public LivretA() {
	super(TAUXINTERET);
    }
}
