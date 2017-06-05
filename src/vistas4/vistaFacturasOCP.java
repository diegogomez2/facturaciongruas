/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas4;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelos.modeloFacturas;
import vistas.vistaJornadasP;

/**
 *
 * @author diego
 */
public class vistaFacturasOCP extends javax.swing.JPanel {

    /**
     * Creates new form vistaFacturasOCP
     */
    public vistaFacturasOCP(String tipo, Object[][] data) {
        initComponents();
        initComponents();
        String[] columNames = {"Código OC", "Razón", "Giro", "Dirección", "Región", "Comuna", "Fecha",
            "Neto", "IVA", "Total", "Desc"};
        DefaultTableModel datos = new DefaultTableModel(data, columNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaFacturasOC.setModel(datos);
        TableColumnModel tcm = tablaFacturasOC.getColumnModel();
        tcm.removeColumn(tcm.getColumn(10));
        tablaFacturasOC.setAutoCreateRowSorter(true);
        if (tablaFacturasOC.getRowCount() > 0) {
            tablaFacturasOC.setRowSelectionInterval(0, 0);
        }
        tablaFacturasOC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaFacturasOC.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                JTable table = (JTable) evt.getSource();
                Point p = evt.getPoint();
                int row = table.rowAtPoint(p);
                if (evt.getClickCount() == 2) {
                    controladores.controladorFacturas miControlador = new controladores.controladorFacturas();
                    try {
                        miControlador.irVistaDetalleFacturas(tablaFacturasOC.getValueAt(row, 0).toString());
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
        tablaFacturasOC = new javax.swing.JTable();
        botonFactura3 = new javax.swing.JButton();
        botonBoleta = new javax.swing.JButton();
        botonNotaDeb = new javax.swing.JButton();
        botonFacEx = new javax.swing.JButton();
        botonQuitar = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();

        tablaFacturasOC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaFacturasOC);

        botonFactura3.setText("Generar factura");
        botonFactura3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFactura3ActionPerformed(evt);
            }
        });

