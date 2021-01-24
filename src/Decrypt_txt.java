import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Decrypt_txt {
    // sc.nextLine -> iso exen text
    public static String decrypt(String message, KeyPair key) {
        String txt = new String(message.getBytes(StandardCharsets.UTF_8));
        return new String((new BigInteger(txt)).modPow(key.getKey(), key.getN()).toByteArray());
    }
}
