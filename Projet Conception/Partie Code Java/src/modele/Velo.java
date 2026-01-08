package modele;

/**
 * Classe représentant un vélo volé
 */
public class Velo extends BienVole {
    private String numeroSerie;
    
    public Velo(String couleur, String marque, String numeroSerie, String description) {
        super(couleur, marque, description);
        this.numeroSerie = numeroSerie;
    }
    
    public String getNumeroSerie() {
        return numeroSerie;
    }
    
    @Override
    public TypeBien getType() {
        return TypeBien.VELO;
    }
    
    @Override
    public String toString() {
        return super.toString() + " (N° série: " + numeroSerie + ")";
    }
}
