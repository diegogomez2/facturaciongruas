/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.swing.JPanel;
import vistas.vistaClientesP;
import vistas.vistaControlClientes;

/**
 *
 * @author Diego
 */
public class controladorClientes {
    static vistas.vistaControlClientes vistaClientes;
    static vistas.vistaClientesP vistaClientesP;
    
    public void mostrarVistaControlClientes(String tipo, Object[][] data){
        if(vistaClientes != null) vistaClientes.setVisible(false);
        vistaClientes = new vistaControlClientes(tipo, data);
        vistaClientes.setVisible(true);
    }
    public void focusVistaControlClientes(){
        vistaClientes.setFocusableWindowState(true);
        vistaClientes.requestFocus();
    }
    
    public void irVistaIngresarClientes() {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorIngresarClientes();
    }
    
    public void eliminarClientes(String rut){
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorEliminarClientes(rut);
    }

    public void irVistaModificarClientes(String rut, String nombres, String apP) {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorModificarClientes(rut, nombres, apP);
    }

    public void irVistaDetalleCliente(String rut) {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorDetalleCliente(rut);
    }

    public JPanel mostrarTabControlClientes(String tipo, Object[][] data) {
        //if(vistaClientes != null) vistaClientes.setVisible(false);
        vistaClientesP = new vistaClientesP(tipo, data);
        
        //vistaClientes.setVisible(true);   
        return vistaClientesP;
    }
}