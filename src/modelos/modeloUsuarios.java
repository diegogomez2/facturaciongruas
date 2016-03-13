/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import controladores.controladorPrincipal;
import java.sql.*;

/**
 *
 * @author Diego
 */
public class modeloUsuarios {
    static String login = "root";
    static String password = "205243";
    static String url = "jdbc:mysql://localhost:3306/factgruas";
    Connection conn = null;
    
    public String verificarLogin(String rut, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM usuarios WHERE user = ?");
            pstm.setString(1, rut);
            ResultSet res = pstm.executeQuery();
            
            while(res.next()){
                String contraseña = res.getString("pass");
                if(contraseña.compareTo(pass) == 0){
                    return "correcto";
                }
            }
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
            System.out.println(url);
        }
        return "incorrecto";
    }

    public String obtenerContraseña(String user) {
        String contraseña = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("SELECT pass FROM usuarios WHERE user = ?");
            pstm.setString(1, user);
            ResultSet res = pstm.executeQuery();
            
            while(res.next()){
                contraseña = res.getString("pass");
            }
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
            System.out.println(url);
        }
        return contraseña;
    }

    public String cambiarClave(String pwNueva) {
        try{
            controladores.controladorPrincipal miControlador = new controladorPrincipal();
            String user = miControlador.user;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, login, password);
            PreparedStatement pstm = conn.prepareStatement("UPDATE usuarios set pass=? where user = ?");
            pstm.setString(1, pwNueva);
            pstm.setString(2, user);
            pstm.executeUpdate();
            pstm.close();
        }catch(SQLException e){
            System.out.println(e);
            return "incorrecto";
        }catch(ClassNotFoundException e){
            System.out.println(e);
            System.out.println(url);
            return "incorrecto";
        }
        return "correcto";
    }
}