/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.controladorPrincipal;
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
        //vistaPrincipal.addTab("Usuarios", miControlador.crearControladorUsuariosP());
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
        itemAgregarUsuario = new javax.swing.JMenuItem();
        itemCambiarContraseña = new javax.swing.JMenuItem();
        itemUsuarios = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuTarifas = new javax.swing.JMenuItem();
        menuAgregarTarifa = new javax.swing.JMenuItem();
        menuOperaciones = new javax.swing.JMenu();
        itemOperaciones = new javax.swing.JMenuItem();
        menuCobranza = new javax.swing.JMenu();
        itemCobranzas = new javax.swing.JMenuItem();
        itemGenerarReporte = new javax.swing.JMenuItem();
        menuCompras = new javax.swing.JMenu();
        itemCompras = new javax.swing.JMenuItem();
        menuLibros = new javax.swing.JMenu();
        itemLibroCompras = new javax.swing.JMenuItem();
        itemLibroVentas = new javax.swing.JMenuItem();
        itemLibroAtrasado = new javax.swing.JMenuItem();
        menuRemuneraciones = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setMinimumSize(new java.awt.Dimension(900, 700));

        MenuArchivo.setText("Archivo");
        MenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuArchivoActionPerformed(evt);
            }
        });

        itemAgregarUsuario.setText("Agregar usuario");
        itemAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAgregarUsuarioActionPerformed(evt);
            }
        });
        MenuArchivo.add(itemAgregarUsuario);

        itemCambiarContraseña.setText("Cambiar contraseña");
        itemCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCambiarContraseñaActionPerformed(evt);
            }
        });
        MenuArchivo.add(itemCambiarContraseña);

        itemUsuarios.setText("Mostrar usuarios");
        itemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuariosActionPerformed(evt);
            }
        });
        MenuArchivo.add(itemUsuarios);

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

        menuOperaciones.setText("Operaciones y Servicios");
        menuOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOperacionesActionPerformed(evt);
            }
        });

        itemOperaciones.setText("Mostrar operaciones y servicios");
        itemOperaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOperacionesActionPerformed(evt);
            }
        });
        menuOperaciones.add(itemOperaciones);

        MenuPrincipal.add(menuOperaciones);

        menuCobranza.setText("Cobranzas");

        itemCobranzas.setText("Mostrar cobranzas");
        itemCobranzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCobranzasActionPerformed(evt);
            }
        });
        menuCobranza.add(itemCobranzas);

        itemGenerarReporte.setText("Generar reporte");
        itemGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGenerarReporteActionPerformed(evt);
            }
        });
        menuCobranza.add(itemGenerarReporte);

        MenuPrincipal.add(menuCobranza);

        menuCompras.setText("Compras");

        itemCompras.setText("Mostrar compras");
        itemCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemComprasActionPerformed(evt);
            }
        });
        menuCompras.add(itemCompras);

        MenuPrincipal.add(menuCompras);

        menuLibros.setText("Libros");

        itemLibroCompras.setText("Generar libro de compras");
        itemLibroCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLibroComprasActionPerformed(evt);
            }
        });
        menuLibros.add(itemLibroCompras);

        itemLibroVentas.setText("Generar libro de ventas");
        itemLibroVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLibroVentasActionPerformed(evt);
            }
        });
        menuLibros.add(itemLibroVentas);

        itemLibroAtrasado.setText("Generar libro atrasado");
        itemLibroAtrasado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLibroAtrasadoActionPerformed(evt);
            }
        });
        menuLibros.add(itemLibroAtrasado);

        MenuPrincipal.add(menuLibros);

        menuRemuneraciones.setText("Remuneraciones");

        jMenuItem1.setText("Editar sueldos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRemuneraciones.add(jMenuItem1);

        jMenuItem2.setText("Generar liquidaciones de sueldo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuRemuneraciones.add(jMenuItem2);

        MenuPrincipal.add(menuRemuneraciones);

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

    private void itemCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCambiarContraseñaActionPerformed
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        miControlador.crearControladorUsuarios();
    }//GEN-LAST:event_itemCambiarContraseñaActionPerformed

    private void menuTarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTarifasActionPerformed
        vistaPrincipal.removeAll();
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        vistaPrincipal.addTab("Usuarios", miControlador.crearControladorUsuariosP());
        vistaPrincipal.addTab("Tarifas", miControlador.crearControladorTarifasP());
        vistaPrincipal.setSelectedIndex(1);
    }//GEN-LAST:event_menuTarifasActionPerformed

    private void menuAgregarTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarTarifaActionPerformed
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        miControlador.crearControladorAgregarTarifa();
    }//GEN-LAST:event_menuAgregarTarifaActionPerformed

    private void itemAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAgregarUsuarioActionPerformed
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        miControlador.crearControladorAgregarUsuario2();
    }//GEN-LAST:event_itemAgregarUsuarioActionPerformed

    private void MenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuArchivoActionPerformed
        vistaPrincipal.removeAll();
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        vistaPrincipal.addTab("Usuarios", miControlador.crearControladorUsuariosP());
        //vistaPrincipal.addTab("Grúas", miControlador.crearControladorGruasP());
    }//GEN-LAST:event_MenuArchivoActionPerformed

    private void itemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuariosActionPerformed
        vistaPrincipal.removeAll();
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        vistaPrincipal.addTab("Usuarios", miControlador.crearControladorUsuariosP());
        vistaPrincipal.addTab("Tarifas", miControlador.crearControladorTarifasP());
    }//GEN-LAST:event_itemUsuariosActionPerformed

    private void menuOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOperacionesActionPerformed
        vistaPrincipal.removeAll();
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        vistaPrincipal.addTab("Usuarios", miControlador.crearControladorUsuariosP());
        //vistaPrincipal.addTab("Grúas", miControlador.crearControladorGruasP());
    }//GEN-LAST:event_menuOperacionesActionPerformed

    private void itemOperacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOperacionesActionPerformed
        vistaPrincipal.removeAll();
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        vistaPrincipal.addTab("Clientes", miControlador.crearControladorClientesP());
        vistaPrincipal.addTab("Grúas", miControlador.crearControladorGruasP());
        vistaPrincipal.addTab("Trabajadores", miControlador.crearControladorEmpleadosP());
        vistaPrincipal.addTab("Jornada diaria", miControlador.crearControladorJornadaP());
        vistaPrincipal.addTab("OTs", miControlador.crearControladorOtsP());
        vistaPrincipal.addTab("A facturar", miControlador.crearControladorFacturasP());
        vistaPrincipal.addTab("Facturadas", miControlador.crearControladorFacturadasP());
        vistaPrincipal.addTab("Histórico", miControlador.crearControladorHistoricoP());
        //vistaPrincipal.addTab("Usuarios", miControlador.crearControladorUsuariosP());
    }//GEN-LAST:event_itemOperacionesActionPerformed

    private void itemComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemComprasActionPerformed
        vistaPrincipal.removeAll();
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        vistaPrincipal.addTab("Proveedores", miControlador.crearControladorProveedoresP());
        vistaPrincipal.addTab("Compras", miControlador.crearControladorComprasP());
        vistaPrincipal.add("Agenda de pagos", miControlador.crearControladorAgendaDePagosP());
        vistaPrincipal.add("Agenda de otros pagos", miControlador.crearControladorAgendaDeOtrosPagosP());
        vistaPrincipal.add("Global de pagos", miControlador.crearControladorGlobalPagosP());
        vistaPrincipal.add("Global otros pagos", miControlador.crearControladorGlobalOtrosPagosP());
    }//GEN-LAST:event_itemComprasActionPerformed

    private void itemCobranzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCobranzasActionPerformed
        vistaPrincipal.removeAll();
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        vistaPrincipal.addTab("Cobranza", miControlador.crearControladorCobranzasP());
    }//GEN-LAST:event_itemCobranzasActionPerformed

    private void itemGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGenerarReporteActionPerformed
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.generarReporte();
    }//GEN-LAST:event_itemGenerarReporteActionPerformed

    private void itemLibroComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLibroComprasActionPerformed
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.generarLibroCompras();
    }//GEN-LAST:event_itemLibroComprasActionPerformed

    private void itemLibroVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLibroVentasActionPerformed
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.generarLibroVentas();
    }//GEN-LAST:event_itemLibroVentasActionPerformed

    private void itemLibroAtrasadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLibroAtrasadoActionPerformed
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorGenerarLibroAtrasado();
    }//GEN-LAST:event_itemLibroAtrasadoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorEditarSueldos();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        controladorPrincipal miconPrincipal = new controladorPrincipal();
        miconPrincipal.crearControladorGenerarLiquidaciones();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
    private javax.swing.JMenuItem itemAgregarUsuario;
    private javax.swing.JMenuItem itemCambiarContraseña;
    private javax.swing.JMenuItem itemCobranzas;
    private javax.swing.JMenuItem itemCompras;
    private javax.swing.JMenuItem itemGenerarReporte;
    private javax.swing.JMenuItem itemLibroAtrasado;
    private javax.swing.JMenuItem itemLibroCompras;
    private javax.swing.JMenuItem itemLibroVentas;
    private javax.swing.JMenuItem itemOperaciones;
    private javax.swing.JMenuItem itemUsuarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem menuAgregarTarifa;
    private javax.swing.JMenu menuCobranza;
    private javax.swing.JMenu menuCompras;
    private javax.swing.JMenu menuLibros;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JMenu menuRemuneraciones;
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

