/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.controladorEmpleados;
import controladores.controladorGruas;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


/**
 *
 * @author Diego
 */
public class vistaIngresarOts extends javax.swing.JDialog {

    int horas = 0;
    String ton;
    String fechaInicio, fechaFin;
    String diaInicio, diaFin;
    String horaInicio, horaFin;
    String id;
    String rutEmp;
    int nuevoNeto = 0;
    DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatClock = new SimpleDateFormat("HH:mm:ss");
    NumberFormat FORMAT = NumberFormat.getCurrencyInstance();
    DecimalFormatSymbols dfs = new DecimalFormatSymbols();
    DocumentFilter onlyNumbers = new DocumentFilter() {
            Pattern regEx = Pattern.compile("\\d+");

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                Matcher matcher = regEx.matcher(text);
                if (!matcher.matches()) {
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        };
    
    public vistaIngresarOts(java.awt.Frame parent, boolean modal, String[] data, Object[] ciudades) throws ParseException {
        super(parent, modal);
        initComponents();
        dfs.setCurrencySymbol("$");
        dfs.setGroupingSeparator('.');
        dfs.setMonetaryDecimalSeparator('.');
        ((DecimalFormat) FORMAT).setDecimalFormatSymbols(dfs);
        ((AbstractDocument) textoCodigo.getDocument()).setDocumentFilter(onlyNumbers);
        textoDespacho.setEnabled(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoColacion = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        botonIngresar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        botonCalcular = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinnerCol30 = new javax.swing.JSpinner();
        spinnerCol1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        textoGiro = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        spinnerHoraSalida = new javax.swing.JSpinner(new SpinnerDateModel());
        labelHoraSalida = new javax.swing.JLabel();
        labelFinFaena = new javax.swing.JLabel();
        spinnerFinFaena = new javax.swing.JSpinner(new SpinnerDateModel());
        labelHoraLlegada = new javax.swing.JLabel();
        spinnerHoraLlegada = new javax.swing.JSpinner(new SpinnerDateModel());
        labelSeñores = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        textoRazon2 = new javax.swing.JTextField();
        textoCodigo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        textoEmpleado = new javax.swing.JTextField();
        checkHoraMinimo = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textoRazon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textoTelefono = new javax.swing.JTextField();
        textoRutCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textoDespacho = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        textoNeto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textoBruto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textoIva = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        textoDescuento = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        textoNuevoNeto = new javax.swing.JTextField();
        textoContacto = new javax.swing.JTextField();
        checkDespacho = new javax.swing.JCheckBox();
        textoCiudad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        spinnerHoraExNormales = new javax.swing.JSpinner(new SpinnerNumberModel
            (0.0, 0.0, 999.0, 0.25));
        jLabel27 = new javax.swing.JLabel();
        spinnerHoraExFes = new javax.swing.JSpinner(new SpinnerNumberModel
            (0.0, 0.0, 999.0, 0.25));
        jPanel9 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textoGrua = new javax.swing.JTextField();
        comboCondPago = new javax.swing.JComboBox<>();
        textoDespachado = new javax.swing.JTextField();
        comboFormaPago = new javax.swing.JComboBox<>();
        textoFechaOt = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar orden de trabajo");
        setResizable(false);

        botonIngresar.setText("Ingresar");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonCalcular.setText("Calcular tarifa");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });

        jLabel1.setText("Dirección");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Colación"));

        jLabel14.setText("30 min de colación");

        jLabel24.setText("No tomo colación");

        jLabel13.setText("Días");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(spinnerCol30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spinnerCol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(spinnerCol30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(spinnerCol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Giro");

        textoGiro.setEditable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Horarios"));

        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinnerHoraSalida, "HH:mm");
        spinnerHoraSalida.setEditor(timeEditor);
        spinnerHoraSalida.setValue(new Date());

        labelHoraSalida.setText("Hora salida");

        labelFinFaena.setText("Fin faena");

        JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(spinnerFinFaena, "HH:mm");
        spinnerFinFaena.setEditor(timeEditor2);
        spinnerFinFaena.setValue(new Date());

        labelHoraLlegada.setText("Hora llegada");

        JSpinner.DateEditor timeEditor3 = new JSpinner.DateEditor(spinnerHoraLlegada, "HH:mm");
        spinnerHoraLlegada.setEditor(timeEditor3);
        spinnerHoraLlegada.setValue(new Date());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelHoraSalida)
                    .addComponent(labelFinFaena)
                    .addComponent(labelHoraLlegada))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spinnerFinFaena)
                    .addComponent(spinnerHoraSalida)
                    .addComponent(spinnerHoraLlegada))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHoraSalida)
                    .addComponent(spinnerHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFinFaena)
                    .addComponent(spinnerFinFaena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHoraLlegada)
                    .addComponent(spinnerHoraLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelSeñores.setText("Señores");

        textoDireccion.setEditable(false);

        jLabel23.setText("Codigo Ot");

        textoRazon2.setEditable(false);

        jLabel21.setText("Operador");

        textoEmpleado.setEditable(false);

        checkHoraMinimo.setSelected(true);
        checkHoraMinimo.setText("Considerar horario minimo");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoCodigo)
                    .addComponent(textoRazon2)
                    .addComponent(textoDireccion)
                    .addComponent(textoGiro)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoEmpleado)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkHoraMinimo)
                            .addComponent(labelSeñores)
                            .addComponent(jLabel1)
                            .addComponent(jLabel23)
                            .addComponent(jLabel2)
                            .addComponent(jLabel21))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelSeñores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoRazon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26))
                    .addComponent(textoGiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkHoraMinimo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setText("Rut");

        textoRazon.setEditable(false);

        jLabel6.setText("Teléfono");

        textoTelefono.setEditable(false);

        textoRutCliente.setEditable(false);

        jLabel3.setText("Solicitado por");

        jLabel5.setText("Ciudad");

        jLabel7.setText("Trabajo realizado en");

        textoDespacho.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoDespachoFocusLost(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        jLabel15.setText("Neto total");

        textoNeto.setEditable(false);

        jLabel16.setText("Bruto");

        textoBruto.setEditable(false);

        jLabel17.setText("IVA");

        textoIva.setEditable(false);

        jLabel28.setText("Descuento");

        textoDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textoDescuentoFocusLost(evt);
            }
        });

        jLabel29.setText("Nuevo neto");

        textoNuevoNeto.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNuevoNeto)
                    .addComponent(textoDescuento)
                    .addComponent(textoNeto, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(textoBruto)
                    .addComponent(textoIva)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(textoDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(textoNuevoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(textoIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textoBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        checkDespacho.setText("Despacho");
        checkDespacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDespachoActionPerformed(evt);
            }
        });

        textoCiudad.setEditable(false);

        jLabel12.setText("Valor");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Horas extras"));

        jLabel25.setText("Cantidad");

        jLabel26.setText("Lunes a Sábado");

        jLabel27.setText("Domingos y festivos y nocturnos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerHoraExFes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerHoraExNormales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(spinnerHoraExNormales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(spinnerHoraExFes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textoRazon)
                    .addComponent(textoTelefono)
                    .addComponent(textoCiudad)
                    .addComponent(textoRutCliente)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(checkDespacho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textoDespacho))
                    .addComponent(textoContacto)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoRutCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoRazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDespacho)
                    .addComponent(jLabel12)
                    .addComponent(textoDespacho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setText("Despachado por");

        jLabel22.setText("Observación en faena");

        jLabel8.setText("Fecha");

        jLabel10.setText("Condición de pago");

        textoGrua.setEditable(false);

        comboCondPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Transferencia", "Efectivo", "Cheque" }));

        comboFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Al día", "30 días", "60 días", "90 días" }));

        jLabel9.setText("Forma de pago");

        jLabel11.setText("Grúa");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Recepción"));

        jLabel18.setText("Nombre");

        jLabel19.setText("C.I.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11)
                    .addComponent(jTextField12)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textoObs.setColumns(20);
        textoObs.setLineWrap(true);
        textoObs.setRows(3);
        textoObs.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textoObs);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboCondPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoGrua)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoDespachado)
                    .addComponent(textoFechaOt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboFormaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel22))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoDespachado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoFechaOt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCondPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoGrua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonIngresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonCalcular, botonCancelar, botonIngresar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonIngresar)
                    .addComponent(botonCancelar)
                    .addComponent(botonCalcular))
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

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarActionPerformed
        controladores.controladorIngresarOts miControladorIO = new controladores.controladorIngresarOts();
        String respuesta = miControladorIO.camposVacios();
        boolean esVacio = respuesta.length() == 0;
        if(!esVacio){
            JOptionPane.showMessageDialog(this, respuesta, "Debe rellenar los siguientes campos", JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(miControladorIO.irVistaJornadasP(id, horas)){
                setVisible(false);
                controladores.controladorGruas micontroladorGruas = new controladorGruas();
                controladores.controladorEmpleados micontroladorEmpleados = new controladorEmpleados();
                micontroladorGruas.agregarHoras(textoGrua.getText(), horas);
                micontroladorEmpleados.agregarMensualidad(getRutEmp(), getMes(), getYear(), getHoras(), getSpinnerHorasExtraNormales(), getSpinnerHorasExtraFestivos(), getSpinnerColacion30(), 
                        getSpinnerColacion1(), ton);
                //micontroladorEmpleados.agregarHoras(getRutEmp(), horas, ton);
                //micontroladorEmpleados.agregarColacion(getRutEmp(), getSpinnerColacion());
                //micontroladorEmpleados.agregarHorasExtra(getRutEmp(), getSpinnerHorasExtra(), getHorasExCal());
                //miControladorIO.agregarHorasExtra(id, getSpinnerHorasExtraNormales(), getSpinnerHorasExtraFestivos());
                //miControladorIO.agregarHorasColacion(id, getSpinnerColacion30(), getSpinnerColacion1());
            }
        }
    }//GEN-LAST:event_botonIngresarActionPerformed

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        controladores.controladorIngresarOts miControlador = new controladores.controladorIngresarOts();
        try {
            List<List<String>> valores = miControlador.calcularTarifa(diaInicio, diaFin, getSpinnerHoraSalida(), getSpinnerHoraLlegada(), ton, getCheckHoraMin());
            int size = valores.size();
            setTextoNeto(valores.get(size - 1).get(0));
            setNuevoNeto(Integer.parseInt(getTextoNeto()) + Integer.parseInt(getTextoDespacho()) - Integer.parseInt(getTextoDescuento()));
            setTextoNuevoNeto(String.valueOf(Integer.parseInt(getTextoNeto()) + Integer.parseInt(getTextoDespacho()) - Integer.parseInt(getTextoDescuento())));
            double nuevoIva = nuevoNeto * 0.19;
            double nuevoBruto = nuevoNeto + nuevoIva;
            setTextoIva(String.valueOf((int)nuevoIva));
            setTextoBruto(String.valueOf((int)nuevoBruto));
        } catch (ParseException ex) {
            Logger.getLogger(vistaIngresarOts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonCalcularActionPerformed

    private void checkDespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDespachoActionPerformed
        if(checkDespacho.isSelected()){
            textoDespacho.setEnabled(true);
        }else{
            textoDespacho.setEnabled(false);
        }
    }//GEN-LAST:event_checkDespachoActionPerformed

    private void textoDespachoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoDespachoFocusLost
        setTextoValorDespacho(getTextoDespacho());
        setNuevoNeto(Integer.parseInt(getTextoNeto()) + Integer.parseInt(getTextoDespacho()) - Integer.parseInt(getTextoDescuento()));
        double nuevoIva = nuevoNeto * 0.19;
        double nuevoBruto = nuevoNeto + nuevoIva;
        setTextoIva(String.valueOf((int)nuevoIva));
        setTextoBruto(String.valueOf((int)nuevoBruto));
        setTextoNuevoNeto(String.valueOf(nuevoNeto));
    }//GEN-LAST:event_textoDespachoFocusLost

    private void textoDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textoDescuentoFocusLost
        setTextoDescuento(getTextoDescuento());
        setNuevoNeto(Integer.parseInt(getTextoNeto()) - Integer.parseInt(getTextoDescuento()) + Integer.parseInt(getTextoDespacho()));
        double nuevoIva = nuevoNeto * 0.19;
        double nuevoBruto = nuevoNeto + nuevoIva;
        setTextoIva(String.valueOf((int)nuevoIva));
        setTextoBruto(String.valueOf((int)nuevoBruto));
        setTextoNuevoNeto(String.valueOf(nuevoNeto));
    }//GEN-LAST:event_textoDescuentoFocusLost

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
            java.util.logging.Logger.getLogger(vistaIngresarOts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaIngresarOts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaIngresarOts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaIngresarOts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonIngresar;
    private javax.swing.JCheckBox checkDespacho;
    private javax.swing.JCheckBox checkHoraMinimo;
    private javax.swing.JComboBox<String> comboCondPago;
    private javax.swing.JComboBox<String> comboFormaPago;
    private javax.swing.ButtonGroup grupoColacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JLabel labelFinFaena;
    private javax.swing.JLabel labelHoraLlegada;
    private javax.swing.JLabel labelHoraSalida;
    private javax.swing.JLabel labelSeñores;
    private javax.swing.JSpinner spinnerCol1;
    private javax.swing.JSpinner spinnerCol30;
    private javax.swing.JSpinner spinnerFinFaena;
    private javax.swing.JSpinner spinnerHoraExFes;
    private javax.swing.JSpinner spinnerHoraExNormales;
    private javax.swing.JSpinner spinnerHoraLlegada;
    private javax.swing.JSpinner spinnerHoraSalida;
    private javax.swing.JTextField textoBruto;
    private javax.swing.JTextField textoCiudad;
    private javax.swing.JTextField textoCodigo;
    private javax.swing.JTextField textoContacto;
    private javax.swing.JTextField textoDescuento;
    private javax.swing.JTextField textoDespachado;
    private javax.swing.JTextField textoDespacho;
    private javax.swing.JTextField textoDireccion;
    private javax.swing.JTextField textoEmpleado;
    private org.jdesktop.swingx.JXDatePicker textoFechaOt;
    private javax.swing.JTextField textoGiro;
    private javax.swing.JTextField textoGrua;
    private javax.swing.JTextField textoIva;
    private javax.swing.JTextField textoNeto;
    private javax.swing.JTextField textoNuevoNeto;
    private javax.swing.JTextArea textoObs;
    private javax.swing.JTextField textoRazon;
    private javax.swing.JTextField textoRazon2;
    private javax.swing.JTextField textoRutCliente;
    private javax.swing.JTextField textoTelefono;
    // End of variables declaration//GEN-END:variables

    public String getTextoContacto() {
        return textoContacto.getText();
    }

    public String getTextoDireccion() {
        return textoDireccion.getText();
    }

    public String getTextoEmpleado() {
        return textoEmpleado.getText();
    }

    public String getTextoGiro() {
        return textoGiro.getText();
    }

    public String getTextoGrua() {
        return textoGrua.getText();
    }

    public String getTextoRazon() {
        return textoRazon.getText();
    }

    public String getTextoRutCliente() {
        return textoRutCliente.getText();
    }

    public String getTextoTelefono() {
        return textoTelefono.getText();
    }

    public String getTextoDespachado() {
        return textoDespachado.getText();
    }

    public String getTextoObs() {
        return textoObs.getText();
    }

    public String getComboCondPago() {
        return comboCondPago.getSelectedItem().toString();
    }

    public String getComboFormaPago() {
        return comboFormaPago.getSelectedItem().toString();
    }

    public String getTextoFechaOt() {
        Date fecha = textoFechaOt.getDate();
        if(fecha == null) return "";
        String dateString = formatDate.format(textoFechaOt.getDate());
        return dateString;
    }
    
    public int getMes(){
        Date fecha = textoFechaOt.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        System.out.println("Mes: " + cal.get(Calendar.MONTH));
        if(cal.get(Calendar.DAY_OF_MONTH) > 25)
            return cal.get(Calendar.MONTH) + 2;
        return cal.get(Calendar.MONTH) + 1;  
    }
    
    public int getYear(){
        Date fecha = textoFechaOt.getDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        System.out.println("Year: " + cal.get(Calendar.YEAR));
        return cal.get(Calendar.YEAR);  
    }

    public String getTextoCodigo() {
        return textoCodigo.getText();
    }

    public String getTextoBruto() {
        String bruto = textoBruto.getText();
        bruto = bruto.replace("$", "");
        bruto = bruto.replace(".", "");
        return bruto;
    }

    public String getTextoIva() {
        String iva = textoIva.getText();
        iva = iva.replace("$", "");
        iva = iva.replace(".", "");
        return iva;
    }

    public String getTextoNeto() {
        String neto = textoNeto.getText();
        neto = neto.replace("$", "");
        neto = neto.replace(".", "");
        return neto;
    }
    
    public String getTextoNuevoNeto() {
        String neto = textoNuevoNeto.getText();
        neto = neto.replace("$", "");
        neto = neto.replace(".", "");
        return neto;
    }

    public String getSpinnerFinFaena() {
        String hora = formatClock.format(spinnerFinFaena.getValue());
        if(hora == null) return "";
        return hora;
    }

    public void setHoras(int horas){
        this.horas = horas;
    }
    
    public int getHoras(){
        return this.horas;
    }
    
    public String getSpinnerHoraSalida(){
        String hora = formatClock.format(spinnerHoraSalida.getValue());
        if(hora == null) return "";
        return hora;
    }
    
    public String getSpinnerHoraLlegada(){
        String hora = formatClock.format(spinnerHoraLlegada.getValue());
        if(hora == null) return "";
        return hora;
    }

    public String getCheckDespacho() {
        if(checkDespacho.isSelected()) return "1";
        return "0";
    }
    
    //BORRAR
    public int getSpinnerColacion(){
        int colacion = 2 * (Integer) spinnerCol1.getValue() + (Integer) spinnerCol30.getValue();
        return colacion;
    }
    
    public int getSpinnerColacion30(){
        int colacion = (Integer) spinnerCol30.getValue();
        return colacion;
    }
    
    public int getSpinnerColacion1(){
        int colacion = (Integer) spinnerCol1.getValue();
        return colacion;
    }
    
    //Horas extra totales
    /***BORRAR***/
//    public double getSpinnerHorasExtra(){
//        double horasEx = (Double) spinnerHoraExNormales.getValue() + (Double) spinnerHoraExFes.getValue();
//        return horasEx;
//    }
    
    
    public double getSpinnerHorasExtraNormales(){
        double horasEx = (Double) spinnerHoraExNormales.getValue();
        return horasEx;
    }
    
    public double getSpinnerHorasExtraFestivos(){
        double horasEx = (Double) spinnerHoraExFes.getValue();
        return horasEx;
    }

    public String getTextoDespacho() {
        if(getCheckDespacho().compareTo("0") == 0){
            return "0";
        }
        if(textoDespacho.getText().compareTo("") == 0){
            return "0";
        }else{
            String desp = textoDespacho.getText();
            desp = desp.replace("$", "");
            desp = desp.replace(".", "");
            return desp;
        }
    }

    public void setTon(String ton) {
        this.ton = ton;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDiaInicio(String diaInicio) {
        this.diaInicio = diaInicio;
    }

    public void setDiaFin(String diaFin) {
        this.diaFin = diaFin;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSpinnerFinFaena(String spinnerFinFaena) throws ParseException {
        this.spinnerFinFaena.setValue(formatClock.parse(spinnerFinFaena));
    }

    public void setSpinnerHoraLlegada(String spinnerHoraLlegada) throws ParseException {
        this.spinnerHoraLlegada.setValue(formatClock.parse(spinnerHoraLlegada));
    }

    public void setSpinnerHoraSalida(String spinnerHoraSalida) throws ParseException {
        this.spinnerHoraSalida.setValue(formatClock.parse(spinnerHoraSalida));
    }

    public void setTextoBruto(String textoBruto) {
        try{
            Object value = Integer.parseInt(textoBruto);
            if (value instanceof Number) {
                this.textoBruto.setHorizontalAlignment(JLabel.RIGHT);
                this.textoBruto.setText(FORMAT.format(value));
            } else {
                this.textoBruto.setHorizontalAlignment(JLabel.RIGHT);
                this.textoBruto.setText("");
            }
        }catch(NumberFormatException e){
            this.textoBruto.setHorizontalAlignment(JLabel.RIGHT);
            this.textoBruto.setText("");
        }
    }
    
    public void setTextoNuevoNeto(String textoNuevoNeto) {
        try{
            Object value = Integer.parseInt(textoNuevoNeto);
            if (value instanceof Number) {
                this.textoNuevoNeto.setHorizontalAlignment(JLabel.RIGHT);
                this.textoNuevoNeto.setText(FORMAT.format(value));
            } else {
                this.textoNuevoNeto.setHorizontalAlignment(JLabel.RIGHT);
                this.textoNuevoNeto.setText("");
            }
        }catch(NumberFormatException e){
            this.textoNuevoNeto.setHorizontalAlignment(JLabel.RIGHT);
            this.textoNuevoNeto.setText("");
        }
    }

    public void setTextoCiudad(String textoCiudad) {
        this.textoCiudad.setText(textoCiudad);
    }

    public void setTextoCodigo(String textoCodigo) {
        this.textoCodigo.setText(textoCodigo);
    }

    public void setTextoContacto(String textoContacto) {
        this.textoContacto.setText(textoContacto);
    }

    public void setTextoDespachado(String textoDespachado) {
        this.textoDespachado.setText(textoDespachado);
    }

    public void setTextoDespacho(String textoDespacho) {
        this.textoDespacho.setText(textoDespacho);
    }

    public void setTextoDireccion(String textoDireccion) {
        this.textoDireccion.setText(textoDireccion);
    }

    public void setTextoEmpleado(String textoEmpleado) {
        this.textoEmpleado.setText(textoEmpleado);
    }

    public void setTextoFechaOt() throws ParseException {
        this.textoFechaOt.setDate(new Date());
    }

    public void setTextoGiro(String textoGiro) {
        this.textoGiro.setText(textoGiro);
    }

    public void setTextoGrua(String textoGrua) {
        this.textoGrua.setText(textoGrua);
    }

    public void setTextoIva(String textoIva) {
        try{
            Object value = Integer.parseInt(textoIva);
            if (value instanceof Number) {
                this.textoIva.setHorizontalAlignment(JLabel.RIGHT);
                this.textoIva.setText(FORMAT.format(value));
            } else {
                this.textoIva.setHorizontalAlignment(JLabel.RIGHT);
                this.textoIva.setText("");
            }
        }catch(NumberFormatException e){
            this.textoIva.setHorizontalAlignment(JLabel.RIGHT);
            this.textoIva.setText("");
        }
    }

    public void setTextoNeto(String textoNeto) {
        try{
            Object value = Integer.parseInt(textoNeto);
            if (value instanceof Number) {
                this.textoNeto.setHorizontalAlignment(JLabel.RIGHT);
                this.textoNeto.setText(FORMAT.format(value));
            } else {
                this.textoNeto.setHorizontalAlignment(JLabel.RIGHT);
                this.textoNeto.setText("");
            }
        }catch(NumberFormatException e){
            this.textoNeto.setHorizontalAlignment(JLabel.RIGHT);
            this.textoNeto.setText("");
        }
    }

    public void setTextoObs(String textoObs) {
        this.textoObs.setText(textoObs);
    }

    public void setTextoRazon(String textoRazon) {
        this.textoRazon.setText(textoRazon);
    }

    public void setTextoRazon2(String textoRazon2) {
        this.textoRazon2.setText(textoRazon2);
    }

    public void setTextoRutCliente(String textoRutCliente) {
        this.textoRutCliente.setText(textoRutCliente);
    }

    public void setTextoTelefono(String textoTelefono) {
        this.textoTelefono.setText(textoTelefono);
    }
    
    public void setRutEmp(String rut){
        rutEmp = rut;
    }
    
    public String getRutEmp(){
        return rutEmp;
    }
    
    public boolean getCheckHoraMin(){
        if(checkHoraMinimo.isSelected()) return true;
        return false;
    }
    
    public String getTextoDescuento() {
        String desc = textoDescuento.getText().replace("$", "");
        desc = desc.replace(".", "");
        return desc;
    }
    
    public void setTextoDescuento(String desc){
        try{
            Object value = Integer.parseInt(desc);
            if (value instanceof Number) {
                textoDescuento.setHorizontalAlignment(JLabel.RIGHT);
                textoDescuento.setText(FORMAT.format(value));
            } else {
                textoDescuento.setHorizontalAlignment(JLabel.RIGHT);
                textoDescuento.setText("");
                textoDescuento.setText(FORMAT.format(0));
            }
        }catch(NumberFormatException e){
            textoDescuento.setHorizontalAlignment(JLabel.RIGHT);
            textoDescuento.setText("");
            textoDescuento.setText(FORMAT.format(0));
        }
    }
    
    public void setTextoValorDespacho(String valor){
        try{
            Object value = Integer.parseInt(valor);
            if (value instanceof Number) {
                textoDespacho.setHorizontalAlignment(JLabel.RIGHT);
                textoDespacho.setText(FORMAT.format(value));
            } else {
                textoDespacho.setHorizontalAlignment(JLabel.RIGHT);
                textoDespacho.setText("");
                textoDespacho.setText(FORMAT.format(0));
            }
        }catch(NumberFormatException e){
            textoDespacho.setHorizontalAlignment(JLabel.RIGHT);
            textoDespacho.setText("");
            textoDespacho.setText(FORMAT.format(0));
        }
    }
    
    public int getNuevoNeto(){
        return nuevoNeto;
    }
    
    public void setNuevoNeto(int neto){
        nuevoNeto = neto;
    }
}
