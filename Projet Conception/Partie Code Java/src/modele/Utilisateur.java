package modele;

/**
 * Classe abstraite représentant un utilisateur du système
 */
public abstract class Utilisateur {
    private String numCNI;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    
    /**
     * Constructeur
     */
    public Utilisateur(String numCNI, String nom, String prenom, String adresse, String telephone) {
        this.numCNI = numCNI;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    
    // Getters
    public String getNumCNI() {
        return numCNI;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    // Setters
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Override
    public String toString() {
        return nom + " " + prenom + " (CNI: " + numCNI + ")";
    }
}
