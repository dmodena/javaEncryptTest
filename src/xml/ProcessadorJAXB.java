/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
}
