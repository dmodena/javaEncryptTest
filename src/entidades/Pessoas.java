/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Micronos
 */
@XmlRootElement(name = "pessoas")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pessoas {
    @XmlElement(name = "pessoa")
    private List<Pessoa> pessoas;
    
    public Pessoas() {
        pessoas = new ArrayList<>();
    }
    
    public void addPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(Pessoa p : pessoas) {
            sb.append(p).append("\n");
        }
        
        return sb.toString();
    }
}
