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
    
    // Métodos para agregar atributos opcionales
    public void setConocidoComo(String conocidoComo) {
        this.conocidoComo = conocidoComo;
    }

    public void setTituloNobiliario(String tituloNobiliario) {
        this.tituloNobiliario = tituloNobiliario;
    }

    public void setEsposa(String esposa) {
        this.esposa = esposa;
    }

    public void agregarHijo(Integrante hijo) {
        this.hijos.insertar(hijo);
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    // Método para mostrar información
    public void mostrarInfo() {
        System.out.println("Nombre Completo: " + nombreCompleto);
        System.out.println("Of his name: " + ofHisName);
        System.out.println("Born to (Father): " + bornToFather);
        System.out.println("Of eyes: " + ofEyes);
        System.out.println("Of hair: " + ofHair);
        
        if(bornToMother != null){System.out.println("Born to (Mother): " + bornToMother);}

        if(conocidoComo != null){System.out.println("Known throughout as: " + conocidoComo);}
        if(tituloNobiliario != null){System.out.println("Held title: " + tituloNobiliario);}
        if(esposa != null){System.out.println("Wed to: " + (esposa != null ? esposa : "N/A"));}
        if(hijos.pFirst != null){System.out.print("Father to: ");}
//        if (hijos.isEmpty()) {
//            System.out.println("N/A");
//        } else {
////            System.out.println(hijos);
//        }
        if(notas != null){System.out.println("Notes: " + notas);}
        if(destino != null){System.out.println("Fate: " + destino);}
    }

}

