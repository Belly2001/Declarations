package observateur;

import modele.Declaration;
import java.util.ArrayList;
import java.util.List;

/**
 * Système de gestion des objets trouvés
 * Implémente le pattern Observer (Subject)
 */
public class SystemeObjetsTrouves implements Subject {
    private List<Observer> observers;
    private List<Declaration> declarations;
    
    public SystemeObjetsTrouves() {
        this.observers = new ArrayList<>();
        this.declarations = new ArrayList<>();
    }
    
    /**
     * Enregistre un objet trouvé et notifie les victimes concernées
     */
    public void enregistrerObjetTrouve(ObjetTrouve objet) {
        System.out.println("\n ---Objet trouvé enregistré---");
        System.out.println(objet.getType().getLibelle() + " - " + objet.getCouleur() + " " + objet.getMarque());
        
        // Recherche des déclarations correspondantes
        List<Declaration> correspondances = rechercherDeclarationsCorrespondantes(objet);
        
        System.out.println(correspondances.size() + " déclaration(s) correspondante(s) trouvée(s)");
        
        // Notification des victimes concernées
        for (Declaration declaration : correspondances) {
            if (declaration.getDeclarant() instanceof Observer) {
                Observer victime = (Observer) declaration.getDeclarant();
                victime.update(objet);
            }
        }
    }
    
    /**
     * Recherche les déclarations correspondant à l'objet trouvé
     */
    private List<Declaration> rechercherDeclarationsCorrespondantes(ObjetTrouve objet) {
        List<Declaration> correspondances = new ArrayList<>();
        
        for (Declaration declaration : declarations) {
            if (objet.correspondsA(declaration.getBienVole())) {
                correspondances.add(declaration);
            }
        }
        
        return correspondances;
    }
    
    /**
     * Ajoute une déclaration à surveiller
     */
    public void ajouterDeclaration(Declaration declaration) {
        declarations.add(declaration);
        
        // Si le déclarant est une victime, l'ajouter comme observateur
        if (declaration.getDeclarant() instanceof Observer) {
            attach((Observer) declaration.getDeclarant());
        }
    }
    
    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers(ObjetTrouve objet) {
        for (Observer observer : observers) {
            observer.update(objet);
        }
    }
}
