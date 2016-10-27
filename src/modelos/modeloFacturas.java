/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author diego
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class modeloFacturas {
    Connector conector = Connector.getInstance();
    String login = conector.getLogin();
    String password = conector.getPassword();
    String url = conector.getUrl();
    Connection conn = null;
    DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public String ingresarFacturada(String fec, int valorNeto, int valorIva, int valorTotal, String tipo, String folio){        
        String id = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("insert into facturas (fec_fac, neto_fac,"
                    + "iva_fac, tot_fac, tipo_fac, fol_fac)"
                    + " values (?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, fec);
            pstm.setInt(2, valorNeto);
            pstm.setInt(3, valorIva);
            pstm.setInt(4, valorTotal);
            pstm.setString(5, tipo);
            pstm.setInt(6, Integer.parseInt(folio));
            pstm.execute();
            ResultSet res = pstm.getGeneratedKeys();
            res.next();
            id = res.getString(1);
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error ingresar facturada");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return id;
    }
    
    public Object[][] listarFacturadas(){
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT COUNT(1) as total from  facturas");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            pstm = conn.prepareStatement("SELECT COUNT(1) as total from  notacredito");
            res = pstm.executeQuery();
            res.next();
            registros += res.getInt("total");
            res.close();
            pstm = conn.prepareStatement("SELECT COUNT(1) as total from  notadebito");
            res = pstm.executeQuery();
            res.next();
            registros += res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error listar facturadas");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][11];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_fac as fol, raz_cli, gir_cli, dir_cli, \n" +
            "ciu_cli, com_cli,tot_fac as tot, neto_fac as neto, iva_fac as iva"
                    + ",fec_fac as fec, tipo_fac as tipo FROM facturas f INNER JOIN( " +
            "SELECT  id_fac, rut_cli " +
            "FROM jornadas GROUP BY id_fac) b ON b.id_fac = f.id_fac " +
            "INNER JOIN clientes c on c.rut_cli = b.rut_cli " +
            "UNION " +
            "SELECT fol_nc as fol, raz_cli, gir_cli, dir_cli, " +
            "ciu_cli, com_cli, tot_fac, neto_fac as neto, iva_fac as iva"
                    + ", fec_nc as fec, tipo_nc as tipo FROM notacredito f " +
            "INNER JOIN(SELECT  id_fac, rut_cli " +
            "FROM jornadas GROUP BY id_fac) b ON b.id_fac = f.id_fac " +
            "INNER JOIN clientes c on c.rut_cli = b.rut_cli " +
            "INNER JOIN facturas on facturas.id_fac = f.id_fac " +
            "UNION " +
            "SELECT fol_nd as fol, raz_cli, gir_cli, dir_cli, " +
            "ciu_cli, com_cli, tot_nd as tot, neto_nd as neto, iva_nd as iva"
                    + ", fec_nd as fec, tipo_nd as tipo FROM notadebito f " +
            "INNER JOIN(SELECT  id_fac, rut_cli " +
            "FROM jornadas GROUP BY id_fac) b ON b.id_fac = f.id_fac " +
            "INNER JOIN clientes c on c.rut_cli = b.rut_cli " +
            "INNER JOIN facturas on facturas.id_fac = f.id_fac order by fec DESC");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estid = res.getString("fol");
                String estfec = res.getString("fec");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("tot");
                String estnet = res.getString("neto");
                String estiva = res.getString("iva");
                String esttip = res.getString("tipo");

                data[i] = new String[]{estid, estraz, estgir, estdir, estciu, estcom, estfec, estnet,
                    estiva, esttot, esttip };
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error listar facturadas");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public String[] obtenerFacturaPorId(String id) {
        String[] data = new String[]{};
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT neto_fac, iva_fac, tot_fac "
                    + "FROM facturas WHERE id_fac = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estnet = res.getString("neto_fac");
            String estiva = res.getString("iva_fac");
            String esttot = res.getString("tot_fac");
            data = new String[]{estnet, estiva, esttot, res.getString(1)};
        }catch(SQLException e){
            System.out.println("Error obtener factura por id");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    public String[] obtenerFacturaPorIdNC(String id) {
        String[] data = new String[]{};
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT cod_ot, neto_fac, iva_fac, tot_fac, facturas.id_fac "
                    + "FROM facturas WHERE id_fac = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estcod = res.getString("cod_ot");
            String estnet = res.getString("neto_fac");
            String estiva = res.getString("iva_fac");
            String esttot = res.getString("tot_fac");
            String estfac = res.getString("facturas.id_fac");
            data = new String[]{estcod, estnet, estiva, esttot, estfac, res.getString(1)};
        }catch(SQLException e){
            System.out.println("Error obtener factura por id");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    public String[] obtenerOtsPorIdNC(String id) {
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM notacredito INNER"
                    + " JOIN facturas ON notacredito.id_fac = facturas.id_fac INNER JOIN jornadas ON "
                    + "jornadas.id_fac = facturas.id_fac WHERE id_nc = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener ot por id nc");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        String[] data = new String[registros];
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT cod_ot FROM "
                    + "jornadas INNER JOIN facturas ON jornadas.id_fac = facturas.id_fac INNER JOIN "
                    + "notacredito ON notacredito.id_fac = facturas.id_fac WHERE id_nc = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estcod = res.getString("cod_ot");
                data[i] = estcod;
                i++;
            }
            
        }catch(SQLException e){
            System.out.println("Error obtener ots por id nc");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    //OBTIENE LOS CODIGOS POR LA ID DE LA FACTURA
    public String[] obtenerOtsPorIdFacturada(String id) {
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM"
                    + " jornadas WHERE id_fac = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener ot por id fact");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        String[] data = new String[registros];
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT cod_ot FROM "
                    + "jornadas WHERE id_fac = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estcod = res.getString("cod_ot");
                data[i] = estcod;
                i++;
            }
            
        }catch(SQLException e){
            System.out.println("Error obtener ots por id fac");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    public String[] obtenerValoresNC(String id) {
        String[] data = new String[]{};
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT facturas.id_fac, neto_fac, iva_fac, tot_fac FROM "
                    + "facturas INNER JOIN notacredito ON facturas.id_fac = notacredito.id_fac "
                    + "WHERE id_nc = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfac = res.getString("id_fac");
            String estnet = res.getString("neto_fac");
            String estiva = res.getString("iva_fac");
            String esttot = res.getString("tot_fac");
            data = new String[]{estfac, estnet, estiva, esttot};
        }catch(SQLException e){
            System.out.println("Error obtener valores ots por id nc");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    public String ingresarNotaCredito(String id, String razon, String folio, String tipo){    
        String fecha = formatDate.format(new Date());
        String id_nc;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT id_fac FROM facturas where fol_fac = ?"
                    + " AND tipo_fac = ?");
            pstm.setString(1, id);
            pstm.setString(2, tipo);
            ResultSet res = pstm.executeQuery();
            res.next();
            String id_fac = res.getString("id_fac");
            pstm.close();
            res.close();
            pstm = conn.prepareStatement("insert into notacredito (fec_nc, raz_nc, id_fac, fol_nc, tipo_nc)"
                    + " values (?, ?, ?, ?, 'notacredito')", PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, fecha);
            pstm.setString(2, razon);
            pstm.setInt(3, Integer.parseInt(id_fac));
            pstm.setInt(4, Integer.parseInt(folio));
            pstm.execute();
            res = pstm.getGeneratedKeys();
            res.next();
            id_nc = res.getString(1);
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error ingresar nota credito");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return id_nc;
    }
    
    public String ingresarND(String fec, int valorNeto, int valorIva, int valorTotal, String id_fac, String folio, String tiponc){        
        String id = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT id_fac FROM facturas where fol_fac = ?"
                    + " AND tipo_fac = ?");
            pstm.setString(1, id_fac);
            pstm.setString(2, tiponc);
            ResultSet res = pstm.executeQuery();
            res.next();
            String idFac = res.getString("id_fac");
            pstm.close();
            res.close();
            pstm = conn.prepareStatement("insert into notadebito (fec_nd, neto_nd,"
                    + "iva_nd, tot_nd, id_fac, fol_nd, tipo_nd)"
                    + " values (?, ?, ?, ?, ?, ?, 'notadebito')", PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, fec);
            pstm.setInt(2, valorNeto);
            pstm.setInt(3, valorIva);
            pstm.setInt(4, valorTotal);
            pstm.setString(5, idFac);
            pstm.setInt(6, Integer.parseInt(folio));
            pstm.execute();
            res = pstm.getGeneratedKeys();
            res.next();
            id = res.getString(1);
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error ingresar nota debito");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return id;
    }
    
    public String folioFac(){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_fac from folios WHERE id_fol = 1 "
                    + "FOR UPDATE"); 
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_fac");
            fol = estfol;
            pstm = conn.prepareStatement("UPDATE folios SET fol_fac = fol_fac + 1 WHERE id_fol = 1");
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error obtener folio fac");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String folioFacEx(){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_facex from folios WHERE id_fol = 1 "
                    + "FOR UPDATE");
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_facex");
            fol = estfol;
            pstm = conn.prepareStatement("UPDATE folios SET fol_facex = fol_facex + 1 WHERE id_fol = 1");
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error obtener folio facex");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String folioBol(){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_bol from folios WHERE id_fol = 1 "
                    + "FOR UPDATE");
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_bol");
            fol = estfol;
            pstm = conn.prepareStatement("UPDATE folios SET fol_bol = fol_bol + 1 WHERE id_fol = 1");
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error folio bol");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String folioND(){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_nd from folios WHERE id_fol = 1 "
                    + "FOR UPDATE");
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_nd");
            fol = estfol;
            pstm = conn.prepareStatement("UPDATE folios SET fol_nd = fol_nd + 1 WHERE id_fol = 1");
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error folio nd");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String folioNC(){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_nc from folios WHERE id_fol = 1 "
                    + "FOR UPDATE");
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_nc");
            fol = estfol;
            pstm = conn.prepareStatement("UPDATE folios SET fol_nc = fol_nc + 1 WHERE id_fol = 1");
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error folio nc");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String folioGuiaDesp(){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_gd from folios WHERE id_fol = 1 "
                    + "FOR UPDATE");
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_gd");
            fol = estfol;
            pstm = conn.prepareStatement("UPDATE folios SET fol_gd = fol_gd + 1 WHERE id_fol = 1");
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error folio fd");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String obtenerFolioFac(String id){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_fac from facturas WHERE id_fac = ? ");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_fac");
            fol = estfol;
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error obtener folio fac");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String obtenerFolioNC(String id){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_nc from notacredito WHERE id_nc = ? ");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_nc");
            fol = estfol;
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error obtener folio nc");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String obtenerFolioND(String id){
        String fol = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fol_nd from notadebito WHERE id_nd = ? ");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfol = res.getString("fol_nd");
            fol = estfol;
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error obtener folio nd");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fol;
    }
    
    public String obtenerFechaFac(String id, String tipo){
        String fec = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fec_fac from facturas WHERE fol_fac = ? and"
                    + " tipo_fac = ?");
            pstm.setString(1, id);
            pstm.setString(2, tipo);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estfec = res.getString("fec_fac");
            fec = estfec;
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error obtener fecha fac");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return fec;
    }
    
    public String[] obtenerResumenMes(String mes){
       int registros = 0;
       String[] datos = new String[4];
       try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM facturas where "
                    + " MONTH(fec_fac) = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "factura");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            pstm.close();
            datos[0] = String.valueOf(registros);
            
            pstm = conn.prepareStatement("SELECT sum(neto_fac) neto FROM facturas where MONTH(fec_fac)"
                    + " = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "factura");
            res = pstm.executeQuery();
            res.next();
            datos[1] = res.getString("neto");
            res.close();
            pstm.close();
            
            pstm = conn.prepareStatement("SELECT sum(iva_fac) iva FROM facturas where MONTH(fec_fac)"
                    + " = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "factura");
            res = pstm.executeQuery();
            res.next();
            datos[2] = res.getString("iva");
            res.close();
            pstm.close();
            
            pstm = conn.prepareStatement("SELECT sum(tot_fac) tot FROM facturas where MONTH(fec_fac)"
                    + " = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "factura");
            res = pstm.executeQuery();
            res.next();
            datos[3] = res.getString("tot");
            res.close();
            pstm.close();
       }catch(SQLException e){
            System.out.println("Error al contar facturas");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
       return datos;
   }
    
    public String[] obtenerResumenNCMes(String mes){
       int registros = 0;
       String[] datos = new String[4];
       try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM facturas where "
                    + " MONTH(fec_fac) = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "notacredito");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            pstm.close();
            datos[0] = String.valueOf(registros);
            
            pstm = conn.prepareStatement("SELECT coalesce(sum(neto_fac), 0) neto FROM facturas where MONTH(fec_fac)"
                    + " = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "notacredito");
            res = pstm.executeQuery();
            res.next();
            datos[1] = res.getString("neto");
            res.close();
            pstm.close();
            
            pstm = conn.prepareStatement("SELECT coalesce(sum(iva_fac), 0) iva FROM facturas where MONTH(fec_fac)"
                    + " = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "notacredito");
            res = pstm.executeQuery();
            res.next();
            datos[2] = res.getString("iva");
            res.close();
            pstm.close();
            
            pstm = conn.prepareStatement("SELECT coalesce(sum(tot_fac), 0) tot FROM facturas where MONTH(fec_fac)"
                    + " = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "notacredito");
            res = pstm.executeQuery();
            res.next();
            datos[3] = res.getString("tot");
            res.close();
            pstm.close();
       }catch(SQLException e){
            System.out.println("Error al contar facturas");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
       return datos;
   }
    
    public String[][] obtenerFacturasMes(String mes){
       int registros = 0;
       try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM Facturas where "
                    + " MONTH(fec_fac) = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "factura");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            pstm.close();            
       }catch(SQLException e){
            System.out.println("Error al obtener ventas mes");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
       
       String[][] datos = new String[registros][8];
       
       try{
           PreparedStatement pstm = conn.prepareStatement("SELECT fol_fac, fec_fac, "
                   + "clientes.rut_cli, dig_cli, raz_cli, neto_fac, iva_fac, tot_fac FROM Facturas "
                   + "INNER JOIN Jornadas on Jornadas.id_fac = Facturas.id_fac INNER JOIN Clientes ON "
                   + "Clientes.rut_cli = Jornadas.rut_cli WHERE MONTH(fec_fac) = ? and tipo_fac = ?");
           pstm.setString(1, mes);
           pstm.setString(2, "factura");
           ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfol = res.getString("fol_fac");
                String estfec = res.getString("fec_fac");
                String estrut = res.getString("Clientes.rut_cli");
                String estdig = res.getString("dig_cli");
                String estraz = res.getString("raz_cli");
                String estnet = res.getString("neto_fac");
                String estiva = res.getString("iva_fac");
                String esttot = res.getString("tot_fac");
                datos[i] = new String[]{estfol, estfec, estrut + "-" + estdig, estraz, estnet, 
                    estiva, esttot};
                i++;
            }
            res.close();
       }catch(Exception e){
           
       }
       return datos;
   }
    
    public String[][] obtenerNCMes(String mes){
       int registros = 0;
       try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM Facturas where "
                    + " MONTH(fec_fac) = ? and tipo_fac = ?");
            pstm.setString(1, mes);
            pstm.setString(2, "notacredito");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
            pstm.close();            
       }catch(SQLException e){
            System.out.println("Error al obtener ventas mes");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
       
       String[][] datos = new String[registros][8];
       
       try{
           PreparedStatement pstm = conn.prepareStatement("SELECT fol_fac, fec_fac, "
                   + "clientes.rut_cli, dig_cli, raz_cli, neto_fac, iva_fac, tot_fac FROM Facturas "
                   + "INNER JOIN Jornadas on Jornadas.id_fac = Facturas.id_fac INNER JOIN Clientes ON "
                   + "Clientes.rut_cli = Jornadas.rut_cli WHERE MONTH(fec_fac) = ? and tipo_fac = ?");
           pstm.setString(1, mes);
           pstm.setString(2, "notacredito");
           ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfol = res.getString("fol_fac");
                String estfec = res.getString("fec_fac");
                String estrut = res.getString("Clientes.rut_cli");
                String estdig = res.getString("dig_cli");
                String estraz = res.getString("raz_cli");
                String estnet = res.getString("neto_fac");
                String estiva = res.getString("iva_fac");
                String esttot = res.getString("tot_fac");
                datos[i] = new String[]{estfol, estfec, estrut + "-" + estdig, estraz, estnet, 
                    estiva, esttot};
                i++;
            }
            res.close();
       }catch(Exception e){
           
       }
       return datos;
   }
}
