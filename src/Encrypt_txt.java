import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Encrypt_txt {
    public static String encrypt(String message, KeyPair key) {
        return (new BigInteger(message.getBytes(StandardCharsets.UTF_8))).modPow(key.getKey(), key.getN()).toString();
    }
}
