/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author diego
 */
public class vistaDetalleJornadas extends javax.swing.JDialog {

    /**
     * Creates new form vistaDetalleJornadas
     */
    DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat formatClock = new SimpleDateFormat("HH:mm");
    DateFormat formateDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public vistaDetalleJornadas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelFechaSalida = new javax.swing.JLabel();
        textoFechaSalida = new org.jdesktop.swingx.JXDatePicker();
        labelHoraSalida = new javax.swing.JLabel();
        textoHoraSalida = new javax.swing.JSpinner(new SpinnerDateModel());
        labelGrua = new javax.swing.JLabel();
        labelCliente = new javax.swing.JLabel();
        labelOperador = new javax.swing.JLabel();
        labelFechaRegreso = new javax.swing.JLabel();
        textoFechaRegreso = new org.jdesktop.swingx.JXDatePicker();
        labelHoraRegreso = new javax.swing.JLabel();
        labelObs = new javax.swing.JLabel();
        textoGrua = new javax.swing.JTextField();
        textoCliente = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        scrollpan = new javax.swing.JScrollPane();
        textoObs = new javax.swing.JTextArea();
        textoHoraRegreso = new javax.swing.JSpinner(new SpinnerDateModel());
        textoEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoObsCliente = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle jornada");

        labelFechaSalida.setText("Fecha de salida");

        textoFechaSalida.setEnabled(false);

        labelHoraSalida.setText("Hora de salida");

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(textoHoraSalida, "HH:mm:ss");
        textoHoraSalida.setEditor(timeEditor);
        textoHoraSalida.setValue(new Date());
        textoHoraSalida.setEnabled(false);

        labelGrua.setText("Grúa");

        labelCliente.setText("Cliente");

        labelOperador.setText("Operador");

        labelFechaRegreso.setText("Fecha de regreso");

        textoFechaRegreso.setEnabled(false);

        labelHoraRegreso.setText("Hora de regreso");

        labelObs.setText("Observaciones");

        textoGrua.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoGrua.setEnabled(false);

        textoCliente.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoCliente.setEnabled(false);
        textoCliente.setMaximumSize(new java.awt.Dimension(6, 20));

        botonCancelar.setText("OK");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        textoObs.setColumns(20);
        textoObs.setRows(5);
        textoObs.setEnabled(false);
        scrollpan.setViewportView(textoObs);

        JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(textoHoraRegreso, "HH:mm:ss");
        textoHoraRegreso.setEditor(timeEditor2);
        textoHoraRegreso.setValue(new Date());
        textoHoraRegreso.setEnabled(false);

        textoEmpleado.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        textoEmpleado.setEnabled(false);
        textoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoEmpleadoActionPerformed(evt);
            }
        });

        jLabel1.setText("Observaciones cliente");

        textoObsCliente.setColumns(20);
        textoObsCliente.setRows(5);
        jScrollPane1.setViewportView(textoObsCliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoGrua)
                            .addComponent(textoHoraSalida)
                            .addComponent(labelCliente)
                            .addComponent(labelGrua)
                            .addComponent(labelHoraSalida)
                            .addComponent(labelFechaSalida)
                            .addComponent(textoFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textoHoraRegreso, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(scrollpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                            .addComponent(textoFechaRegreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelHoraRegreso)
                            .addComponent(labelFechaRegreso)
                            .addComponent(labelOperador)
                            .addComponent(textoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelObs))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelFechaSalida)
                            .addComponent(labelFechaRegreso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(labelHoraSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelGrua)
                            .addComponent(labelOperador)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(textoFechaRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(labelHoraRegreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoHoraRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoGrua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCliente)
                    .addComponent(labelObs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(scrollpan, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(botonCancelar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void textoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(vistaDetalleJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaDetalleJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaDetalleJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaDetalleJornadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vistaDetalleJornadas dialog = new vistaDetalleJornadas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelFechaRegreso;
    private javax.swing.JLabel labelFechaSalida;
    private javax.swing.JLabel labelGrua;
    private javax.swing.JLabel labelHoraRegreso;
    private javax.swing.JLabel labelHoraSalida;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelOperador;
    private javax.swing.JScrollPane scrollpan;
    private javax.swing.JTextField textoCliente;
    private javax.swing.JTextField textoEmpleado;
    private org.jdesktop.swingx.JXDatePicker textoFechaRegreso;
    private org.jdesktop.swingx.JXDatePicker textoFechaSalida;
    private javax.swing.JTextField textoGrua;
    private javax.swing.JSpinner textoHoraRegreso;
    private javax.swing.JSpinner textoHoraSalida;
    private javax.swing.JTextArea textoObs;
    private javax.swing.JTextArea textoObsCliente;
    // End of variables declaration//GEN-END:variables

    public void setTextoCliente(String comboCliente) {
        this.textoCliente.setText(comboCliente);
    }

    public void setTextoGrua(String comboGrua) {
        this.textoGrua.setText(comboGrua);
    }

    public void setTextoOperador(String comboOperador) {
        this.textoEmpleado.setText(comboOperador);
    }

    public void setTextoFechaRegreso(String textoFechaRegreso) throws ParseException {
        this.textoFechaRegreso.setDate(formatDate.parse(textoFechaRegreso));
    }

    public void setTextoFechaSalida(String textoFechaSalida) throws ParseException {
        this.textoFechaSalida.setDate(formatDate.parse(textoFechaSalida));
    }

    public void setTextoHoraRegreso(String textoHoraRegreso) throws ParseException {
        this.textoHoraRegreso.setValue(formatClock.parse(textoHoraRegreso));
    }

    public void setTextoHoraSalida(String textoHoraSalida) throws ParseException {
        this.textoHoraSalida.setValue(formatClock.parse(textoHoraSalida));
    }

    public void setTextoObs(String textoObs) {
        this.textoObs.setText(textoObs);
    }
    
    public void setTextoObsCliente(String textoObsCliente){
        this.textoObsCliente.setText(textoObsCliente);
    }

}
