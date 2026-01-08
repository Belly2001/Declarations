import modele.*;
import observateur.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe de test du système RQV
 */
public class TestSystemeRQV {
    
    public static void main(String[] args) {
        System.out.println("---TEST DU SYSTÈME RQV---");
        
        // Test 1: Création d'utilisateurs
        System.out.println("1. CRÉATION DES UTILISATEURS");
        Victime victime1 = new Victime("CNI001", "Ali", "Hassane", "10 rue de Paris", "0612345678");
        Victime victime2 = new Victime("CNI002", "Don", "Belly Star", "5 avenue Victor Hugo", "0698765432");
        Temoin temoin1 = new Temoin("CNI003", "Enac", "Philipe", "20 boulevard de la Liberté", "0656781234");
        AgentPolicier agent = new AgentPolicier("CNI004", "Sao", "Toumé", "Commissariat Central", "0601020304", "agent1", "password123");
        
        System.out.println("✓ Victime 1: " + victime1);
        System.out.println("✓ Victime 2: " + victime2);
        System.out.println("✓ Témoin: " + temoin1);
        System.out.println("✓ Agent: " + agent);
        
        // Test 2: Création de déclarations
        System.out.println("\n2. CRÉATION DES DÉCLARATIONS");
        
        // Déclaration 1: Vélo volé
        Velo velo1 = new Velo("Bleu", "Decathlon", "VEL123456", "VTT 26 pouces");
        Lieu lieu1 = new Lieu("15", "rue de la Gare", "Toulouse", "31000", 
                              LocalDate.of(2025, 12, 10), LocalTime.of(14, 30));
        Declaration declaration1 = new Declaration(victime1, RoleDeclarant.VICTIME, velo1, lieu1);
        declaration1.sauvegarder();
        System.out.println("✓ " + declaration1);
        
        // Déclaration 2: Véhicule volé
        VehiculeMoteur vehicule1 = new VehiculeMoteur("Noir", "Renault", "AB-123-CD", "Clio 5 portes");
        Lieu lieu2 = new Lieu("8", "place du Capitole", "Toulouse", "31000",
                              LocalDate.of(2025, 12, 11), LocalTime.of(22, 15));
        Declaration declaration2 = new Declaration(victime2, RoleDeclarant.VICTIME, vehicule1, lieu2);
        declaration2.sauvegarder();
        System.out.println("✓ " + declaration2);
        
        // Déclaration 3: Vélo bleu (pour test Observer)
        Velo velo2 = new Velo("Bleu", "Decathlon", "VEL789012", "Vélo de ville");
        Lieu lieu3 = new Lieu("3", "allée Jean Jaurès", "Toulouse", "31000",
                              LocalDate.of(2025, 12, 11), LocalTime.of(16, 0));
        Declaration declaration3 = new Declaration(victime2, RoleDeclarant.VICTIME_TEMOIN, velo2, lieu3);
        declaration3.sauvegarder();
        System.out.println("✓ " + declaration3);
        
        // Test 3: Test du pattern Observer
        System.out.println("\n3. TEST DU PATTERN OBSERVER");
        
        SystemeObjetsTrouves systemeObjets = new SystemeObjetsTrouves();
        
        // Enregistrer les déclarations dans le système
        systemeObjets.ajouterDeclaration(declaration1);
        systemeObjets.ajouterDeclaration(declaration2);
        systemeObjets.ajouterDeclaration(declaration3);
        
        System.out.println("✓ 3 déclarations ajoutées au système");
        
        // Un vélo bleu Decathlon est retrouvé
        System.out.println("\n--- Scénario: Un vélo bleu Decathlon est retrouvé ---");
        ObjetTrouve veloTrouve = new ObjetTrouve(TypeBien.VELO, "Bleu", "Decathlon", "Vélo retrouvé au parc");
        systemeObjets.enregistrerObjetTrouve(veloTrouve);
        
        // Test 4: Génération d'un RQV
        System.out.println("\n4. GÉNÉRATION D'UN RQV");
        
        // Authentification de l'agent
        boolean authOk = agent.authentifier("agent1", "password123");
        System.out.println("Authentification: " + (authOk ? "✓ Réussie" : "✗ Échouée"));
        
        if (authOk) {
            RQV rqv = new RQV(LocalDate.now());
            rqv.ajouterNouvelleDeclaration(declaration1);
            rqv.ajouterNouvelleDeclaration(declaration2);
            rqv.ajouterDeclarationModifiee(declaration3);
            
            System.out.println("✓ " + rqv);
        }
        
        // Test 5: Modification d'état
        System.out.println("\n5. MODIFICATION D'ÉTAT D'UNE DÉCLARATION");
        System.out.println("État initial: " + declaration1.getEtat().getLibelle());
        declaration1.setEtat(EtatDeclaration.EN_COURS);
        System.out.println("Après traitement: " + declaration1.getEtat().getLibelle());
        declaration1.setEtat(EtatDeclaration.RESOLUE);
        System.out.println("Après résolution: " + declaration1.getEtat().getLibelle());
        
        // Test 6: Test des différents rôles
        System.out.println("\n6. TEST DES RÔLES");
        System.out.println("Déclaration 1 - Rôle: " + declaration1.getRole().getLibelle());
        System.out.println("Déclaration 2 - Rôle: " + declaration2.getRole().getLibelle());
        System.out.println("Déclaration 3 - Rôle: " + declaration3.getRole().getLibelle());
        
        System.out.println("\n FIN DES TESTS");
    }
}
