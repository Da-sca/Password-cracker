import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

public class MD5Utils {
    //on empeche l'instantiation
    private MD5Utils() {}

    public static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestBytes = md.digest(input.getBytes());
            return bytesToHex(digestBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        BigInteger bigInt = new BigInteger(1, bytes);
        String hex = bigInt.toString(16);
        while (hex.length() < 32) {
            hex = "0" + hex;
        }
        return hex;
    }
}
