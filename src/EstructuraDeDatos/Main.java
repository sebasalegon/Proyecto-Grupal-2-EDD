/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructuraDeDatos;

/**
 *
 * @author sebas/jesus/aaron
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herepublic class Main {
        ArbolFamiliar arbol = new ArbolFamiliar(100);
        Opciones opciones = new Opciones();
        opciones.setVisible(true);
        arbol = opciones.tree;

        // Agregar algunos integrantes (ejemplo)
//        Integrante integrante1 = new Integrante("William I", "1", null, "Azul", "Rubio");
//        Integrante integrante2 = new Integrante("William II", "2", "William I", "Verde", "Castaño");
//        Integrante integrante3 = new Integrante("Elizabeth I", "1", "Henry VIII", "Marrón", "Rojo");
//        Integrante integrante4 = new Integrante("Henry VIII", "1", null, "Azul", "Castaño");

//        arbol.agregarIntegrante(integrante1, null); // Raíz
//        arbol.agregarIntegrante(integrante2, "William I");
//        arbol.agregarIntegrante(integrante3, "Henry VIII");
//        arbol.agregarIntegrante(integrante4, "Henry VIII");

        // 2. Ver Registro
        System.out.println("Registro de William I: " + arbol.verRegistro("William I").nombreCompleto);

        // 3. Buscar por Nombre
        System.out.println("Buscar por nombre 'William': "  );
        arbol.buscarPorNombre("William").imprimir();

        // 4. Mostrar Antepasados
        System.out.println("Antepasados de William II: " );
        arbol.mostrarAntepasados("William II").imprimir();

        // 5. Buscar por Título
        System.out.println("Buscar por título 'Rey': " );
        arbol.buscarPorTitulo("Rey").imprimir();

        // 6. Lista de integrantes de una generación
        System.out.println("Integrantes de la generación 1: " );
        arbol.listaIntegrantesPorGeneracion(1).imprimir();

    }

}
