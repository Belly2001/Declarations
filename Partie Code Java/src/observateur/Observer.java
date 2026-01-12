package observateur;

/**
 * Interface Observer du pattern Observer
 */
public interface Observer {
    /**
     * Méthode appelée lorsqu'un objet trouvé correspond à une déclaration
     */
    void update(ObjetTrouve objet);
}
