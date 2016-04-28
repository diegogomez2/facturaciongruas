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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelOperador)
                            .addComponent(labelCliente)
                            .addComponent(labelGrua)
                            .addComponent(labelHoraSalida)
                            .addComponent(labelFechaSalida)
                            .addComponent(textoGrua)
                            .addComponent(textoHoraSalida)
                            .addComponent(textoFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(textoEmpleado)
                            .addComponent(textoCliente))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollpan)
                            .addComponent(labelFechaRegreso)
                            .addComponent(labelObs)
                            .addComponent(labelHoraRegreso)
                            .addComponent(textoFechaRegreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoHoraRegreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelFechaSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(labelHoraSalida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelGrua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoGrua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelCliente)
                        .addGap(10, 10, 10)
                        .addComponent(textoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelOperador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelFechaRegreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoFechaRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(labelHoraRegreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoHoraRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(labelObs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollpan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(botonCancelar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

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
    private javax.swing.JPanel jPanel1;
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

}
