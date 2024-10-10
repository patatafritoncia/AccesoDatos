/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Curso_JSON;

/**
 *
 * @author FP
 */
public class UsuarioAvanzado {
    private String id;
    private String nombre;
    private String horas;
    private String notas;

    public UsuarioAvanzado(String id, String nombre, String horas, String notas) {
        this.id = id;
        this.nombre = nombre;
        this.horas = horas;
        this.notas = notas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHoras() {
        return horas;
    }

    public String getNotas() {
        return notas;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    
    
    
}
