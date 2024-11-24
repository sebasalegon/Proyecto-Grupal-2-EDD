/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author sebas
 */
public class HashTableMote {

    private Integrante[] table;
    private int size;

    public HashTableMote(int capacity) {
        this.table = new Integrante[capacity];
        this.size = 0;
    }

    public void insertar(Integrante integrante) {
        if (integrante.conocidoComo != null) {
            int index = hash(integrante.conocidoComo);
            while (table[index] != null) {
                index = (index + 1) % table.length; // Manejo de colisiones lineales
            }
            table[index] = integrante;
            size++;
        }
    }

    public Integrante buscar(String mote) {
        int index = hash(mote);
        while (table[index] != null) {
            if (table[index].conocidoComo.equals(mote)) {
                return table[index];
            }
            index = (index + 1) % table.length; // Buscar en la siguiente posición
        }
        return null; // No encontrado
    }

    private int hash(String mote) {
        return mote.hashCode() % table.length;
    }

    public boolean contiene(String mote) {
        return buscar(mote) != null;
    }
}
