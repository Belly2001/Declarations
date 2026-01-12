package modele;

/**
 * Classe représentant un agent policier
 */
public class AgentPolicier extends Utilisateur {
    private String login;
    private String motDePasse;
    
    public AgentPolicier(String numCNI, String nom, String prenom, String adresse, String telephone,
                         String login, String motDePasse) {
        super(numCNI, nom, prenom, adresse, telephone);
        this.login = login;
        this.motDePasse = motDePasse;
    }
    
    /**
     * Authentifie l'agent avec login et mot de passe
     */
    public boolean authentifier(String login, String motDePasse) {
        return this.login.equals(login) && this.motDePasse.equals(motDePasse);
    }
    
    public String getLogin() {
        return login;
    }
}
