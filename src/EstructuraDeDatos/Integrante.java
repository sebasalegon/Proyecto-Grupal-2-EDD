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

public class Integrante {
    // Atributos obligatorios
    public String nombreCompleto;
    public int ofHisName;
    public String bornToFather;
    public String bornToMother;
    public String ofEyes;
    public String ofHair;

    // Atributos opcionales
    public String conocidoComo;
    public String tituloNobiliario;
    public String esposa;
    public ListaSimple hijos;
    public String notas;
    public String destino;

    // Constructor
    public Integrante(String nombreCompleto, int ofHisName, String bornToFather, String ofEyes, String ofHair) {
        this.nombreCompleto = nombreCompleto;
        this.ofHisName = ofHisName;
        this.bornToFather = bornToFather;
        this.ofEyes = ofEyes;
        this.ofHair = ofHair;
        this.hijos = new ListaSimple();
    }
}