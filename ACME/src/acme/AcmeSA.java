package acme;

import controlador.Controlador;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
import modelo.ConsultaUsuario;
import modelo.Usuario;
import vista.FrmLogin;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */
public class AcmeSA {
    
    public static void main(String[] args) {
//        
        // Abrir vista LogIn con su consulta y su controlador
        FrmLogin login = new FrmLogin();
        ConsultaUsuario consulta = new ConsultaUsuario();
        Usuario usr = new Usuario();       
        Controlador ctrl = new Controlador(usr,login,consulta);
        ctrl.iniciar();
        login.setVisible(true);
        
    }  
}

