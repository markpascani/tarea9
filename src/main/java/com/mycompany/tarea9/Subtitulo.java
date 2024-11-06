/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea9;

/**
 *
 * @author alumno
 */
public class Subtitulo {
    private int numero;
    private String inicio;
    private String fin;
    private String texto;

    public Subtitulo(int numero, String inicio, String fin, String texto) {
        this.numero = numero;
        this.inicio = inicio;
        this.fin = fin;
        this.texto = texto;
    }

    public Subtitulo() {
    }
    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
