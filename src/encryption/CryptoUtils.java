/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Micronos
 */
public class CryptoUtils {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static final String DEFAULTKEY = "95a8ddaec72d445e";
    
    /**
     * Encrypt from file to file with standard key
     * @param inputFile Input file
     * @param outputFile Output file
     * @throws CryptoException Exception
     */
    public static void encrypt(File inputFile, File outputFile) throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, DEFAULTKEY, inputFile, outputFile);
    }
    
    /**
     * Encrypt from byte array to file with standard key
     * @param inputBytes Input byte array
     * @param outputFile Output file
     * @throws CryptoException Exception
     */
    public static void encrypt(byte[] inputBytes, File outputFile) throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, DEFAULTKEY, inputBytes, outputFile);
    }    
    
    /**
     * Encrypt from file to file
     * @param key Encryption key
     * @param inputFile Input file
     * @param outputFile Output file
     * @throws CryptoException Exception
     */
    public static void encrypt(String key, File inputFile, File outputFile) throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }
 
    /**
     * Encrypt from byte array to file
     * @param key Encryption key
     * @param inputBytes Input byte array
     * @param outputFile Output file
     * @throws CryptoException 
     */
    public static void encrypt(String key, byte[] inputBytes, File outputFile) throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputBytes, outputFile);
    }
    
    /**
     * Decrypt from file to file with standard key
     * @param inputFile Input file
     * @param outputFile Output file
     * @throws CryptoException Exception
     */
    public static void decrypt(File inputFile, File outputFile) throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, DEFAULTKEY, inputFile, outputFile);
    }
    
    /**
     * Decrypt from file to byte array with standard key
     * @param inputFile Input file
     * @return Output byte array
     * @throws CryptoException Exception
     */
    public static byte[] decrypt(File inputFile) throws CryptoException {
        return doCrypto(Cipher.DECRYPT_MODE, DEFAULTKEY, inputFile);
    }
    
    /**
     * Decrypt from file to file
     * @param key Encryption key
     * @param inputFile Input file
     * @param outputFile Output file
     * @throws CryptoException Exception
     */
    public static void decrypt(String key, File inputFile, File outputFile) throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }
    
    /**
     * Decrypt from file to byte array
     * @param key Encryption key
     * @param inputFile Input file
     * @return Output byte array
     * @throws CryptoException Exception
     */
    public static byte[] decrypt(String key, File inputFile) throws CryptoException {
        return doCrypto(Cipher.DECRYPT_MODE, key, inputFile);
    }
    
    private static void doCrypto(int cipherMode, String key, byte[] inputBytes, File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
            
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
                        
            outputStream.close();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {            
            throw new CryptoException(ex.getMessage(), ex);
        }
    }
 
    private static void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
             
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            inputStream.close();
            outputStream.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException(ex.getMessage(), ex);
        }
    }
    
    private static byte[] doCrypto(int cipherMode, String key, File inputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
             
            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
            
            inputStream.close();
             
            return cipher.doFinal(inputBytes);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException(ex.getMessage(), ex);
        }    
    }
}
