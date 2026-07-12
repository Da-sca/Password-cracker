public class BruteForceHashCracker implements HashCracker {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int MAX_LENGTH = 4;

    private long attempts = 0;

    @Override
    public String crack(String hash) {
        long startTime = System.currentTimeMillis();
        String result = null;

        for (int length = 1; length <= MAX_LENGTH && result == null; length++) {
            result = tryAllCombinations(new char[length], 0, hash);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Attempts: " + attempts);
        System.out.println("Time elapsed: " + (endTime - startTime) + " ms");

        return result;
    }

    private String tryAllCombinations(char[] current, int index, String targetHash) {
        if (index == current.length) {
            String candidate = new String(current);
            attempts++;
            if (MD5Utils.hash(candidate).equals(targetHash)) {
                return candidate;
            }
            return null;
        }

        for (int i = 0; i < ALPHABET.length(); i++) {
            current[index] = ALPHABET.charAt(i);
            String found = tryAllCombinations(current, index + 1, targetHash);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
