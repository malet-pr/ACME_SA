package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 6/2019
 */

public class ConsultaAdministracion extends Conexion {

    public static String[] resultado = {"",""};
    public static Cliente cli;
    public static ArrayList<Object> tablaClientes = new ArrayList<Object>();
 
    public boolean serviciosSemana(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "select * from total_servicios_de_la_semana"; 
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                resultado[0] = rs.getString("servicios");
                resultado[1] = rs.getString("monto");
                return true;
            }
        return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean serviciosMes(){
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "select * from total_servicios_del_mes"; 
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                resultado[0] = rs.getString("servicios");
                resultado[1] = rs.getString("monto");
                return true;
            }
        return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaAdministracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        
    public boolean serviciosFechas(Date fecha1, Date fecha2) {  
        String sql1 = "{call total_servicios_entre_fechas(?,?,?,?)}";
        String sql2 = "select @servicios, @monto"; 
        CallableStatement cs;
        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            cs = con.prepareCall(sql1); 
            cs.setDate(1,fecha1);
            cs.setDate(2,fecha2);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            resultado[0] = cs.getString(3);
            resultado[1] = cs.getString(4);
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
    }   

    public ArrayList listaClientes() {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConexion();
        String sql = "select * from lista_clientes";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Object[] obj = new Object[5];
                obj[0] = (rs.getString("apellido"));
                obj[1] = (rs.getString("nombre"));
                obj[2] = (rs.getString("domicilio"));
                obj[3] = (rs.getString("movil"));
                obj[4] = (rs.getString("correo"));
                tablaClientes.add(obj);   
            }
            return tablaClientes;
        } catch (SQLException e) {
            System.err.println(e);
            return tablaClientes;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
}

   