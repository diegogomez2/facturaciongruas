package modelos;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Diego
 */
public class modeloGruas {
    Connector conector = Connector.getInstance();
    String login = conector.getLogin();
    String password = conector.getPassword();
    String url = conector.getUrl();
    DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    Connection conn = null;
    
    public java.sql.Date toSqlDate(String data){
        java.util.Date parsed = null;
        if (data.compareTo("") == 0) return null;
        try{
            parsed = formatDate.parse(data);
        }catch(ParseException e){
            System.out.println(e);
        }
        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
        return sqlDate;
    }
    
    public Object[][] listarGruas(){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM gruas");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error al listar gruas");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][5];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT pat_gru, des_gru, mar_gru, mod_gru, "
                    + "ton_gru FROM gruas");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estpat = res.getString("pat_gru");
                String estdes = res.getString("des_gru");
                String estmar = res.getString("mar_gru");
                String estmodel = res.getString("mod_gru");
                String estton = res.getString("ton_gru");
                data[i] = new String[]{estpat, estdes, estmar, estmodel, estton};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error al listar gruas");
            System.out.println(e);
        }
        return data;
    }
    
    public String ingresarGrua(String[] data){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("insert into gruas (pat_gru, des_gru, mod_gru,"
                    + "pes_gru, tneum_gru, tneum2_gru, ncha_gru, tcom_gru, obs_gru, ton_gru, horo_gru,"
                    + "fin_gru, mar_gru, mas_gru, altmas_gru, anc_gru, lar_gru, larU_gru, altlev_gru,"
                    + "ndel_gru, ntra_gru, nmo_gru, nse_gru, frt_gru, fum_gru, kmhum_gru)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstm.setString(1, data[0]); //patente
            pstm.setString(2, data[1]); //descripcion
            pstm.setString(3, data[2]); //modelo
            if(data[3].compareTo("") == 0){
                pstm.setNull(4, Types.INTEGER);
            }else{
                pstm.setInt(4, Integer.parseInt(data[3])); //peso
            }
            pstm.setString(5, data[4]); //tipo neum
            pstm.setString(6, data[5]); //tipo neum2
            pstm.setString(7, data[6]); //nchasis
            pstm.setString(8, data[7]); //tipo combs
            pstm.setString(9, data[8]); //obs
            pstm.setFloat(10, Float.parseFloat(data[9])); //ton
            if(data[10].compareTo("") == 0){
                pstm.setInt(11, 0);
            }else{
                pstm.setInt(11, Integer.parseInt(data[10])); //horometro (KMH)
            }
            pstm.setDate(12, toSqlDate(data[11])); //fechain
            pstm.setString(13, data[12]);   //marca
            pstm.setString(14, data[13]);   //mastil
            if(data[14].compareTo("") == 0){
                pstm.setNull(15, Types.INTEGER);
            }else{
                pstm.setInt(15, Integer.parseInt(data[14])); //altmast
            }
            if(data[15].compareTo("") == 0){
                pstm.setNull(16, Types.INTEGER);
            }else{
                pstm.setInt(16, Integer.parseInt(data[15])); //ancho
            }   
            if(data[16].compareTo("") == 0){
                pstm.setNull(17, Types.INTEGER);
            }else{
                pstm.setInt(17, Integer.parseInt(data[16])); //largo
            }
            if(data[17].compareTo("") == 0){
                pstm.setNull(18, Types.INTEGER);
            }else{
                pstm.setInt(18, Integer.parseInt(data[17])); //largo unas
            }
            if(data[18].compareTo("") == 0){
                pstm.setNull(19, Types.INTEGER);
            }else{
                pstm.setInt(19, Integer.parseInt(data[18])); //alt levante
            }
            pstm.setString(20, data[19]); //neum del
            pstm.setString(21, data[20]);   //neum tras
            pstm.setString(22, data[21]);   //nmotor
            pstm.setString(23, data[22]);   //nserie
            pstm.setDate(24, toSqlDate(data[23])); //fecharev
            pstm.setDate(25,toSqlDate(data[24])); //fechaum
            if(data[25].compareTo("") == 0){
                pstm.setNull(26, Types.INTEGER);
            }else{
                pstm.setInt(26, Integer.parseInt(data[25])); //kmhum
            }
            //pstm.setInt(27, Integer.parseInt(data[26])); //horaspm
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error al ingresar grua");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }catch(NumberFormatException e){
            System.out.println(e);
            return "numero incorrecto";
        }catch(Exception e){
            System.out.println(e);
            System.out.println("ERROR ING");
        }
        return "correcto";
    }

    public String eliminarGrua(String data){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM gruas WHERE pat_gru = ?");
            pstm.setString(1, data);
            pstm.execute();
            pstm.close();
            return "correcto";
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("Error al eliminar gruas");
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
    }

    public String[] obtenerGruaPorPatente(String patente) {
        String data[] = new String[]{};
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT *, coalesce(fin_gru,'') as fin,"
                    + "coalesce(frt_gru,'') as frt, coalesce(fum_gru,'') as fum, coalesce(fba_gru,'') as fba"
                    + " FROM gruas WHERE pat_gru = ?");
            pstm.setString(1, patente);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estpat = res.getString("pat_gru");
            String estdesc = res.getString("des_gru");
            String estmod = res.getString("mod_gru");
            String estpeso = res.getString("pes_gru");
            String esttiponeum = res.getString("tneum_gru");
            String esttiponeum2 = res.getString("tneum2_gru");
            String estnchasis = res.getString("ncha_gru");
            String esttipocombs = res.getString("tcom_gru");
            String estobs = res.getString("obs_gru");
            String estton = res.getString("ton_gru");
            String estkmh = res.getString("horo_gru");
            String estfechain = res.getString("fin");
            String estmarca = res.getString("mar_gru");
            String estmastil = res.getString("mas_gru");
            String estaltmastil = res.getString("altmas_gru");
            String estancho = res.getString("anc_gru");
            String estlargo = res.getString("lar_gru"); 
            String estlargounas = res.getString("larU_gru");
            String estaltlevante = res.getString("altlev_gru");
            String estneumdel = res.getString("ndel_gru");
            String estneumtras = res.getString("ntra_gru");
            String estnmotor = res.getString("nmo_gru");
            String estnserie = res.getString("nse_gru");
            String estfechart = res.getString("frt");
            String estfechaum = res.getString("fum");
            String estfechakmhum = res.getString("kmhum_gru");
            String esthpm = res.getString("hpm_gru");
            String estfechabaja = res.getString("fba");
            System.out.println(esttiponeum);
            data = new String[]{estpat, estdesc , estmod, estpeso, esttiponeum, esttiponeum2, estnchasis,
                esttipocombs, estobs, estton, estkmh, estfechain, estmarca, estmastil, estaltmastil, estancho,
                estlargo, estlargounas, estaltlevante, estneumdel, estneumtras, estnmotor, estnserie, estfechart,
            estfechaum, estfechakmhum, esthpm, estfechabaja};
        }catch(SQLException e){
            System.out.println("Error al obtener grua por patente");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;   
    }

    public String modificarGrua(String[] data, String patente) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("update gruas set pat_gru=?, des_gru=?, mod_gru=?,"
                    + "pes_gru=?, tneum_gru=?, tneum2_gru=?, ncha_gru=?, tcom_gru=?, obs_gru=?, ton_gru=?,"
                    + "kmh_gru=?, fin_gru=?, mar_gru=?, mas_gru=?, altmas_gru=?, anc_gru=?, lar_gru=?, "
                    + "larU_gru=?, altlev_gru=?, ndel_gru=?, ntra_gru=?, nmo_gru=?, nse_gru=?, frt_gru=?, "
                    + "fum_gru=?, kmhum_gru=?, hpm_gru=?, fba_gru=? WHERE pat_gru=?");
            pstm.setString(1, data[0]);
            pstm.setString(2, data[1]);
            pstm.setString(3, data[2]);
            pstm.setInt(4, Integer.parseInt(data[3]));
            if(data[4].compareTo("") == 0){
                pstm.setNull(5, Types.VARCHAR);
            }else{
                pstm.setString(5, data[4]);  
            }
            if(data[5].compareTo("") == 0){
                pstm.setNull(6, Types.VARCHAR);
            }else{
                pstm.setString(6, data[5]);
            }
            pstm.setString(7, data[6]);
            if(data[7].compareTo("") == 0){
                pstm.setNull(8, Types.VARCHAR);
            }else{
                pstm.setString(8, data[7]);  
            }
            pstm.setString(9, data[8]);
            pstm.setFloat(10, Float.parseFloat(data[9]));
            pstm.setString(11, data[10]);
            pstm.setDate(12, toSqlDate(data[11]));
            pstm.setString(13, data[12]);
            pstm.setString(14, data[13]);
            if(data[14].compareTo("") == 0){
                pstm.setNull(15, Types.INTEGER);
            }else{
                pstm.setInt(15, Integer.parseInt(data[14]));
            }
            if(data[15].compareTo("") == 0){
                pstm.setNull(16, Types.INTEGER);
            }else{
                pstm.setInt(16, Integer.parseInt(data[15]));
            }
            if(data[16].compareTo("") == 0){
                pstm.setNull(17, Types.INTEGER);
            }else{
                pstm.setInt(17, Integer.parseInt(data[16]));
            }
            if(data[17].compareTo("") == 0){
                pstm.setNull(18, Types.INTEGER);
            }else{
                pstm.setInt(18, Integer.parseInt(data[17]));
            }
            if(data[18].compareTo("") == 0){
                pstm.setNull(19, Types.INTEGER);
            }else{
                pstm.setInt(19, Integer.parseInt(data[18]));
            }
            if(data[19].compareTo("") == 0){
                pstm.setNull(20, Types.INTEGER);
            }else{
                pstm.setInt(20, Integer.parseInt(data[19]));
            }
            if(data[20].compareTo("") == 0){
                pstm.setNull(21, Types.INTEGER);
            }else{
                pstm.setInt(21, Integer.parseInt(data[20]));
            }
            pstm.setString(22, data[21]);
            pstm.setString(23, data[22]);
            pstm.setDate(24, toSqlDate(data[23])); //fecharev
            pstm.setDate(25,toSqlDate(data[24])); //fechaum
            if(data[25].compareTo("") == 0){
                pstm.setNull(26, Types.INTEGER);
            }else{
                pstm.setInt(26, Integer.parseInt(data[25]));
            } //kmhum
            if(data[26].compareTo("") == 0){
                pstm.setNull(27, Types.INTEGER);
            }else{
                pstm.setInt(27, Integer.parseInt(data[26]));
            } //horaspm
            pstm.setDate(28, toSqlDate(data[27]));
            pstm.setString(29, patente);
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println("Error al modificar grua");
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }catch(NumberFormatException e){
            System.out.println(e);
            return "numero incorrecto";
        }
        return "correcto";    
    }

    public Object[] obtenerDescGruas() {
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM Gruas");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error al obtener descripcion gruas");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[] data = new String[registros];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT coalesce(des_gru,'') as des_gru FROM Gruas");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estdes = res.getString("des_gru");
                data[i] = estdes;
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error obtener descripcion gruas");
            System.out.println(e);
        }
        return data;  
    }

    /* Obtiene la patente de la grúa según su descripción*/
    public String obtenerGruaPorDesc(String textoGrua) {
        String data = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT pat_gru FROM Gruas WHERE des_gru = ?");
            pstm.setString(1, textoGrua);
            ResultSet res = pstm.executeQuery();
            res.next();
            String estpat = res.getString("pat_gru");
            data = estpat;
        }catch(SQLException e){
            System.out.println("Error obtener gruas por descripcion");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        return data;
    }
    
    public void actualizarHorometro(int horas, String desc){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("UPDATE Gruas SET horo_gru = horo_gru + ? WHERE des_gru = ?");
            pstm.setInt(1, horas);
            pstm.setString(2, desc);
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error al actualizar horometro gruas");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    
    /* Actualiza el numero de horas en detalle gruas para OC*/
    public void actualizarHorasDetalleGruas(int id, int horas){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("UPDATE Detalle_oc_gru SET horas_det_gru = ? WHERE id_det_gru = ?");
            pstm.setInt(1, horas);
            pstm.setInt(2, id);
            pstm.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error al actualizar det horas gruas oc");
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    /* Obtiene las gruas disponibles en periodo de tiempo*/
    public Object[] obtenerDescGruasDisp(String fhsal, String fhreg) {
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT COUNT(*) AS total FROM Gruas WHERE pat_gru not in( "
                    + "SELECT pat_gru from Jornadas where ( ? <= fhreg_jor and ? >= fhsal_jor and pat_gru is not null and nc_ot = 0) "
                    + "UNION ALL "
                    + "SELECT pat_gru FROM Detalle_oc_gru WHERE fhsal_det_gru IS NULL AND fhreg_det_gru IS NULL AND pat_gru IS NOT NULL "
                    + "UNION ALL "
                    + "SELECT pat_gru FROM Detalle_oc_gru WHERE ? <= fhreg_det_gru AND ? >= fhsal_det_gru  AND pat_gru IS NOT NULL)");
            pstm.setString(1, fhsal);
            pstm.setString(2, fhreg);
            pstm.setString(3, fhsal);
            pstm.setString(4, fhreg);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error al obtener descripcion gruas disp");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[] data = new String[registros];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT coalesce(des_gru,'') AS des_gru FROM Gruas WHERE pat_gru not in ( "
                    + "SELECT pat_gru from Jornadas WHERE (?  <= fhreg_jor and ?  >= fhsal_jor and pat_gru is not null and nc_ot = 0) "
                    + "UNION ALL "
                    + "SELECT pat_gru FROM Detalle_oc_gru WHERE fhsal_det_gru IS NULL AND fhreg_det_gru IS NULL AND pat_gru IS NOT NULL "
                    + "UNION ALL "
                    + "SELECT pat_gru FROM Detalle_oc_gru WHERE ? <= fhreg_det_gru AND ? >= fhsal_det_gru AND pat_gru IS NOT NULL)"
                    + " order by des_gru");
            pstm.setString(1, fhsal);
            pstm.setString(2, fhreg);
            pstm.setString(3, fhsal);
            pstm.setString(4, fhreg);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estdes = res.getString("des_gru");
                data[i] = estdes;
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error obtener descripcion gruas disp");
            System.out.println(e);
        }
        return data;  
    }
    
    /* Comprueba disponibilidad de una grua en el periodo indicado*/
    public int checkGruaDisp(String fhsal, String fhreg, String pat) {
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT SUM(total) total FROM("
                    + "SELECT count(*) as total FROM Jornadas WHERE ( ? <= fhreg_jor AND ? >= fhsal_jor AND pat_gru = ? AND nc_ot = 0) "
                    + "UNION ALL "
                    + "SELECT count(*) as total FROM Detalle_oc_gru WHERE pat_gru = ? AND fhsal_det_gru IS NULL AND fhreg_det_gru IS NULL "
                    + "UNION ALL "
                    + "SELECT count(*) as total FROM Detalle_oc_gru WHERE ? <= fhreg_det_gru AND ? >= fhsal_det_gru AND pat_gru = ?"
                    + ") a");
            pstm.setString(1, fhsal);
            pstm.setString(2, fhreg);
            pstm.setString(3, pat);
            pstm.setString(4, pat);
            pstm.setString(5, fhsal);
            pstm.setString(6, fhreg);
            pstm.setString(7, pat);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error al obtener check disp grua ");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        return registros;
    }
    
    
    /* Chequea la disponibilidad de una grua en un periodo determinado dejando fuera la id de la jornada (se usa en el modificar) */
    public int checkGruaDispId(String fhsal, String fhreg, String pat, String id) {
        int registros = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT SUM(total) total FROM("
                    + "SELECT count(*) as total FROM Jornadas WHERE ( ? <= fhreg_jor AND ? >= fhsal_jor AND pat_gru = ? AND id_jor <> ? AND nc_ot = 0) "
                    + "UNION ALL "
                    + "SELECT count(*) as total FROM Detalle_oc_gru WHERE pat_gru = ? AND fhsal_det_gru IS NULL AND fhreg_det_gru IS NULL "
                    + "UNION ALL "
                    + "SELECT count(*) as total FROM Detalle_oc_gru WHERE ? <= fhreg_det_gru AND ? >= fhsal_det_gru AND pat_gru = ?"
                    + ") a");
            pstm.setString(1, fhsal);
            pstm.setString(2, fhreg);
            pstm.setString(3, pat);
            pstm.setString(4, id);
            pstm.setString(5, pat);
            pstm.setString(6, fhsal);
            pstm.setString(7, fhreg);
            pstm.setString(8, pat);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error al obtener check disp grua ");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        return registros;
    }
    
    public Object[][] listarReporteGruas(){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM gruas");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println("Error al listar reporte gruas");
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][28];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT pat_gru, coalesce(ano_gru, '') ano, des_gru, mar_gru, coalesce(mod_gru, '') modelo, ton_gru, "
                    + "coalesce(pes_gru, '') peso, coalesce(tneum_gru, '') tneum, coalesce(tneum2_gru, '') tneum2, coalesce(ncha_gru, '') ncha, coalesce(tcom_gru, '') tcom, "
                    + "coalesce(mas_gru, '') mastil, coalesce(altmas_gru, '') altmas, coalesce(anc_gru, '') anc, coalesce(lar_gru, '') lar, coalesce(larU_gru, '') laru, "
                    + "coalesce(altlev_gru, '') altlev, coalesce(ndel_gru, '') ndel, coalesce(ntra_gru, '') ntra, coalesce(nmo_gru, '') nmo, coalesce(nse_gru, '') nse, "
                    + "coalesce(frt_gru, '') frt, coalesce(fum_gru, '') fum, coalesce(kmhum_gru, '') kmhum, coalesce(hpm_gru, '') hpm, coalesce(fba_gru, '') fba, "
                    + "coalesce(obs_gru, '') obs, coalesce(fin_gru, '') fin, coalesce(kmh_gru, '') kmh, ocu_gru, coalesce(horo_gru, '') horo FROM gruas");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estpat = res.getString("pat_gru");
                String estano = res.getString("ano");
                String estdes = res.getString("des_gru");
                String estmar = res.getString("mar_gru");
                String estmod = res.getString("modelo");
                String estton = res.getString("ton_gru");
                String estpeso = res.getString("peso");
                String esttiponeum = res.getString("tneum");
                String esttiponeum2 = res.getString("tneum2");
                String estnchasis = res.getString("ncha");
                String esttipocombs = res.getString("tcom");
                String estmastil = res.getString("mastil");
                String estaltmastil = res.getString("altmas");
                String estancho = res.getString("anc");
                String estlargo = res.getString("lar"); 
                String estlargounas = res.getString("larU");
                String estaltlevante = res.getString("altlev");
                String estneumdel = res.getString("ndel");
                String estneumtras = res.getString("ntra");
                String estnmotor = res.getString("nmo");
                String estnserie = res.getString("nse");
                String estfechart = res.getString("frt");
                String estfechaum = res.getString("fum");
                String estfechakmhum = res.getString("kmhum");
                String estfechabaja = res.getString("fba");
                String estobs = res.getString("obs");
                String estfechain = res.getString("fin");
                String estkmh = res.getString("horo");
                data[i] = new String[]{estpat, estano, estdes, estmar, estmod, estton, estpeso, esttiponeum, esttiponeum2, estnchasis, esttipocombs, estmastil, estaltmastil, 
                    estancho, estlargo, estlargounas, estaltlevante, estneumdel, estneumtras, estnmotor, estnserie, estfechart, estfechaum, estfechakmhum, estfechabaja, 
                    estobs, estfechain, estkmh};
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println("Error al listar reporte gruas");
            System.out.println(e);
        }
        return data;
    }
}
