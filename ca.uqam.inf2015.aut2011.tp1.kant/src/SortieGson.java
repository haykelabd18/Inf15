import java.math.BigDecimal;
import java.util.ArrayList;


public class SortieGson {
	
	
	
    private String id = "";
    private String description = "";
    private BigDecimal montant;
    private int nombreAnnee;
    private int frequenceRemboursement;
    private BigDecimal tauxInteret;
    private BigDecimal frequenceComposition;
    private BigDecimal versementPeriodique;
    private ArrayList<Object> amortissement = new ArrayList<Object>();
	
	
    
    /**
     * Constructeur VIDE de SortieGson
     */
    public SortieGson()
    {
  
        this.id = "";
        this.description = "";
        this.montant = new BigDecimal(0.0);
        this.nombreAnnee = 0;
        this.frequenceRemboursement = 0;
        this.tauxInteret = new BigDecimal(0.0);
        this.frequenceComposition = new BigDecimal(0.0);
        this.versementPeriodique = new BigDecimal(0.0);
      	this.amortissement = null;
       
    }
	
    
    
    
    
    // -------------------------------------------------------------------------
    //
    //                          GETTERS et SETTERS
    //
    // -------------------------------------------------------------------------

    
    /**
     * @return the array list
     */
    public ArrayList<Object> getListe() {
        return amortissement;
    }

    /**
     * @param id the id to set
     */
    public void setListe(ArrayList<Object> listePeriode) {
        this.amortissement = listePeriode;
    }
    
    
    
    
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
    
    

	public String toString() {
		   return "SortieGson [id=" + id + ", description=" + description +", montant=" + montant +", nombreAnnee=" + nombreAnnee +
		   ", frequenceRemboursement=" + frequenceRemboursement +", tauxInteret=" + tauxInteret +", frequenceComposition=" +
		   frequenceComposition +", versementPeriodique=" + versementPeriodique + ", amortissement="
			+ amortissement + "]";
		}


	
	
	
	
	

}
