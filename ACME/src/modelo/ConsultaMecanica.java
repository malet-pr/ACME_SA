package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import controlador.Controlador;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */

public class ConsultaMecanica extends Conexion {
   
    public static String[] resultado = {"","",""};
    
    public boolean consultarDuenio(String patente){  
        String sql = "{call buscar_duenio(?)}";
        CallableStatement cs;
        ResultSet rs; 
        Connection con = getConexion();
        try {
            cs = con.prepareCall(sql); 
            cs.setString(1,patente);
            rs = cs.executeQuery();
            while(rs.next()){
                resultado[0] = rs.getString("nombre");
                resultado[1] = rs.getString("apellido");
                resultado[2] = rs.getString("movil");
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaMecanica.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }  
    }

    public boolean cargarServicio(String patente, Date fecha, double costo){  
        String sql = "{call cargar_servicio(?,?,?)}";
        CallableStatement cs;
        Connection con = getConexion();
        if(existeAuto(patente)){
            try {
                cs = con.prepareCall(sql); 
                cs.setString(1,patente);
                cs.setDate(2,fecha);
                cs.setDouble(3,costo);
                cs.execute();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaMecanica.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            } 
        } else {
            JOptionPane.showMessageDialog(null,"No existe un auto con esa patente");
            return false;
        }    
    }
    
    public boolean existeAuto(String patente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql1 = "SELECT id FROM autos WHERE patente = ?";
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1, patente);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            } 
        return false;    
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }              
    }  
    
} 
