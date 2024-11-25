/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EstructuraDeDatos;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author aaron
 */
public class Opciones extends javax.swing.JFrame {

    public static ArbolFamiliar tree;

    /**
     * Creates new form Opciones
     */
    public Opciones(ArbolFamiliar tree) {
        initComponents();
        this.setVisible(true);

        this.tree = tree;
    }

    public void cargarArchivo(String rutaArchivo) {
        String contenidoJson = obtenerContenidoJson(rutaArchivo);
        if (contenidoJson != null) {
            JsonElement elementoJson = JsonParser.parseString(contenidoJson);
            analizarJson(elementoJson);
        }
    }

    public static String obtenerContenidoJson(String ruta) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contenido.append(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            return null;
        }
        return contenido.toString();
    }

    public void analizarJson(JsonElement elementoJson) {
        if (elementoJson.isJsonObject()) {
            JsonObject objetoJson = elementoJson.getAsJsonObject();
            for (String casa : objetoJson.keySet()) {
                JsonArray listaPersonajes = objetoJson.getAsJsonArray(casa);
                for (JsonElement elementoPersonaje : listaPersonajes) {
                    JsonObject personajeJson = elementoPersonaje.getAsJsonObject();

                    String nombreCompleto = personajeJson.keySet().iterator().next();
                    JsonArray arrayDetalles = personajeJson.getAsJsonArray(nombreCompleto);
                    JsonObject detallesPersonaje = new JsonObject();

                    for (JsonElement elementoDetalle : arrayDetalles) {
                        JsonObject detalleJson = elementoDetalle.getAsJsonObject();
                        for (String clave : detalleJson.keySet()) {
                            detallesPersonaje.add(clave, detalleJson.get(clave));
                        }
                    }

                    // Atributos requeridos
                    String numeral = "Desconocido";
                    String padre = "Desconocido";
                    String colorOjos = "Desconocido";
                    String colorCabello = "Desconocido";

                    numeral = obtenerValor(detallesPersonaje, "Of his name", numeral);
                    padre = obtenerValor(detallesPersonaje, "Born to", padre);
                    colorOjos = obtenerValor(detallesPersonaje, "Of eyes", colorOjos);
                    colorCabello = obtenerValor(detallesPersonaje, "Of hair", colorCabello);

                    // Atributos opcionales
                    String mote = "Desconocido";
                    String titulo = "Desconocido";
                    String esposa = "Desconocido";
                    String notas = "Desconocido";
                    String destino = "Desconocido";

                    mote = obtenerValor(detallesPersonaje, "Known throughout as", mote);
                    titulo = obtenerValor(detallesPersonaje, "Held title", titulo);
                    esposa = obtenerValor(detallesPersonaje, "Wed to", esposa);
                    notas = obtenerValor(detallesPersonaje, "Notes", notas);
                    destino = obtenerValor(detallesPersonaje, "Fate", destino);

                    // Agregar a la estructura de datos
                    Integrante nuevoIntegrante = new Integrante(nombreCompleto + ", " + numeral + " of his name", numeral + " Of His Name", padre, colorOjos, colorCabello);
                    nuevoIntegrante.conocidoComo = mote;
                    nuevoIntegrante.destino = destino;
                    nuevoIntegrante.esposa = esposa;
                    nuevoIntegrante.notas= notas;
                    nuevoIntegrante.tituloNobiliario = titulo;
                    tree.agregarIntegrante(nuevoIntegrante, padre);
                }
            }
        } else {
            System.out.println("El contenido no es un objeto JSON válido.");
        }
    }

    private String obtenerValor(JsonObject detalles, String clave, String valorPorDefecto) {
        if (detalles.has(clave)) {
            JsonElement elemento = detalles.get(clave);
            if (elemento.isJsonArray() && elemento.getAsJsonArray().size() > 0) {
                return elemento.getAsJsonArray().get(0).getAsString();
            } else if (elemento.isJsonPrimitive()) {
                return elemento.getAsString();
            }
        }
        return valorPorDefecto;
    }

    
    public String buscarArchivoJson() {
        // Crear un JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Establecer el filtro para mostrar solo archivos JSON
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JSON", "json"));

        // Mostrar el cuadro de diálogo para seleccionar el archivo
        int returnValue = fileChooser.showOpenDialog(null);

        // Verificar si se seleccionó un archivo
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath(); // Devolver la ruta absoluta del archivo
        }

        return null; // Si no se seleccionó ningún archivo
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Buscar JSON");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.cargarArchivo(this.buscarArchivoJson());
//        GraphStream g = new GraphStream(this.tree);
//        g.setVisible(true);
        Menu menu = new Menu(tree);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Opciones(tree).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
