/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea9;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

/**
 *
 * @author alumno
 */
public class TransformadorSRTaXML {

    private File ficheroSRT;
    private File ficheroXML;
    private Scanner sc;

    /**
     * Constructor vacío del Transformador srt a xml
     */
    public TransformadorSRTaXML(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Getter del fichero SRT
     *
     * @return
     */
    public File getFicheroSRT() {
        return ficheroSRT;
    }

    /**
     * Setter del fichero SRT
     *
     * @param ficheroSRT
     */
    public void setFicheroSRT(File ficheroSRT) {
        this.ficheroSRT = ficheroSRT;
    }

    /**
     * Getter del fichero XML
     *
     * @return
     */
    public File getFicheroXML() {
        return ficheroXML;
    }

    /**
     * Setter del fichero XML
     *
     * @param ficheroXML
     */
    public void setFicheroXML(File ficheroXML) {
        this.ficheroXML = ficheroXML;
    }

    /**
     * Método que pregunta al usuario la ruta del fichero srt y crea una
     * instancia del fichero para el getter.
     *
     * @param mensaje
     * @return ruta del fichero con el que se va a trabajar
     */
    public void solicitarRutaFicheroSRT(String mensaje) {
        System.out.println(mensaje);
        String ruta;
        while (true) {
            ruta = sc.nextLine().trim();

            if (ruta.endsWith(".srt")) {
                this.ficheroSRT = new File(ruta);
                if (!this.ficheroSRT.exists()) {
                    System.out.println("El fichero no existe.");
                } else {
                    break;
                }

            } else {
                System.out.println("Tiene que ser un fichero acabado en .srt.Prueba de nuevo.");
            }
        }
    }

    public void crearFicheroXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation impl = builder.getDOMImplementation();
            Document documento = impl.createDocument(null, "subtitulos", null);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();

        }

    }

}
