/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea9;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author alumno
 */
public class TransformadorSRTaXML {

    private File ficheroSRT;
    private final File ficheroXML = new File("subtitulos.xml");
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

    public void crearFicheroXML(List<Subtitulo> subtitulos) throws IOException {
        if(!ficheroXML.exists()){
            ficheroXML.createNewFile();
            System.out.println("Fichero XML vacío creado.");
        }
        
        
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation impl = builder.getDOMImplementation();
            Document documento = impl.createDocument(null, "subtitulos", null);
            
            Element root = documento.getDocumentElement();
            
            
            for(Subtitulo subtitulo: subtitulos){
                crearNodoSubtitulo(documento, subtitulo, root);
            }
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new FileWriter(ficheroXML));
            
            transformer.transform(source, result);
            
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }

    private void crearNodoSubtitulo(Document documento, Subtitulo subtitulo, Element root) throws DOMException {
        Element subti = documento.createElement("subtitulo");
        Text texto = documento.createTextNode(subtitulo.getTexto());
        subti.appendChild(texto);
        subti.setAttribute("numero", String.valueOf(subtitulo.getNumero()));
        subti.setAttribute("inicio", subtitulo.getInicio());
        subti.setAttribute("fin", subtitulo.getFin());
        root.appendChild(subti);
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        TransformadorSRTaXML transf = new TransformadorSRTaXML(sc);
        
        transf.solicitarRutaFicheroSRT("Escribe la ruta del fichero .srt. ");
        GestionSubtitulos gestion = new GestionSubtitulos(transf.getFicheroSRT());
        
        try {
            transf.crearFicheroXML(gestion.getSubtitulo());
        } catch (IOException ex) {
            Logger.getLogger(TransformadorSRTaXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
