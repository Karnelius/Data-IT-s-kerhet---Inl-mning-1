import java.math.BigInteger;
import java.nio.charset.StandardCharsets;


//Generera nycklar och spara dem i filer
//Läsa in sparade nycklar . Privata / Publika
//TODO Kunna kryptera och dekryptera strängar
//TODO Kunna kryptera och dekryptera textfiler

public class Main {
    //Medlemsvariabler




    public static void main(String[] args) {
        Menu menu = new Menu();
        int bitLength = 4096;

        /*
        int bitLength = 4096;
        GenerateKeys.generateKeys("David", bitLength);
        KeyPair publicKey = ReadKey.readKey("David_pub.key");
        //System.out.println(publicKey.getKey());
        KeyPair privateKey = ReadKey.readKey("David_private.key");
        //System.out.println(privateKey.getKey());
        String encrypted = Encrypt_string.encrypt("Pay up!", publicKey);
        String clear = Decrypt_string.decrypt(encrypted, privateKey);

        System.out.println();
        System.out.println("Plaintext: " + clear);
        */

        // Encrypt
        //String cipher = msg.modPow(e, n).toString();
        // Decrypt
        //String plain = new String((new BigInteger(cipher)).modPow(d, n).toByteArray());
    }
}