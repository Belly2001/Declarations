package modele;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe représentant le lieu et les circonstances d'un vol
 */
public class Lieu {
    private String numeroRue;
    private String nomRue;
    private String ville;
    private String codePostal;
    private String detailsSupplementaires;
    private LocalDate dateVol;
    private LocalTime heureVol;
    
    public Lieu(String numeroRue, String nomRue, String ville, String codePostal,
                LocalDate dateVol, LocalTime heureVol) {
        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.dateVol = dateVol;
        this.heureVol = heureVol;
        this.detailsSupplementaires = "";
    }
    
    public String getAdresseComplete() {
        return numeroRue + " " + nomRue + ", " + codePostal + " " + ville;
    }
    
    // Getters
    public String getNumeroRue() {
        return numeroRue;
    }
    
    public String getNomRue() {
        return nomRue;
    }
    
    public String getVille() {
        return ville;
    }
    
    public String getCodePostal() {
        return codePostal;
    }
    
    public String getDetailsSupplementaires() {
        return detailsSupplementaires;
    }
    
    public LocalDate getDateVol() {
        return dateVol;
    }
    
    public LocalTime getHeureVol() {
        return heureVol;
    }
    
    // Setter pour détails
    public void setDetailsSupplementaires(String details) {
        this.detailsSupplementaires = details;
    }
    
    @Override
    public String toString() {
        return getAdresseComplete() + " le " + dateVol + " à " + heureVol;
    }
}
