package modele;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un Rapport Quotidien de Vol
 */
public class RQV {
    private LocalDate dateRapport;
    private List<Declaration> nouvellesDeclarations;
    private List<Declaration> declarationsModifiees;
    private List<Declaration> declarationsResolues;
    
    /**
     * Constructeur
     */
    public RQV(LocalDate date) {
        this.dateRapport = date;
        this.nouvellesDeclarations = new ArrayList<>();
        this.declarationsModifiees = new ArrayList<>();
        this.declarationsResolues = new ArrayList<>();
    }
    
    // Méthodes pour ajouter des déclarations
    public void ajouterNouvelleDeclaration(Declaration d) {
        nouvellesDeclarations.add(d);
    }
    
    public void ajouterDeclarationModifiee(Declaration d) {
        declarationsModifiees.add(d);
    }
    
    public void ajouterDeclarationResolue(Declaration d) {
        declarationsResolues.add(d);
    }
    
    // Getters
    public LocalDate getDateRapport() {
        return dateRapport;
    }
    
    public List<Declaration> getNouvellesDeclarations() {
        return new ArrayList<>(nouvellesDeclarations);
    }
    
    public List<Declaration> getDeclarationsModifiees() {
        return new ArrayList<>(declarationsModifiees);
    }
    
    public List<Declaration> getDeclarationsResolues() {
        return new ArrayList<>(declarationsResolues);
    }
    
    @Override
    public String toString() {
        return "RQV du " + dateRapport +
               "\nNouvelles: " + nouvellesDeclarations.size() +
               "\nModifiées: " + declarationsModifiees.size() +
               "\nRésolues: " + declarationsResolues.size();
    }
}
