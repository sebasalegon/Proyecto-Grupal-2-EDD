/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author sebas
 */
public class HashTable {

    private Integrante[] table;
    private int size;

    public HashTable(int capacity) {
        this.table = new Integrante[capacity];
        this.size = 0;
    }

    public void insertar(Integrante integrante) {
        if (integrante.nombreCompleto != null) {
            int index = hash(integrante.nombreCompleto);
            if (index < 0) {
                index *= -1;
            }
            while (table[index] != null) {
                index = (index + 1) % table.length; // Manejo de colisiones lineales
            }
            table[index] = integrante;
            size++;
        }
    }

    public Integrante buscar(String nombreCompleto) {
        int index = hash(nombreCompleto);
        if (index < 0) {
            index *= -1;
        }

        while (table[index] != null) {
            if (table[index].nombreCompleto.equals(nombreCompleto)) {
                return table[index];
            }
            index = (index + 1) % table.length; // Buscar en la siguiente posición
        }
        return null; // No encontrado
    }

    private int hash(String nombreCompleto) {
        return nombreCompleto.hashCode() % table.length;
    }

    public boolean contiene(String nombreCompleto) {
        return buscar(nombreCompleto) != null;
    }
}

