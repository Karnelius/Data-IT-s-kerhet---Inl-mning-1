import java.math.BigInteger;
import java.util.Scanner;

public class Menu extends KeyPair {
    public static Scanner sc = new Scanner(System.in);

    public Menu {
        super();


        while(true){
            System.out.println();
            System.out.println("Choose an option");
            System.out.println("1. Generate keys");
            System.out.println("2. Read Keys");
            System.out.println("3. Save Keys");
            System.out.println("4. Encrypt String");
            System.out.println("5. Decrypt String");
            System.out.println("6. Encrypt textmessage in a textfile");
            System.out.println("7. Decrypt textmessage in a textfile");
            System.out.println();
            System.out.println("8. Exit");

            String selection = sc.nextLine();
            switch(selection){
                    case 1 -> {
                        System.out.println("Generate Keys:");
                        GenerateKeys.generateKeys("David", 4096);
                    }
                    case 2 -> {
                        System.out.println("Read Keys");
                        ReadKey.readKey("David");
                    }
                    case 3 -> {
                        System.out.println("Save Keys");
                        SaveKeys.saveKey("David", x);
                    }
                    case 4 -> {
                        System.out.println("Encrypt String");
                        Encrypt_string.encrypt("TEXT", "x");
                    }
                    case 5 -> {
                        System.out.println("Decrypt String");
                        Decrypt_string.decrypt("txt", "x");
                    }
                    case 6 -> {
                        System.out.println("Encrypt Text");
                        Encrypt_txt.encrypt("BLABLABL", "x");
                    }
                    case 7 -> {
                        System.out.println("Decrypt Text");
                        Decrypt_txt.decrypt("BLABLAL", "x");
                    }
                    case 8 -> {
                        System.out.println("Exiting");
                        break;
                    }
                }

        }
    }

    }
