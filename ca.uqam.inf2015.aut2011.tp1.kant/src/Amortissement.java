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
 * @author Benoit Filiatreault
 * @version 1.1
 * 
 */
public class Amortissement {

    private int periode;
    private BigDecimal capitalDebut;
    private BigDecimal versementTotal;
    private BigDecimal versementInteret;
    private BigDecimal versementCapital;
    private BigDecimal capitalFin;
    private BigDecimal versementTotalCumulatif;
    private BigDecimal versementInteretCumulatif;
    private BigDecimal versementCapitalCumulatif;
    


    public Amortissement() {
        this.periode = 1;
        this.capitalDebut = new BigDecimal(0);
        this.versementTotal = new BigDecimal(0);
        this.versementInteret = new BigDecimal(0);
        this.versementCapital = new BigDecimal(0);
        this.capitalFin = new BigDecimal(0);
        this.versementTotalCumulatif = new BigDecimal(0);
        this.versementInteretCumulatif = new BigDecimal(0);
        this.versementCapitalCumulatif = new BigDecimal(0);
    }

    /**
     * @return the periode
     */
    public int getPeriode() {
        return periode;
    }

    /**
     * @param periode the periode to set
     */
    public void setPeriode(int periode) {
        this.periode = periode;
    }

    /**
     * @return the capitalDebut
     */
    public BigDecimal getCapitalDebut() {
        return capitalDebut;
    }

    /**
     * @param capitalDebut the capitalDebut to set
     */
    public void setCapitalDebut(BigDecimal capitalDebut) {
        this.capitalDebut = capitalDebut;
    }

    /**
     * @return the versementTotal
     */
    public BigDecimal getVersementTotal() {
        return versementTotal;
    }

    /**
     * @param versementTotal the versementTotal to set
     */
    public void setVersementTotal(BigDecimal versementTotal) {
        this.versementTotal = versementTotal;
    }

    /**
     * @return the versementInteret
     */
    public BigDecimal getVersementInteret() {
        return versementInteret;
    }

    /**
     * @param versementInteret the versementInteret to set
     */
    public void setVersementInteret(BigDecimal versementInteret) {
        this.versementInteret = versementInteret;
    }

    /**
     * @return the versementCapital
     */
    public BigDecimal getVersementCapital() {
        return versementCapital;
    }

    /**
     * @param versementCapital the versementCapital to set
     */
    public void setVersementCapital(BigDecimal versementCapital) {
        this.versementCapital = versementCapital;
    }

    /**
     * @return the capitalFin
     */
    public BigDecimal getCapitalFin() {
        return capitalFin;
    }

    /**
     * @param capitalFin the capitalFin to set
     */
    public void setCapitalFin(BigDecimal capitalFin) {
        this.capitalFin = capitalFin;
    }

    /**
     * @return the versementTotalCumulatif
     */
    public BigDecimal getVersementTotalCumulatif() {
        return versementTotalCumulatif;
    }

    /**
     * @param versementTotalCumulatif the versementTotalCumulatif to set
     */
    public void setVersementTotalCumulatif(BigDecimal versementTotalCumulatif) {
        this.versementTotalCumulatif = versementTotalCumulatif;
    }

    /**
     * @return the versementInteretCumulatif
     */
    public BigDecimal getVersementInteretCumulatif() {
        return versementInteretCumulatif;
    }

    /**
     * @param versementInteretCumulatif the versementInteretCumulatif to set
     */
    public void setVersementInteretCumulatif(BigDecimal versementInteretCumulatif) {
        this.versementInteretCumulatif = versementInteretCumulatif;
    }

    /**
     * @return the versementCapitalCumulatif
     */
    public BigDecimal getVersementCapitalCumulatif() {
        return versementCapitalCumulatif;
    }

    /**
     * @param versementCapitalCumulatif the versementCapitalCumulatif to set
     */
    public void setVersementCapitalCumulatif(BigDecimal versementCapitalCumulatif) {
        this.versementCapitalCumulatif = versementCapitalCumulatif;
    }

    
    
    /**
     * toString : Donne toutes les infos de l'objet Amortissement
     * 
     * @return toutes les infos de l'objet Amortissement dans une String (String)
     */
                
    @Override
    public String toString()
    {

        
        return ("Amortissement.java         : override toSting() \n" +
                "periode : " + this.getPeriode() + "\n" +
                "capitalDebut : " + this.getCapitalDebut() + "\n" +
                "versementTotal : " + this.getVersementTotal() + "\n" +
                "versementInteret : " + this.getVersementInteret() + "\n" +
                "versementCapital : " + this.getVersementCapital() + "\n" +
                "capitalFin : " + this.getCapitalFin() + "\n" +
                "versementTotalCumulatif : " + this.getVersementTotalCumulatif() + "\n" +
                "versementInteretCumulatif : " + this.getVersementInteretCumulatif() + "\n" +
                "versementCapitalCumulatif : " + this.getVersementCapitalCumulatif() + "\n");
    }
    
}
