package observateur;

import modele.TypeBien;
import modele.BienVole;
import java.time.LocalDateTime;

/**
 * Classe représentant un objet trouvé
 */
public class ObjetTrouve {
    private TypeBien type;
    private String couleur;
    private String marque;
    private String description;
    private LocalDateTime dateDecouverte;
    
    public ObjetTrouve(TypeBien type, String couleur, String marque, String description) {
        this.type = type;
        this.couleur = couleur;
        this.marque = marque;
        this.description = description;
        this.dateDecouverte = LocalDateTime.now();
    }
    
    /**
     * Vérifie si cet objet correspond à un bien volé
     */
    public boolean correspondsA(BienVole bien) {
        return this.type == bien.getType() &&
               this.couleur.equalsIgnoreCase(bien.getCouleur()) &&
               this.marque.equalsIgnoreCase(bien.getMarque());
    }
    
    // Getters
    public TypeBien getType() {
        return type;
    }
    
    public String getCouleur() {
        return couleur;
    }
    
    public String getMarque() {
        return marque;
    }
    
    public String getDescription() {
        return description;
    }
    
    public LocalDateTime getDateDecouverte() {
        return dateDecouverte;
    }
}
