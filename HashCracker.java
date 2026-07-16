
/**
 * Interface commune pour toutes les stratégies de cassage de hash.
 */
public interface HashCracker {
    /**
     * Tente de retrouver le mot de passe correspondant au hash fourni.
     * 
     * @param hash Le hash MD5 recherché.
     * @return Le mot de passe trouvé, ou null si aucun résultat.
     */
    String crack(String hash);
}