/*
 * CLASSE : Validation
 * 
 *          cette classe possede des methodes qui servent a la validation
 *          des parametres d'entree du main
 * 
 */


/**
 *
 * @author Gabriel Bedard     (GB)
 * @author Haykel Abdennadher (HA)
 * 
 * Dernieres modifications : GB
 * 
 * @version 1.5
 * @date 16 oct 2011 12h11
 * 
 */
public class Validation {
    
    public static boolean ValiderParametreEntree(String[] arg) {
        
        int nbParametre = arg.length;
        
        if(nbParametre != 2) {
            System.out.println("Main : ERREUR : Le programme doit avoir deux parametres en entree soit :");
            System.out.println("                <cheminDesFichiersEntrants> <cheminDesFichiesExtrants> \n\n");
            
            return true;
        }
        else {
                System.out.println("args[0]"+arg[0]);
        	System.out.println("args[1]"+arg[1]);
        }
        
        return true;
    }
    
}
