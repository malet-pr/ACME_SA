package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */
public class Conexion {
    
   private final String BASE = "service-automotor";
   private final String TIMEZONE = "?serverTimezone=UTC-3.00";
   private final String USER = "root";
   private final String PASSWORD = "UNgs#1409";
   private final String URL = "jdbc:mysql://localhost:3306/" + BASE;
   private Connection con = null;
   
   public Connection getConexion() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = (Connection) DriverManager.getConnection(this.URL,this.USER,this.PASSWORD);
       } catch(SQLException e) {
           System.err.println(e);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
       return con;
   }
   
}

