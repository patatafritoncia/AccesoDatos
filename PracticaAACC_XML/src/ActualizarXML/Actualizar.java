/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActualizarXML;

import java.io.File;
import java.io.FileOutputStream;
import org.w3c.dom.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

/**
 *
 * @author FP
 */
public class Actualizar {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("empleados1.xml"));
        
        ArrayList <Empleado> arrayEmpleados = new ArrayList<Empleado>();
        
        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        // Lee los atributos de los empleados
        NodeList nList = document.getElementsByTagName("empleado");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType()== Node.ELEMENT_NODE){
                Element e = (Element) node;
                
                String id = e.getAttribute("id");
                String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
                String apellidos = e.getElementsByTagName("apellidos").item(0).getTextContent();
                String ciudad = e.getElementsByTagName("ciudad").item(0).getTextContent();
                
                arrayEmpleados.add(new Empleado(id,nombre,apellidos,ciudad));
            }
            
        }
        for (Empleado e: arrayEmpleados){
            System.out.println(e.toString());
        }

        // Recogida de datos y creación del objeto
        Empleado empleadoNuevo = new Empleado("675","Manuel","Pérez","Huelva");
        arrayEmpleados.add(empleadoNuevo);
        System.out.println(empleadoNuevo);
        
        // Creacion del xml con Transfer
        // Escritura con Trnsformer en otro fichero para respetar el anterior
        String nombreFichero = "empleados22";
        DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder2 = factory2.newDocumentBuilder();
        Document doc = builder2.newDocument();
        
      
        //Creamos la estructura recorrirendo el arraylist y sabiendo como es el documento XML
                        // Aqui se recorre el arrayList
        
        // elemento raiz
        Element rootElement = doc.createElement("empleados");
        doc.appendChild(rootElement);
        
        for (Empleado e: arrayEmpleados){
            System.out.println(e.toString());
            // recogemos y metemos todos los empleados
            Element empleado = doc.createElement("empleado");
            empleado.setAttribute("id", e.getId());
            rootElement.appendChild(empleado);
            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode(e.getNombre()));
            empleado.appendChild(nombre);
            
            Element apellidos = doc.createElement("apellidos");
            apellidos.appendChild(doc.createTextNode(e.getApellidos()));
            empleado.appendChild(apellidos);
            
            Element ciudad = doc.createElement("ciudad");
            ciudad.appendChild(doc.createTextNode(e.getCiudad()));
            empleado.appendChild(ciudad);
            
        }
        // cerramos el elemento raiz
        
        /// Escritura del fichero
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        
        StreamResult result = new StreamResult(new FileOutputStream(nombreFichero + ".xml"));
        transformer.transform(source, result);
        System.out.println("Datos actualizados en el archivo XML");
    }
}
