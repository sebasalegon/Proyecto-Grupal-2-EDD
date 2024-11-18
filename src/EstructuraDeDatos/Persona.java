/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author sebas
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a una persona en el árbol genealógico.
 */
public class Persona {
    private String nombreCompleto; // Nombre completo de la persona
    private String numeral; // Numeral asociado a la persona
    private String padre; // Nombre del padre
    private String mote; // Mote único
    private String tituloNobiliario; // Título nobiliario de la persona
    private List<String> hijos; // Lista de nombres de los hijos
    private String notas; // Notas sobre la vida de la persona
    private String destino; // Comentarios sobre la muerte de la persona

    /**
     * Constructor de la clase Persona.
     *
     * @param nombreCompleto Nombre completo de la persona.
     * @param numeral Numeral asociado a la persona.
     * @param padre Nombre del padre.
     * @param mote Mote único de la persona.
     * @param tituloNobiliario Título nobiliario de la persona.
     * @param hijos Lista de nombres de los hijos.
     * @param notas Notas sobre la vida de la persona.
     * @param destino Comentarios sobre la muerte de la persona.
     */
    public Persona(String nombreCompleto, String numeral, String padre, String mote, 
                   String tituloNobiliario, List<String> hijos, String notas, String destino) {
        this.nombreCompleto = nombreCompleto; // Inicializa el nombre completo
        this.numeral = numeral; // Inicializa el numeral
        this.padre = padre; // Inicializa el padre
        this.mote = mote; // Inicializa el mote
        this.tituloNobiliario = tituloNobiliario; // Inicializa el título nobiliario
        this.hijos = hijos != null ? hijos : new ArrayList<>(); // Inicializa la lista de hijos
        this.notas = notas; // Inicializa las notas
        this.destino = destino; // Inicializa el destino
    }

    // Métodos getter
    public String getNombreCompleto() {
        return nombreCompleto; // Retorna el nombre completo
    }

    public String getMote() {
        return mote; // Retorna el mote
    }

    public List<String> getHijos() {
        return hijos; // Retorna la lista de hijos
    }

    public String getPadre() {
        return padre; // Retorna el nombre del padre
    }

    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto + ", Mote: " + mote + ", Título: " + tituloNobiliario; // Representación en cadena
    }
}

