

public class Verif {
	// Evite le débordement au-delà de la grille en validant ou non
	  static boolean PasDebordement(int x, int y) {
	   return (x >= 0 && y >=0 && x < DemTest.l && y < DemTest.h ? true : false);	
	  }
	  
	  
	// Présence de mines
	  static boolean Mines(int x, int y) {
//		  Si pas de débordement , case est une bombe ou bombe découverte ou bombe repérée
	    return ((Verif.PasDebordement(x, y) && (DemTest.grille[x][y] == -1 || DemTest.grille[x][y] == 9 || DemTest.grille[x][y] == 19)) ? true : false);
	    
	  }
	  
	// Il y a un drapeau
	  static boolean Drapeau(int x,int y){
		  return Verif.PasDebordement(x, y) && DemTest.grille[x][y] > 18;
	  }
	  
	  static void setDrapeau(int x, int y) {
		  
		//si case en dehors de la grille ou déja retournée on retourne la méthode
		    if(!Verif.PasDebordement(x, y) || Verif.RetounerM(x, y)) return;
		 // Met un drapeau ou l'enlève
		    DemTest.grille[x][y] += Verif.Drapeau(x, y) ? -20 : 20;
		  }
	  
	  
	//Case ouverte soit :
	//  - case retournée
	//  - case contenant une bombe repérer avec le drapeau
	//  - case ouverte contenant une mine
	  static boolean RetounerM(int x, int y) {
		  return Verif.PasDebordement(x, y) && DemTest.grille[x][y] > 8 && DemTest.grille[x][y] < 19;
	  }
}
