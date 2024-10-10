/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaaacc_xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("arcade.xml"));
        document.getDocumentElement().normalize();
        System.out.println("Documento normalizado");

        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        // Examinamos cada uno de los atributos de los productos
        // Metemos en una Lista cada uno de los productos
        NodeList nList = document.getElementsByTagName("producto");
        System.out.println("=========");

        int contadorRegistros = 0;

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                contadorRegistros++;
                if (contadorRegistros == 1) {
                    System.out.println("-.-");
                } else if (contadorRegistros <= nList.getLength()) {
                    System.out.println(";;");
                }
                //Hacemos un sout de cada uno de los atributos de cada producto que recorre el for
                Element eElement = (Element) node;
                System.out.println("ID Producto: " + eElement.getAttribute("id"));
                System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Características: " + eElement.getElementsByTagName("caracteristicas").item(0).getTextContent());
                System.out.println("Materiales de la Base y el Pie: " + eElement.getElementsByTagName("materialBasePie").item(0).getTextContent());
                System.out.println("Reposapiés: " + eElement.getElementsByTagName("reposapies").item(0).getTextContent());
                System.out.println("Protección: " + eElement.getElementsByTagName("antideslizate").item(0).getTextContent());
                System.out.println("Acabados: " + eElement.getElementsByTagName("acabados").item(0).getTextContent());
                System.out.println("Tipo de Asiento: " + eElement.getElementsByTagName("tipoAsiento").item(0).getTextContent());
                System.out.println("Altura Total: " + eElement.getElementsByTagName("alturaTotal").item(0).getTextContent());
                System.out.println("Asiento: " + eElement.getElementsByTagName("asiento").item(0).getTextContent());
                System.out.println("Base: " + eElement.getElementsByTagName("base").item(0).getTextContent());
                System.out.println("Distancia Reposapiés - Asiento: " + eElement.getElementsByTagName("distancia").item(0).getTextContent());
                System.out.println("Pie: " + eElement.getElementsByTagName("pie").item(0).getTextContent());
                System.out.println("Peso: " + eElement.getElementsByTagName("peso").item(0).getTextContent());
                System.out.println("Materiales: " + eElement.getElementsByTagName("materiales").item(0).getTextContent());
            }

            if (contadorRegistros == nList.getLength()) {
                System.out.println(";;;;");
            }

        }

    }
}
