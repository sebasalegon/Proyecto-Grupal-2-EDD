/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EstructuraDeDatos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

/**
 *
 * @author aaron
 */
public class GraphStreamDescendientes extends javax.swing.JFrame implements ViewerListener {

    static ArbolFamiliar tree;
    static String nombreCompleto;
    static Integrante raiz;
    Graph graph;
    final ViewerPipe fromviewer;

    /**
     * Creates new form GraphStream
     */
    public GraphStreamDescendientes(ArbolFamiliar tree, Integrante raiz) {
        this.tree = tree;
        initComponents();
        this.setVisible(true);
        this.raiz = raiz;
        this.setLocationRelativeTo(null);
        graph = new SingleGraph("ARBOL FAMILIAR");

        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        View view = viewer.addDefaultView(false);
        viewer.getDefaultView().enableMouseOptions();
        GraphStreamPanel.setLayout(new BorderLayout());
        GraphStreamPanel.add((Component) view, BorderLayout.CENTER);
        GraphStreamPanel.setPreferredSize(new Dimension(2060, 1200));
        GraphStreamPanel.setFocusable(true);
        GraphStreamPanel.requestFocusInWindow();
        GraphStreamPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fromviewer = viewer.newViewerPipe();
        fromviewer.addViewerListener(this);
        fromviewer.addSink(graph);

        populateGraph(tree.root, 0, 0, raiz, false);

        PumpViewer();

    }

    private void populateGraph(NodoFT nodo, int x, int y, Integrante raiz, boolean found) {
        boolean f = found;
        if (nodo == null) {
            return;
        } else if (raiz.nombreCompleto.equals(nodo.integrante.nombreCompleto) || found) {
            try {
                f = true;
                String clave = nodo.integrante.nombreCompleto;
                graph.addNode(clave);
                Node node = graph.getNode(clave);
                node.setAttribute("xyz", x, y, 1);
                node.setAttribute("ui.label", nodo.integrante.nombreCompleto);
                node.setAttribute("ui.style", "fill-color: gray; size: 45px; stroke-width: 2px;");
                node.setAttribute("ui.clickable", true);

                if (nodo.father != null) {
                    String clave2 = nodo.father.integrante.nombreCompleto;
                    try {
                        graph.addEdge(clave2 + "-" + clave, clave2, clave);
                    } catch (Exception e) {

                    }
                }
            } catch (Exception e) {

            }
        }
//        try {
        if (nodo.sons != null) {
            int childX = x - (nodo.sons.length * 50) / 2;
            int childY = y - 100;
            for (NodoFT hijo : nodo.sons) {
                try{

                populateGraph(hijo, childX, childY, raiz, f);
                childX += 200;}catch(Exception e){
                    
                }
            }
        }
//        } catch (Exception e) {
//            System.out.println("ERROR EN EL NODO" + nodo.integrante.nombreCompleto);
//        }
    }

    private void PumpViewer() {
        SwingWorker<Void, Void> worker;
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                while (!isCancelled()) {
                    fromviewer.pump();
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                return null;
            }
        };
        worker.execute();
    }

    @Override
    public void viewClosed(String id) {
    }

    @Override
    public void buttonPushed(String id) {
        System.out.println("Botón presionado: " + id);
        Node node = graph.getNode(id);
        if (node != null) {
            String nombre = (String) node.getAttribute("ui.label");
            JOptionPane.showMessageDialog(this, "Has hecho clic en el nodo: " + nombre);
        } else {
            System.out.println("El nodo no se encontró: " + id);
        }
    }

    @Override
    public void buttonReleased(String string) {
    }

    @Override
    public void mouseOver(String string) {
    }

    @Override
    public void mouseLeft(String string) {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GraphStreamPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GraphStreamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(GraphStreamPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GraphStreamDescendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphStreamDescendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphStreamDescendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphStreamDescendientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphStreamDescendientes(tree, raiz).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GraphStreamPanel;
    // End of variables declaration//GEN-END:variables
}
