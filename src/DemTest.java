

import java.util.*;


public class DemTest {

	
  static int grille [][] ;
  static int  l, h;
  static int CaseBlanche;

  
  public DemTest(int l, int h, int mines){
	
	  DemTest.l = l;
	  DemTest.h = h;

//génère case
    grille = new int[l][h];
       
    Dessiner.initgrille(mines);
  }


  void Jouer() {

    Scanner sc = new Scanner(System.in);
    
    while(CaseBlanche > 0) {
    	// boucle de jeu
    	Dessiner.Design();

      System.out.print("Saisir coordonnées(l,h) : ");
      String[] line = sc.nextLine().split(" ");

      try{

         int l = Integer.parseInt(line[0]) - 1;
         int h = Integer.parseInt(line[1]) - 1;
//        Il y a trois valeurs max écrites par l'utilisateur
        boolean flag = line.length > 2;

        if(flag) 
        	Verif.setDrapeau(l, h);
        else 
        	Dessiner.Retourner(l, h);

      }catch(Exception e){
    	  System.out.println("Les coordonées saisis ne sont pas acceptées ! ");
      }

    }

    Dessiner.Design();
    System.out.println(CaseBlanche == 0 ? "GAGNE" : "PERDU");
    sc.close();
  }


}