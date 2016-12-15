/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entidades.Aluno;
import entidades.Pessoas;
import entidades.Professor;
import java.util.HashMap;
import java.util.Map;
import xml.ProcessadorJAXB;

/**
 *
 * @author Micronos
 */
public class AnotherTest {
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
        
        // Gravando xml em arquivo
        ProcessadorJAXB.gravar(ps, "testando.xml");
        
        // Lendo arquivo xml
        Pessoas pa = (Pessoas) ProcessadorJAXB.ler(Pessoas.class, "testando.xml");
        System.out.println(pa);
        
        // Gravando xml em byte array
        byte[] bytes = ProcessadorJAXB.gravar(ps);
        
        // Lendo bytes xml
        Pessoas pb = (Pessoas) ProcessadorJAXB.ler(Pessoas.class, bytes);
        System.out.println(pb);
    }
}
