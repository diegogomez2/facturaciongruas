/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Diego
 */
public class vistaIngresarClientes extends javax.swing.JDialog {

    /**
     * Creates new form vistaIngresarClientes
     */
    public vistaIngresarClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelRut = new javax.swing.JLabel();
        textoRut = new javax.swing.JTextField();
        labelNombres = new javax.swing.JLabel();
        textoNombres = new javax.swing.JTextField();
        labelApPaterno = new javax.swing.JLabel();
        textoApPaterno = new javax.swing.JTextField();
        labelApMaterno = new javax.swing.JLabel();
        textoApMaterno = new javax.swing.JTextField();
        labelRazon = new javax.swing.JLabel();
        textoRazon = new javax.swing.JTextField();
        labelGiro = new javax.swing.JLabel();
        textoGiro = new javax.swing.JTextField();
        labelCorreo = new javax.swing.JLabel();
        textoCorreo = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        textoTelefono = new javax.swing.JTextField();
        labelFax = new javax.swing.JLabel();
        textoFax = new javax.swing.JTextField();
        labelCel = new javax.swing.JLabel();
        textoCel = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        labelDireccion = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        labelRegin = new javax.swing.JLabel();
        textoRegion = new javax.swing.JComboBox<>();
        labelComuna = new javax.swing.JLabel();
        textoComuna = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoObs = new javax.swing.JTextArea();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion", 0, 0, null, java.awt.Color.black));

        labelRut.setText("Rut");

        labelNombres.setText("Nombres");

        labelApPaterno.setText("Apellido Paterno");

        labelApMaterno.setText("Apellido Materno");

        labelRazon.setText("Razón Social");

        labelGiro.setText("Giro");

        labelCorreo.setText("Correo");

        labelTelefono.setText("Teléfono");

        labelFax.setText("Fax");

