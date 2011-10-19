/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


// -------------------------------
//
//   IMPORTATION DES LIBRAIRIES
//
// -------------------------------

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;

import com.google.gson.Gson;

/**
 *
 * @author Gabriel Bedard
 * @version 1.0
 * 
 */
public class EntreeSortie {
    
    /* -------------------------------------------------------------------------
     * methode   : NombreDeFichierDansRepertoire
     * 
     * Entree(s) : String : repertoire = nom du repertoire d'entree
     *                                   fournit comme premier parametre
     *                                   d'entree par l'utilisateur
     *             String : extension  = nom de l'extension des fichiers a
     *                                   retenir dans le calcul des fichiers
     *                                   du repertoire 
     *             Exemple : .json     : il considerera uniquement les 
     *                                   fichier ayant l'extension .json      
     * 
     * Sortie    : ArrayList<Object>   : la liste des fichiers dans le repertoire
     *                                   qui ont l'extension fournit dans les
     *                                   entrees.
     * 
     * Portee    : public static
     * 
       ---------------------------------------------------------------------- */
    public static ArrayList<Object> ListeDesFichiersDansRepertoire(String repertoire, String extension) {
 
        String fichier;
        String nomFichier = "";
        String ext = "";
        
        int i = 0;
        
        ArrayList<Object> listeFichier = new ArrayList<Object>();
        
        File folder = new File(repertoire);
        File[] listOfFiles = folder.listFiles(); 

        System.out.println("NombreDeFichierDansRepertoire : Repertoire a observer : " + repertoire); 
        System.out.println("NombreDeFichierDansRepertoire : Extension a conserver : " + extension);
        
        for (i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                
                fichier = listOfFiles[i].getName();

                int point = fichier.lastIndexOf(".");
                
                nomFichier = fichier.substring(0, point);
                ext = fichier.substring(point + 1, fichier.length());  
                
                System.out.println("NombreDeFichierDansRepertoire : nomFichier = " + nomFichier);
                System.out.println("NombreDeFichierDansRepertoire : ext        = " + ext);
                
                if(ext.toUpperCase().equals(extension.toUpperCase())) {
                    System.out.println("NombreDeFichierDansRepertoire : Fichier : " + fichier + "[ OK! ]");
                    listeFichier.add(nomFichier + "." + ext);
                }
            }
        }
        
        return listeFichier;
    }

    /* -------------------------------------------------------------------------
     * methode   : LireFichierJSon
     * 
     * Entree(s) : String : fichier    = le nom du fichier JSon a lire
     * 
     * Sortie    : pret           : un objet JSon converti en objet Java.
     * 
     * Portee    : public static
     * 
       ---------------------------------------------------------------------- */
    public static Pret LireFichierJSon(String fichier) { //BF J'ai optimisé & formaté
        
        Pret pret = new Pret();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichier)); // BF
            pret = new Gson().fromJson(br, Pret.class); // BF
        } 
        catch (IOException e) {
	    e.printStackTrace();
        }
        
        return pret;
    }
    
    
    /* -------------------------------------------------------------------------
     * methode   : EcrireFichierJSon
     * 
     * Entree(s) : String : fichier    = le nom du fichier JSon a ecrire
     * 
     *             Pret : pret   = un objet java qui sera converti en
     *                                   objet au format JSon avant son ecriture
     *                                   dans le fichier
     * 
     * Sortie    : void      
     * 
     * Portee    : public static
     * 
       ---------------------------------------------------------------------- */
    public static void EcrireFichierJSon(String fichier, Object objet) { //BF J'ai optimisé & formaté
        
        String json = new Gson().toJson(objet); //BF
 
        System.out.println("EcrireFichierJSon : fichier de sortie = " + fichier);
        
	try {
		FileWriter writer = new FileWriter(fichier);
		writer.write(json);
		writer.close();
 	} 
        catch (IOException e) {
		e.printStackTrace();
	}
 
	System.out.println(json);
    }
    
    
}
