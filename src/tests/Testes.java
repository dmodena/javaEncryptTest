/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import encryption.CryptoException;
import encryption.CryptoUtils;
import java.io.File;

/**
 *
 * @author Micronos
 */
public class Testes {
    public static void main(String[] args) {
        String key = "cae6a92437635ab4";
        
        // Encrypt file to file
        try {
            CryptoUtils.encrypt(key, new File("encrypt.txt"), new File("encryptedkey.txt"));
            CryptoUtils.encrypt(new File("encrypt.txt"), new File("encryptednokey.txt"));
        } catch (CryptoException ex) {
            ex.printStackTrace();
        }
        
        // Encrypt byte array to file
        try {
            byte[] byteArray = "Mensagem".getBytes();
            CryptoUtils.encrypt(key, byteArray, new File("messagekey.txt"));
            CryptoUtils.encrypt(byteArray, new File("messagenokey.txt"));
        } catch (CryptoException ex) {
            ex.printStackTrace();
        }
        
        // Decrypt file to file
        try {
            CryptoUtils.decrypt(key, new File("encryptedkey.txt"), new File("decryptedkey.txt"));
            CryptoUtils.decrypt(new File("encryptednokey.txt"), new File("decryptednokey.txt"));
        } catch (CryptoException ex) {
            ex.printStackTrace();
        }
        
        // Decrypt file to byte array
        try {            
            byte[] mensagem1 = CryptoUtils.decrypt(key, new File("messagekey.txt"));
            byte[] mensagem2 = CryptoUtils.decrypt(new File("messagenokey.txt"));  
            
            print(mensagem1);
            print(mensagem2);
        } catch (CryptoException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void print(byte[] byteArray) {
        System.out.println(new String(byteArray));
    }
}
