package modele;

import observateur.Observer;
import observateur.ObjetTrouve;

/**
 * Classe représentant une victime
 * Implémente le pattern Observer pour recevoir les notifications
 */
public class Victime extends Utilisateur implements Observer {
    
    public Victime(String numCNI, String nom, String prenom, String adresse, String telephone) {
        super(numCNI, nom, prenom, adresse, telephone);
    }
    
    /**
     * Reçoit une notification lorsqu'un objet correspondant est trouvé
     */
    public void recevoirNotification(ObjetTrouve objet) {
        System.out.println("Notification pour " + getNom() + " " + getPrenom());
        System.out.println("Un " + objet.getType().getLibelle() + " correspondant à votre déclaration a été trouvé.");
        System.out.println("Caractéristiques : " + objet.getCouleur() + ", " + objet.getMarque());
        System.out.println("Veuillez vous présenter au commissariat pour vérification.");
    }
    
    /**
     * Méthode du pattern Observer
     */
    @Override
    public void update(ObjetTrouve objet) {
        recevoirNotification(objet);
    }
}
