/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ficherosconfiguracion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author FP
 */
public class Escritura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String miUsuario = "root";
        String miContrasena = "p@ssw0rd";
        String elServidor = "goldengate.tk";
        String elPuerto = "3306";
        
        
        Properties configuration = new Properties();
        configuration.setProperty("user", miUsuario);
        configuration.setProperty("password", miContrasena);
        configuration.setProperty("server", elServidor);
        configuration.setProperty("port", elPuerto);
        
        try{
            configuration.store(new FileOutputStream("config.pass"), "Fichero de configuración");
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        
        
    }
    
}
