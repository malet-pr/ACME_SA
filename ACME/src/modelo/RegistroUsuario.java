package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */
public class RegistroUsuario extends Conexion {
       
    public boolean registrar(Usuario usr) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO usuarios (Nombre,legajo,userName,password,permisos) VALUES (?,?,?,?,?)";        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getLegajo());
            ps.setString(3, usr.getUserName());
            ps.setString(4, usr.getPassword());
            ps.setInt(5, usr.getPermisos());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
    }

    public int existeLegajo(String legajo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT count(id) FROM usuarios WHERE legajo = ?";        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, legajo);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }  
    }
    
    public int existeUserName(String userName) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT count(id) FROM usuarios WHERE userName = ?";        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }  
    }
        
}
