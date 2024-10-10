/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosconfiguracion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author FP
 */
public class Lectura {
     public static void main(String[] args) throws IOException {
        String miUsuario, miContrasena, elServidor;
        Integer elPuerto;
        
        Properties configuration = new Properties();
        
        
        try{
            configuration.load(new FileInputStream("config.pass"));
            miUsuario = configuration.getProperty("user");
            miContrasena = configuration.getProperty("password");
            elServidor = configuration.getProperty("server");
            elPuerto = Integer.valueOf(configuration.getProperty("port"));
            
            System.out.println(miUsuario);
            System.out.println(miContrasena);
            System.out.println(elServidor);
            System.out.println(elPuerto);
            
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        
        
    }
}
