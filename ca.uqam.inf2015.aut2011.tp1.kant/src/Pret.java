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
/**
 *
 * @author Gabriel Bedard
 * @version 1.0
 * 
 */

public class Pret {

    private String id = "";
    private String description = "";
    private BigDecimal montant;
    private int nombreAnnee;
    private int frequenceRemboursement;
    private BigDecimal tauxInteret;
    private BigDecimal frequenceComposition;
    private BigDecimal versementPeriodique;
    

    
    /**
     * Constructeur VIDE de Pret
     */
    public Pret()
    {
        this.id = "";
        this.description = "";
        this.montant = new BigDecimal(0.0);
        this.nombreAnnee = 0;
        this.frequenceRemboursement = 0;
        this.tauxInteret = new BigDecimal(0.0);
        this.frequenceComposition = new BigDecimal(0.0);
        this.versementPeriodique = new BigDecimal(0.0);
       
    }

    
    // -------------------------------------------------------------------------
    //
    //                          GETTERS et SETTERS
    //
    // -------------------------------------------------------------------------
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the montant
     */
    public BigDecimal getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    /**
     * @return the nombreAnnee
     */
    public int getNombreAnnee() {
        return nombreAnnee;
    }

    /**
     * @param nombreAnnee the nombreAnnee to set
     */
    public void setNombreAnnee(int nombreAnnee) {
        this.nombreAnnee = nombreAnnee;
    }

    /**
     * @return the frequenceRemboursement
     */
    public int getFrequenceRemboursement() {
        return frequenceRemboursement;
    }

    /**
     * @param frequenceRemboursement the frequenceRemboursement to set
     */
    public void setFrequenceRemboursement(int frequenceRemboursement) {
        this.frequenceRemboursement = frequenceRemboursement;
    }

    /**
     * @return the tauxInteret
     */
    public BigDecimal getTauxInteret() {
        return tauxInteret;
    }

    /**
     * @param tauxInteret the tauxInteret to set
     */
    public void setTauxInteret(BigDecimal tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    /**
     * @return the frequenceComposition
     */
    public BigDecimal getFrequenceComposition() {
        return frequenceComposition;
    }

    /**
     * @param frequenceComposition the frequenceComposition to set
     */
    public void setFrequenceComposition(BigDecimal frequenceComposition) {
        this.frequenceComposition = frequenceComposition;
    }

    /**
     * @return the versementPeriodique
     */
    public BigDecimal getVersementPeriodique() {
        return versementPeriodique;
    }

    /**
     * @param versementPeriodique the versementPeriodique to set
     */
    public void setVersementPeriodique(BigDecimal versementPeriodique) {
        this.versementPeriodique = versementPeriodique;
    }



    /**
     * toString : Donne toutes les infos de l'objet Pret
     * 
     * @return toutes les infos de l'objet Pret dans une String (String)
     */
                
    @Override
    public String toString()
    {
        return("Pret.java              : override toSting() \n" +
               "                    id : " + this.getId() + "\n" +
               "           description : " + this.getDescription() + "\n" +
               "               montant : " + this.getMontant() + "\n" +
               "           nombreAnnee : " + this.getNombreAnnee() + "\n" +
               "frequenceRemboursement : " + this.getFrequenceRemboursement() + "\n" +
               "           tauxInteret : " + this.getTauxInteret() + "\n" +
               "  frequenceComposition : " + this.getFrequenceComposition() + "\n" +
               "  VersementPeriodique  : " + this.getVersementPeriodique() + "\n");
    }
}