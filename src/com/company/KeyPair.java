package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class KeyPair implements java.io.Serializable {
    private static final long serialVersionUID = 4L;
    private BigInteger key;
    private BigInteger n;

    public KeyPair(BigInteger key, BigInteger n) {
        this.setKey(key);
        this.setN(n);
    }

    public BigInteger getN() {
        return this.n;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getKey() {
        return this.key;
    }

    public void setKey(BigInteger key) {
        this.key = key;
    }

    public static void saveKey(String fileName, KeyPair key) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(key);
            out.close();
            System.out.println("Saved key as " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

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
    public static String readFile(String path) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
        assert sc != null;
        String text = sc.useDelimiter(",").next();
        sc.close();
        return text;
    }

    public static void writeToFile(String fileName, String encryptedMessage) {
        try {
            FileWriter myWriter = new FileWriter(fileName + ".txt");
            myWriter.write(encryptedMessage);
            myWriter.close();
        } catch (IOException e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }
}