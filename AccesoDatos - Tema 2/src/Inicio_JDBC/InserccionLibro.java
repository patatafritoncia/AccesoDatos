/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Inicio_JDBC;

import java.sql.*;

/**
 *
 * @author FP
 */
public class InserccionLibro {

    private static final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "root";
    private static final String password = "fp.2023";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(url, user, password); Statement sentencia = con.createStatement()) {
            System.out.println("Conexión correcta");

            // Insertar Libro
            String isbn = "123";
            String titulo = "";
            Integer numeroEjemplares = 0;
            String nomAutor = "";
            String nomEditorial = "";
            String nomTema = "";

            // Comprobar datos del libro con ResultSet
            String selectLibro = "SELECT * FROM Libro WHERE isbn = " + isbn + ";";
            ResultSet cursor = sentencia.executeQuery(selectLibro);

            if (cursor.next()) {
                System.out.println("El libro ya existe");
                // Hacemos metodo visualizar para ver todos los libros

            } else {
                // No existe y hay que dar de alta el libro
                System.out.println("El libro no existe. Dar de alta: ");
                visualizarLibros();
                // Como el libro no existe hay que darlo de alta
                
                
                
            }

        } catch (SQLException e) {
            System.out.println("Conexión incorrecta: " + e.getMessage());
        }
    }

    public static void visualizarLibros() { // Tiene que ser static
        try (Connection con = DriverManager.getConnection(url, user, password); Statement sentencia = con.createStatement()) {

            String selectLibro = "SELECT * FROM Libro NATURAL JOIN (Autor, Editorial, Tema);";
            ResultSet sentenciaSelect = sentencia.executeQuery(selectLibro);

            while (sentenciaSelect.next()) {
                System.out.println(sentenciaSelect.getString("ISBN") + " ");
                System.out.println(sentenciaSelect.getString("titulo") + " ");
                System.out.println(sentenciaSelect.getInt("numeroejemplares") + " ");
                System.out.println(sentenciaSelect.getString("nombreAutor") + " ");
                System.out.println(sentenciaSelect.getString("nombreEditorial") + " ");
                System.out.println(sentenciaSelect.getString("direccion") + " ");
                System.out.println(sentenciaSelect.getString("telefono") + " ");
                System.out.println(sentenciaSelect.getString("nombreTema") + " ");
                System.out.println("");
                System.out.println("============================================");
            }

        } catch (SQLException ei) {
            System.out.println("Conexión incorrecta: " + ei.getMessage());
        }
    }

}




          /*  // Insertar Autor
            String insertarAutor = "INSERT INTO Autor VALUES (9,\"Nekane Depedroviejo\");";
            try(Statement sentencia = con.createStatement()){
                sentencia.executeUpdate(insertarAutor);
                System.out.println("Datos insertados correctamente");
            }catch(SQLException e){
                System.out.println("Error al insertar datos: " + e.getMessage());
            }
*/
