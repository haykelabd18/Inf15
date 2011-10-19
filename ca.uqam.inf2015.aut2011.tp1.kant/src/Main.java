/*
 *  COURS : INF2015 
 * GROUPE : 40
 * 
 *                     TRAVAIL PRATIQUE I 
 * 
 *   REMISE LE : 20 OCTOBRE 2011
 *           A : PASCAL CHOUINARD
 * 
 *         PAR : BENOIT FILIATREAULT (FILB06058201)
 *             : HAYKEL ABDENNADHER (ABDH06018400)
 *             : GABRIEL BEDARD (BEDG07027604)
 * 
 *      EQUIPE : KANT
 * 
 * TRASMIT VIA : Github
 * 
 */


// -------------------------------
//
//   IMPORTATION DES LIBRAIRIES
//
// -------------------------------

import java.math.BigDecimal;

/**
 * @author Gabriel Bedard      (GB)
 * @author Haykel Abdennadher  (HA)
 * @author Benoit Filiatreault (BF)
 * 
 * Dernieres modifications : GB
 * @version 1.76
 * @date 16 oct 2011 12h54
 * 
 */

public class Main {

    /**
     * Programme de calcul d'un amortissement d'une hypotheque
     * 
     * Ce programme calcule les periodes d'amortissements d'une hypotheque selon
     * l'investissement de depart, le nombre d'annees du pret, le taux d'interet 
     * ainsi que la frequence de composition des interets
     * 
     * Le format des fichiers d'entrees et de sorties est le format JSON
     * Ref. : http://www.json.org
     * Ce format texte est simple d'utilisation et tres portable sur differents
     * langages et plate-formes.
     * 
     **/
    
    /* -------------------------------------------------------------------------
     * Modifications apportees :
     *
     * VERSION 1.0 : 26 septembre 2011 @ 08h00
     *         PAR : Gabriel Bedard
     *               
     *               Construction du projet debut programmation du main
     *
     *
     * VERSION 1.5 : 7 octobre 2011 @ 21h34
     *         PAR : Haykel Abdennadher
     * 
     *               Modification de la validation des parametres
     *               Deplacement du message du Main pour les 2 parametres dans
     *               la classe validation
     * 
     * VERSION 1.6 : 13 octobre 2011 @ 10h48
     *         PAR : Benoit Filiatreault
     *       
     *               ajout de la classe Pret
     * 
     * VERSION 1.75 : 16 octobre 2011 @ 12h19
     *          PAR : Gabriel Bedard
     *  
     *                refactoring renommer classe Inf2015 en Main
     *                ajouts de commentaires
     *                Mise en place de la fin normale et anormale du programme
     *
     * VERSION 1.76 : 16 octobre 2011 @ 12h54
     *          PAR : Gabriel Bedard
     *  
     *                refactoring retrait du package inf2015r
     * 
       ------------------------------------------------------------------------- */
    

    /***************************************************************************
     * 
     * DEBUT DU PROGRAMME PRINCIPAL
     
     * Le main doit recevoir deux parametres en entree soit :
     * 
     * String : <cheminDesFichiersEntrants> : chemin des fichiers JSON a lire
     * String : <cheminDesFichiesExtrants>  : chemin des fichiers JSON a ecrire
     *                                        comme fichiers resultats
     *
     * @param args the command line arguments <cheminDesFichiersEntrants> <cheminDesFichiesExtrants>
     * 
     ***************************************************************************/

    public static void main(String[] args) {
      
        // ------------------------
        //
        //    VARIABLES LOCALES
        //
        // ------------------------
        String fichierEntree  = "";
        String fichierSortie  = "";
        
        boolean resultat = false;
        boolean parametreEntree = Validation.ValiderParametreEntree(args);
        
        if(parametreEntree == true) {

            //fichierEntree = args[0]; // a remettre lorsque la gestion des parametres sera terminee GB
            //fichierSortie = args[1];
            
            resultat = Traitement.traitementDesFichiers("/home/lha18/workspace2/ca.uqam.inf2015.aut2011.tp1.kant/src/inf2015/Fichiers/Entre/", "/home/lha18/workspace2/ca.uqam.inf2015.aut2011.tp1.kant/src/inf2015/Fichiers/Sortie/");
            
            System.out.println("FIN NORMALE DU PROGRAMME !");
            
        }
        else {
            
            System.out.println("===>>> ATTENTION - FIN ANORMALE DU PROGRAMME !!!");
        }
    }
}
