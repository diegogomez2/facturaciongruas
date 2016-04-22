/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author diego
 */
public class modeloRegiones {
    static String login = "root";
    static String password = "205243";
    static String url = "jdbc:mysql://localhost:3306/factgruas";
    Connection conn = null;
    
    public Object[][] listarRegiones(){
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM Regiones");
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][2];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT nom_reg, id_reg FROM Regiones ORDER BY num_reg");
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estid = res.getString("id_reg");
                String estnom = res.getString("nom_reg");
                data[i][0] = estid;
                data[i][1] = estnom;
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }

    public Object[][] listaComunas(int region) {
        int registros = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT count(1) as total FROM Comunas INNER JOIN"
                    + " Regiones ON comunas.id_reg = regiones.id_reg WHERE regiones.id_reg = ?");
            pstm.setInt(1, region);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
       }catch(SQLException e){
            System.out.println(e);
       }catch(ClassNotFoundException e){
            System.out.println(e);
       }
        
        Object[][] data = new String[registros][1];
        
        try{
            PreparedStatement pstm = conn.prepareStatement("SELECT nom_com FROM Comunas INNER JOIN regiones ON comunas.id_reg = regiones.id_reg where comunas.id_reg = ? ORDER BY nom_com");
            pstm.setInt(1, region);
            ResultSet res = pstm.executeQuery();
            int i = 0;
            while(res.next()){
                String estnom = res.getString("nom_com");
                data[i][0] = estnom;
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
}