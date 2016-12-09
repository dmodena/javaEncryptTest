/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import encryption.CryptoException;
import encryption.CryptoUtils;
import java.io.File;

/**
 *
 * @author Micronos
 */
public class crypto {
    public static void main(String[] args) {
        if(args.length == 0) help();
        else {
            switch(args[0]) {
                case "-e":
                    encrypt(args);
                    break;
                case "-d":
                    decrypt(args);
                    break;
                default:
                    help();
                    break;
            }
        }        
    }
    
    public static void encrypt(String[] args) {        
        try {
            CryptoUtils.encrypt(new File(args[1]), new File(args[2]));
        } catch(CryptoException ex) {
            System.out.println(ex);
        }        
    }
    
    public static void decrypt(String[] args) {
        try {
            CryptoUtils.decrypt(new File(args[1]), new File(args[2]));
        } catch(CryptoException ex) {
            System.out.println(ex);
        }    
    }
    
    public static void help() {
        System.out.println("crypto - encrypt/decrypt text files");
        System.out.println("to encrypt run 'crypto -e inputFile outputFile'");
        System.out.println("to decrypt run 'crypto -d inputFile outputFile'");
    }
}
