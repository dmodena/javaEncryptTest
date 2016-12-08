/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import encryption.CryptoException;
import encryption.CryptoUtils;
import entidades.Aluno;
import entidades.Pessoas;
import entidades.Professor;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import xml.ProcessadorJAXB;

/**
 *
 * @author Micronos
 */
public class CryptoTest {
    public static void main(String[] args) {
        Map<String, Double> notasA1 = new HashMap<>();
        notasA1.put("bd", 9.5);
        notasA1.put("dsi", 8d);        
        Aluno a1 = new Aluno();
        a1.setCpf("a001");
        a1.setNome("João");
        a1.setMedia(8.5d);
        a1.setNotas(notasA1);
        
        Map<String, Double> notasA2 = new HashMap<>();
        notasA2.put("bd", 8.0);
        notasA2.put("dsi", 7.0);
        Aluno a2 = new Aluno();
        a2.setCpf("a002");
        a2.setNome("Maria");
        a2.setMedia(7.5);
        a2.setNotas(notasA2);
        
        Professor p1 = new Professor();
        p1.setCpf("p001");
        p1.setNome("Cristiane");
        p1.setCadastroProf("001");
        
        Professor p2 = new Professor();
        p2.setCpf("p002");
        p2.setNome("Renata");
        p2.setCadastroProf("002");
        
        Pessoas ps = new Pessoas();
        ps.addPessoa(a1);
        ps.addPessoa(a2);
        ps.addPessoa(p1);
        ps.addPessoa(p2);   
        
        ProcessadorJAXB pXml = new ProcessadorJAXB("testa.xml");
        
        String strXml = pXml.gravar(ps);
        byte[] btXml = strXml.getBytes();       
        
        String key = "95a8ddaec72d445e";
        File encryptedFile = new File("document.encrypted");
        File decryptedFile = new File("document.decrypted");
         
        try {
            CryptoUtils.encrypt(key, btXml, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
