
/**
 * Fabrique simple chargée de centraliser l'instanciation des différentes
 * stratégies de cassage de mot de passe.
 */
public class HashCrackerFactory {

    /**
     * Crée et retourne une instance de HashCracker correspondant à la méthode demandée.
     * 
     * @param method La méthode de cassage ("BRUTE" ou "DICO").
     * @return Une instance implémentant l'interface HashCracker.
     * @throws IllegalArgumentException Si la méthode demandée est inconnue ou nulle.
     */
    public static HashCracker create(String method) {
        if (method == null) {
            throw new IllegalArgumentException("La méthode de cassage ne peut pas être nulle.");
        }

        // On harmonise en majuscules pour éviter les erreurs de casse (ex: "dico" -> "DICO")
        switch (method.toUpperCase()) {
            case "BRUTE":
                return new BruteForceHashCracker();
            case "DICO":
                return new DictionaryHashCracker();
            default:
                throw new IllegalArgumentException("Méthode de cassage inconnue : " + method);
        }
    }
}