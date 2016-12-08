/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Micronos
 */
@XmlRootElement(name = "aluno")
@XmlAccessorType(XmlAccessType.FIELD)
public class Aluno extends Pessoa {
    private double media;
    @XmlElement(name = "nota")
    private Map<String, Double> notas;
    
    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Map<String, Double> getNotas() {
        return notas;
    }

    public void setNotas(Map<String, Double> notas) {
        this.notas = notas;
    }
    
    @Override
    public String toString() {
        return "Aluno - " + getCpf() + " " + getNome() + " " + media;
    }
}
