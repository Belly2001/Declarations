package modele;

/**
 * Classe représentant un véhicule à moteur volé
 */
public class VehiculeMoteur extends BienVole {
    private String matricule;
    
    public VehiculeMoteur(String couleur, String marque, String matricule, String description) {
        super(couleur, marque, description);
        this.matricule = matricule;
    }
    
    public String getMatricule() {
        return matricule;
    }
    
    @Override
    public TypeBien getType() {
        return TypeBien.VEHICULE_MOTEUR;
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Matricule: " + matricule + ")";
    }
}
