package repaso.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

    /* HAY QUE IR TRABAJANDO CON LAS EXCEPCIONES */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fichero = new File("C:\\Users\\FP\\Desktop\\fichero.txt");

        //Comprobamos que exista el fichero
        if (!fichero.exists()) {
            System.out.println("El fichero NO existe");
        } else {
            System.out.println("El fichero existe");
            FileReader lectura = new FileReader(fichero);
            BufferedReader texto = new BufferedReader(lectura);

            String lineas;
            String parrafos;
            String caracteres;
            String palabras;

            int contadorPalabras = 0;
            int contadorCaracteres = 0;
            int contadorParrafos = 0;
            int contadorLineas = 0;

            while ((lineas = texto.readLine()) != null) {
                contadorParrafos++;
                contadorCaracteres = contadorCaracteres + lineas.length();

                for (int i = 0; i < lineas.length(); i++) {

                    if (lineas.charAt(i) == ' ') {
                        contadorPalabras++;
                    }

                    contadorLineas = (lineas.length()/95 + 1);

                }
            }

            System.out.println("Contador de lineas: " + contadorLineas);
            System.out.println("Contador de parrafos: " + contadorParrafos);
            System.out.println("Contador de palabras: " + contadorPalabras);
            System.out.println("Contador de caracteres: " + contadorCaracteres);
            System.out.println("Contador de caracteres sin espacios: " + (contadorCaracteres - contadorPalabras));

        }

    }

}
