/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso.filewriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class RepasoFileWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        File fichero = new File("C:\\Users\\FP\\Desktop\\plantilla.txt");
        FileReader lectura = new FileReader(fichero);
        String linea;

        String nombre = teclado.next();
        String apellido = teclado.next();
        String jefe = teclado.next();
        String departamento = teclado.next();

        //Comprobamos que exista el fichero
        if (!fichero.exists()) {
            System.out.println("El fichero NO existe");
        } else {
            System.out.println("El fichero existe");
            FileWriter escritura = new FileWriter("C:\\Users\\FP\\Desktop\\carta.txt");

            BufferedReader cursor = new BufferedReader(lectura);

            while ((linea = cursor.readLine()) != null) {
                
                linea = linea.replace("$nombre", nombre);
                linea = linea.replace("$apellido", apellido);
                linea = linea.replace("$jefe", jefe);
                linea = linea.replace("$departamento", departamento);
                
                escritura.write(linea);
                escritura.write("\n");

            }
            escritura.close();
            cursor.close();
        }
        lectura.close();

    }
}
