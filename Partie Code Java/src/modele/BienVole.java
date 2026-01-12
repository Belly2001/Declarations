package modele;

/**
 * Classe abstraite représentant un bien volé
 */
public abstract class BienVole {
    private String couleur;
    private String marque;
    private String description;
    
    public BienVole(String couleur, String marque, String description) {
        this.couleur = couleur;
        this.marque = marque;
        this.description = description;
    }
    
    // Getters
    public String getCouleur() {
        return couleur;
    }
    
    public String getMarque() {
        return marque;
    }
    
    public String getDescription() {
        return description;
    }
    
    // Méthode abstraite à implémenter par les sous-classes
    public abstract TypeBien getType();
    
    @Override
    public String toString() {
        return getType().getLibelle() + " - " + marque + " " + couleur;
    }
}
