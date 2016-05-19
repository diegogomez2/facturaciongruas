/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Diego
 */
public class vistaClientesP extends javax.swing.JPanel {

    /**
     * Creates new form vistaClientesP
     */
    Object[][] data;
    DefaultTableModel datos;
    
    public vistaClientesP(String tipo, Object[][] data) {
        initComponents();
        final int rows = 5;
        String[] columNames = {"Rut", "Razón social", "Teléfono", "Dirección", "Contacto"};
        datos = new DefaultTableModel(data, columNames){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tablaClientes.setModel(datos);
        if(tablaClientes.getRowCount() > 0) tablaClientes.setRowSelectionInterval(0, 0);
        tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaClientes.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent evt){
                JTable table = (JTable)evt.getSource();
                Point p = evt.getPoint();
                int row = table.rowAtPoint(p);
                if(evt.getClickCount() == 2){
                    controladores.controladorClientes miControlador = new controladores.controladorClientes();
                    miControlador.irVistaDetalleCliente(tablaClientes.getValueAt(row, 0).toString());
                }
            }
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        botonAgregarCliente = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        textoFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Rut", "Nombre", "Teléfono", "Dirección"
            }
        ));
        tablaClientes.setToolTipText("");
        tablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaClientes);

        botonAgregarCliente.setText("Agregar Cliente");
        botonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarClienteActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar Cliente");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonModificar.setText("Modificar Cliente");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        textoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoFiltroKeyReleased(evt);
            }
        });

        jLabel1.setText("Filtro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonAgregarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModificar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonAgregarCliente, botonEliminar, botonModificar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAgregarCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonModificar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarClienteActionPerformed
        controladores.controladorClientes miControlador = new controladores.controladorClientes();
        miControlador.irVistaIngresarClientes();
        JTabbedPane tabs = (JTabbedPane)this.getParent();
        miControlador.crearControladorPrincipal(tabs);
    }//GEN-LAST:event_botonAgregarClienteActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        controladores.controladorClientes miControlador = new controladores.controladorClientes();
        String rut, nombres;
        boolean selected = tablaClientes.getSelectedRowCount() > 0;
        if(selected){
            int row = getFilaSeleccionada();
            rut = getRutFila(row);
            nombres = getNombresFila(row);
            int dialogResult = JOptionPane.showOptionDialog(tablaClientes, "Esta seguro que desea eliminar el cliente: \n "
            + rut + "\n" + nombres, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
            if(dialogResult == JOptionPane.YES_OPTION)  miControlador.eliminarClientes(rut);
            JTabbedPane tabs = (JTabbedPane)this.getParent();
            miControlador.crearControladorPrincipal(tabs);
        }else{
            JOptionPane.showMessageDialog(tablaClientes, "Debe seleccionar un cliente para ser eliminado");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        controladores.controladorClientes miControlador = new controladores.controladorClientes();
        boolean selected = tablaClientes.getSelectedRowCount() > 0;
        if(selected){
            int row = getFilaSeleccionada();
            String rut = getRutFila(row);
            String nombres = getNombresFila(row);
            String[] rut_dv = rut.split("-");
            miControlador.irVistaModificarClientes(rut_dv[0], nombres);
            JTabbedPane tabs = (JTabbedPane)this.getParent();
            miControlador.crearControladorPrincipal(tabs);
        }else{
            JOptionPane.showMessageDialog(tablaClientes, "Debe seleccionar un cliente para ser modificado");
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void textoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroKeyReleased
        String query = textoFiltro.getText();
        filtrar(query);
    }//GEN-LAST:event_textoFiltroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCliente;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField textoFiltro;
    // End of variables declaration//GEN-END:variables
    
    public int getFilaSeleccionada() {
        return tablaClientes.getSelectedRow();
    }

    public String getRutFila(int row){
        return tablaClientes.getValueAt(row, 0).toString();
    }
    
    public String getNombresFila(int row){
        return tablaClientes.getValueAt(row,1).toString();
    }
    
    public void filtrar(String query){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(datos);
        tablaClientes.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)"+query));
    }
}
