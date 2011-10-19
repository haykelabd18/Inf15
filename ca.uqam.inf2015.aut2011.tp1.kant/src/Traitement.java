/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

// -------------------------------
//
//   IMPORTATION DES LIBRAIRIES
//
// -------------------------------
import java.util.ArrayList;


/**
 *
 * @author Gabriel Bedard (GB)
 * @version 1.0
 * @date 16 octobre 2011 @ 13h28
 * 
 */

public class Traitement {
    public static boolean traitementDesFichiers(String fichierEntree, String fichierSortie) {

        // ------------------------
        //
        //    VARIABLES LOCALES
        //
        // ------------------------
        ArrayList<Object> listeFichier = new ArrayList<Object>();
                
        Pret pret;

        listeFichier = EntreeSortie.ListeDesFichiersDansRepertoire("/home/lha18/workspace2/ca.uqam.inf2015.aut2011.tp1.kant/src/inf2015/Fichiers/Entre/", "json");
        
        for(int i = 0; i < listeFichier.size(); i++) {

            fichierEntree += listeFichier.get(i);
            fichierSortie += listeFichier.get(i);

            pret = EntreeSortie.LireFichierJSon(fichierEntree);
            System.out.println(pret.toString());
            // listeAmortissement retournera une liste de node a ajouter dans objetJSon
                
            Calcul.listeArmortissement(fichierSortie,pret);

            
        }
        
        return true;
    }

}
