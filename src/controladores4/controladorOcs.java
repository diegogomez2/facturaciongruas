/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores4;

import controladores.controladorPrincipal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author diego
 */
public class controladorOcs {
    static vistas4.vistaOcsP vistaOcsP;
    
    public JPanel mostrarTabControlOcs(String tipo, Object[][] data) {
        vistaOcsP = new vistas4.vistaOcsP(tipo, data);  
        return vistaOcsP;
    }

    public void irVistaIngresarOT(String[] data, Object[] ciudades) throws ParseException {
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorIngresarOT(data, ciudades);
    }
    
    public String getIdFactura(String id){
        String idFact;
        modelos4.modeloOcs ocs = new modelos4.modeloOcs();
        idFact = ocs.getIdFacturaOC(id);
        return idFact;
    }

    public void crearControladorPrincipal(JTabbedPane tabs){
        controladorPrincipal miControlador = new controladorPrincipal();
        tabs.remove(1);
        tabs.remove(1);
        tabs.insertTab("OCs", null, miControlador.crearControladorOcsP(), null, 1);
        tabs.insertTab("A facturar", null, miControlador.crearControladorFacturasOCP(), null, 2);
//        tabs.insertTab("Facturadas", null, miControlador.crearControladorFacturadasP(), null, 6);
//        tabs.insertTab("Histórico", null, miControlador.crearControladorHistoricoP(), null, 7);
        tabs.setSelectedIndex(1);
    }
    
    public String ingresarFactura(String idOc){
        String respuesta = "";
        modelos4.modeloOcs ocs = new modelos4.modeloOcs();
        respuesta = ocs.ingresarFacturaOC(idOc);
        return respuesta;
    }
    
    public String anularFactura(String idOc){
        String respuesta = "";
        modelos4.modeloOcs ocs = new modelos4.modeloOcs();
        respuesta = ocs.anularFactura(idOc);
        return respuesta;
    }
    
    public String eliminarOc(String idOc){
        String respuesta = "";
        modelos4.modeloOcs ocs = new modelos4.modeloOcs();
        respuesta = ocs.eliminarOc(idOc);
        return respuesta;
    }
    
    public void restarMensualidad(String idOc) throws ParseException{
//        int mes, year;
//        modelos.modeloEmpleados empleado = new modelos.modeloEmpleados();
//        String[][] data = empleado.obtenerHorasOc(idOc);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date fecha = sdf.parse(data[1]);
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(fecha);
//        if(cal.get(Calendar.DAY_OF_MONTH) > 25){
//            mes = cal.get(Calendar.MONTH) + 2;
//        }else{
//            mes = cal.get(Calendar.MONTH) + 1;
//        }
//        year = cal.get(Calendar.YEAR);
////        empleado.restarMensualidad(data[0], mes, year, data[2], data[3], data[4], data[5], data[6], data[7]);
        
    }
    
    public String quitarFacturaOC(String idOc){
        String respuesta = "";
        modelos4.modeloOcs ocs = new modelos4.modeloOcs();
        respuesta = ocs.quitarFacturaOC(idOc);
        return respuesta;
    }
    
    public void irVistaDetalleOcs(String id) throws ParseException{
        controladorPrincipal miControlador = new controladorPrincipal();
        miControlador.crearControladorDetalleOcs(id);
    }
}
