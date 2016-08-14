/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores2;

import controladores.*;
import java.text.ParseException;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import vistas2.vistaComprasP;

/**
 *
 * @author Diego
 */
public class controladorCompras {

    static vistaComprasP vistaComprasP;

    public void irVistaIngresarCompras() {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorIngresarCompras();
    }

    public void eliminarProveedores(String rut) {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorEliminarProveedores(rut);
    }

    public void irVistaModificarCompras(String id) throws ParseException {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorModificarCompras(id);
    }

    public void irVistaDetalleCompras(String id) throws ParseException {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorDetalleCompra(id);
    }

    public JPanel mostrarTabControlCompras(String tipo, Object[][] data) {
        vistaComprasP = new vistaComprasP(tipo, data);
        return vistaComprasP;
    }

    public void crearControladorPrincipal(JTabbedPane tabs) {
        controladorPrincipal miControlador = new controladorPrincipal();
        tabs.remove(1);
        tabs.insertTab("Compras", null, miControlador.crearControladorComprasP(), null, 1);
        tabs.setSelectedIndex(1);
    }
}
