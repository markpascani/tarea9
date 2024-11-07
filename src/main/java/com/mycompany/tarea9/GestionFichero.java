/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea9;

import java.io.File;


/**
 *
 * @author alumno
 */
public class GestionFichero {

    private File carpeta;

    public GestionFichero(File carpeta) {
        if(gestionarCarpeta(carpeta)){
            this.carpeta=carpeta;
        }

    }

    private boolean gestionarCarpeta(File carpeta) {
        if (!this.carpeta.exists() || this.carpeta.list().length == 0) {
            System.out.println("No existe esta carpeta o no hay ficheros dentro de ella.");
            return false;
        }
        return true;

    }

    public void generarFicherosXMLCarpeta() {
        if(this.carpeta != null){
            
        }
        return null;
    }
    


}