        botonBoleta.setText("Generar Boleta");
        botonBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBoletaActionPerformed(evt);
            }
        });

        botonNotaDeb.setText("Generar Nota débito");
        botonNotaDeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNotaDebActionPerformed(evt);
            }
        });

        botonFacEx.setText("Generar factura ex.");
        botonFacEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFacExActionPerformed(evt);
            }
        });

        botonQuitar.setText("Quitar");
        botonQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonQuitarActionPerformed(evt);
            }
        });

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
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(botonQuitar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                            .addComponent(botonFacEx)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonNotaDeb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonBoleta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonFactura3))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonActualizar)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(botonActualizar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonFactura3)
                        .addComponent(botonBoleta)
                        .addComponent(botonNotaDeb)
                        .addComponent(botonFacEx)
                        .addComponent(botonQuitar))
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonFactura3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFactura3ActionPerformed
        try{
            controladores4.controladorCrearFacturaOC miControlador = new controladores4.controladorCrearFacturaOC();
            controladores4.controladorOcs micontroladorOcs = new controladores4.controladorOcs();
            int filas = tablaFacturasOC.getRowCount();
            if(filas > 0){
                String flag = verificarRazon();
                if (flag.compareTo("correcto") == 0) {
                    String[] idOcs = new String[filas];
                    int neto = 0, iva = 0, total = 0, desc = 0;
                    for (int i = 0; i < filas; i++) {
                        idOcs[i] = getIdFact(i);
                        desc = getDescFact(i);
                        //                        neto += getNetoFact(i) - desc;
                        neto += getNetoFact(i);
                        iva += getIvaFact(i);
                        total += getTotalFact(i);
                    }
                    controladores4.controladorFacturasOC micontroladorFacturasOC = new controladores4.controladorFacturasOC();
                    String id = micontroladorFacturasOC.archivarFacturas(idOcs, neto, iva, total, "factura", "0", "0");
                    if(id.compareTo("-1") == 0){
                        JOptionPane.showMessageDialog(null, "La factura ya había sido ingresada al sistema", "Error factura duplicada",
                            JOptionPane.INFORMATION_MESSAGE);
                        JTabbedPane tabs = (JTabbedPane) this.getParent();
                        micontroladorOcs.crearControladorPrincipal(tabs);
                        miControlador.crearControladorPrincipalOC(tabs);
                    }else{
                        try {
                            //docRef va en el tag observaciones
                            String docRef = JOptionPane.showInputDialog("Ingrese documento de referencia: ");
                            if ((miControlador.crearFacXML(idOcs, Integer.toString(neto), Integer.toString(iva),
                                Integer.toString(total), id, docRef).compareTo("correcto") == 0)) {
                                JTabbedPane tabs = (JTabbedPane) this.getParent();
                                micontroladorOcs.crearControladorPrincipal(tabs);
                                miControlador.crearControladorPrincipalOC(tabs);
                            }
                        }catch (ParseException ex) {
                            ex.printStackTrace();
                            //                            ex.printStackTrace(ps);
                            Logger.getLogger(vistaFacturasOCP.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede generar una factura para clientes distintos");
                }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ocs para generar una factura");
        }
        }catch(Exception e){
            //            e.printStackTrace(ps);
            e.printStackTrace();
        }
    }//GEN-LAST:event_botonFactura3ActionPerformed

    private void botonBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBoletaActionPerformed
//        controladores.controladorCrearFactura miControlador = new controladores.controladorCrearFactura();
//        controladores.controladorOts micontroladorOts = new controladores.controladorOts();
//        int filas = tablaFacturas.getRowCount();
//        if(filas > 0){
//            String flag = verificarRazon();
//            if(flag.compareTo("correcto") == 0){
//                String[] idOts = new String[filas];
//                int neto = 0, iva = 0, total = 0, desc = 0;
//                for (int i = 0; i < filas; i++) {
//                    idOts[i] = getIdFact(i);
//                    desc = getDescFact(i);
//                    //                    neto += getNetoFact(i) - desc;
//                    neto += getNetoFact(i);
//                    iva += getIvaFact(i);
//                    total += getTotalFact(i);
//                }
//                controladores.controladorFacturas micontroladorFacturas = new controladores.controladorFacturas();
//                String id = micontroladorFacturas.archivarFacturas(idOts, neto, iva, total, "boleta", "0", "0");
//                if ((miControlador.crearBolXML(idOts, Integer.toString(neto), Integer.toString(iva),
//                    Integer.toString(total), id).compareTo("correcto") == 0)) {
//            JTabbedPane tabs = (JTabbedPane) this.getParent();
//            micontroladorOts.crearControladorPrincipal(tabs);
//            miControlador.crearControladorPrincipal(tabs);
//        }
//        }else{
//            JOptionPane.showMessageDialog(null, "No se puede generar una boleta para clientes distintos");
//        }
//        }else{
//            JOptionPane.showMessageDialog(null, "No hay ots para generar una boleta");
//        }
    }//GEN-LAST:event_botonBoletaActionPerformed

    private void botonNotaDebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNotaDebActionPerformed
        controladores4.controladorCrearFacturaOC miControlador = new controladores4.controladorCrearFacturaOC();
        controladores4.controladorOcs micontroladorOcs = new controladores4.controladorOcs();
        int filas = tablaFacturasOC.getRowCount();
        if(filas > 0){
            String flag = verificarRazon();
            JTextField idfac = new JTextField();
            JComboBox combo = new JComboBox(new String[]{"Factura", "Boleta", "Factura exenta"});
            Object[] message = {
                "Folio: ",idfac,
                "Tipo documento: ", combo
            };
            String id_fac, tiponc;
            if(flag.compareTo("correcto") == 0){
                int resp = JOptionPane.showConfirmDialog(null, message, "N° de folio de factura: ", JOptionPane.OK_CANCEL_OPTION);
                if(resp == JOptionPane.OK_OPTION){
                    id_fac = idfac.getText();
                    tiponc = combo.getSelectedItem().toString();
                    boolean existe = verificarExisteFactura(id_fac, tiponc);
                    if(existe){
                        String razonFac = verificarRazonFactura(id_fac, tiponc);
                        if(razonFac.compareTo(getRazonFila(0)) == 0){
                            String[] idOcs = new String[filas];
                            int neto = 0, iva = 0, total = 0, desc = 0;
                            for (int i = 0; i < filas; i++) {
                                idOcs[i] = getIdFact(i);
                                desc = getDescFact(i);
                                //                                neto += getNetoFact(i) - desc;
                                neto += getNetoFact(i);
                                iva += getIvaFact(i);
                                total += getTotalFact(i);
                            }
                            controladores4.controladorFacturasOC micontroladorFacturas = new controladores4.controladorFacturasOC();
                            String id = micontroladorFacturas.archivarFacturas(idOcs, neto, iva, total, "nota debito", id_fac, tiponc);
                            if(id.compareTo("incorrecto") != 0){
                                if(id.compareTo("-1") == 0){
                                    JOptionPane.showMessageDialog(null, "La nota de débito ya había sido ingresada al sistema", "Error nota de débito duplicada",
                                        JOptionPane.INFORMATION_MESSAGE);
                                    JTabbedPane tabs = (JTabbedPane) this.getParent();
                                    micontroladorOcs.crearControladorPrincipal(tabs);
                                    miControlador.crearControladorPrincipalOC(tabs);
                                }else{
                                    try {
                                        if ((miControlador.crearNotaDebXML(idOcs, Integer.toString(neto), Integer.toString(iva),
                                            Integer.toString(total), id, id_fac).compareTo("correcto") == 0)) {
                                    JTabbedPane tabs = (JTabbedPane) this.getParent();
                                    micontroladorOcs.crearControladorPrincipal(tabs);
                                    miControlador.crearControladorPrincipalOC(tabs);
                                }
                                    } catch (ParseException ex) {
                                        Logger.getLogger(vistaFacturasOCP.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede generar una nota de débito para una factura con clientes distintos");
                }
            }else{
                JOptionPane.showMessageDialog(null, "La " + tiponc + " con folio " + id_fac + " no existe.");
            }
        }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede generar una nota de débito para clientes distintos");
        }
        }else{
            JOptionPane.showMessageDialog(null, "No hay ocs para generar una nota de débito");
        }
    }//GEN-LAST:event_botonNotaDebActionPerformed

    private void botonFacExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFacExActionPerformed
//        controladores.controladorCrearFactura miControlador = new controladores.controladorCrearFactura();
//        controladores.controladorOts micontroladorOts = new controladores.controladorOts();
//        int filas = tablaFacturas.getRowCount();
//        if(filas > 0){
//            String flag = verificarRazon();
//            if(flag.compareTo("correcto") == 0){
//                String[] idOts = new String[filas];
//                int neto = 0, iva = 0, total = 0, desc = 0;
//                for (int i = 0; i < filas; i++) {
//                    idOts[i] = getIdFact(i);
//                    desc = getDescFact(i);
//                    neto += getNetoFact(i) - desc;
//                    iva += getIvaFact(i);
//                    total += getTotalFact(i);
//                }
//                controladores.controladorFacturas micontroladorFacturas = new controladores.controladorFacturas();
//                String id = micontroladorFacturas.archivarFacturas(idOts, neto, iva, total, "factura ex", "0", "0");
//                String docRef = JOptionPane.showInputDialog("Ingrese documento de referencia: ");
//                if ((miControlador.crearFacExXML(idOts, Integer.toString(neto), Integer.toString(iva),
//                    Integer.toString(total), id, docRef).compareTo("correcto") == 0)) {
//            JTabbedPane tabs = (JTabbedPane) this.getParent();
//            micontroladorOts.crearControladorPrincipal(tabs);
//            miControlador.crearControladorPrincipal(tabs);
//        }
//        }else{
//            JOptionPane.showMessageDialog(null, "No se puede generar una factura exenta para clientes distintos");
//        }
//        }else{
//            JOptionPane.showMessageDialog(null, "No hay ots para generar una factura exenta");
//        }
    }//GEN-LAST:event_botonFacExActionPerformed

    private void botonQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonQuitarActionPerformed
        String id;
        String idOc;
        controladores4.controladorOcs miControlador = new controladores4.controladorOcs();
        controladores.controladorFacturas micontroladorFacturas = new controladores.controladorFacturas();
        boolean selected = tablaFacturasOC.getSelectedRowCount() > 0;
        if (selected) {
            int row = getFilaSeleccionada();
            id = getIdFila(row);
            idOc = getIdOc(row);
            miControlador.quitarFacturaOC(idOc);
            JTabbedPane tabs = (JTabbedPane) this.getParent();
            micontroladorFacturas.crearControladorPrincipalOC(tabs);
            //JOptionPane.showMessageDialog(null, "Orden de trabajo facturada con éxito");

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una orden de trabajo quitar");
        }
    }//GEN-LAST:event_botonQuitarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        controladores.controladorFacturas miControlador = new controladores.controladorFacturas();
        JTabbedPane tabs = (JTabbedPane)this.getParent();
        miControlador.crearControladorPrincipalOC(tabs);
    }//GEN-LAST:event_botonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBoleta;
    private javax.swing.JButton botonFacEx;
    private javax.swing.JButton botonFactura3;
    private javax.swing.JButton botonNotaDeb;
    private javax.swing.JButton botonQuitar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFacturasOC;
    // End of variables declaration//GEN-END:variables

    public int getFilaSeleccionada() {
        return tablaFacturasOC.getSelectedRow();
    }

    public String getIdFila(int row) {
        return tablaFacturasOC.getValueAt(row, 0).toString();
    }
    
    public String getIdOc(int row) {
        return tablaFacturasOC.getValueAt(row, 0).toString();
    }
    
    public String verificarRazon() {
        String razon = getRazonFila(0);
        for (int i = 1; i < tablaFacturasOC.getRowCount(); i++) {
            if (razon.compareTo(getRazonFila(i)) != 0) {
                return "incorrecto";
            }
        }
        return "correcto";
    }
    
    public String getRazonFila(int row) {
        return tablaFacturasOC.getValueAt(row, 1).toString();
    }
    
    public String getIdFact(int row) {
        return tablaFacturasOC.getValueAt(row, 0).toString();
    }
    
    public int getNetoFact(int row) {
        return Integer.parseInt(tablaFacturasOC.getValueAt(row, 7).toString());
    }

    public int getDescFact(int row) {
        return Integer.parseInt(tablaFacturasOC.getModel().getValueAt(tablaFacturasOC.convertRowIndexToModel(row), 10).toString());
    }
    
    public int getIvaFact(int row) {
        return Integer.parseInt(tablaFacturasOC.getValueAt(row, 8).toString());
    }

    public int getTotalFact(int row) {
        return Integer.parseInt(tablaFacturasOC.getValueAt(row, 9).toString());
    }
    
    public boolean verificarExisteFactura(String fol, String tipo){
        modelos.modeloFacturas factura = new modeloFacturas();
        return factura.verificarExisteFactura(fol, tipo);
    }
    
    public String verificarRazonFactura(String fol, String tipo) {
        modelos.modeloFacturas factura = new modeloFacturas();
        return factura.obtenerRazonFacturaOC(fol, tipo.toLowerCase());
    }
}
