/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Libreria_JSON;

import org.json.*;

/**
 *
 * @author FP
 */
public class Principal {

    public static void main(String[] args) {
        // crear usuarios
        UsuarioAvanzado usuario1 = new UsuarioAvanzado("Jude Bellingham",21);
        UsuarioAvanzado usuario2 = new UsuarioAvanzado("Kylian Mbappé",25);
        
        // Crear proyecto con participantes
        Proyecto proyecto = new Proyecto("Copa de Europa 24/25");
        proyecto.agregarParticipante(usuario1);
        proyecto.agregarParticipante(usuario2);
        
        // Convertir el proyecto a un JSONObject
        JSONObject jsonProyecto = new JSONObject ();
        jsonProyecto.put("nombre", proyecto.getNombre());
        
        JSONArray jsonParticipantes = new JSONArray();
        for(UsuarioAvanzado participante : proyecto.getParticipantes()){
            JSONObject jsonParticipante = new JSONObject();
            
            jsonParticipante.put("nombre", participante.getNombre());
            jsonParticipante.put("edad", participante.getEdad());
            
            jsonParticipantes.put(jsonParticipante);
        }
        jsonProyecto.put("participantes", jsonParticipantes);
        
        // Escritura EN UN ARCHIVO JSON
        try{
            java.nio.file.Files.write(java.nio.file.Paths.get("proyecto.json"), jsonProyecto.toString().getBytes());
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
        
        
        // Leer de un archivo Json
        try{
            String contenido = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("proyecto.json")));
            JSONObject jsonLeido = new JSONObject (contenido);
            
            //Recuperar datos del proyecto
            String nombreProyecto = jsonLeido.getString("nombre");
            JSONArray jsonParticipantesLeidos = jsonLeido.getJSONArray("participantes");
            
            //Crear el proyecto con los datos leidos
            Proyecto proyectoLeido = new Proyecto(nombreProyecto);
            
            //Agregar participantes al proyecto
            for (int i = 0; i < jsonParticipantesLeidos.length(); i++) {
                JSONObject jsonParticipante = jsonParticipantesLeidos.getJSONObject(i);
                String nombreParticipante = jsonParticipante.getString("nombre");
                int edadParticipante = jsonParticipante.getInt("edad");
                
                UsuarioAvanzado participanteLeido = new UsuarioAvanzado(nombreParticipante, edadParticipante);
                
                //Agrego al ArrayList
                proyectoLeido.agregarParticipante(participanteLeido);
                
                //Realizar operaciones con el proyecto leido
                System.out.println("Proyecto. " + proyectoLeido);
                System.out.println("Participantes: ");
                
                //Muestro el arraylist
                for(UsuarioAvanzado participante : proyectoLeido.getParticipantes()){
                    System.out.println("- " + participante.getNombre() + ", Edad " + participante.getEdad());
                }
            }
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
    
    }

}
