// La ou on va instancier les password cracker

public class PasswordCracker {
    public static void main(String[] args) {
        String method = null;
        String hash = null;

        // Lecture des arguments de la ligne de commande (-m et -h)
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-m") && i + 1 < args.length) {
                method = args[i + 1];
            } else if (args[i].equals("-h") && i + 1 < args.length) {
                hash = args[i + 1];
            }
        }

        // Validation des arguments requis
        if (method == null || hash == null) {
            System.out.println(" Usage: PasswordCracker -m [BRUTE|DICO] -h [hash_md5]");
            return;
        }

        try {
            // Récupération de l'algorithme via la Fabrique (Simple Factory)
            HashCracker cracker = HashCrackerFactory.create(method);

            // Mesure du temps et exécution du cassage
            long startTime = System.currentTimeMillis();
            String result = cracker.crack(hash);
            long endTime = System.currentTimeMillis();

            // Affichage du résultat final
            if (result != null) {
                System.out.println(" Mot de passe trouvé : " + result);
            } else {
                System.out.println(" Mot de passe non trouvé.");
            }
            System.out.println(" Temps d'exécution du programme : " + (endTime - startTime) + " ms");

        } catch (IllegalArgumentException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}