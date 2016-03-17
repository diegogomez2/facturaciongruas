/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.Date;
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
public class modeloJornadas {
    
    static String login = "root";
    static String password = "205243";
    static String url = "jdbc:mysql://localhost:3306/fact_gruas";
    DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    Connection conn = null;

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
    
    public Object[][] listarJornadas() {
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM jornadas");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][8];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT id_jor, fsal_jor, hsal_jor, raz_cli,"
                    + "pat_gru, nom_emp, apP_emp, freg_jor, hreg_jor, obs_jor FROM Jornadas INNER JOIN"
                    + " clientes ON clientes.rut_cli = jornadas.rut_cli INNER JOIN empleados ON empleados.rut_emp "
                    + "= jornadas.rut_emp ORDER BY id_jor");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estid = res.getString("id_jor");
                String estfsal = res.getString("fsal_jor");
                String esthsal = res.getString("hsal_jor");
                String estcli = res.getString("raz_cli");
                String estgrua = res.getString("pat_gru");
                String estop = res.getString("nom_emp") + res.getString("apP_emp");
                String estfreg = res.getString("freg_jor");
                String esthreg = res.getString("hreg_jor");
                String estobs = res.getString("obs_jor");
                data[i][0] = estid;
                data[i][1] = estgrua;
                data[i][2] = estcli;
                data[i][3] = estop;
                data[i][4] = estfsal;
                data[i][5] = null;
                data[i][6] = estobs;
                data[i][7] = esthsal;
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }

    public String ingresarJornada(String[] data) {
        try{
            String rut_cli = null, pat_gru = null, rut_emp = null;
            int dig_cli = 0, dig_emp;
            String[] rut_dv = data[4].split("-");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("Select rut_cli, dig_cli From clientes where "
                    + "raz_cli = ?");
            pstm.setString(1, data[3]);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estrutcli = res.getString("rut_cli");
                String estdigcli = res.getString("dig_cli");
                rut_cli = estrutcli;
                dig_cli = Integer.parseInt(estdigcli);
                i++;
            }
            res.close();
            pstm.close();
            pstm = conn.prepareStatement("Select pat_gru From gruas where "
                    + "des_gru = ?");
            pstm.setString(1, data[2]);
            res = pstm.executeQuery();
            i = 0;
            while(res.next()){
                String estpatgru = res.getString("pat_gru");
                pat_gru = estpatgru;
                i++;
            }
            res.close();
            pstm.close();
            pstm = conn.prepareStatement("insert into jornadas (fsal_jor, hsal_jor,"
                    + "pat_gru, rut_cli, rut_emp, freg_jor, hreg_jor, obs_jor) values (?, ?, ?, ?, ?, ?,"
                    + " ?, ?)");
            pstm.setDate(1, toSqlDate(data[0]));
            pstm.setString(2, data[1]);
            pstm.setString(3, pat_gru);
            pstm.setInt(4, Integer.parseInt(rut_cli));
            pstm.setInt(5, Integer.parseInt(rut_dv[0]));
            pstm.setDate(6, toSqlDate(data[5]));
            pstm.setString(7, data[6]);
            pstm.setString(8, data[7]);
            pstm.execute();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            return "incorrecto";
        }
        return "correcto";
    }
    
}
