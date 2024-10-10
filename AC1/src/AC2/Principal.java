package AC2;

import java.io.File;


public class Principal {
    public static void main(String[] args) {
        //Programa que me diga si tengo java instalado
        File f = new File ("C:\\Program Files\\Java\\jdk-21");
        File f2 = new File("C:\\Program Files\\Java\\jdk-22");
        
        if (f.exists()){
            System.out.println("Existe y es la version 21");
        }else{
            System.out.println("No existe y no puedo confirmar que tengas java 21");
        }
        
        System.out.println("\n");
        
        if (f2.exists()){
            System.out.println("Existe y es la version 22");
        }else{
            System.out.println("No existe y no puedo comfirmar que tengas java 22");
        }
    }
    
}
