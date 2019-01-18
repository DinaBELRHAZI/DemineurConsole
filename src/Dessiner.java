

import java.util.Random;

public class Dessiner {
	
	
	
	static void initgrille(int mines) {
		  
		  Random random = new Random();
		  
		  System.out.println("\t  #----------------------#");
		  System.out.println("\t  |      Démineur        |");
		  System.out.println("\t  #----------------------#");
		  
//		    Nombres de cases sans mines
		    DemTest.CaseBlanche = DemTest.l * DemTest.h - mines;

//		    Tant qu'il y a des mines
		    while(mines != 0)
		    {
//		    	emplacement aléatoire des mines
		      int lx = random.nextInt(DemTest.l);
		      int hy = random.nextInt(DemTest.h);

		      if(Verif.Mines(lx, hy)) continue;
		      
//		      case contenant une mine à une valeur de -1
		      DemTest.grille[lx][hy] = -1;

//		      Découvre les cases sans mine
		      for(int l= -1; l < 2; l++)
		      {
		        for(int h = -1; h < 2; h++)
		        {
		          if(Verif.PasDebordement(lx+l, hy+h) && !Verif.Mines(lx+l, hy+h))
		        	  DemTest.grille[lx+l][hy+h]++;
		        }
		      }
//		      décrémente le nombre de mines
		      mines--;
		    }
		  }
	
	
	static void Design() {

	    StringBuffer buffer = new StringBuffer();
   
	    
	    for(int h = -1; h < DemTest.h; h++) {
	    	buffer.append("").append(" |").append(h == -1 ? " " : h+1).append("| ");
		
		      for(int l = 0; l < DemTest.l ; l++) {
		    	  buffer.append("").append(" | ").append(h==-1 ? l+1
		        	: Verif.Drapeau(l, h) ? "O"
		        	: Verif.RetounerM(l, h) ? Verif.Mines(l, h) ? "¤"
		        	: DemTest.grille[l][h] == 10 ? " "
		        	: DemTest.grille[l][h] - 10
		        	: ("X")).append(" | ");
		      }
		      buffer.append("\n");
	    }
	    System.out.println(buffer.toString());
	  }



	  static void Retourner(int x, int y) {

	    if(!Verif.Drapeau(x, y) && Verif.Mines(x, y)) {
	    	DemTest.CaseBlanche = -1;
		      for(int lx = 0; lx < DemTest.l; lx++) {
		    	  for(int hy = 0; hy < DemTest.h; hy++) {
		    		  if(Verif.Mines(lx, hy))
		    			  DemTest.grille[lx][hy] = 9;
		    	  }
		      }
	    } else if(!Verif.PasDebordement(x, y) || Verif.RetounerM(x, y) || Verif.Drapeau(x, y)) return;

			    DemTest.grille[x][y] += 10;
			    DemTest.CaseBlanche--;
			
			    if(DemTest.grille[x][y] > 10) return;
			
			    Retourner(x-1, y);
			    Retourner(x+1, y);
			    Retourner(x, y-1);
			    Retourner(x, y+1);

	  }

}
