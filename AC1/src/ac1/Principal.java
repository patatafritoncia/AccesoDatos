package ac1;

import java.io.File;


public class Principal {

    public static void main(String[] args) {
        File f = new File ("WINDOWS\\fortnite.xml");
        
        System.out.println("Nombre " + f.getName());
        System.out.println("Ruta Absoluta " + f.getAbsolutePath());
        System.out.println("Directorio padre " + f.getParent());
        System.out.println("Directorio padre " + f.getPath());
        
        //usar metodos para saber si existe el fichero y saber si es un directorio
        /*System.out.println("Existe el fichero? " + f.exists());
        System.out.println("Es directorio? " + f.isDirectory());*/
        
        if (f.exists()){
            System.out.println("El fichero existe");
        }else{
            System.out.println("El fichero no existe");
        }
        
        if (f.isDirectory()){
            System.out.println("El fichero es un directorio");
        }else{
            System.out.println("El fichero no es un directorio");
        }
        
        if (f.isFile()){
            System.out.println("Es fichero");
        }else{
            System.out.println("No es fichero");
        }
        
    }
    
}
