/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Corregido;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author FP
 */
public class Principal {
     public static void main(String[] args) throws FileNotFoundException, IOException {
        File fichero = new File("C:\\Users\\FP\\Desktop\\fichero.txt");

        //Comprobamos que exista el fichero
        if (!fichero.exists()) {
            System.out.println("El fichero NO existe");
        } else {
            System.out.println("El fichero existe");
            FileReader lectura = new FileReader(fichero);
            BufferedReader texto = new BufferedReader(lectura);


            String parrafo;
            String parrafoSin;
            
            int contadorCaracteres = 0;
            int caracteresSin = 0;
            int veces = 0;
            double lineasD = 0.0;
            
            
            int contadorPalabras = 0;
            int contadorLineas = 0;
            
            while ((parrafo = texto.readLine()) != null) {
                veces++;
                contadorCaracteres += parrafo.length();
                
                //Trabajo con parrafo sin 
                parrafoSin = parrafo;
                parrafoSin = parrafoSin.replace(" ", "");
                caracteresSin +=parrafoSin.length();
                
                
            }
            
            // Contar lineas hacia arriba
            lineasD = (double) contadorCaracteres / 95;
            int lineasFinal = (int) Math.ceil(lineasD);

            
            System.out.println("Contador de parrafos: " + veces);
            System.out.println("Contador de caracteres: " + contadorCaracteres);
            System.out.println("Contador de caracteres sin espacios: " + (caracteresSin));
            System.out.println("Contador de lineas: " + lineasFinal);
            System.out.println("Contador de palabras: " + contadorPalabras);

        }

    }

}
