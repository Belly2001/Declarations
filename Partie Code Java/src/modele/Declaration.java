package modele;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe représentant une déclaration de vol
 */
public class Declaration {
    private String identifiant;
    private RoleDeclarant role;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    private EtatDeclaration etat;
    private Utilisateur declarant;
    private BienVole bienVole;
    private Lieu lieu;
    
    /**
     * Constructeur
     */
    public Declaration(Utilisateur declarant, RoleDeclarant role, BienVole bienVole, Lieu lieu) {
        this.identifiant = genererIdentifiant();
        this.declarant = declarant;
        this.role = role;
        this.bienVole = bienVole;
        this.lieu = lieu;
        this.dateCreation = LocalDateTime.now();
        this.dateModification = LocalDateTime.now();
        this.etat = EtatDeclaration.BROUILLON;
    }
    
    /**
     * Génère un identifiant unique pour la déclaration
     */
    private String genererIdentifiant() {
        return "DEC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    
    /**
     * Ajoute des informations à la déclaration
     */
    public void ajouterInformation(String info) {
        // Logique pour ajouter des informations
        this.dateModification = LocalDateTime.now();
    }
    
    /**
     * Sauvegarde la déclaration
     */
    public void sauvegarder() {
        if (this.etat == EtatDeclaration.BROUILLON) {
            this.etat = EtatDeclaration.SAUVEGARDEE;
            this.dateModification = LocalDateTime.now();
        }
    }
    
    // Getters
    public String getIdentifiant() {
        return identifiant;
    }
    
    public RoleDeclarant getRole() {
        return role;
    }
    
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }
    
    public LocalDateTime getDateModification() {
        return dateModification;
    }
    
    public EtatDeclaration getEtat() {
        return etat;
    }
    
    public Utilisateur getDeclarant() {
        return declarant;
    }
    
    public BienVole getBienVole() {
        return bienVole;
    }
    
    public Lieu getLieu() {
        return lieu;
    }
    
    // Setters
    public void setRole(RoleDeclarant role) {
        this.role = role;
        this.dateModification = LocalDateTime.now();
    }
    
    public void setEtat(EtatDeclaration etat) {
        this.etat = etat;
        this.dateModification = LocalDateTime.now();
    }
    
    public void setDateModification(LocalDateTime date) {
        this.dateModification = date;
    }
    
    @Override
    public String toString() {
        return "Déclaration " + identifiant + " - " + etat.getLibelle() + 
               "\nDéclarant: " + declarant.toString() +
               "\nBien: " + bienVole.toString() +
               "\nLieu: " + lieu.toString();
    }
}
