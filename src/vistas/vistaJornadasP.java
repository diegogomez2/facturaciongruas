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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author diego
 */
public class vistaJornadasP extends javax.swing.JPanel {

    /**
     * Creates new form vistaJornadaP
     */
    int horas = 0;
    DefaultTableModel datos;

    public vistaJornadasP(String tipo, Object[][] data) {
        initComponents();
        final int rows = 5;
        String[] columNames = {"Código", "Grúa", "Cliente", "Operador", "Fecha de salida", "Hora",
            "Observaciones"};
        datos = new DefaultTableModel(data, columNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
        tablaJornadas.setModel(datos);
        tablaJornadas.setAutoCreateRowSorter(true);
        if (tablaJornadas.getRowCount() > 0) {
            tablaJornadas.setRowSelectionInterval(0, 0);
        }
        tablaJornadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaJornadas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                JTable table = (JTable) evt.getSource();
                Point p = evt.getPoint();
                int row = table.rowAtPoint(p);
                if (evt.getClickCount() == 2) {
                    controladores.controladorJornadas miControlador = new controladores.controladorJornadas();
                    try {
                        miControlador.irVistaDetalleJornada(tablaJornadas.getValueAt(row, 0).toString());
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
        tablaJornadas = new javax.swing.JTable(){
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
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        botonAsignar = new javax.swing.JButton();
        textoFiltro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        botonGenerarGD = new javax.swing.JButton();

        tablaJornadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaJornadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaJornadas);

        botonModificar.setText("Modificar Jornada");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonEliminar.setText("Eliminar Jornada");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonAgregar.setText("Agregar Jornada");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonAsignar.setText("Asignar OT");
        botonAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarActionPerformed(evt);
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

        botonGenerarGD.setText("Generar Guía despacho");
        botonGenerarGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarGDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
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
                        .addComponent(botonAsignar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonGenerarGD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonModificar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonAgregar, botonAsignar, botonEliminar, botonModificar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(botonActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonModificar)
                    .addComponent(botonEliminar)
                    .addComponent(botonAgregar)
                    .addComponent(botonAsignar)
                    .addComponent(botonGenerarGD))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        controladores.controladorJornadas miControlador = new controladores.controladorJornadas();
        miControlador.irVistaIngresarJornadas();
        JTabbedPane tabs = (JTabbedPane) this.getParent();
        miControlador.crearControladorPrincipal(tabs);
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        controladores.controladorJornadas miControlador = new controladores.controladorJornadas();
        String id;
        boolean selected = tablaJornadas.getSelectedRowCount() > 0;
        if (selected) {
            int row = getFilaSeleccionada();
            id = getIdFila(row);
            int dialogResult = JOptionPane.showOptionDialog(null, "Esta seguro que desea eliminar la jornada: \n "
                    + "Código: " + id, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
            if (dialogResult == JOptionPane.YES_OPTION) {
                miControlador.eliminarJornadas(id);
            }
            JTabbedPane tabs = (JTabbedPane) this.getParent();
            miControlador.crearControladorPrincipal(tabs);
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una jornada para ser eliminada");
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarActionPerformed
        String id;
        controladores.controladorJornadas miControlador = new controladores.controladorJornadas();
        controladores.controladorOts miControladorOt = new controladores.controladorOts();
        boolean selected = tablaJornadas.getSelectedRowCount() > 0;
        if (selected) {
            int row = getFilaSeleccionada();
            id = getIdFila(row);
            String grua = getGruaFila(row);
            String trab = getTrabFila(row);
            trab = trab.trim();
            if (trab.compareTo("") != 0 && grua.compareTo("") != 0) {
                try {
                    miControlador.irVistaIngresarOts(id);
                } catch (ParseException ex) {
                    Logger.getLogger(vistaJornadasP.class.getName()).log(Level.SEVERE, null, ex);
                }
                JTabbedPane tabs = (JTabbedPane) this.getParent();
                miControladorOt.crearControladorPrincipal(tabs);
                miControlador.crearControladorPrincipal(tabs);
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar los datos faltantes para asignar una OT a esta jornada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una jornada para ser asignada");
        }
    }//GEN-LAST:event_botonAsignarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        controladores.controladorJornadas miControlador = new controladores.controladorJornadas();
        boolean selected = tablaJornadas.getSelectedRowCount() > 0;
        if (selected) {
            int row = getFilaSeleccionada();
            String id = getIdFila(row);
            try {
                miControlador.irVistaModificarJornadas(id);
            } catch (ParseException ex) {
                Logger.getLogger(vistaJornadasP.class.getName()).log(Level.SEVERE, null, ex);
            }
            JTabbedPane tabs = (JTabbedPane) this.getParent();
            miControlador.crearControladorPrincipal(tabs);

        } else {
            JOptionPane.showMessageDialog(tablaJornadas, "Debe seleccionar una jornada para ser modificada");
        }
    }//GEN-LAST:event_botonModificarActionPerformed

    private void textoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoFiltroKeyReleased
        String query = textoFiltro.getText();
        filtrar(query);
    }//GEN-LAST:event_textoFiltroKeyReleased

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        controladores.controladorJornadas miControlador = new controladores.controladorJornadas();
        JTabbedPane tabs = (JTabbedPane)this.getParent();
        miControlador.crearControladorPrincipal(tabs);
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonGenerarGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarGDActionPerformed
        String id;
        //controladores.controladorFacturadas miControlador = new controladores.controladorFacturadas();
        controladores.controladorJornadas miControlador = new controladores.controladorJornadas();
        controladores.controladorCrearFactura miControladorC = new controladores.controladorCrearFactura();
        boolean selected = tablaJornadas.getSelectedRowCount() > 0;
        if(selected){
            int row = getFilaSeleccionada();
            String grua = getGruaFila(row);
            if(grua.compareTo("") != 0){
                id = getIdFila(row);
                String[] jornada = miControlador.obtenerJornadaPorId(id);
                JTextField textPat = new JTextField();
                JTextField textRut = new JTextField();
                JTextField textDir = new JTextField();
                JTextField textCom = new JTextField();
                JTextField textCiud = new JTextField();
                JTextField textMon = new JTextField();
                JTextField textTras = new JTextField();
                Object[] inputs = {
                    "Indicador de traslado: ", textTras,
                    "Patente: " , textPat,
                    "Rut ", textRut, 
                    "Dirección: ", textDir,
                    "Comuna: ", textCom,
                    "Ciudad: ", textCiud,
                    "Monto: ", textMon,
                };
                int option = JOptionPane.showConfirmDialog(null, inputs, "Ingrese la información", JOptionPane.OK_CANCEL_OPTION);
                if(option == JOptionPane.OK_OPTION){
                    String ind = textTras.getText();
                    String pat = textPat.getText();
                    String rut = textRut.getText();
                    String dir = textDir.getText();
                    String com = textCom.getText();
                    String ciu = textCiud.getText();
                    String mon = textMon.getText();
                    try{
                        Object value = Integer.parseInt(mon);
                        if (value instanceof Number) {
                            if((miControladorC.crearGuiaDespXML(jornada, id, (int)value, pat, rut, dir, com, ciu, ind).compareTo("correcto") == 0)){
                                JTabbedPane tabs = (JTabbedPane)this.getParent();
                                miControlador.crearControladorPrincipal(tabs);
                            }  
                        } else {
                            JOptionPane.showMessageDialog(null, "El monto debe ser un número");
                        }
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "El monto debe ser un número");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe asignar una grúa a esta jornada para generar el despacho");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una factura para generar una guía de despacho");
        }
    }//GEN-LAST:event_botonGenerarGDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAsignar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGenerarGD;
    private javax.swing.JButton botonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaJornadas;
    private javax.swing.JTextField textoFiltro;
    // End of variables declaration//GEN-END:variables

    public JTable getTablaJornadas() {
        return tablaJornadas;
    }

    public int getFilaSeleccionada() {
        return tablaJornadas.getSelectedRow();
    }

    public String getIdFila(int row) {
        return tablaJornadas.getValueAt(row, 0).toString();
    }

    public String getGruaFila(int row) {
        return tablaJornadas.getValueAt(row, 1).toString();
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void filtrar(String query) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(datos);
        tablaJornadas.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
    }

    public String getTrabFila(int row) {
        return tablaJornadas.getValueAt(row, 3).toString();
    }

}
