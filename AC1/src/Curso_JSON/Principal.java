/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Curso_JSON;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) {
        // crear usuarios
        UsuarioAvanzado usuario1 = new UsuarioAvanzado("1","Acceso a Datos","6","4.5");
        UsuarioAvanzado usuario2 = new UsuarioAvanzado("2","PSP","4","4.5");
        
        // Crear proyecto con participantes
        Curso curso = new Curso("DAM");
        curso.agregarModulos(usuario1);
        curso.agregarModulos(usuario2);
        
        // Convertir el proyecto a un JSONObject
        JSONObject jsonProyecto = new JSONObject ();
        jsonProyecto.put("nombre", curso.getNombre());
        
        JSONArray jsonModulos = new JSONArray();
        for(UsuarioAvanzado mod : curso.getModulos()){
            JSONObject jsonModulo = new JSONObject();
            
            jsonModulo.put("id", mod.getId());
            jsonModulo.put("nombre", mod.getNombre());
            jsonModulo.put("horas", mod.getHoras());
            jsonModulo.put("notas", mod.getNotas());
            
            
            jsonModulos.put(jsonModulo);
        }
        jsonProyecto.put("modulos", jsonModulos);
        
        // eSCRIBIR EN UN ARCHIVO JSON
        try{
            java.nio.file.Files.write(java.nio.file.Paths.get("curso.json"), jsonProyecto.toString().getBytes());
        }catch (java.io.IOException e){
            e.printStackTrace();
        }
    
    }
}
