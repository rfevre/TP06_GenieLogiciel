package comptes ;
public class Banque 
{
    public static void main(String [] arg) throws Exception
    {
	Compte [] c = new Compte[5] ;
	c[0] = new CompteCourant(1111, 50) ;
	c[1] = new CompteCourant(1112, 100) ;
	c[2] = new LivretA(5555) ;
	c[3] = new PEL(9999) ;
	c[4] = new PEL(9998) ;

	for (int i=0; i<c.length; i++)
	    { 
		c[i].ajouter(20+(int)(Math.random()*100)) ;
		System.out.println(c[i]) ;
		//		c[i].operationsMensuelles() ;
		System.out.println(c[i]) ;
	    }
	
	for (int i=0; i<c.length; i++)
	    { 
		c[i].retirer(20+(int)(Math.random()*100)) ;
		System.out.println(c[i]) ;
		c[i].operationsMensuelles() ;
		System.out.println(c[i]) ;
	    }
	
    }
}