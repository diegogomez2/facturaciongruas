/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author diego
 */
public class controladorJornadas {
    
    vistas.vistaJornadasP vistaJornadasP;
    public controladorJornadas() {
    }

    JPanel mostrarTabControlJornadas(String tipo, Object[][] data) {
        vistaJornadasP = new vistas.vistaJornadasP(tipo, data);  
        return vistaJornadasP;
    }

    public void irVistaIngresarJornadas() {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorIngresarJornadas();
    }
    
    public void crearControladorPrincipal(JTabbedPane tabs){
        controladorPrincipal miControlador = new controladorPrincipal();
        tabs.remove(3);
        tabs.insertTab("Jornada diaria", null, miControlador.crearcontroladorJornadaP(), null, 3);
        tabs.setSelectedIndex(3);
    }
    
}