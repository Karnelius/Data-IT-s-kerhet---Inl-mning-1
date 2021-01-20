import java.math.BigInteger;
import java.nio.charset.StandardCharsets;


//TODO Generera nycklar och spara dem i filer
//TODO Läsa in sparade nycklar
//TODO Kunna kryptera och dekryptera strängar
//TODO Kunna kryptera och dekryptera textfiler

public class Main {


    public static String encrypt(String message, KeyPair key) {
        return (new BigInteger(message.getBytes(StandardCharsets.UTF_8))).modPow(key.getKey(), key.getN()).toString();
    }

    public static String decrypt(String message, KeyPair key) {
        String msg = new String(message.getBytes(StandardCharsets.UTF_8));
        return new String((new BigInteger(msg)).modPow(key.getKey(), key.getN()).toByteArray());
    }

    public static void main(String[] args) {

        int bitLength = 4096;
        GenerateKeys.generateKeys("David", bitLength);
        KeyPair publicKey = ReadKey.readKey("David_pub.key");
        System.out.println(publicKey.getKey());
        KeyPair privateKey = ReadKey.readKey("David_private.key");
        System.out.println(privateKey.getKey());
        String encrypted = encrypt("Pay up!", publicKey);
        String clear = decrypt(encrypted, privateKey);

        System.out.println();
        System.out.println(clear);


        // Encrypt
        //String cipher = msg.modPow(e, n).toString();
        // Decrypt
        //String plain = new String((new BigInteger(cipher)).modPow(d, n).toByteArray());
    }
}