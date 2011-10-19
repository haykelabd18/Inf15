/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


// -------------------------------
//
//   IMPORTATION DES LIBRAIRIES
//
// -------------------------------

import java.math.BigDecimal;
//import java.math.MathContext;
//import java.math.RoundingMode;
import java.util.ArrayList;

/**
 *
 * @author Benoit Filiatreault
 * @version 1.2
 * 
 */
public class Calcul {
    

    // constante d'arrondissement
    private static final int decimal = 2;
    
    /* -------------------------------------------------------------------------
     * methode   : arrondissement
     * 
     * Entree(s) : BigDecimal nombre : nombre non arrondi
     * 
     * Sortie    : BigDecimal        : nombre arrondi
     * 
     * Portee    : public static
     * 
    ---------------------------------------------------------------------- */
    
      public static BigDecimal arrondissement(BigDecimal nombre) {
            return nombre.setScale(decimal, BigDecimal.ROUND_HALF_EVEN);
    }

        

    /* -------------------------------------------------------------------------
     * methode   : tauxInteretMensuel
     * 
     * Entree(s) : BigDecimal tauxInteret : taux d'interet annuel
     * 
     * Sortie    : BigDecimal             : taux d'interet mensuel
     * 
     * Portee    : public static
     * 
     * Formule Math: (1 + (tauxInteret/100) / frequenceComposition)^(1 / (12 / frequenceComposition)) - 1
    ---------------------------------------------------------------------- */
    public static BigDecimal setTauxInteretMensuel(BigDecimal tauxInteret, BigDecimal frequenceComposition) {
        BigDecimal tauxInteretAnnuel = tauxInteret.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);

        BigDecimal nombre1 = new BigDecimal(1).add(tauxInteretAnnuel.divide(frequenceComposition,2, BigDecimal.ROUND_HALF_EVEN));
        BigDecimal nombre2 = new BigDecimal(1).divide(new BigDecimal(12).divide(frequenceComposition,20, BigDecimal.ROUND_HALF_EVEN),20, BigDecimal.ROUND_HALF_EVEN);
        
