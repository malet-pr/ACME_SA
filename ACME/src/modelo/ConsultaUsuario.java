package modelo;

import controlador.Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */

public class ConsultaUsuario extends Conexion {
    
    public boolean cambiarClave(Usuario usr){
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE usuarios SET password=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getPassword());
            ps.setInt(2, usr.getId());
            ps.executeUpdate();
            return true;
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
    
    public boolean cambiarMotivo(int usuario, String motivo){
        Usuario usr = new Usuario();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql1 = "UPDATE usuarios SET motivo=? WHERE id = ?";
        String sql2 = "SELECT * FROM usuarios WHERE id = ?";
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1, motivo);
            ps.setInt(2, usuario);
            ps.executeUpdate();
            ps = con.prepareStatement(sql2);
            ps.setInt(1, usuario);
            rs = ps.executeQuery();
            if(rs.next()){
                Controlador.abrirHome(new Usuario(Integer.parseInt(rs.getString("id")),
                        rs.getString("nombre"),Integer.parseInt(rs.getString("permisos")),
                        rs.getString("motivo"),rs.getString("idioma")));
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
    
    public boolean cambiarIdioma(int usuario, String idioma){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql1 = "UPDATE usuarios SET idioma = ? WHERE id = ?";
        String sql2 = "SELECT * FROM usuarios WHERE id = ?";
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1, idioma);
            ps.setInt(2, usuario);
            ps.executeUpdate();   
            ps = con.prepareStatement(sql2);
            ps.setInt(1, usuario);
            rs = ps.executeQuery();
            if(rs.next()){
                Controlador.abrirHome(new Usuario(Integer.parseInt(rs.getString("id")),
                        rs.getString("nombre"), Integer.parseInt(rs.getString("permisos")),
                        rs.getString("motivo"),rs.getString("idioma")));
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
    
    public boolean login(Usuario usr) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM usuarios WHERE userName = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUserName());
            rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString("password").equals(usr.getPassword())){ 
                    String sqlU = "UPDATE usuarios SET ultimaSesion=? WHERE id=?";
                    ps = con.prepareStatement(sqlU);
                    ps.setString(1, usr.getUltimaSesion());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();
                    Controlador.user.setId(Integer.parseInt(rs.getString("id")));
                    Controlador.user.setIdioma(rs.getString("idioma"));
                    Controlador.user.setPermisos(rs.getInt("permisos"));
                    Controlador.user.setMotivo(rs.getString("motivo"));
                    Controlador.abrirHome(new Usuario(Integer.parseInt(rs.getString("id")),
                        rs.getString("nombre"), Integer.parseInt(rs.getString("permisos")),
                        rs.getString("motivo"),rs.getString("idioma")));
                    return true;     
                }  
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
    
    public boolean agregar(Usuario usr) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql1 = "SELECT id FROM usuarios WHERE legajo = ?";
        String sql2 = "SELECT id FROM usuarios WHERE userName = ?";
        String sql3 = "INSERT INTO usuarios (nombre,legajo,userName,password,permisos) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1, usr.getLegajo());
            rs = ps.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Ya existe un usuario con ese legajo");
                return false;
            } else {
                ps = con.prepareStatement(sql2);
                ps.setString(1, usr.getUserName());
                rs = ps.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Ese nombre de usuario no está disponible");
                    return false;                    
                } else {   
                    ps = con.prepareStatement(sql3);
                    ps.setString(1, usr.getNombre());
                    ps.setString(2, usr.getLegajo());
                    ps.setString(3, usr.getUserName());
                    ps.setString(4, usr.getPassword());
                    ps.setInt(5, usr.getPermisos());
                    ps.execute();
                    return true;
                }         
            }
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
    
    public boolean modificar(Usuario usr) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE usuarios SET nombre=?, legajo=?, userName=?, password=?, permisos=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombre());
            ps.setString(2, usr.getLegajo());
            ps.setString(3, usr.getUserName());
            ps.setString(4, usr.getPassword());
            ps.setInt(5, usr.getPermisos());
            ps.setInt(6, usr.getId());
            ps.execute();
            return true;
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
    
    public boolean eliminar(Usuario usr) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "DELETE FROM usuarios WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usr.getId());
            ps.execute();
            return true;            
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
    
    public boolean existeUsuario(Usuario usr) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql1 = "SELECT id FROM usuarios WHERE legajo = ?";
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1, usr.getLegajo());
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
    
    public boolean buscar(Usuario usr) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "SELECT * FROM usuarios WHERE legajo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getLegajo());
            rs = ps.executeQuery();
            if(rs.next()){
                usr.setId(Integer.parseInt(rs.getString("id")));
                usr.setNombre(rs.getString("nombre"));
                usr.setLegajo(rs.getString("legajo"));
                usr.setUserName(rs.getString("userName"));
                usr.setPassword(rs.getString("password"));
                usr.setPermisos(Integer.parseInt(rs.getString("permisos")));
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
