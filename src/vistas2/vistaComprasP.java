/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas2;

import controladores2.controladorCompras;
import vistas.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import controladores2.TableAlign;

/**
 *
 * @author Diego
 */
public class vistaComprasP extends javax.swing.JPanel {

    /**
     * Creates new form vistaClientesP
     */
    Object[][] data;
    MyTableModel datos;
    
    public vistaComprasP(String tipo, Object[][] data) {
        initComponents();
        String[] columNames = {"Id","Tipo de documento", "Folio real", "Folio interno", "Rut proveedor",
            "Razón social", "Fecha vencimiento", "Estado"};
        datos = new MyTableModel(data){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tablaCompras.setModel(datos);
        tablaCompras.setAutoCreateRowSorter(true);
        if(tablaCompras.getRowCount() > 0) tablaCompras.setRowSelectionInterval(0, 0);
        tablaCompras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaCompras.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent evt){
                JTable table = (JTable)evt.getSource();
                Point p = evt.getPoint();
                int row = table.rowAtPoint(p);
                if(evt.getClickCount() == 2){
                    controladorCompras miControlador = new controladorCompras();
                    try {
                        miControlador.irVistaDetalleCompras(tablaCompras.getValueAt(row, 0).toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(vistaComprasP.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
        tablaCompras = new javax.swing.JTable(){
            //Implement table cell tool tips.
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    tip = getValueAt(rowIndex, colIndex).toString();
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        };
        botonAgregarCompra = new javax.swing.JButton();
        botonEliminarCompra = new javax.swing.JButton();
        botonModificarProveedor = new javax.swing.JButton();
        textoFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();

        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCompras.setToolTipText("");
        tablaCompras.getTableHeader().setReorderingAllowed(false);
        tablaCompras.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaCompras);

        botonAgregarCompra.setText("Agregar Compra");
        botonAgregarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarCompraActionPerformed(evt);
            }
        });

        botonEliminarCompra.setText("Eliminar Compra");
        botonEliminarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarCompraActionPerformed(evt);
            }
        });

        botonModificarProveedor.setText("Modificar Compra");
        botonModificarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarProveedorActionPerformed(evt);
            }
        });

        textoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoFiltroKeyReleased(evt);
            }
        });

        jLabel1.setText("Filtro");

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 457, Short.MAX_VALUE)
                        .addComponent(botonAgregarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminarCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModificarProveedor))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonAgregarCompra, botonEliminarCompra, botonModificarProveedor});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(botonActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAgregarCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonEliminarCompra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonModificarProveedor, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarCompraActionPerformed
        controladorCompras miControlador = new controladorCompras();
        miControlador.irVistaIngresarCompras();
        JTabbedPane tabs = (JTabbedPane)this.getParent();
        miControlador.crearControladorPrincipal(tabs);
    }//GEN-LAST:event_botonAgregarCompraActionPerformed

    private void botonEliminarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarCompraActionPerformed
        controladores2.controladorCompras miControlador = new controladorCompras();
        String id, tipo, rut;
        boolean selected = tablaCompras.getSelectedRowCount() > 0;
        if(selected){
            int row = getFilaSeleccionada();
            id = getIdFila(row);
            tipo = getTipoFila(row);
            rut = getRutFila(row);
            int dialogResult = JOptionPane.showOptionDialog(null, "Esta seguro que desea eliminar la compra: \n " +
                    "Tipo: " + tipo + "\n Rut proveedor: " + rut, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
            if(dialogResult == JOptionPane.YES_OPTION)  miControlador.eliminarCompras(id);
            JTabbedPane tabs = (JTabbedPane)this.getParent();
            miControlador.crearControladorPrincipal(tabs);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una compra para ser eliminada");
        }
    }//GEN-LAST:event_botonEliminarCompraActionPerformed

    private void botonModificarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarProveedorActionPerformed
        controladorCompras miControlador = new controladorCompras();
        boolean selected = tablaCompras.getSelectedRowCount() > 0;
        if(selected){
            int row = getFilaSeleccionada();
            String id = getIdFila(row);
            try {
                miControlador.irVistaModificarCompras(id);
            } catch (ParseException ex) {
                Logger.getLogger(vistaComprasP.class.getName()).log(Level.SEVERE, null, ex);
            }
            JTabbedPane tabs = (JTabbedPane)this.getParent();
            miControlador.crearControladorPrincipal(tabs);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor para ser modificado");
        }
    }//GEN-LAST:event_botonModificarProveedorActionPerformed

    private void textoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroKeyReleased
        String query = textoFiltro.getText();
        filtrar(query);
    }//GEN-LAST:event_textoFiltroKeyReleased

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        controladorCompras miControlador = new controladorCompras();
        JTabbedPane tabs = (JTabbedPane)this.getParent();
        miControlador.crearControladorPrincipal(tabs);
    }//GEN-LAST:event_botonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregarCompra;
    private javax.swing.JButton botonEliminarCompra;
    private javax.swing.JButton botonModificarProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCompras;
    private javax.swing.JTextField textoFiltro;
    // End of variables declaration//GEN-END:variables
    
    public int getFilaSeleccionada() {
        return tablaCompras.getSelectedRow();
    }

    public String getRutFila(int row){
        return tablaCompras.getValueAt(row, 4).toString();
    }
    
    public String getIdFila(int row){
        return tablaCompras.getValueAt(row,0).toString();
    }
    
    public String getTipoFila(int row){
        return tablaCompras.getValueAt(row,1).toString();
    }
    
    public void filtrar(String query){
        TableRowSorter<MyTableModel> sorter = new TableRowSorter<>(datos);
        tablaCompras.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)"+query));
    }
    
    public class MyTableModel extends DefaultTableModel{
        public MyTableModel() {
          super(new String[]{"Id","Tipo de documento", "Folio real", "Folio interno", "Rut proveedor",
            "Razón social", "Fecha vencimiento", "Estado"}, 0);
        }
        public MyTableModel(Object[][] data){
            super(new String[]{"Id","Tipo de documento", "Folio real", "Folio interno", "Rut proveedor",
            "Razón social", "Fecha vencimiento", "Estado"}, 0);
            
            int i = 0;
            this.setRowCount(data.length);
            for(Object[] data1 : data){
                int id = Integer.parseInt(data1[0].toString());
                int folr = Integer.parseInt(data1[2].toString());
                int foli = Integer.parseInt(data1[3].toString());
                this.setValueAt(id, i, 0);
                this.setValueAt(data1[1], i, 1);
                this.setValueAt(folr, i, 2);
                this.setValueAt(foli, i, 3);
                this.setValueAt(data1[4], i, 4);
                this.setValueAt(data1[5], i, 5);
                this.setValueAt(data1[6], i, 6);
                this.setValueAt(data1[7], i, 7);
                i++;
            }
        }
        @Override
        public Class getColumnClass(int column) {
            switch (column) {
                case 0:
                    return Integer.class;
                case 2:
                    return Integer.class;
                case 3:
                    return Integer.class;
                default:
                    return String.class;
          }
        }
    }
}