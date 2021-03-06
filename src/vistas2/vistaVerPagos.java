/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas2;

import controladores.controladorPrincipal;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author diego
 */
public class vistaVerPagos extends javax.swing.JDialog {

    /**
     * Creates new form vistaVerPagos
     */
    MyTableModel datos;
    NumberFormat FORMAT = NumberFormat.getCurrencyInstance();
    DecimalFormatSymbols dfs = new DecimalFormatSymbols();
    
    public vistaVerPagos(java.awt.Frame parent, boolean modal, String tipo, Object[][] data) {
        super(parent, modal);
        initComponents();
        datos = new MyTableModel(data);
        dfs.setCurrencySymbol("$");
        dfs.setGroupingSeparator('.');
        dfs.setMonetaryDecimalSeparator('.');
        ((DecimalFormat) FORMAT).setDecimalFormatSymbols(dfs);
        
        tablaPagos.setModel(datos);
        tablaPagos.getColumnModel().getColumn(1).setCellRenderer(new CurrencyTableCellRenderer());
        TableColumnModel tcm = tablaPagos.getColumnModel();
        tcm.removeColumn(tcm.getColumn(6));
        tablaPagos.setAutoCreateRowSorter(true);
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
        tablaPagos = new javax.swing.JTable();
        botonModificarPago = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagos");

        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaPagos);

        botonModificarPago.setText("Modificar pago");
        botonModificarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonModificarPago)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonModificarPago)
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonModificarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarPagoActionPerformed
        boolean selected = tablaPagos.getSelectedRowCount() > 0;
        if(selected){
            int row = getRowSelected();
            String id = getId(row);
            controladores.controladorPrincipal miControlador = new controladorPrincipal();
            try {
                miControlador.crearControladorModificarPago(id);
            } catch (ParseException ex) {
                Logger.getLogger(vistaVerPagos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un pago para ser modificado");
        }
    }//GEN-LAST:event_botonModificarPagoActionPerformed

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
            java.util.logging.Logger.getLogger(vistaVerPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaVerPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaVerPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaVerPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificarPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPagos;
    // End of variables declaration//GEN-END:variables

    public int getRowSelected(){
        return tablaPagos.getSelectedRow();
    }
    
    public String getId(int row){
        return tablaPagos.getModel().getValueAt(tablaPagos.convertRowIndexToModel(row), 6).toString();
    }
    
    public class MyTableModel extends DefaultTableModel{
        public MyTableModel() {
          super(new String[]{"Opcion de pago", "Monto", "Fecha", "Medio de pago", "Banco", "N° cuenta/cheque", "Id"}, 0);
        }
        public MyTableModel(Object[][] data){
            super(new String[]{"Opcion de pago", "Monto", "Fecha", "Medio de pago", "Banco", "N° cuenta/cheque", "Id"}, 0);
            
            int i = 0;
            this.setRowCount(data.length);
            for(Object[] data1 : data){
                int mon = Integer.parseInt(data1[1].toString());
                this.setValueAt(data1[0], i, 0);
                this.setValueAt(mon, i, 1);
                this.setValueAt(data1[2], i, 2);
                this.setValueAt(data1[3], i, 3);
                this.setValueAt(data1[4], i, 4);
                this.setValueAt(data1[5], i, 5);
                this.setValueAt(data1[6], i, 6);
                i++;
            }
        }
        @Override
        public Class getColumnClass(int column) {
            switch (column) {
                case 1:
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
