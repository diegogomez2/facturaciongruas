package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author diego
 */
public class modeloOts {
    Connector conector = Connector.getInstance();
    String login = conector.getLogin();
    String password = conector.getPassword();
    String url = conector.getUrl();
    Connection conn = null;
    
    DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    public java.sql.Date toSqlDate(String data){
        java.util.Date parsed = null;
        try{
            parsed = formatDate.parse(data);
        }catch(ParseException e){
            System.out.println(e);
        }
        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
        return sqlDate;
    }
    
    public String ingresarOt(String[] data) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("update jornadas set cont_ot = ?, fec_ot = ?, pag_ot = ?,"
                    + "cond_ot = ?, desp_ot = ?, cod_ot = ?, neto_ot = ?, iva_ot = ?, total_ot = ?, "
                    + "horfin_ot=?, hortot_ot=?, horsal_jor=?, horlleg_jor=?, checkdesp_ot = ?, vdesp_ot = ?, "
                    + "checkhormin_ot=?, desc_ot=?, horex_ot=?, horex2_ot=?, horcol30_ot=?, horcol1_ot=?, fhsal_jor=CONCAT(DATE(fhsal_jor),' ', ?) where id_jor = ?");
            pstm.setString(1, data[0]);
            pstm.setString(2, data[1]);
            pstm.setString(3, data[2]);
            pstm.setString(4, data[3]);
            pstm.setString(5, data[4]);
            pstm.setInt(6, Integer.parseInt(data[6]));
            pstm.setInt(7, Integer.parseInt(data[7]));
            pstm.setInt(8, Integer.parseInt(data[8]));
            pstm.setInt(9, Integer.parseInt(data[9]));
            pstm.setString(10, data[10]);
            pstm.setInt(11, Integer.parseInt(data[11]));
            pstm.setString(12, data[12]);
            pstm.setString(13, data[13]);
            pstm.setString(14, data[14]);
            if(data[14].compareTo("1") == 0){
                pstm.setInt(15, Integer.parseInt(data[15]));
            }else{
                pstm.setInt(15, 0);
            }
            pstm.setString(16, data[16]);
            pstm.setInt(17, Integer.parseInt(data[17]));
            pstm.setDouble(18, Double.parseDouble(data[18]));
            pstm.setDouble(19, Double.parseDouble(data[19]));
            pstm.setInt(20, Integer.parseInt(data[20]));
            pstm.setInt(21, Integer.parseInt(data[21]));
            pstm.setString(22, data[12]);
            pstm.setInt(23, Integer.parseInt(data[5]));
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error ingresar ot");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return "correcto";
    }
    
    public Object[][] listarOts(){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM jornadas where not cod_ot = -1 and fact_ot < 2");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error listar ot");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][13];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT id_jor, fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "ciu_cli, com_cli, pat_gru, nom_emp, apP_emp, obs_jor, cod_ot, total_ot, neto_ot, "
                    + "iva_ot, fact_ot, clientes.rut_cli, dig_cli FROM Jornadas INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where not cod_ot = -1 and fact_ot < 2 ORDER BY cod_ot, fact_ot");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                String estfact = res.getString("fact_ot");
                String estfact2;
                if(estfact.compareTo("0") == 0){
                    estfact2 = "Disponible";
                }else{
                    estfact2 = "Facturada";
                }
                String estemp = res.getString("nom_emp") + " " + res.getString("apP_emp");
                String estrut = res.getString("rut_cli") + "-" + res.getString("dig_cli");
                data[i] = new String[]{estcodot, estraz, estgir, estdir, estciu, estcom, estfec, estnet,
                estiva, esttot, estfact2, estemp, estrut};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error listar ots");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][] listarHistoricos(){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM jornadas where not cod_ot = -1 and fact_ot >= 2");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error listar ot");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][13];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT id_jor, fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "ciu_cli, com_cli, pat_gru, nom_emp, apP_emp, obs_jor, cod_ot, total_ot, neto_ot, "
                    + "iva_ot, fact_ot, clientes.rut_cli, dig_cli FROM Jornadas INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where not cod_ot = -1 and fact_ot >= 2 ORDER BY cod_ot, fact_ot");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                String estfact = res.getString("fact_ot");
                String estfact2;
                if(estfact.compareTo("0") == 0){
                    estfact2 = "Disponible";
                }else if(estfact.compareTo("4") == 0){
                    estfact2 = "Nula";
                }else{
                    estfact2 = "Facturada";
                }
                String estemp = res.getString("nom_emp") + " " + res.getString("apP_emp");
                String estrut = res.getString("clientes.rut_cli") + "-" + res.getString("dig_cli");
                data[i] = new String[]{estcodot, estraz, estgir, estdir, estciu, estcom, estfec, estnet,
                estiva, esttot, estfact2, estemp, estrut};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error listar ots");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public String[] obtenerOtPorId(String id){
        String[] data = new String[]{};
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fsal_jor, horsal_jor, freg_jor, horlleg_jor,"
                    + "des_gru, raz_cli, ciu_cli, nom_emp, apP_emp, apM_emp, freg_jor, obs_jor, clientes.rut_cli, clientes.dig_cli,"
                    + "gir_cli, dir_cli, tel_cli, ton_gru, fec_ot, cod_ot, pag_ot, cond_ot, cont_ot, "
                    + "total_ot, neto_ot, iva_ot, desp_ot, horfin_ot, checkdesp_ot, vdesp_ot, desc_ot, checkhormin_ot, "
                    + " coalesce(horex_ot, 0) horex, coalesce(horex2_ot, 0) horex2, coalesce(horcol30_ot, 0) horcol30_ot, coalesce(horcol1_ot, 0) horcol1_ot "
                    + " FROM jornadas INNER JOIN clientes ON "
                    + "jornadas.rut_cli = clientes.rut_cli INNER JOIN gruas ON gruas.pat_gru = jornadas.pat_gru "
                    + "INNER JOIN empleados ON empleados.rut_emp = jornadas.rut_emp WHERE cod_ot = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estrutcli = res.getString("clientes.rut_cli");
            String estdigcli = res.getString("clientes.dig_cli");
            String estfsal = res.getString("fsal_jor");
            String esthorsal = res.getString("horsal_jor");
            String estdes = res.getString("des_gru");
            String estraz = res.getString("raz_cli");
            String estciu = res.getString("ciu_cli");
            String estnom = res.getString("nom_emp") + " " + res.getString("apP_emp") + " " + res.getString("apM_emp");
            String estfreg = res.getString("freg_jor");
            String esthorlleg = res.getString("horlleg_jor");
            String estobs = res.getString("obs_jor");
            String estgir = res.getString("gir_cli");
            String estdir = res.getString("dir_cli");
            String esttel = res.getString("tel_cli");
            String estton = res.getString("ton_gru");
            String estfot = res.getString("fec_ot");
            String estcond = res.getString("cond_ot");
            String estpago = res.getString("pag_ot");
            String estcont = res.getString("cont_ot");
            String esttot = res.getString("total_ot");
            String estneto = res.getString("neto_ot");
            String estiva = res.getString("iva_ot");
            String estdesp = res.getString("desp_ot");
            String esthorfin = res.getString("horfin_ot");
            String estcdesp = res.getString("checkdesp_ot");
            String estvdesp = res.getString("vdesp_ot");
            String estdesc = res.getString("desc_ot");
            String estchmin = res.getString("checkhormin_ot");
            String esthorex = res.getString("horex");
            String esthorex2 = res.getString("horex2");
            String esthorcol30 = res.getString("horcol30_ot");
            String esthorcol1 = res.getString("horcol1_ot");
            data = new String[]{estfsal, esthorsal, estfreg, esthorlleg, estdes, estnom, estobs
                    , estrutcli, estdigcli, estraz, estgir, estdir, esttel, id, estton, estfot, estcond
                    , estpago, estcont, esttot, estneto, estiva, estdesp, esthorfin, estcdesp, estvdesp, estciu, estdesc, estchmin, esthorex, esthorex2, 
                    esthorcol30, esthorcol1};
        }catch(SQLException e){
            System.out.println("Error obtener ot por id");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    public String[] getTarifa(String diaInicio, String horaInicio, String day, String ton){
        String data[] = new String[]{};
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT prec_tar, horarios.hfin_hor FROM tarifas INNER JOIN"
                    + " tonelajes ON tonelajes.id_ton = tarifas.id_ton INNER JOIN horarios ON"
                    + " horarios.id_hor = tarifas.id_hor INNER JOIN dias ON dias.id_dia = tarifas.id_dia"
                    + " WHERE pes_ton = ? AND hin_hor <= ? And hfin_hor > ? AND dias.id_dia = ?");
            pstm.setString(1, ton);
            pstm.setString(2, horaInicio);
            pstm.setString(3, horaInicio);
            pstm.setString(4, day);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estprec = res.getString("prec_tar");
            String esthfin = res.getString("horarios.hfin_hor");
            data = new String[]{estprec, esthfin};
        }catch(SQLException e){
            System.out.println("Error obtener tarifa");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    public String getMaxTarifa(String diaInicio, String horaInicio, String day, String ton){
        String data = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT MAX(prec_tar) as prec_tar FROM tarifas INNER JOIN"
                    + " tonelajes ON tonelajes.id_ton = tarifas.id_ton INNER JOIN dias ON dias.id_dia = tarifas.id_dia"
                    + " WHERE pes_ton = ? AND dias.id_dia = ?");
            pstm.setString(1, ton);
            pstm.setString(2, day);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estprec = res.getString("prec_tar");
            data = estprec;
        }catch(SQLException e){
            System.out.println("Error obtener tarifa");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][] listarFacturas(){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM jornadas where fact_ot = 1");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error listar facturas");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][11];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT id_jor, fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "reg_cli, com_cli, obs_jor, cod_ot, total_ot, neto_ot, "
                    + "iva_ot, fact_ot, desc_ot FROM Jornadas INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where not cod_ot = -1 and fact_ot = 1 ORDER BY cod_ot, fact_ot");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estreg = res.getString("reg_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                String estdesc = res.getString("desc_ot");
                data[i] = new String[]{estcodot, estraz, estgir, estdir, estreg, estcom, estfec, estnet,
                    estiva, esttot, estdesc};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error listar facturas");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public String getIdFactura(String id){
        String idFact = "";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fact_ot FROM jornadas where cod_ot = ?");
             pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            idFact = res.getString("fact_ot");
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener id factura");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        return idFact;
    }
    
    public String ingresarFactura(String idOt){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("update jornadas set fact_ot = 1 where cod_ot = ?");
            pstm.setString(1, idOt);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error ingresar factura");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return "correcto";
    }
    
    public String anularFactura(String idOt){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("update jornadas set fact_ot = 4 where cod_ot = ?");
            pstm.setString(1, idOt);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error anular factura");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return "correcto";
    }
    
    public String eliminarOt(String idOt){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM Jornadas WHERE cod_ot = ?");
            pstm.setString(1, idOt);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error eliminar ot");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return "correcto";
    }
    
    public String quitarFactura(String idOt){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("update jornadas set fact_ot = 0 where cod_ot = ?");
            pstm.setString(1, idOt);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error quitar factura");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return "correcto";
    }
    
    public String[] obtenerFacturaPorId(String idOt){
        String[] data = new String[12];
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT clientes.rut_cli, dig_cli, raz_cli, gir_cli,"
                    + "dir_cli, ciu_cli, com_cli, total_ot, neto_ot, iva_ot, fact_ot, cod_ot, hortot_ot, "
                    + "checkhormin_ot "
                    + " FROM jornadas INNER JOIN clientes"
                    + " ON clientes.rut_cli = jornadas.rut_cli where cod_ot = ?");
            pstm.setString(1, idOt);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                String estrut = res.getString("rut_cli");
                String estdig = res.getString("dig_cli");
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                String estfact = res.getString("fact_ot");
                String esthor = res.getString("hortot_ot");
                String estcheckhor = res.getString("checkhormin_ot");
                data = new String[]{estrut + "-" + estdig.toUpperCase(), estraz, estgir, estdir, estciu, estcom, esttot, estnet,
                estiva, estfact, estcodot, esthor, estcheckhor};
            }
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener factura por id");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        return data;
    }
    
    public void actualizarHoras(int horas, String id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("update jornadas set hortot_ot = ? WHERE id_jor = ?");
            pstm.setInt(1, horas);
            pstm.setString(2, id);
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error actualizar hroas");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public String archivarFactura(String idOt, String id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT coalesce(fact_ot, 0) fact_ot FROM jornadas WHERE cod_ot = ?");
            pstm.setString(1, idOt);
            ResultSet res = pstm.executeQuery();
            res.next();
            String facot = res.getString("fact_ot");
            System.out.println(facot);
            res.close();
            if(facot.compareTo("2") == 0){
                pstm.close();
                return "yafacturada";
            }
            pstm = conn.prepareStatement("update jornadas set fact_ot = 2, id_fac = ? WHERE cod_ot = ?");
            pstm.setInt(1, Integer.parseInt(id));
            pstm.setInt(2, Integer.parseInt(idOt));
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error archivar facturas");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return "correcto";
    }
    
    public String archivarFacturaND(String idOt, String id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT coalesce(fact_ot, 0) fact_ot FROM jornadas WHERE cod_ot = ?");
            pstm.setString(1, idOt);
            ResultSet res = pstm.executeQuery();
            res.next();
            String facot = res.getString("fact_ot");
            System.out.println(facot);
            res.close();
            if(facot.compareTo("2") == 0){
                pstm.close();
                return "yafacturada";
            }
            pstm = conn.prepareStatement("update jornadas set fact_ot = 2, id_nd = ? WHERE cod_ot = ?");
            pstm.setInt(1, Integer.parseInt(id));
            pstm.setInt(2, Integer.parseInt(idOt));
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error archivar facturas");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return "correcto";
    }
    
    public Object[][] listarFacturadas2(){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM jornadas where fact_ot = 2");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][11];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT id_jor, fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "ciu_cli, com_cli, obs_jor, cod_ot, total_ot, neto_ot, "
                    + "iva_ot, fact_ot FROM Jornadas INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where not cod_ot = -1 and fact_ot = 2 ORDER BY cod_ot, fact_ot");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                data[i] = new String[]{estcodot, estraz, estgir, estdir, estciu, estcom, estfec, estnet, 
                estiva, esttot};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error listar facturadas 2");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public String[] obtenerNetoTotal(String id_fac){
        int registros = 0;
        int neto = 0;
        String[] datos;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM detallefactura where id_fac = ?");
            pstm.setInt(1, Integer.parseInt(id_fac));
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println("Error obtener neto total");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        datos = new String[registros];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT neto_ot FROM Jornadas INNER JOIN"
                    + " detallefactura ON jornadas.id_jor = detallefactura.id_jor Where id_fac = ?");
            pstm.setInt(1, Integer.parseInt(id_fac));
            ResultSet res = pstm.executeQuery();
            
            while(res.next()){
                neto += res.getInt("neto_ot");
            }
            res.close();
            
            pstm = conn.prepareStatement("Select raz_cli From jornadas INNER JOIN clientes ON "
                    + "jornadas.rut_cli = clientes.rut_cli INNER JOIN detallefactura ON jornada.id_jor "
                    + "= detallelfactura.id_jor where id_fac = ?");
            pstm.setInt(1, Integer.parseInt(id_fac));
            res = pstm.executeQuery();
            
            String estraz = res.getString("raz_cli");
            datos = new String[]{estraz, Integer.toString(neto)};
        }catch(SQLException e){
            System.out.println("Error obtener neto total");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return datos;
    }
    
    public String[] obtenerTotales(String id_jor){
        String[] datos = null;        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT neto_ot, , iva_ot, total_ot FROM Jornadas "
                    + "Where id_jor = ?");
            pstm.setInt(1, Integer.parseInt(id_jor));
            ResultSet res = pstm.executeQuery();
            res.next();
            String estnet = res.getString("neto_ot");
            String estbru = res.getString("total_ot");
            String estiva = res.getString("iva_ot");
            datos = new String[]{estnet, estbru, estiva};
            res.close();
        }catch(SQLException e){
            System.out.println("Error obtener totales");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return datos;
    }
    
    public Object[][] obtenerOtPorIdFacturada(String id, String tipo){
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM jornadas INNER JOIN facturas"
                    + " ON facturas.id_fac = jornadas.id_fac where fol_fac = ? and tipo_fac = ?");
            pstm.setString(1, id);
            pstm.setString(2, tipo);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener ot por id facturada");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][11];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "ciu_cli, com_cli, cod_ot, total_ot, neto_ot, "
                    + "iva_ot, fact_ot FROM Jornadas  INNER JOIN facturas ON facturas.id_fac = jornadas.id_fac"
                    + " INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where fol_fac = ? and tipo_fac = ? ORDER BY cod_ot");
            pstm.setString(1, id);
            pstm.setString(2, tipo);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                String estfact = res.getString("fact_ot");
                data[i] = new String[]{estcodot, estraz, estgir, estdir, estciu, estcom, estfec, estnet,
                estiva, esttot, estfact};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error obtener ot por id facturada");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][] obtenerOtPorIdFacturadaNC(String id){
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT COUNT(1) as total FROM Jornadas "
                    + "INNER JOIN Notacredito n ON n.id_fac = Jornadas.id_fac WHERE fol_nc = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener ot por id facturada");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][11];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "ciu_cli, com_cli, cod_ot, total_ot, neto_ot, "
                    + "iva_ot, fact_ot FROM Jornadas INNER JOIN notacredito ON notacredito.id_fac = "
                    + " jornadas.id_fac "
                    + "INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where fol_nc = ? ORDER BY cod_ot");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                String estfact = res.getString("fact_ot");
                data[i] = new String[]{estcodot, estraz, estgir, estdir, estciu, estcom, estfec, estnet,
                estiva, esttot, estfact};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error obtener ot por id facturada");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][] obtenerOtPorIdNDNC(String id){
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT COUNT(1) as total FROM Jornadas "
                    + "INNER JOIN Notacredito n ON n.id_nd = Jornadas.id_nd WHERE fol_nc = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener ot por id facturada");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][11];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "ciu_cli, com_cli, cod_ot, total_ot, neto_ot, "
                    + "iva_ot, fact_ot FROM Jornadas INNER JOIN notacredito ON notacredito.id_nd = "
                    + " jornadas.id_nd "
                    + "INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where fol_nc = ? ORDER BY cod_ot");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                String estfact = res.getString("fact_ot");
                data[i] = new String[]{estcodot, estraz, estgir, estdir, estciu, estcom, estfec, estnet,
                estiva, esttot, estfact};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error obtener ot por id facturada");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public Object[][] obtenerOtPorIdFacturadaND(String id){
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM notadebito where fol_nd = ?");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener ot por id facturada");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][11];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "ciu_cli, com_cli, cod_ot, tot_nd, neto_nd, "
                    + "iva_nd, fact_ot FROM Jornadas INNER JOIN notadebito ON jornadas.id_nd = notadebito.id_nd "
                    + "INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where notadebito.fol_nd = ? ORDER BY cod_ot");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("tot_nd");
                String estnet = res.getString("neto_nd");
                String estiva = res.getString("iva_nd");
                String estcodot = res.getString("cod_ot");
                String estfact = res.getString("fact_ot");
                data[i] = new String[]{estcodot, estraz, estgir, estdir, estciu, estcom, estfec, estnet,
                estiva, esttot, estfact};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error obtener ot por id facturada");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public String obtenerCodigoOt(String cod){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM jornadas where cod_ot = ?");
            pstm.setString(1, cod);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener cod ot");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        if(registros == 0){
            return "correcto";
        }else{
            return "incorrecto";
        }
    }
    
    public String[] obtenerDiasPorIdOt(String idOt){
        String[] data = new String[12];
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT fsal_jor, freg_jor, horsal_jor, horlleg_jor,"
                    + "ton_gru FROM jornadas INNER JOIN gruas ON gruas.pat_gru = jornadas.pat_gru "
                    + " WHERE cod_ot = ?");
            pstm.setString(1, idOt);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfsal = res.getString("fsal_jor");
                String estfreg = res.getString("freg_jor");
                String esthsal = res.getString("horsal_jor");
                String esthreg = res.getString("horlleg_jor");
                String estton = res.getString("ton_gru");
                data = new String[]{estfsal, estfreg, esthsal, esthreg, estton};
                i++;
            }
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener factura por id");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        return data;
    }
    
    public String[] obtenerValorDespachoOt(String idOt){
        String[] data = new String[2];
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT vdesp_ot, checkdesp_ot FROM jornadas WHERE cod_ot = ?");
            pstm.setString(1, idOt);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estcheck = res.getString("checkdesp_ot");
                String estvdesp = res.getString("vdesp_ot");
                data[0] = estcheck;
                data[1] = estvdesp;
                i++;
            }
            res.close();
       }catch(SQLException e){
            System.out.println("Error obtener factura por id");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        return data;
    }
    
    public String obtenerFormaPago(String idOt){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT pag_ot, cond_ot FROM jornadas WHERE cod_ot = ?");
            pstm.setString(1, idOt);
            ResultSet res = pstm.executeQuery();
            res.next();
            String pag_ot = res.getString("pag_ot");
            String cond_ot = res.getString("cond_ot");
            res.close();
            if(pag_ot.compareTo("Al día") == 0 && cond_ot.compareTo("Cheque") != 0){
                return "1";
            }else{
                return "2";
            }
       }catch(SQLException e){
            System.out.println("Error obtener forma pago por id");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        return "0";
    }
    
    //Para saber si es nc de fac o nd
    public int tipoNC(String id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM Notacredito "
                    + "WHERE fol_nc = ? and id_fac is null");
            pstm.setString(1, id);
            ResultSet res = pstm.executeQuery();
            res.next();
            int total = res.getInt("total");
            return total;
       }catch(SQLException e){
            System.out.println("Error obtener forma pago por id");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        return -1;
    }
    
    public int agregarHorasExtra(String id, double horex, double horex2){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("update jornadas set horex_ot = ?, horex2_ot = ? WHERE id_jor = ?");
            pstm.setDouble(1, horex);
            pstm.setDouble(2, horex2);
            pstm.setString(3, id);
            System.out.println(id);
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error actualizar horas en ot");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return 1;
    }
    
    public int agregarHorasColacion(String id, int col30, int col1){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("UPDATE Jornadas set horcol30_ot = ?, horcol1_ot = ? WHERE id_jor = ?");
            pstm.setDouble(1, col30);
            pstm.setDouble(2, col1);
            pstm.setString(3, id);
            System.out.println(id);
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error actualizar horas colacion en ot");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return 1;
    }
    
    public Object[][] listarReporteHistoricoOt(String fecIn, String fecFin){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM jornadas WHERE NOT cod_ot = -1 and fact_ot >= 2 AND fec_ot >= ? AND fec_ot <= ?");
            pstm.setString(1, fecIn);
            pstm.setString(2, fecFin);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error listar reporte historico ot");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][14];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT id_jor, fec_ot, raz_cli, gir_cli, dir_cli,"
                    + "ciu_cli, com_cli, pat_gru, nom_emp, apP_emp, obs_jor, cod_ot, total_ot, neto_ot, "
                    + "iva_ot, fact_ot, clientes.rut_cli, dig_cli FROM Jornadas INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp Where not cod_ot = -1 and fact_ot >= 2 AND fec_ot >= ? AND fec_ot <= ? ORDER BY cod_ot, fact_ot");
            pstm.setString(1, fecIn);
            pstm.setString(2, fecFin);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estfec = res.getString("fec_ot");
                java.util.Date fecha = formatDate.parse(estfec);
                estfec = newFormat.format(fecha);
                String estraz = res.getString("raz_cli");
                String estgir = res.getString("gir_cli");
                String estdir = res.getString("dir_cli");
                String estciu = res.getString("ciu_cli");
                String estcom = res.getString("com_cli");
                String esttot = res.getString("total_ot");
                String estnet = res.getString("neto_ot");
                String estiva = res.getString("iva_ot");
                String estcodot = res.getString("cod_ot");
                String estfact = res.getString("fact_ot");
                String estfact2;
                if(estfact.compareTo("0") == 0){
                    estfact2 = "Disponible";
                }else if(estfact.compareTo("4") == 0){
                    estfact2 = "Nula";
                }else{
                    estfact2 = "Facturada";
                }
                String estemp = res.getString("nom_emp") + " " + res.getString("apP_emp");
                String estrut = res.getString("clientes.rut_cli") + "-" + res.getString("dig_cli");
                String estpat = res.getString("pat_gru");
                data[i] = new String[]{estcodot, estrut, estraz, estgir, estdir, estciu, estcom, estfec, estnet,
                estiva, esttot, estfact2, estemp, estpat};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error listar reporte historico ots");
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
}
