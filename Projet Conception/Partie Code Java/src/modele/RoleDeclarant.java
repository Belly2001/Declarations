package modele;

/**
 * Énumération représentant le rôle du déclarant
 */
public enum RoleDeclarant {
    VICTIME("Victime"),
    TEMOIN("Témoin"),
    VICTIME_TEMOIN("Victime et Témoin");
    
    private String libelle;
    
    private RoleDeclarant(String libelle) {
        this.libelle = libelle;
    }
    
    public String getLibelle() {
        return libelle;
    }
}
