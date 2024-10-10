
package xmlDOM;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document document = builder.parse(new File("empleados.xml"));
        
        document.getDocumentElement().normalize();
        System.out.println("Documento normalizado");
        
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());
        
        
        //Examinar los atributos, los empleados
        NodeList nList = document.getElementsByTagName("empleado");
        System.out.println("==============");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node= nList.item(temp);
            
            System.out.println("");
            if(node.getNodeType()== Node.ELEMENT_NODE){
                // Print each employee's detail
                
                Element eElement = (Element) node;
                System.out.println("Empleado id: " + eElement.getAttribute("id"));
                System.out.println("Nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Apellidos : " + eElement.getElementsByTagName("apellidos").item(0).getTextContent());
                System.out.println("Ciudad : " + eElement.getElementsByTagName("ciudad").item(0).getTextContent());
            }
        }
        
        
    }
        
}