        BigDecimal nombre3 = new BigDecimal(Math.pow(nombre1.doubleValue(), nombre2.doubleValue())).add(new BigDecimal(-1));
        return nombre3;
    }

    /* -------------------------------------------------------------------------
     * methode   : versementPeriodique
     * 
     * Entree(s) : Pret pret : la référence à un pret
     * 
     * Sortie    : BigDecimal versementPeriodique : la valeur du versement
     * 
     * Portee    : public static
     * 
     * Formule Math: montant * tauxInteretMensuel) / (1 - (1 + tauxInteretMensuel) ^ -periode));
    ---------------------------------------------------------------------- */
    public static BigDecimal setVersementPeriodique(Pret pret, BigDecimal tauxInteretMensuel) {
        BigDecimal montant = pret.getMontant();
        int periode = Calcul.setPeriode(pret);
        
        BigDecimal nombre1 = montant.multiply(tauxInteretMensuel);
        BigDecimal nombre2 = new BigDecimal(1).add(tauxInteretMensuel);
        BigDecimal nombre3 = new BigDecimal(1).subtract(new BigDecimal(Math.pow(nombre2.doubleValue(), - periode)));
        
        
        //BigDecimal versementPeriodique = (montant * tauxInteretMensuel) / (1 - Math.pow(1 + tauxInteretMensuel, -periode));

        return nombre1.divide(nombre3, decimal, BigDecimal.ROUND_HALF_EVEN);
    }
    
    
    /* -------------------------------------------------------------------------
     * methode   : setPeriode
     * 
     * Entree(s) : Pret pret : la référence a un objet pret
     * 
     * Sortie    : int la periode
     * 
     * Portee    : public static
     * 
     * Formule Math:  nombreAnnee * frequenceRemboursement
    ---------------------------------------------------------------------- */
    public static int setPeriode(Pret pret) {
        return pret.getNombreAnnee()* pret.getFrequenceRemboursement();
    }
    
    
    
    
    /* -------------------------------------------------------------------------
     * methode   : setVersementTotal
     * 
     * Entree(s) : Pret pret : la référence a un objet pret
     * 
     * Sortie    : int la periode
     * 
     * Portee    : public static
    ---------------------------------------------------------------------- */
    public static BigDecimal setVersementTotal(BigDecimal versementPeriodique, BigDecimal capitalDebut) {
        BigDecimal reponse;
        if (versementPeriodique.doubleValue() <= capitalDebut.doubleValue())
            reponse = versementPeriodique;
        else
            reponse = capitalDebut;
        
        return reponse;
    }
    
    

    /* -------------------------------------------------------------------------
     * methode   : serVersementInteret
     * 
     * Entree(s) : BigDecimal capitalDebut
     *             BigDecimal tauxInteretMensuel
     * 
     * Sortie    : BigDecimal valeur du versement
     * 
     * Portee    : public static
     * 
     * Formule Math: capitalDebut * tauxInteretMensuel
    ---------------------------------------------------------------------- */
    public static BigDecimal setVersementInteret(BigDecimal capitalDebut, BigDecimal tauxInteretMensuel) {
        return arrondissement(capitalDebut.multiply(tauxInteretMensuel));
    }

    /* -------------------------------------------------------------------------
     * methode   : setVersementCapital
     * 
     * Entree(s) : Pret pret : la reference a un pret
     *             Amortissement amortissement : la reference a un objet Amortissement
     * 
     * Sortie    : BigDecimal valeur du versement
     * 
     * Portee    : public static
     * 
     * Formule Math: versementTotal - versementInteret
    ---------------------------------------------------------------------- */
    public static BigDecimal setVersementCapital(BigDecimal versementTotal, Amortissement amortissement) {
        return versementTotal.subtract(amortissement.getVersementInteret());
    }

    /* -------------------------------------------------------------------------
     * methode   : setNouveauCapital
     * 
     * Entree(s) : Amortissement amortissement : la reference a un objet Amortissement
     * 
     * Sortie    : BigDecimal              : la valeur du nouveau capital
     * 
     * Portee    : public static
     * 
     * Formule Math: capitalDebut - versementCapital
    ---------------------------------------------------------------------- */
    public static BigDecimal setNouveauCapital(Amortissement amortissement) {
        return amortissement.getCapitalDebut().subtract(amortissement.getVersementCapital());
    }

    
    /* -------------------------------------------------------------------------
     * methode   : setCumulatif
     * 
     * Entree(s) : Amortissement amortiPrece : Amortissement precedent
     *             Amortissement amorti      : Amortissement actuel
     *             BigDecimal versementPeriodique: versement periodique
     * 
     * Sortie    : Amortissement amorti      : Amortissement actuel
     * 
     * Portee    : public static
     * 
     * Formule Math: versementTotalCumulatif =+ versementPeriodique
     *               versementInteretCumulatif =+ versementInteret
     *               versementCapitalCumulatif =+ versementCapital
    ---------------------------------------------------------------------- */
    public static Amortissement setCumulatif(Amortissement amortiPrece, Amortissement amorti, BigDecimal versementPeriodique)
    {
        amorti.setVersementTotalCumulatif(amortiPrece.getVersementTotalCumulatif().add(versementPeriodique));
        amorti.setVersementInteretCumulatif(amortiPrece.getVersementInteretCumulatif().add(amorti.getVersementInteret()));
        amorti.setVersementCapitalCumulatif(amortiPrece.getVersementCapitalCumulatif().add(amorti.getVersementCapital()));
        return amorti;
    }

    
    /* -------------------------------------------------------------------------
     * methode   : amortissement
     * 
     * Entree(s) : Pret pret : Reference a un pret
     *             Amortissement amortiPrece : Amortissement precedent
     *             BigDecimal periode            : periode
     *             BigDecimal tauxInteretMensuel : Taux interet mensuel
     * 
     * Sortie    : Amortissement amorti      : Amortissement actuel
     * 
     * Portee    : public static
     * 
    ---------------------------------------------------------------------- */
    public static Amortissement setAmortissement(Pret pret, Amortissement amortiPrece, int periode, BigDecimal tauxInteretMensuel) {
        Amortissement amorti = new Amortissement();
        amorti.setPeriode(periode);
        amorti.setCapitalDebut(amortiPrece.getCapitalFin());
        amorti.setVersementTotal(pret.getVersementPeriodique());
        
        // si capital début est < au versement periodique, alors
        //      versement capital = capital debut
        //      versement interet est calcule par la suite
        //      versement capital doit être = à 0
        //amorti.setVersementTotal(Calcul.setVersementTotal(pret.getVersementPeriodique(), amorti.getCapitalDebut())); // si montant restant est < versement périodique, sinon mettre montant <
        
        amorti.setVersementInteret(Calcul.setVersementInteret(amortiPrece.getCapitalFin(), tauxInteretMensuel));
        amorti.setVersementCapital(Calcul.setVersementCapital(amorti.getVersementTotal(), amorti));
        amorti.setCapitalFin(Calcul.setNouveauCapital(amorti));
        amorti = Calcul.setCumulatif(amortiPrece, amorti, pret.getVersementPeriodique());

        return amorti;
    }
    
    
    /* -------------------------------------------------------------------------
     * procedure : listeArmortissement
     * 
     * Entree(s) : Pret pret       : reférence à un pret
     * 
     * Sortie    : Aucune (void)
     * 
     * Portee    : public static
     * 
    ---------------------------------------------------------------------- */
    // node liste d'armortissement
    // retournera un node d'armortissement a ajouter a pret
    public static void listeArmortissement(String fichierSortie,Pret pret) {
       
    	ArrayList<Object> liste = new ArrayList<Object>();
        SortieGson sortie = new SortieGson();
        
        sortie.setId(pret.getId());
        sortie.setDescription(pret.getDescription());
        sortie.setFrequenceComposition(pret.getFrequenceComposition());
        sortie.setFrequenceRemboursement(pret.getFrequenceRemboursement());
        sortie.setMontant(pret.getMontant());
        sortie.setNombreAnnee(pret.getNombreAnnee());
        sortie.setTauxInteret(pret.getTauxInteret());
        sortie.setVersementPeriodique(pret.getVersementPeriodique());
    	
    	BigDecimal tauxInteretMensuel = Calcul.setTauxInteretMensuel(pret.getTauxInteret(), pret.getFrequenceComposition()); // bf
        pret.setVersementPeriodique(Calcul.setVersementPeriodique(pret, tauxInteretMensuel)); // bf


        
        Amortissement amortissement = new Amortissement(); // bf
        BigDecimal capitalFin = pret.getMontant(); //bf
        amortissement.setCapitalFin(capitalFin); // bf

        int periode = Calcul.setPeriode(pret); // bf

       
        for (int a = 1; a <= periode; a ++) //bf
        {
            amortissement = Calcul.setAmortissement(pret, amortissement, a, tauxInteretMensuel);
            System.out.println(amortissement.toString());
            
            liste.add(amortissement);
            capitalFin = amortissement.getCapitalFin();
        }
        sortie.setListe(liste);
        EntreeSortie.EcrireFichierJSon(fichierSortie, sortie);
    }
    
}
    

