/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Micronos
 */
public class ProcessadorJAXB {
    private String arquivo;
    
    public ProcessadorJAXB() { }
    
    public ProcessadorJAXB(String arquivo) {
        this.arquivo = arquivo;
    }
    
    public String gravar(Object object) {
        StringWriter sw = new StringWriter();
        
        try {
            
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, sw);
        }
        catch(JAXBException ex) {
            System.out.println(ex);
        }
        
        return sw.toString();
    }
    
    public Object ler(Class c) {
        try {
            File file = new File(arquivo);
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(file);
        }
        catch(JAXBException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public Object ler(Class c, byte[] inputBytes) {
        try {            
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return unmarshaller.unmarshal(new ByteArrayInputStream(inputBytes));
        }
        catch(JAXBException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
