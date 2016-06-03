/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author diego
 */
public class vistaFacturadasP extends javax.swing.JPanel {

    /**
     * Creates new form vistaFacturadasP
     */
    DefaultTableModel datos;
    
    public vistaFacturadasP(String tipo, Object[][] data) {
        initComponents();
         String[] columNames = {"N°Folio", "Razon", "Giro", "Dirección", "Ciudad", "Comuna", "Fecha",
             "Neto", "IVA", "Total", "Tipo"};
        datos = new DefaultTableModel(data, columNames){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tablaFacturadas.setModel(datos);
        tablaFacturadas.setAutoCreateRowSorter(true);
        if(tablaFacturadas.getRowCount() > 0) tablaFacturadas.setRowSelectionInterval(0, 0);
        tablaFacturadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaFacturadas.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent evt){
                JTable table = (JTable)evt.getSource();
                Point p = evt.getPoint();
                int row = table.rowAtPoint(p);
                if(evt.getClickCount() == 2){
                    controladores.controladorFacturadas miControlador = new controladores.controladorFacturadas();
                    try {
                        miControlador.irVistaDetalleFacturadas(tablaFacturadas.getValueAt(row, 0).toString(),
                                tablaFacturadas.getValueAt(row, 10).toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(vistaJornadasP.class.getName()).log(Level.SEVERE, null, ex);
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
        tablaFacturadas = new javax.swing.JTable();
        botonGenerarNC = new javax.swing.JButton();
        botonGuiaDesp = new javax.swing.JButton();
        textoFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();

        tablaFacturadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaFacturadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaFacturadas);

        botonGenerarNC.setText("Generar nota de crédito");
        botonGenerarNC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarNCActionPerformed(evt);
            }
        });

        botonGuiaDesp.setText("Generar guía despacho");
        botonGuiaDesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuiaDespActionPerformed(evt);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonGuiaDesp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonGenerarNC)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonGenerarNC, botonGuiaDesp});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(botonActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGenerarNC)
                    .addComponent(botonGuiaDesp))
                .addGap(11, 11, 11))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonGenerarNCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarNCActionPerformed
        String id, tipo;
        controladores.controladorFacturadas miControlador = new controladores.controladorFacturadas();
        controladores.controladorCrearFactura miControladorC = new controladores.controladorCrearFactura();
        boolean selected = tablaFacturadas.getSelectedRowCount() > 0;
        if(selected){
            int row = getFilaSeleccionada();
            id = getIdFila(row);
            tipo = getTipoFila(row);
            if(tipo.compareTo("notacredito") == 0 || tipo.compareTo("notadebito") == 0){
                JOptionPane.showMessageDialog(null, "No se puede generar una nota de crédito para una " + tipo);
            }else{
                String razon = JOptionPane.showInputDialog("Razón: ");
                if(razon != null){
                   String id_nc = miControlador.ingresarNotaCredito(id, razon, tipo);
                    String[] valores_nc = miControlador.obtenerValoresNC(id_nc);
                    String[] ots = miControlador.obtenerOtsPorIdNC(id_nc);
                    if((miControladorC.crearNotaCredXML(id_nc, valores_nc, ots, razon, id).compareTo("correcto") == 0)){
                        JTabbedPane tabs = (JTabbedPane)this.getParent();
                        miControlador.crearControladorPrincipal(tabs);
                    } 
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una factura para generar una nota de crédito");
        }
    }//GEN-LAST:event_botonGenerarNCActionPerformed

    private void botonGuiaDespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuiaDespActionPerformed
        String id;
        //controladores.controladorPrincipal miControladorP = new controladores.controladorPrincipal();
        controladores.controladorFacturadas miControlador = new controladores.controladorFacturadas();
        controladores.controladorCrearFactura miControladorC = new controladores.controladorCrearFactura();
        boolean selected = tablaFacturadas.getSelectedRowCount() > 0;
        if(selected){
            int row = getFilaSeleccionada();
            id = getIdFila(row);
            String[] ots = miControlador.obtenerOtsPorIdFacturada(id);
            if((miControladorC.crearGuiaDespXML(ots, id).compareTo("correcto") == 0)){
                JTabbedPane tabs = (JTabbedPane)this.getParent();
                miControlador.crearControladorPrincipal(tabs);
            } 
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una factura para generar una guía de despacho");
        }
    }//GEN-LAST:event_botonGuiaDespActionPerformed

    private void textoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroKeyReleased
        String query = textoFiltro.getText();
        filtrar(query);
    }//GEN-LAST:event_textoFiltroKeyReleased

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        controladores.controladorFacturadas miControlador = new controladores.controladorFacturadas();
        JTabbedPane tabs = (JTabbedPane)this.getParent();
        miControlador.crearControladorPrincipal(tabs);
    }//GEN-LAST:event_botonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonGenerarNC;
    private javax.swing.JButton botonGuiaDesp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFacturadas;
    private javax.swing.JTextField textoFiltro;
    // End of variables declaration//GEN-END:variables
    public int getFilaSeleccionada() {
        return tablaFacturadas.getSelectedRow();
    }
    
    public String getIdFila(int row){
        return tablaFacturadas.getValueAt(row, 0).toString();
    }
    
    public String getTipoFila(int row){
        return tablaFacturadas.getValueAt(row, 10).toString();
    }
    
    public void filtrar(String query) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(datos);
        tablaFacturadas.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
    }
}
