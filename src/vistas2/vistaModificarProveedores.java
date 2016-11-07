/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas2;

import vistas.*;
import controladores2.controladorModificarProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class vistaModificarProveedores extends javax.swing.JDialog {

    int rut;
    /**
     * Creates new form vistaModificarClientes
     */
    public vistaModificarProveedores(java.awt.Frame parent, boolean modal, final Object[][] regiones, String reg,
            String ciu, String com) {
        super(parent, modal);
        initComponents();
        String[] listaRegiones = new String[regiones.length];
        for(int i = 0; i < regiones.length; i++){
            listaRegiones[i] = regiones[i][1].toString();
        }
        comboRegion.setModel(new DefaultComboBoxModel<String>(listaRegiones));
        cargarComunas(regiones);
        cargarCiudades(regiones);
        setComboRegion(reg);
        setComboCiudad(ciu);
        setComboComuna(com);
        comboRegion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                cargarComunas(regiones);
                cargarCiudades(regiones);
            }
        });
    }
    
    public void cargarComunas(Object[][] regiones){
        controladorModificarProveedores miControlador = new controladorModificarProveedores();
        int index = comboRegion.getSelectedIndex();
        int region = Integer.parseInt(regiones[index][0].toString());
        Object[] comunas = miControlador.cargarComunas(region);
        String[] listaComunas = new String[comunas.length];
        for(int i = 0; i < comunas.length; i++){
            listaComunas[i] = comunas[i].toString();
        }
        comboComuna.setModel(new DefaultComboBoxModel<String>(listaComunas));
    }
    
    public void cargarCiudades(Object[][] regiones){
        controladorModificarProveedores miControlador = new controladorModificarProveedores();
        int index = comboRegion.getSelectedIndex();
        int region = Integer.parseInt(regiones[index][0].toString());
        Object[] ciudades = miControlador.cargarCiudades(region);
        String[] listaCiudades = new String[ciudades.length];
        for(int i = 0; i < ciudades.length; i++){
            listaCiudades[i] = ciudades[i].toString();
        }
        comboCiudad.setModel(new DefaultComboBoxModel<String>(listaCiudades));
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
        jPanel2 = new javax.swing.JPanel();
        labelDireccion = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboRegion = new javax.swing.JComboBox<>();
        labelComuna = new javax.swing.JLabel();
        comboComuna = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        comboCiudad = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoObs = new javax.swing.JTextArea();
        botonAceptar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        labelForma = new javax.swing.JLabel();
        comboForma = new javax.swing.JComboBox();
        labelMedio = new javax.swing.JLabel();
        comboMedio = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar proveedor");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion"));

        labelRut.setText("Rut");

        labelContacto.setText("Contacto");

        labelRazon.setText("Razón Social");

        textoRazon.setMaximumSize(new java.awt.Dimension(6, 20));
        textoRazon.setPreferredSize(new java.awt.Dimension(320, 20));

        labelGiro.setText("Giro");

        labelCorreo.setText("Correo");

        labelTelefono.setText("Teléfono");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRut)
                    .addComponent(labelContacto)
                    .addComponent(labelRazon)
                    .addComponent(labelGiro)
                    .addComponent(labelCorreo)
                    .addComponent(labelTelefono)
                    .addComponent(textoTelefono)
                    .addComponent(textoRut)
                    .addComponent(textoContacto)
                    .addComponent(textoGiro)
                    .addComponent(textoCorreo)
                    .addComponent(textoRazon, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(textoRazon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));

        labelDireccion.setText("Dirección");

        jLabel2.setText("Región");

        labelComuna.setText("Comuna");

        jLabel1.setText("Ciudad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoDireccion)
                    .addComponent(comboRegion, 0, 0, Short.MAX_VALUE)
                    .addComponent(comboComuna, 0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDireccion)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(labelComuna))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboCiudad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(comboRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelComuna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addComponent(jScrollPane1)
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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pago"));

        labelForma.setText("Forma de pago");

        comboForma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Al día", "30 días", "60 días", "90 días" }));

        labelMedio.setText("Medio de pago");

        comboMedio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Transferencia", "Efectivo", "Cheque" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboForma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelForma)
                            .addComponent(labelMedio))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboMedio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelForma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboMedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(botonAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        controladorModificarProveedores miControladorMP = new controladorModificarProveedores();
        String respuesta = miControladorMP.camposVacios();
        boolean esVacio = respuesta.length() == 0;
        if (!esVacio) {
            JOptionPane.showMessageDialog(this, respuesta, "Debe rellenar los siguientes campos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            boolean rutValido = miControladorMP.verificarRut(getTextoRut());
            if (rutValido) {
                if (miControladorMP.irVistaProveedoresP()) {
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
            java.util.logging.Logger.getLogger(vistaModificarProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaModificarProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaModificarProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaModificarProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
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
    private javax.swing.JComboBox comboCiudad;
    private javax.swing.JComboBox<String> comboComuna;
    private javax.swing.JComboBox comboForma;
    private javax.swing.JComboBox comboMedio;
    private javax.swing.JComboBox<String> comboRegion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelComuna;
    private javax.swing.JLabel labelContacto;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelForma;
    private javax.swing.JLabel labelGiro;
    private javax.swing.JLabel labelMedio;
    private javax.swing.JLabel labelRazon;
    private javax.swing.JLabel labelRut;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTextField textoContacto;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoGiro;
    private javax.swing.JTextArea textoObs;
    private javax.swing.JTextField textoRazon;
    private javax.swing.JTextField textoRut;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables

    public int getRut(){
        return rut;
    }

    public String getComboComuna() {
        return comboComuna.getSelectedItem().toString();
    }
    
    public String getComboCiudad() {
        return comboCiudad.getSelectedItem().toString();
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

    public String getComboRegion() {
        return comboRegion.getSelectedItem().toString();
    }
    
    public String getComboForma() {
        return comboForma.getSelectedItem().toString();
    }
    
    public String getComboMedio() {
        return comboMedio.getSelectedItem().toString();
    }

    public void setRut(int rut){
        this.rut = rut;
    }

    public void setComboComuna(String textoComuna) {
        this.comboComuna.setSelectedItem(textoComuna);
    }
    
    public void setComboCiudad(String textoCiudad) {
        this.comboCiudad.setSelectedItem(textoCiudad);
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

    public void setComboRegion(String textoRegion) {
        this.comboRegion.setSelectedItem(textoRegion);
    }

    public void setTextoRut(String textoRut) {
        this.textoRut.setText(textoRut);
    }

    public void setTextoTelefono(String textoTelefono) {
        this.textoTelefono.setText(textoTelefono);
    }
    
    public void setComboForma(String textoForma) {
        this.comboForma.setSelectedItem(textoForma);
    }
    
    public void setComboMedio(String textoMedio) {
        this.comboMedio.setSelectedItem(textoMedio);
    }
}