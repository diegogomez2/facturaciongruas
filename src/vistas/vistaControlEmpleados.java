/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class vistaControlEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form vistaControlEmpleados
     */
    public vistaControlEmpleados(String tipo, Object[][] data) {
        initComponents();
        setLocationRelativeTo(null);
        String[] columNames = {"Rut", "Nombre", "Cargo"};
        DefaultTableModel datos = new DefaultTableModel(data, columNames){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tablaEmpleados.setModel(datos);
        tablaEmpleados.setRowSelectionInterval(0, 0);
        tablaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelEmpleados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        botonAgregarEmpleado = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        MenuPrincipal = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        MenuUsuarios = new javax.swing.JMenu();
        MenuCambioClave = new javax.swing.JMenuItem();
        MenuControlUsuarios = new javax.swing.JMenuItem();
        MenuAgenda = new javax.swing.JMenu();
        MenuJornadaDiaria = new javax.swing.JMenuItem();
        MenuGestionAgendas = new javax.swing.JMenuItem();
        MenuClientes = new javax.swing.JMenu();
        MenuControlClientes = new javax.swing.JMenuItem();
        MenuEmpleados = new javax.swing.JMenu();
        MenuControlEmpleados = new javax.swing.JMenuItem();
        MenuLiquidaciones = new javax.swing.JMenuItem();
        MenuFiniquitos = new javax.swing.JMenuItem();
        MenuGruas = new javax.swing.JMenu();
        MenuControlGruas = new javax.swing.JMenuItem();
        MenuCaja = new javax.swing.JMenu();
        MenuCobranza = new javax.swing.JMenu();
        MenuFacturacion = new javax.swing.JMenu();
        MenuMantenciones = new javax.swing.JMenu();
        MenuAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelEmpleados.setToolTipText("");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rut", "Nombre", "Teléfono", "Dirección", "Razón social"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        botonAgregarEmpleado.setText("Agregar Empleado");
        botonAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarEmpleadoActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar Empleado");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonModificar.setText("Modificar Empleado");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEmpleadosLayout = new javax.swing.GroupLayout(PanelEmpleados);
        PanelEmpleados.setLayout(PanelEmpleadosLayout);
        PanelEmpleadosLayout.setHorizontalGroup(
            PanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                    .addGroup(PanelEmpleadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAgregarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModificar)))
                .addGap(14, 14, 14))
        );
        PanelEmpleadosLayout.setVerticalGroup(
            PanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelEmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEliminar)
                    .addComponent(botonAgregarEmpleado)
                    .addComponent(botonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        MenuArchivo.setText("Archivo");

        MenuUsuarios.setText("Usuarios");

        MenuCambioClave.setText("Cambio de clave");
        MenuUsuarios.add(MenuCambioClave);

        MenuControlUsuarios.setText("Control de usuarios");
        MenuUsuarios.add(MenuControlUsuarios);

        MenuArchivo.add(MenuUsuarios);

        MenuAgenda.setText("Agenda");

        MenuJornadaDiaria.setText("Jornada diaria");
        MenuAgenda.add(MenuJornadaDiaria);

        MenuGestionAgendas.setText("Gestión de agendas");
        MenuAgenda.add(MenuGestionAgendas);

        MenuArchivo.add(MenuAgenda);

        MenuClientes.setText("Clientes");

        MenuControlClientes.setText("Control de clientes");
        MenuControlClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuControlClientesActionPerformed(evt);
            }
        });
        MenuClientes.add(MenuControlClientes);

        MenuArchivo.add(MenuClientes);

        MenuEmpleados.setText("Empleados");

        MenuControlEmpleados.setText("Control de empleados");
        MenuEmpleados.add(MenuControlEmpleados);

        MenuLiquidaciones.setText("Liquidaciones");
        MenuEmpleados.add(MenuLiquidaciones);

        MenuFiniquitos.setText("Finiquitos");
        MenuEmpleados.add(MenuFiniquitos);

        MenuArchivo.add(MenuEmpleados);

        MenuGruas.setText("Grúas");

        MenuControlGruas.setText("Control de grúas");
        MenuControlGruas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuControlGruasActionPerformed(evt);
            }
        });
        MenuGruas.add(MenuControlGruas);

        MenuArchivo.add(MenuGruas);

        MenuPrincipal.add(MenuArchivo);

        MenuCaja.setText("Caja");
        MenuPrincipal.add(MenuCaja);

        MenuCobranza.setText("Cobranza");
        MenuPrincipal.add(MenuCobranza);

        MenuFacturacion.setText("Facturación");
        MenuPrincipal.add(MenuFacturacion);

        MenuMantenciones.setText("Mantenciones");
        MenuPrincipal.add(MenuMantenciones);

        MenuAyuda.setText("Ayuda");
        MenuPrincipal.add(MenuAyuda);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelEmpleados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuControlClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuControlClientesActionPerformed
        this.setVisible(false);
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        miControlador.crearControladorClientes();
    }//GEN-LAST:event_MenuControlClientesActionPerformed

    private void MenuControlGruasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuControlGruasActionPerformed
        this.setVisible(false);
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        miControlador.crearControladorGruas();
    }//GEN-LAST:event_MenuControlGruasActionPerformed

    private void botonAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarEmpleadoActionPerformed
        controladores.controladorClientes miControlador = new controladores.controladorClientes();
        miControlador.irVistaIngresarClientes();
    }//GEN-LAST:event_botonAgregarEmpleadoActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
       /*controladores.controladorClientes miControlador = new controladores.controladorClientes();
        String rut, nombres, apP;
        int row = getFilaSeleccionada();
        rut = getRutFila(row);
        nombres = getNombresFila(row);
        apP = getApPaternoFila(row);
        int dialogResult = JOptionPane.showOptionDialog(rootPane, "Esta seguro que desea eliminar el cliente: \n "
            + rut + " " + nombres + " " + apP, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
        if(dialogResult == JOptionPane.YES_OPTION)  miControlador.eliminarClientes(rut);*/
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        /*controladores.controladorClientes miControlador = new controladores.controladorClientes();
        boolean selected = tablaEmpleados.getSelectedRowCount() > 0;
        if(selected){
            int row = getFilaSeleccionada();
            String rut = getRutFila(row);
            String nombres = getNombresFila(row);
            String apP = getApPaternoFila(row);
            String[] rut_dv = rut.split("-");
            miControlador.irVistaModificarClientes(rut_dv[0], nombres, apP);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar un cliente para ser modificado");
        }*/

    }//GEN-LAST:event_botonModificarActionPerformed

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
            java.util.logging.Logger.getLogger(vistaControlEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaControlEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaControlEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaControlEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAgenda;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenu MenuAyuda;
    private javax.swing.JMenu MenuCaja;
    private javax.swing.JMenuItem MenuCambioClave;
    private javax.swing.JMenu MenuClientes;
    private javax.swing.JMenu MenuCobranza;
    private javax.swing.JMenuItem MenuControlClientes;
    private javax.swing.JMenuItem MenuControlEmpleados;
    private javax.swing.JMenuItem MenuControlGruas;
    private javax.swing.JMenuItem MenuControlUsuarios;
    private javax.swing.JMenu MenuEmpleados;
    private javax.swing.JMenu MenuFacturacion;
    private javax.swing.JMenuItem MenuFiniquitos;
    private javax.swing.JMenuItem MenuGestionAgendas;
    private javax.swing.JMenu MenuGruas;
    private javax.swing.JMenuItem MenuJornadaDiaria;
    private javax.swing.JMenuItem MenuLiquidaciones;
    private javax.swing.JMenu MenuMantenciones;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JMenu MenuUsuarios;
    private javax.swing.JPanel PanelEmpleados;
    private javax.swing.JButton botonAgregarEmpleado;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables
}