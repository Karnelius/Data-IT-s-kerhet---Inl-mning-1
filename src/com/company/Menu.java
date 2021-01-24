package com.company;

import java.util.Scanner;

import static com.company.KeyPair.readKey;


public class Menu {

    static Scanner sc = new Scanner(System.in);

    public Menu() {
        String encrypted = "";
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("1. Generate Keys & Save Keys");
            System.out.println("2. Read Your Generated Keys");
            System.out.println("3. Encrypt String");
            System.out.println("4. Decrypt String");
            System.out.println("5. Encrypt Textmessage In a Textfile");
            System.out.println("6. Decrypt Textmessage in a textfile");
            System.out.println();
            System.out.println("7. Exit");

            String selection = sc.nextLine();

            switch (selection) {
                case "1" -> {
                    System.out.println("Generating keys");
                    System.out.println("Type your keyname: ");
                    String fileName = sc.nextLine();
                    KeyGen.generateKeys(fileName);
                }
                case "2" -> {
                    System.out.println("Reading keys");
                    System.out.println("Type in what key do you want to read? ");
                    String fileName = sc.nextLine();
                    readKey(fileName + "_pub.key");
                    readKey(fileName + "_priv.key");
                }
                case "3" -> {
                    System.out.println("What file do you want to encrypt?");
                    String loadFileName = sc.nextLine();
                    KeyPair publicKey = readKey(loadFileName + "_pub.key");
                    System.out.println("Enter your encrypted message: ");
                    String messageString = sc.nextLine();
                    encrypted = Encryption.encrypt(messageString, publicKey);
                    System.out.println("Your message is now encrypted");

                }
                case "4" -> {
                    System.out.println("What file do you want to decrypt?");
                    String loadFileName = sc.nextLine();
                    KeyPair privateKey = readKey(loadFileName + "_priv.key");
                    String decrypted = Encryption.decrypt(encrypted, privateKey);
                    System.out.println("The decrypted message is:\n----------------\n" + decrypted + "\n----------------");

                }
                case "5" -> {
                    System.out.println("Enter the name of the file: ");
                    String loadFileName = sc.nextLine();
                    KeyPair publicKey = readKey(loadFileName + "_pub.key");
                    System.out.println("Enter the name of the file you want to create: ");
                    String temp = sc.nextLine();
                    System.out.println("Enter your encrypted message");
                    KeyPair.writeToFile(temp, sc.nextLine());
                    String messageFileName = (temp + ".txt");
                    String encryptedFileName = (temp + ".enc");
                    String messageFromFile = KeyPair.readFile(messageFileName);
                    String encryptedFileMessage = Encryption.encrypt(messageFromFile, publicKey);
                    KeyPair.writeToFile(encryptedFileName, encryptedFileMessage);


                }
                case "6" -> {
                    System.out.println("Enter the name of the file: ");
                    String messageFileName = (sc.nextLine());
                    //KeyPair publicKey = readKey(messageFileName + "_pub.key");
                    KeyPair privateKey = readKey(messageFileName + "_priv.key");
                    String messageFromFile = KeyPair.readFile(messageFileName + ".enc.txt");
                    String decrypted = Encryption.decrypt(messageFromFile, privateKey);
                    System.out.println("The decrypted message from " + messageFileName + ".enc.txt" + " is:\n----------------\n" + decrypted + "\n----------------");
                }
                case "7" -> {
                    System.out.println("Exited - bye bye");
                    System.exit(0);
                }
            }

        }
    }
}

