package modele;

/**
 * Énumération représentant l'état d'une déclaration
 */
public enum EtatDeclaration {
    BROUILLON("Brouillon"),
    SAUVEGARDEE("Sauvegardée"),
    EN_COURS("En cours de traitement"),
    RESOLUE("Résolue");
    
    private String libelle;
    
    private EtatDeclaration(String libelle) {
        this.libelle = libelle;
    }
    
    public String getLibelle() {
        return libelle;
    }
}
