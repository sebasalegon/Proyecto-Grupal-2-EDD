/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2gonzalez;

/**
 *
 * @author Aaron
 */
public class NodoFT {
    Integrante integrante;
    NodoFT[] sons;
    NodoFT father;

    public NodoFT(Integrante integrante, NodoFT father) {
        this.integrante = integrante;
        this.father = father;
        this.sons = new NodoFT[10];
    }
}