        labelCel.setText("Celular");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoCel)
                    .addComponent(textoRut)
                    .addComponent(textoNombres)
                    .addComponent(textoApPaterno)
                    .addComponent(textoApMaterno)
                    .addComponent(textoRazon)
                    .addComponent(textoGiro)
                    .addComponent(textoCorreo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textoFax))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRut)
                            .addComponent(labelNombres)
                            .addComponent(labelApPaterno)
                            .addComponent(labelApMaterno)
                            .addComponent(labelRazon)
                            .addComponent(labelGiro)
                            .addComponent(labelCorreo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelTelefono)
                                .addGap(143, 143, 143)
                                .addComponent(labelFax))
                            .addComponent(labelCel))
                        .addGap(0, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelRut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNombres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelApPaterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelApMaterno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelRazon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoRazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelGiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoGiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(labelFax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));

        labelDireccion.setText("Dirección");

        labelRegin.setText("Región");

        textoRegion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "METROPOLITANA" }));

        labelComuna.setText("Comuna");

        textoComuna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "La Florida", "Maipu", "La Cisterna", "Las Condes" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDireccion)
                    .addComponent(textoRegion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDireccion)
                            .addComponent(labelRegin)
                            .addComponent(labelComuna))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textoComuna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelRegin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelComuna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Observaciones"));

        textoObs.setColumns(20);
        textoObs.setRows(5);
        jScrollPane1.setViewportView(textoObs);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.setVisible(false);
    }                                             

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        controladores.controladorIngresarClientes miControladorIC = new controladores.controladorIngresarClientes();
        String respuesta = miControladorIC.camposVacios();
        boolean esVacio = respuesta.length() == 0;
        if (!esVacio) {
            JOptionPane.showMessageDialog(this, respuesta, "Debe rellenar los siguientes campos", JOptionPane.INFORMATION_MESSAGE);
            remarcarVacios();
        } else {
            remarcarVacios();
            boolean rutValido = miControladorIC.verificarRut(getTextoRut());
            if (rutValido) {
                if (miControladorIC.irVistaControlClientes()) {
                    setVisible(false);
                }
            }
        }
    }                                            

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
            java.util.logging.Logger.getLogger(vistaIngresarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaIngresarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaIngresarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaIngresarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vistaIngresarClientes dialog = new vistaIngresarClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelApMaterno;
    private javax.swing.JLabel labelApPaterno;
    private javax.swing.JLabel labelCel;
    private javax.swing.JLabel labelComuna;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelFax;
    private javax.swing.JLabel labelGiro;
    private javax.swing.JLabel labelNombres;
    private javax.swing.JLabel labelRazon;
    private javax.swing.JLabel labelRegin;
    private javax.swing.JLabel labelRut;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTextField textoApMaterno;
    private javax.swing.JTextField textoApPaterno;
    private javax.swing.JTextField textoCel;
    private javax.swing.JComboBox<String> textoComuna;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoFax;
    private javax.swing.JTextField textoGiro;
    private javax.swing.JTextField textoNombres;
    private javax.swing.JTextArea textoObs;
    private javax.swing.JTextField textoRazon;
    private javax.swing.JComboBox<String> textoRegion;
    private javax.swing.JTextField textoRut;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration                   

    public String getTextoApMaterno() {
        return textoApMaterno.getText();
    }

    public String getTextoApPaterno() {
        return textoApPaterno.getText();
    }

    public String getTextoCel() {
        return textoCel.getText();
    }

    public String getTextoComuna() {
        return textoComuna.getSelectedItem().toString();
    }

    public String getTextoCorreo() {
        return textoCorreo.getText();
    }

    public String getTextoDireccion() {
        return textoDireccion.getText();
    }

    public String getTextoFax() {
        return textoFax.getText();
    }

    public String getTextoGiro() {
        return textoGiro.getText();
    }

    public String getTextoNombres() {
        return textoNombres.getText();
    }

    public String getTextoObs() {
        return textoObs.getText();
    }

    public String getTextoRazon() {
        return textoRazon.getText();
    }

    public String getTextoRut() {
        return textoRut.getText();
    }

    public String getTextoTelefono() {
        return textoTelefono.getText();
    }

    public String getTextoRegion() {
        return textoRegion.getSelectedItem().toString();
    }

    public void setLabelApMaterno(boolean vacio) {
        if(vacio){
            labelApMaterno.setText("<html>Apellido Materno<font color='red'> (*)</font></html>");
        }else{
            labelApMaterno.setText("Apellido Materno");
        }
    }

    public void setLabelApPaterno(boolean vacio) {
        if(vacio){
            labelApPaterno.setText("<html>Apellido Paterno<font color='red'> (*)</font></html>");
        }else{
            labelApPaterno.setText("Apellido Paterno");
        }    
    }

    public void setLabelCorreo(boolean vacio) {
        if(vacio){
            labelCorreo.setText("<html>Correo<font color='red'> (*)</font></html>");
        }else{
            labelCorreo.setText("Correo");
        }
    }

    public void setLabelDireccion(boolean vacio) {
        if(vacio){
            labelDireccion.setText("<html>Dirección<font color='red'> (*)</font></html>");
        }else{
            labelDireccion.setText("Dirección");
        }
    }

    public void setLabelNombres(boolean vacio) {
        if(vacio){
            labelNombres.setText("<html>Nombres<font color='red'> (*)</font></html>");
        }else{
            labelNombres.setText("Nombres");
        }
    }

    public void setLabelRazon(boolean vacio) {
        if(vacio){
            labelRazon.setText("<html>Razón<font color='red'> (*)</font></html>");
        }else{
            labelRazon.setText("Razón");
        }
    }

    public void setLabelRut(boolean vacio) {
        if(vacio){
            labelRut.setText("<html>Rut<font color='red'> (*)</font></html>");
        }else{
            labelRut.setText("Rut");
        }
    }

    public void setLabelGiro(boolean vacio) {
        if(vacio){
            labelGiro.setText("<html>Giro<font color='red'> (*)</font></html>");
        }else{
            labelGiro.setText("Giro");
        }
    }

    private void remarcarVacios() {
        boolean vacio;
        vacio = (textoRut.getText().compareTo("") == 0)? true : false;
        setLabelRut(vacio);
        vacio = (textoNombres.getText().compareTo("") == 0)? true : false;
        setLabelNombres(vacio);
       vacio = (textoApPaterno.getText().compareTo("") == 0)? true : false;
        setLabelApPaterno(vacio);
        vacio = (textoApMaterno.getText().compareTo("") == 0)? true : false;
        setLabelApMaterno(vacio);
        vacio = (textoRazon.getText().compareTo("") == 0)? true : false;
        setLabelRazon(vacio);
        vacio = (textoGiro.getText().compareTo("") == 0)? true : false;
        setLabelGiro(vacio);
        vacio = (textoCorreo.getText().compareTo("") == 0)? true : false;
        setLabelCorreo(vacio);
        vacio = (textoDireccion.getText().compareTo("") == 0)? true : false;
        setLabelDireccion(vacio);
    }
}
