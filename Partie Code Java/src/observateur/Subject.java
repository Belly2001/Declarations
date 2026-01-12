package observateur;

/**
 * Interface Subject du pattern Observer
 */
public interface Subject {
    /**
     * Attache un observateur
     */
    void attach(Observer observer);
    
    /**
     * Détache un observateur
     */
    void detach(Observer observer);
    
    /**
     * Notifie tous les observateurs
     */
    void notifyObservers(ObjetTrouve objet);
}
