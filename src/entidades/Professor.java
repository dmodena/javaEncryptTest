/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Micronos
 */
@XmlRootElement(name = "professor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Professor extends Pessoa {
    private String cadastroProf;
    
    public String getCadastroProf() {
        return cadastroProf;
    }
    
    public void setCadastroProf(String cadastroProf) {
        this.cadastroProf = cadastroProf;
    }
    
    @Override
    public String toString() {
        return "Professor - " + getCpf() + " " + getNome() + " " + cadastroProf;
    }
}
