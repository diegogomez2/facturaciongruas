/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores2;

import controladores.*;
import java.awt.Frame;
import javax.swing.JOptionPane;
import vistas.vistaIngresarClientes;
import vistas2.vistaIngresarProveedores;

/**
 *
 * @author Diego
 */
public class controladorIngresarProveedores {

    static vistas2.vistaIngresarProveedores vistaIP;

    public void mostrarVistaIngresarProveedores(Object[][] dataRegiones) {
        vistaIP = new vistaIngresarProveedores(new javax.swing.JFrame(), true, dataRegiones);
        vistaIP.setLocationRelativeTo(null);
        vistaIP.setVisible(true);
    }

    public boolean irVistaProveedoresP() {
        controladores.controladorPrincipal miControlador = new controladores.controladorPrincipal();
        String[] rut_dv = vistaIP.getTextoRut().split("-");
        String[] data = {rut_dv[0], rut_dv[1].toLowerCase(), vistaIP.getTextoContacto(), vistaIP.getTextoRazon(), 
            vistaIP.getTextoGiro(), vistaIP.getTextoCorreo(), vistaIP.getTextoTelefono(),
            vistaIP.getTextoDireccion(), vistaIP.getComboRegion(), vistaIP.getComboCiudad(), 
            vistaIP.getComboComuna(), vistaIP.getTextoObs(), vistaIP.getComboForma(), vistaIP.getComboMedio()};
        boolean flag = miControlador.ingresarProveedor(data);
        return flag;
    }

    public boolean verificarRut(String rut) {
        if (rut.compareTo("") != 0) {
            String[] rut_dv = rut.split("-");
            if (rut_dv.length == 2) {
                try {
                    int num = Integer.parseInt(rut_dv[0]);
                    char dv = rut_dv[1].toLowerCase().charAt(0);
                    if (validarRut(num, dv)) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(vistaIP, "Rut incorrecto");
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(vistaIP, "Rut incorrecto");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(vistaIP, "Rut incorrecto");
            return false;
        }
        JOptionPane.showMessageDialog(vistaIP, "Rut incorrecto");
        return false;
    }

    public static boolean validarRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 107);
    }

    public String camposVacios() {
        String respuesta = "";
        if (vistaIP.getTextoRut().compareTo("") == 0) {
            respuesta += "-Rut.\n";
        }
        if (vistaIP.getTextoRazon().compareTo("") == 0) {
            respuesta += "-Razón social.\n";
        }
        if (vistaIP.getTextoGiro().compareTo("") == 0) {
            respuesta += "-Giro.\n";
        }
        if (vistaIP.getTextoDireccion().compareTo("") == 0) {
            respuesta += "-Dirección.\n";
        }
        return respuesta;
    }

    public Object[] cargarComunas(int region) {
        controladorPrincipal miControlador = new controladorPrincipal();
        return miControlador.cargarComunas(region);
    }
    
    public Object[] cargarCiudades(int region) {
        controladorPrincipal miControlador = new controladorPrincipal();
        return miControlador.cargarCiudades(region);
    }
}
