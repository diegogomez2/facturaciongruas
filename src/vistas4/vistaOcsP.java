/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author diego
 */
public class vistaOcsP extends javax.swing.JPanel {

    MyTableModel datos;
    NumberFormat FORMAT = NumberFormat.getCurrencyInstance();
    DecimalFormatSymbols dfs = new DecimalFormatSymbols();
    /**
     * Creates new form vistaOcsP
     */
    public vistaOcsP(String tipo, Object[][] data) {
        initComponents();
        dfs.setCurrencySymbol("$");
        dfs.setGroupingSeparator('.');
        dfs.setMonetaryDecimalSeparator('.');
        ((DecimalFormat) FORMAT).setDecimalFormatSymbols(dfs);

        jScrollPane1.setViewportView(tablaOcs);

        datos = new MyTableModel(data);

        tablaOcs.setModel(datos);
        tablaOcs.getColumnModel().getColumn(7).setCellRenderer(new CurrencyTableCellRenderer());
        tablaOcs.getColumnModel().getColumn(8).setCellRenderer(new CurrencyTableCellRenderer());
        tablaOcs.getColumnModel().getColumn(9).setCellRenderer(new CurrencyTableCellRenderer());
        tablaOcs.setAutoCreateRowSorter(true);
        if (tablaOcs.getRowCount() > 0) {
            tablaOcs.setRowSelectionInterval(0, 0);
        }
        tablaOcs.setRowSelectionAllowed(true);
        tablaOcs.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaOcs.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                JTable table = (JTable) evt.getSource();
                Point p = evt.getPoint();
                int row = table.rowAtPoint(p);
                if (evt.getClickCount() == 2) {
                    controladores4.controladorOcs miControlador = new controladores4.controladorOcs();
                    try {
                        miControlador.irVistaDetalleOcs(tablaOcs.getValueAt(row, 0).toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(vistaOcsP.class.getName()).log(Level.SEVERE, null, ex);
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
        tablaOcs = new javax.swing.JTable(){
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
            @Override
            public java.awt.Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
                java.awt.Component comp = super.prepareRenderer(renderer, row, col);
                Object value = getModel().getValueAt(row, 10);
                if (value.equals("Facturada")) {
                    comp.setBackground(Color.lightGray);
                }  else {
                    comp.setBackground(Color.white);
                }
                if(isRowSelected(row)){
                    comp.setBackground(new java.awt.Color(184,207,229));
                }
                return comp;
            }
        };
        botonFacturar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textoFiltro = new javax.swing.JTextField();
        botonAnular = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();

        tablaOcs.getTableHeader().setReorderingAllowed(false);
        tablaOcs.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tablaOcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaOcs.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaOcs);

        botonFacturar.setText("Facturar OC");
        botonFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFacturarActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtro");

        textoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoFiltroKeyReleased(evt);
            }
        });

        botonAnular.setText("Anular OC");
        botonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnularActionPerformed(evt);
            }
        });

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar OC");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAnular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonFacturar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonFacturar)
                    .addComponent(botonAnular)
                    .addComponent(botonEliminar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFacturarActionPerformed
        String id;
        String idOt;
        controladores4.controladorOcs miControlador = new controladores4.controladorOcs();
        controladores4.controladorFacturasOC micontroladorFacturas = new controladores4.controladorFacturasOC();
        boolean selected = tablaOcs.getSelectedRowCount() > 0;
        if (selected) {
            int row = getFilaSeleccionada();
            id = getIdFila(row);
            idOt = getIdOc(row);
            if (miControlador.getIdFactura(idOt).compareTo("1") == 0) {
                JOptionPane.showMessageDialog(null, "Esta orden de trabajo ya ha sido facturada");
            }else {
                miControlador.ingresarFactura(idOt);
                JTabbedPane tabs = (JTabbedPane) this.getParent();
                micontroladorFacturas.crearControladorPrincipal(tabs);
                miControlador.crearControladorPrincipal(tabs);
                //JOptionPane.showMessageDialog(null, "Orden de trabajo facturada con éxito");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden de trabajo para ser facturada");
        }
    }//GEN-LAST:event_botonFacturarActionPerformed

    private void textoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroKeyReleased
        String query = textoFiltro.getText();
        filtroPorRazon(query);
    }//GEN-LAST:event_textoFiltroKeyReleased

    private void botonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnularActionPerformed
        String id;
        String idOc;
        controladores4.controladorOcs miControlador = new controladores4.controladorOcs();
        controladores4.controladorFacturasOC micontroladorFacturas = new controladores4.controladorFacturasOC();
        boolean selected = tablaOcs.getSelectedRowCount() > 0;
        if (selected) {
            int row = getFilaSeleccionada();
            id = getIdFila(row);
            idOc = getIdOc(row);
            miControlador.anularFactura(idOc);
            JTabbedPane tabs = (JTabbedPane) this.getParent();
            micontroladorFacturas.crearControladorPrincipal(tabs);
            miControlador.crearControladorPrincipal(tabs);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden de trabajo para ser anulada");
        }
    }//GEN-LAST:event_botonAnularActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        controladores4.controladorOcs miControlador = new controladores4.controladorOcs();
        JTabbedPane tabs = (JTabbedPane)this.getParent();
        miControlador.crearControladorPrincipal(tabs);
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        String idOc;
        controladores4.controladorOcs miControlador = new controladores4.controladorOcs();
        controladores4.controladorFacturasOC micontroladorFacturas = new controladores4.controladorFacturasOC();
        boolean selected = tablaOcs.getSelectedRowCount() > 0;
        if (selected) {
            int row = getFilaSeleccionada();
            idOc = getIdOc(row);
            int dialogResult = JOptionPane.showOptionDialog(null, "Esta seguro que desea eliminar la OC \nCódigo: "
                , "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
            if(dialogResult == JOptionPane.YES_OPTION){
                try {
                    miControlador.restarMensualidad(idOc);
                } catch (ParseException ex) {
                    Logger.getLogger(vistaOcsP.class.getName()).log(Level.SEVERE, null, ex);
                }
                miControlador.eliminarOc(idOc);
            }
            JTabbedPane tabs = (JTabbedPane) this.getParent();
            micontroladorFacturas.crearControladorPrincipal(tabs);
            miControlador.crearControladorPrincipal(tabs);
            JOptionPane.showMessageDialog(null, "Orden de trabajo eliminada con éxito");

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden de trabajo para ser eliminada");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAnular;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonFacturar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaOcs;
    private javax.swing.JTextField textoFiltro;
    // End of variables declaration//GEN-END:variables

    public JTable getTablaOts() {
        return tablaOcs;
    }

    public int getFilaSeleccionada() {
        return tablaOcs.getSelectedRow();
    }

    public String getIdFila(int row) {
        return tablaOcs.getValueAt(row, 0).toString();
    }

    public String getIdOc(int row) {
        return tablaOcs.getValueAt(row, 0).toString();
    }

    public void filtroPorRazon(String query) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(datos);
        tablaOcs.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(query));
    }
    
    public class MyTableModel extends DefaultTableModel{
        public MyTableModel() {
          super(new String[]{"Código OC", "Razon", "Giro", "Dirección", "Ciudad", "Comuna", "Fecha",
            "Neto", "IVA", "Total", "Estado", "Cliente"}, 0);
        }
        public MyTableModel(Object[][] data){
            super(new String[]{"Código OC", "Razon", "Giro", "Dirección", "Ciudad", "Comuna", "Fecha",
            "Neto", "IVA", "Total", "Estado", "Cliente"}, 0);
            
            int i = 0;
            this.setRowCount(data.length);
            for(Object[] data1 : data){
                int cod = Integer.parseInt(data1[0].toString());
                int neto = Integer.parseInt(data1[7].toString());
                int iva = Integer.parseInt(data1[8].toString());
                int tot = Integer.parseInt(data1[9].toString());
                this.setValueAt(cod, i, 0);
                this.setValueAt(data1[1], i, 1);
                this.setValueAt(data1[2], i, 2);
                this.setValueAt(data1[3], i, 3);
                this.setValueAt(data1[4], i, 4);
                this.setValueAt(data1[5], i, 5);
                this.setValueAt(data1[6], i, 6);
                this.setValueAt(neto, i, 7);
                this.setValueAt(iva, i, 8);
                this.setValueAt(tot, i, 9);
                this.setValueAt(data1[10], i, 10);
                this.setValueAt(data1[11], i, 11);
                i++;
        }
        }

        @Override
        public Class getColumnClass(int column) {
          switch (column) {
            case 0:
                return Integer.class;
            case 7:
                return Integer.class;
            case 8:
                return Integer.class;
            case 9:
                return Integer.class;
            default:
                return String.class;
          }
        }
        
        @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
    }
    
    public class CurrencyTableCellRenderer extends DefaultTableCellRenderer {
        @Override
        public final Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
                final Component result = super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);
                if (value instanceof Number) {
                    setHorizontalAlignment(JLabel.RIGHT);
                    setText(FORMAT.format(value));
                } else {
                    setText("");
                }
                return result;
            }
    }
}
