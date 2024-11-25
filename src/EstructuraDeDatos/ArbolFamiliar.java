/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author jesus
 */
public class ArbolFamiliar {

    public NodoFT root;
    public HashTable hashTable;

    public ArbolFamiliar(int hashTableCapacity) {
        this.root = null;
        this.hashTable = new HashTable(hashTableCapacity);
    }

    // Método para agregar un integrante al árbol
    public void agregarIntegrante(Integrante integrante, String nombrePadre) {
        // Agregar a la tabla hash usando el nombre completo
        hashTable.insertar(integrante);

        // Si el árbol está vacío, el nuevo integrante se convierte en la raíz
        if (root == null) {
            root = new NodoFT(integrante, null);
        } else {
            // Buscar el padre en el árbol
            NodoFT padre = buscarPadre(nombrePadre, root);
            if (padre != null) {
                // Agregar el hijo al padre
                agregarHijo(padre, integrante);
            } else {
                padre = buscarIntegrantePorMote(nombrePadre, root);
            if (padre != null) {
                // Agregar el hijo al padre
                agregarHijo(padre, integrante);
            } else {
                System.out.println("Padre no encontrado: " + nombrePadre);
            }
            }
        }
    }

    private void agregarHijo(NodoFT padre, Integrante hijo) {
        for (int i = 0; i < padre.sons.length; i++) {
            if (padre.sons[i] == null) {
                padre.sons[i] = new NodoFT(hijo, padre);
                return;
            }
        }
        System.out.println("El padre ya tiene el número máximo de hijos.");
    }

    // Método para buscar un integrante por su nombre completo
    private NodoFT buscarIntegrantePorNombre(String nombreCompleto, NodoFT nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.integrante.nombreCompleto.equals(nombreCompleto)) {
            return nodo;
        }
        for (NodoFT hijo : nodo.sons) {
            NodoFT resultado = buscarIntegrantePorNombre(nombreCompleto, hijo);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }
    
    public NodoFT buscarIntegrantePorMote(String nombreCompleto, NodoFT nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.integrante.conocidoComo.equals(nombreCompleto) || nodo.integrante.nombreCompleto.equals(nombreCompleto)) {
            return nodo;
        }
        for (NodoFT hijo : nodo.sons) {
            NodoFT resultado = buscarIntegrantePorMote(nombreCompleto, hijo);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }
    
    
    
    public NodoFT buscarPadre(String nombre, NodoFT nodo){
        if (nodo == null) {
            return null;
        }
                System.out.println(nombre + "    +-+-+-+-+-+    " + nodo.integrante.nombreCompleto);

        if (nodo.integrante.nombreCompleto.equals(nombre)) {
            return nodo;
        }
        for (NodoFT hijo : nodo.sons) {
            NodoFT resultado = buscarPadre(nombre, hijo);
            if (resultado != null) {
                return resultado;
            }
        }
        return null;
    }

    // 2. Ver Registro
    public Integrante verRegistro(String nombreCompleto) {
        return hashTable.buscar(nombreCompleto);
    }

    // 3. Buscar por Nombre
    public ListaSimple buscarPorNombre(String nombre) {
        ListaSimple listaResultados = new ListaSimple();
        buscarIntegrantesPorNombre(nombre, root, listaResultados);
        return listaResultados;
    }

    private void buscarIntegrantesPorNombre(String nombre, NodoFT nodo, ListaSimple lista) {
        if (nodo == null) {
            return;
        }
        if (nodo.integrante.nombreCompleto.contains(nombre)) {
            lista.insertar(nodo.integrante);
        }
        for (NodoFT hijo : nodo.sons) {
            if (hijo != null) {
                buscarIntegrantesPorNombre(nombre, hijo, lista);
            }
        }
    }

   // 4. Mostrar Antepasados
public ListaSimple mostrarAntepasados(String nombreCompleto) {
    ListaSimple listaAntepasados = new ListaSimple();
    NodoFT nodo = buscarIntegrantePorNombre(nombreCompleto, root);
    if (nodo != null) {
        buscarAntepasados(nodo, listaAntepasados);
    }
    return listaAntepasados;
}

// Método auxiliar que busca antepasados a partir de un nodo
private void buscarAntepasados(NodoFT nodo, ListaSimple lista) {
    // Mientras haya un padre, agrega a la lista
    while (nodo.father != null) {
        lista.insertar(nodo.father.integrante);
        nodo = nodo.father; // Moverse al padre
    }
}

    // 5. Buscar por Título
    public ListaSimple buscarPorTitulo(String titulo) {
        ListaSimple listaResultados = new ListaSimple();
        return buscarIntegrantesPorTitulo(titulo, root, listaResultados);
        
    }

    private ListaSimple buscarIntegrantesPorTitulo(String titulo, NodoFT nodo, ListaSimple lista) {
        if (nodo == null) {
            return lista;
        }
        if(nodo.integrante.tituloNobiliario != null){
        System.out.println(nodo.integrante.tituloNobiliario  + "  /////////////////  " + titulo);}
        if (nodo.integrante.tituloNobiliario != null && nodo.integrante.tituloNobiliario.equals(titulo)) {
            lista.insertar(nodo.integrante);
        }
        for (NodoFT hijo : nodo.sons) {
            if (hijo != null) {
                lista = buscarIntegrantesPorTitulo(titulo, hijo, lista);
            }
        }
        return lista;
    }

    // 6. Lista de integrantes de una generación
    public ListaSimple listaIntegrantesPorGeneracion(int generacion) {
        ListaSimple listaResultados = new ListaSimple();
        obtenerIntegrantesPorGeneracion(root, 0, generacion, listaResultados);
        return listaResultados;
    }

    private void obtenerIntegrantesPorGeneracion(NodoFT nodo, int nivelActual, int generacion, ListaSimple lista) {
        if (nodo == null) {
            return;
        }
        if (nivelActual == generacion) {
            lista.insertar(nodo.integrante);
        }
        for (NodoFT hijo : nodo.sons) {
            if (hijo != null) {
                obtenerIntegrantesPorGeneracion(hijo, nivelActual + 1, generacion, lista);
            }
        }
    }
}
