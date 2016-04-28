/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.controladorModificarClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class vistaModificarClientes extends javax.swing.JDialog {

    int rut;
    /**
     * Creates new form vistaModificarClientes
     */
    public vistaModificarClientes(java.awt.Frame parent, boolean modal, final Object[][] regiones) {
        super(parent, modal);
        initComponents();
        String[] listaRegiones = new String[regiones.length];
        for(int i = 0; i < regiones.length; i++){
            listaRegiones[i] = regiones[i][1].toString();
        }
        textoRegion.setModel(new DefaultComboBoxModel<String>(listaRegiones));
        cargarComunas(regiones);
        textoRegion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                cargarComunas(regiones);
            }
        });
    }
    
    public void cargarComunas(Object[][] regiones){
        controladores.controladorModificarClientes miControlador = new controladorModificarClientes();
        int index = textoRegion.getSelectedIndex();
        int region = Integer.parseInt(regiones[index][0].toString());
        Object[][] comunas = miControlador.cargarComunas(region);
        String[] listaComunas = new String[comunas.length];
        for(int i = 0; i < comunas.length; i++){
            listaComunas[i] = comunas[i][0].toString();
        }
        textoComuna.setModel(new DefaultComboBoxModel<String>(listaComunas));
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
        labelRut = new javax.swing.JLabel();
        textoRut = new javax.swing.JTextField();
        labelContacto = new javax.swing.JLabel();
        textoContacto = new javax.swing.JTextField();
        labelRazon = new javax.swing.JLabel();
        textoRazon = new javax.swing.JTextField();
        labelGiro = new javax.swing.JLabel();
        textoGiro = new javax.swing.JTextField();
        labelCorreo = new javax.swing.JLabel();
        textoCorreo = new javax.swing.JTextField();
        labelTelefono = new javax.swing.JLabel();
        textoTelefono = new javax.swing.JTextField();
        labelCel = new javax.swing.JLabel();
        textoCel = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        labelDireccion = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textoRegion = new javax.swing.JComboBox<String>();
        labelComuna = new javax.swing.JLabel();
        textoComuna = new javax.swing.JComboBox<String>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoObs = new javax.swing.JTextArea();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

        labelRut.setText("Rut");

        labelContacto.setText("Contacto");

        labelRazon.setText("Razón Social");

        labelGiro.setText("Giro");

        labelCorreo.setText("Correo");

        labelTelefono.setText("Teléfono");

        labelCel.setText("Celular");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRut)
                            .addComponent(labelContacto)
                            .addComponent(labelRazon)
                            .addComponent(labelGiro)
                            .addComponent(labelCorreo)
                            .addComponent(labelTelefono)
                            .addComponent(labelCel))
                        .addGap(0, 310, Short.MAX_VALUE))
                    .addComponent(textoTelefono)
                    .addComponent(textoRut)
                    .addComponent(textoContacto)
                    .addComponent(textoCel)
                    .addComponent(textoRazon)
                    .addComponent(textoGiro)
                    .addComponent(textoCorreo))
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
                .addComponent(labelContacto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(labelTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));

        labelDireccion.setText("Dirección");

        jLabel2.setText("Región");

        labelComuna.setText("Comuna");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDireccion)
                    .addComponent(textoRegion, 0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDireccion)
                            .addComponent(jLabel2)
                            .addComponent(labelComuna))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(textoComuna, 0, 0, Short.MAX_VALUE))
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
                .addComponent(jLabel2)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        controladores.controladorModificarClientes miControladorMC = new controladores.controladorModificarClientes();
        String respuesta = miControladorMC.camposVacios();
        boolean esVacio = respuesta.length() == 0;
        if (!esVacio) {
            JOptionPane.showMessageDialog(this, respuesta, "Debe rellenar los siguientes campos", JOptionPane.INFORMATION_MESSAGE);
            //remarcarVacios();
        } else {
            //remarcarVacios();
            boolean rutValido = miControladorMC.verificarRut(getTextoRut());
            if (rutValido) {
                if (miControladorMC.irVistaClientesP()) {
                    setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(vistaModificarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaModificarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaModificarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaModificarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCel;
    private javax.swing.JLabel labelComuna;
    private javax.swing.JLabel labelContacto;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelGiro;
    private javax.swing.JLabel labelRazon;
    private javax.swing.JLabel labelRut;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTextField textoCel;
    private javax.swing.JComboBox<String> textoComuna;
    private javax.swing.JTextField textoContacto;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoGiro;
    private javax.swing.JTextArea textoObs;
    private javax.swing.JTextField textoRazon;
    private javax.swing.JComboBox<String> textoRegion;
    private javax.swing.JTextField textoRut;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables

    public int getRut(){
        return rut;
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

    public String getTextoGiro() {
        return textoGiro.getText();
    }

    public String getTextoContacto() {
        return textoContacto.getText();
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

    public void setRut(int rut){
        this.rut = rut;
    }

    public void setTextoCel(String textoCel) {
        this.textoCel.setText(textoCel);
    }

    public void setTextoComuna(String textoComuna) {
        this.textoComuna.setSelectedItem(textoComuna);
    }

    public void setTextoCorreo(String textoCorreo) {
        this.textoCorreo.setText(textoCorreo);
    }

    public void setTextoDireccion(String textoDireccion) {
        this.textoDireccion.setText(textoDireccion);
    }

    public void setTextoGiro(String textoGiro) {
        this.textoGiro.setText(textoGiro);
    }

    public void setTextoContacto(String textoNombres) {
        this.textoContacto.setText(textoNombres);
    }

    public void setTextoObs(String textoObs) {
        this.textoObs.setText(textoObs);
    }

    public void setTextoRazon(String textoRazon) {
        this.textoRazon.setText(textoRazon);
    }

    public void setTextoRegion(String textoRegion) {
        this.textoRegion.setSelectedItem(textoRegion);
    }

    public void setTextoRut(String textoRut) {
        this.textoRut.setText(textoRut);
    }

    public void setTextoTelefono(String textoTelefono) {
        this.textoTelefono.setText(textoTelefono);
    }

//    private void remarcarVacios() {
//        boolean vacio;
//        vacio = (textoRut.getText().compareTo("") == 0)? true : false;
//        setLabelRut(vacio);
//        vacio = (textoContacto.getText().compareTo("") == 0)? true : false;
//        setLabelNombres(vacio);
//       vacio = (textoApPaterno.getText().compareTo("") == 0)? true : false;
//        setLabelApPaterno(vacio);
//        vacio = (textoApMaterno.getText().compareTo("") == 0)? true : false;
//        setLabelApMaterno(vacio);
//        vacio = (textoRazon.getText().compareTo("") == 0)? true : false;
//        setLabelRazon(vacio);
//        vacio = (textoGiro.getText().compareTo("") == 0)? true : false;
//        setLabelGiro(vacio);
//        vacio = (textoCorreo.getText().compareTo("") == 0)? true : false;
//        setLabelCorreo(vacio);
//        vacio = (textoDireccion.getText().compareTo("") == 0)? true : false;
//        setLabelDireccion(vacio);    
//    }

//
//    public void setLabelCorreo(boolean vacio) {
//        if(vacio){
//            labelCorreo.setText("<html>Correo<font color='red'> (*)</font></html>");
//        }else{
//            labelCorreo.setText("Correo");
//        }
//    }
//
//    public void setLabelDireccion(boolean vacio) {
//        if(vacio){
//            labelDireccion.setText("<html>Dirección<font color='red'> (*)</font></html>");
//        }else{
//            labelDireccion.setText("Dirección");
//        }
//    }
//
//    public void setLabelNombres(boolean vacio) {
//        if(vacio){
//            labelContacto.setText("<html>Nombres<font color='red'> (*)</font></html>");
//        }else{
//            labelContacto.setText("Nombres");
//        }
//    }
//
//    public void setLabelRazon(boolean vacio) {
//        if(vacio){
//            labelRazon.setText("<html>Razón<font color='red'> (*)</font></html>");
//        }else{
//            labelRazon.setText("Razón");
//        }
//    }
//
//    public void setLabelRut(boolean vacio) {
//        if(vacio){
//            labelRut.setText("<html>Rut<font color='red'> (*)</font></html>");
//        }else{
//            labelRut.setText("Rut");
//        }
//    }
//
//    public void setLabelGiro(boolean vacio) {
//        if(vacio){
//            labelGiro.setText("<html>Giro<font color='red'> (*)</font></html>");
//        }else{
//            labelGiro.setText("Giro");
//        }
//    }
}
