/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EscrituraXML_DOM;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/**
 *
 * @author FP
 */
public class EscribirXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException {
        String nombreFichero = "curso";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();// Creamos un nuevo documento
        
        //Creamos la raiz del documento
        Element root = document.createElement("curso");
        root.setAttribute("nivel", "3");
        root.setAttribute("ciclo", "DAM");
        document.appendChild(root);
        
        // creamos un nuevo modulo y añadimos caracteristicas
        Element modulo = document.createElement("modulo");
        root.appendChild(modulo);
        
        //Añadimos las caracteristicas
        Element nombreModulo = document.createElement("nombre");
        nombreModulo.appendChild(document.createTextNode("PMDM"));
        nombreModulo.setAttribute("curso", "3");
        modulo.appendChild(nombreModulo);
        
        // Transformamos y escribimos los cambios en el archvo xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        
        StreamResult result = new StreamResult(new FileOutputStream(nombreFichero + ".xml"));
        transformer.transform(source, result);
        System.out.println("Datos actualizados en el archivo XML");
    }
}
