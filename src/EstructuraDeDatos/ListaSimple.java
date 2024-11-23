/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author jesus
 */
public class ListaSimple {
    public NodoSL pFirst;
    private NodoSL pLast;

    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
    }

    public void insertar(Integrante integrante) {
        NodoSL nuevoNodo = new NodoSL(integrante);
        if (pFirst == null) {
            pFirst = nuevoNodo;
            pLast = nuevoNodo;
        } else {
            pLast.pNext = nuevoNodo;
            pLast = nuevoNodo;
        }
    }

    public Integrante buscar(String nombreCompleto) {
        NodoSL actual = pFirst;
        while (actual != null) {
            if (actual.integrante.nombreCompleto.equals(nombreCompleto)) {
                return actual.integrante;
            }
            actual = actual.pNext;
        }
        return null;
    }

    public void imprimir() {
        NodoSL actual = pFirst;
        while (actual != null) {
            System.out.println(actual.integrante.nombreCompleto);
            actual = actual.pNext;
        }
    }
    
}