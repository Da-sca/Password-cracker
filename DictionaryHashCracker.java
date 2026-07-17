import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryHashCracker implements HashCracker {

    private static final String DICTIONARY = "dictionary.txt";

    private long attempts = 0;

    @Override
    public String crack(String hash) {
        long startTime = System.currentTimeMillis();
        String result = null;

        try (Scanner scanner = new Scanner(new File(DICTIONARY))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (word.isEmpty()) {
                    continue;
                }
                attempts++;
                if (MD5Utils.hash(word).equals(hash)) {
                    result = word;
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Impossible de lire le fichier de dictionnaire: " + DICTIONARY, e);
        }
       

        long endTime = System.currentTimeMillis();
        System.out.println(" Nombre de tentatives : " + attempts);
        System.out.println(" Temps de cassage : " + (endTime - startTime) + " ms");

        return result;
    }
}
