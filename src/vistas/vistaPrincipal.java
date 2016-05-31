/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.controladorPrincipal;
import java.awt.PopupMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Diego
 */
public class vistaPrincipal extends javax.swing.JFrame {
    //private JPanel vistaClientesP;

    /**
     * Creates new form vistaPrincipal
     */
    public vistaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        vistaPrincipal.addTab("Clientes", miControlador.crearControladorClientesP());
        vistaPrincipal.addTab("Grúas", miControlador.crearControladorGruasP());
        vistaPrincipal.addTab("Trabajadores", miControlador.crearControladorEmpleadosP());
        vistaPrincipal.addTab("Jornada diaria", miControlador.crearControladorJornadaP());
        vistaPrincipal.addTab("OTs", miControlador.crearControladorOtsP());
        vistaPrincipal.addTab("A facturar", miControlador.crearControladorFacturasP());
        vistaPrincipal.addTab("Facturadas", miControlador.crearControladorFacturadasP());
        vistaPrincipal.addTab("Histórico", miControlador.crearControladorHistoricoP());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vistaPrincipal = new javax.swing.JTabbedPane();
        MenuPrincipal = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuTarifas = new javax.swing.JMenuItem();
        menuAgregarTarifa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setMinimumSize(new java.awt.Dimension(900, 700));

        MenuArchivo.setText("Archivo");

        jMenuItem1.setText("Cambiar contraseña");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuArchivo.add(jMenuItem1);

        MenuPrincipal.add(MenuArchivo);

        jMenu1.setText("Tarifas");

        menuTarifas.setText("Ver tarifas");
        menuTarifas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTarifasActionPerformed(evt);
            }
        });
        jMenu1.add(menuTarifas);

        menuAgregarTarifa.setText("Agregar Tarifa");
        menuAgregarTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarTarifaActionPerformed(evt);
            }
        });
        jMenu1.add(menuAgregarTarifa);

        MenuPrincipal.add(jMenu1);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(vistaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(vistaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        miControlador.crearControladorUsuarios();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuTarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTarifasActionPerformed
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        miControlador.crearControladorTarifas();
    }//GEN-LAST:event_menuTarifasActionPerformed

    private void menuAgregarTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarTarifaActionPerformed
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        miControlador.crearControladorAgregarTarifa();
    }//GEN-LAST:event_menuAgregarTarifaActionPerformed

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
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuAgregarTarifa;
    private javax.swing.JMenuItem menuTarifas;
    public javax.swing.JTabbedPane vistaPrincipal;
    // End of variables declaration//GEN-END:variables

    public JTabbedPane getVistaPrincipal() {
        return vistaPrincipal;
    }
    
    public void agregartab(String nom){
        vistaPrincipal.addTab(nom, new JPanel());
    }
    
}

