package modele;

/**
 * Énumération représentant le type de bien volé
 */
public enum TypeBien {
    VEHICULE_MOTEUR("Véhicule à moteur"),
    VELO("Vélo");
    
    private String libelle;
    
    private TypeBien(String libelle) {
        this.libelle = libelle;
    }
    
    public String getLibelle() {
        return libelle;
    }
}
