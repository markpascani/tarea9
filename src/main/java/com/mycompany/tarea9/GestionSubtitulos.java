/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea9;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class GestionSubtitulos {

    private List<Subtitulo> subtitulo;
    private File ficheroSRT;

    public GestionSubtitulos(File ficheroSRT) {
        this.ficheroSRT = ficheroSRT;
        this.subtitulo = leerFicheroSRT();
    }

    private List<Subtitulo> leerFicheroSRT() {
        List<Subtitulo> subtitulos = new ArrayList<Subtitulo>();
        String linea;

        try (BufferedReader reader = new BufferedReader(new FileReader(ficheroSRT))) {
            while ((linea = reader.readLine()) != null) {
                try {
                    // Asegurarse de que la línea no esté vacía antes de procesarla
                    if (linea.trim().isEmpty()) {
                        continue; // Saltar a la siguiente línea si está vacía
                    }
                    //Leer el número de subtítulo
                    int numero = Integer.parseInt(linea);

                    //Leer el tiempo de inicio y fin
                    String[] tiempo = reader.readLine().split("-->");
                    String inicio = tiempo[0].trim();
                    String fin = tiempo[1].trim();

                    //Leer el texto de subtítulo
                    StringBuilder texto = new StringBuilder();
                    while ((linea = reader.readLine()) != null && !linea.isEmpty()) {
                        texto.append(linea);
                    }

                    Subtitulo subtitulo = new Subtitulo(numero, inicio, fin, texto.toString());
                    subtitulos.add(subtitulo);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Formato incorrecto en el archivo SRT.");
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return subtitulos;
    }

    public List<Subtitulo> getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(List<Subtitulo> subtitulo) {
        this.subtitulo = subtitulo;
    }

    public File getFicheroSRT() {
        return ficheroSRT;
    }

    public void setFicheroSRT(File ficheroSRT) {
        this.ficheroSRT = ficheroSRT;
    }

}
