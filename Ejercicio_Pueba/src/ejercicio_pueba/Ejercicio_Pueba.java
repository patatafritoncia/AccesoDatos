/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_pueba;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;

/**
 *
 * @author FP
 */
public class Ejercicio_Pueba {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("categoria-camarasWeb.xml"));

        //Normaizar el documento
        document.getDocumentElement().normalize();
        System.out.println("Documento normalizado correctamente");

        Element root = document.getDocumentElement();
        System.out.println(root.getElementsByTagName("camaras_web"));

        // Creamos un fichero de escritura para guardar la información
        FileWriter escritura = new FileWriter("C:\\Users\\FP\\Desktop\\categoriaCamarasWeb.txt");

        // Título del archivo
        escritura.write("Lo ÚLTIMO de los cámaras WEB" + "\n");
        escritura.write("==============" + "\n");
        
        // Lista de nodos para examinar los atributos de las camaras
        NodeList nList = document.getElementsByTagName("camara");

        // Iterar sobra cada nodo para extraer la información
        int contadorRegistros = 0;
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            System.out.println(" ");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                contadorRegistros++;
                Element elemento = (Element) node;

                escritura.write("Cámara ID: " + elemento.getAttribute("id") + "\n");
                escritura.write("Modelo ¡¡ " + elemento.getElementsByTagName("modelo").item(0).getTextContent() + "\n");
                escritura.write("Marca ¡¡ " + elemento.getElementsByTagName("marca").item(0).getTextContent() + "\n");
                escritura.write("DIMENSIONES Altura # " + elemento.getElementsByTagName("altura").item(0).getTextContent() + "\n");
                escritura.write("DIMENSIONES Anchura @ " + elemento.getElementsByTagName("anchura").item(0).getTextContent() + "\n");
                escritura.write("DIMENSIONES Profundidad # " + elemento.getElementsByTagName("profundidad").item(0).getTextContent() + "\n");
                escritura.write("DIMENSIONES Peso @ " + elemento.getElementsByTagName("peso").item(0).getTextContent() + "\n");
                escritura.write("RESOLUCIÓN Megapíxeles # " + elemento.getElementsByTagName("megapixeles").item(0).getTextContent() + "\n");
                escritura.write("Comentarios: " + "\n");
                escritura.write("***************************" + "\n");
                escritura.write(elemento.getElementsByTagName("comentarios").item(0).getTextContent() + "\n");
                escritura.write("\n");

            }

            if (contadorRegistros == nList.getLength()) {
                escritura.write("+++++++++++++++++++++++++++\n");
                escritura.write("FIN DEL DOCUMENTO XML");
            }

        }
        escritura.close();

    }

}
