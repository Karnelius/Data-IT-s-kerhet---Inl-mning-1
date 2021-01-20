import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadKey {

    public static KeyPair readKey(String fileName) {
        KeyPair key = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            key = (KeyPair) in.readObject();
            in.close();
            System.out.println("Read key from " + fileName);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return key;
    }
}

