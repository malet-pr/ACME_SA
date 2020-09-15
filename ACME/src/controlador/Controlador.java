package controlador;

import com.toedter.calendar.JDateChooser;
import static controlador.ImagenTextoComboBox.tema;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.ConsultaMecanica;
import modelo.ConsultaUsuario;
import modelo.ConsultaAdministracion;
import modelo.ConsultaDireccion;
import modelo.ConsultaPersonal;
import modelo.Hash;
import modelo.Usuario;
import vista.FrmHomeAdministracion;
import vista.FrmHomeDireccion;
import vista.FrmHomeMecanica;
import vista.FrmHomePersonal;
import vista.FrmHomeSistemas;
import vista.FrmLogin;
import vista.Preferencias;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */

public class Controlador implements ActionListener, ListSelectionListener, ItemListener{
    
    public static Usuario user = new Usuario(); // esta variable recoge datos del usuario corriente necesarios para algunas funciones
    public static Usuario usr;      // esta variable se usa para crear usuarios en blanco para la parte de CRUD, procedimientos y vistas
    public static Locale locale;
    public static ResourceBundle rb;
    private FrmLogin frmL;
    private static ConsultaUsuario cu;
    private ConsultaMecanica cm;
    private ConsultaAdministracion ca;
    private ConsultaDireccion cd;
    private ConsultaPersonal cp;
    private FrmHomeMecanica frmHM;
    private FrmHomeAdministracion frmHA;
    private FrmHomePersonal frmHP;
    private FrmHomeSistemas frmHS;
    private FrmHomeDireccion frmHD;
    public static String col[] = {"apellido","nombre","direccion","telefono","mail"};
    public static String data[][] = {};
    public static DefaultTableModel modelo = new DefaultTableModel(data,col);

    public Controlador(Usuario usr,FrmLogin frm,ConsultaUsuario cu){
        this.usr = usr;
        this.frmL = frm;
        this.cu = cu;
        this.frmL.btnLogIn.addActionListener(this);
    }
    
    public Controlador(Usuario usr, FrmHomeMecanica homeM, ConsultaMecanica cm, ConsultaUsuario cu) { 
        this.usr = usr;
        this.frmHM = homeM;
        this.cm = cm;
        this.cu = cu;
        this.frmHM.list.addListSelectionListener(this);
        this.frmHM.btnEnviar.addActionListener(this);
    }   

    public Controlador(Usuario usr, FrmHomeAdministracion homeA, ConsultaAdministracion ca, ConsultaUsuario cu) { 
        this.usr = usr;
        this.frmHA = homeA;
        this.ca = ca;
        this.cu = cu;
        this.frmHA.cb.addItemListener(this);
    }   
     
    public Controlador(Usuario usr, FrmHomePersonal homeP, ConsultaPersonal cp, ConsultaUsuario cu) { 
        this.usr = usr;
        this.frmHP = homeP;
        this.cp = cp;
        this.cu = cu;
        // agregar los ActionListener
    }     
     
    public Controlador(Usuario usr,FrmHomeSistemas homeS,ConsultaUsuario cu){
        this.usr = usr;
        this.frmHS = homeS;
        this.cu = cu;
        this.frmHS.btnRegistrar1.addActionListener(this);
        this.frmHS.btnBuscar.addActionListener(this);
        this.frmHS.btnModificar.addActionListener(this);
        this.frmHS.btnEliminar.addActionListener(this);
    }

    public Controlador(Usuario usr, FrmHomeDireccion homeD, ConsultaDireccion cd, ConsultaUsuario cu) { 
        this.usr = usr;
        this.frmHD = homeD;
        this.cd = cd;
        this.cu = cu;
        // agregar los ActionListener
    }
    
    public void iniciar() {
        frmL.setTitle("Sistema de ACME S.A.");
        frmL.setLocationRelativeTo(null);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == frmHS.btnRegistrar1){
            setLocale();
            if(frmHS.txtNombre1.getText().equals("")|frmHS.txtLegajo1.getText().equals("")|
               frmHS.txtUserName1.getText().equals("")|frmHS.txtPassword1.getPassword().equals("")|
               frmHS.txtConfirmar1.getPassword().equals("")|frmHS.cbxPermisos1.getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(null,rb.getString("incompleto"));
            } else { 
                String pass1 = new String(frmHS.txtPassword1.getPassword());
                String pass2 = new String(frmHS.txtConfirmar1.getPassword());
                if( pass1.equals(pass2) ){
                    user.setNombre(frmHS.txtNombre1.getText());
                    user.setLegajo(frmHS.txtLegajo1.getText());
                    user.setUserName(frmHS.txtUserName1.getText());
                    user.setPassword(Hash.sha1(pass1));
                    user.setPermisos(frmHS.cbxPermisos1.getSelectedIndex());
                    if(cu.agregar(user)) {
                        JOptionPane.showMessageDialog(null,rb.getString("registrado"));
                        frmHS.limpiar1();
                    }
                } else {
                    JOptionPane.showMessageDialog(null,rb.getString("diferentes"));
                }
            }
        }
        
        if (e.getSource() == frmHS.btnBuscar){
            setLocale();
            if(frmHS.txtLegajo2.getText().equals("")){
                JOptionPane.showMessageDialog(null, rb.getString("legajo"));
            } else {
                user.setLegajo(frmHS.txtLegajo2.getText());
                if(cu.buscar(user)) {
                    frmHS.txtNombre2.setText(user.getNombre());
                    frmHS.txtLegajo2.setText(user.getLegajo());
                    frmHS.txtUserName2.setText(user.getUserName());
                    frmHS.txtPassword2.setText(user.getPassword());
                    frmHS.txtId2.setText(String.valueOf(user.getId()));
                    frmHS.cbxPermisos2.setSelectedIndex(user.getPermisos());
                } else {
                    JOptionPane.showMessageDialog(null, rb.getString("legajo2"));
                } 
            }
        }
             
        if (e.getSource() == frmHS.btnModificar){
            setLocale();
            if(frmHS.txtLegajo2.getText().equals("")){
                JOptionPane.showMessageDialog(null, rb.getString("legajo"));
            } else {
                user.setId(Integer.parseInt(frmHS.txtId2.getText()));
                user.setNombre(frmHS.txtNombre2.getText());
                user.setLegajo(frmHS.txtLegajo2.getText());
                user.setUserName(frmHS.txtUserName2.getText());
                user.setPassword(Hash.sha1(new String(frmHS.txtPassword2.getPassword())));
                user.setPermisos(frmHS.cbxPermisos2.getSelectedIndex());
                if(cu.modificar(user)) {
                    JOptionPane.showMessageDialog(null,rb.getString("modificado"));
                    frmHS.limpiar2();
                } else {
                    JOptionPane.showMessageDialog(null, rb.getString("error2"));
                    frmHS.limpiar2();
                }
            }
        }

        if (e.getSource() == frmHS.btnEliminar){
            setLocale();
            if(frmHS.txtLegajo2.getText().equals("")){
                JOptionPane.showMessageDialog(null, rb.getString("legajo"));
            } else {
                user.setId(Integer.parseInt(frmHS.txtId2.getText()));
                if(cu.eliminar(user)) {
                    JOptionPane.showMessageDialog(null,rb.getString("eliminado"));
                    frmHS.limpiar2();
                } else {
                    JOptionPane.showMessageDialog(null, rb.getString("error3"));
                    frmHS.limpiar2();
                } 
            }
        }

        if (e.getSource() == frmHM.btnEnviar) {
            setLocale();
            if(frmHM.txtDato1.getText().equals("")|frmHM.jdcFecha.getDate() == null 
                    |frmHM.txtDato3.getText().equals("")){
                JOptionPane.showMessageDialog(frmHM.rightPanel, rb.getString("incompleto"));
            } else {
                String patente = frmHM.txtDato1.getText().toUpperCase();
                double costo = Double.parseDouble(frmHM.txtDato3.getText());
                Date date = frmHM.jdcFecha.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);  
                String pat1 = "[A-Z]{2}\\d{3}[A-Z]{2}";
                String pat2 = "[A-Z]{3}\\d{3}";                
                if(patente.matches(pat1)|patente.matches(pat2)){
                    if(costo >= 0) {
                        if(cm.cargarServicio(patente, fecha, costo)){
                            JOptionPane.showMessageDialog(frmHM.rightPanel, rb.getString("cargado"));
                            frmHM.limpiar();
                        } else {
                            JOptionPane.showMessageDialog(frmHM.rightPanel, rb.getString("error4"));
                            frmHM.limpiar();
                        }  
                    } else {
                        JOptionPane.showMessageDialog(frmHM.rightPanel, rb.getString("error5"));
                    }  
                } else {
                    JOptionPane.showMessageDialog(frmHM.rightPanel, rb.getString("error6"));
                }
            }
        }
                
        if (e.getSource() == frmL.btnLogIn) {
            Date date = new Date();
            DateFormat fechaSql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setUserName(frmL.txtUserName.getText());
            user.setUltimaSesion(fechaSql.format(date));
            String pass = new String(frmL.txtPassword.getPassword());
            String pass2 = Hash.sha1(pass);
            user.setPassword(pass2);
            if (cu.login(user)){
                frmL.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contrase�a Incorrectos");
            }
        } 
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(frmHM.list.getSelectedIndex() == 0) {
            frmHM.limpiar();
            setLocale();
            frmHM.instruccion.setText(rb.getString("propietario"));
            JTextField txtPatente = new JTextField();
            String message1 = rb.getString("patente");       
            Object[] params = {message1,txtPatente};
            int reply = JOptionPane.showConfirmDialog(frmHM.rightPanel,params,rb.getString("ingresar"),JOptionPane.OK_CANCEL_OPTION);
            if(reply == JOptionPane.CANCEL_OPTION){
                frmHM.list.clearSelection();
                frmHM.instruccion.setText(rb.getString("opcion"));
            } else {
                String patente = txtPatente.getText().toUpperCase();
                String pat1 = "[A-Z]{2}\\d{3}[A-Z]{2}";
                String pat2 = "[A-Z]{3}\\d{3}";
                if(patente.matches(pat1)|patente.matches(pat2)){
                    if(cm.consultarDuenio(patente)){
                        frmHM.dato1.setText(rb.getString("nombre2"));
                        frmHM.dato2.setText(rb.getString("apellido2"));
                        frmHM.dato3.setText(rb.getString("telefono"));
                        frmHM.txtDato1.setText(ConsultaMecanica.resultado[0]);
                        frmHM.txtDato2.setText(ConsultaMecanica.resultado[1]);
                        frmHM.txtDato3.setText(ConsultaMecanica.resultado[2]);
                        frmHM.txtDato1.setBackground(Color.WHITE);
                        frmHM.txtDato2.setBackground(Color.WHITE);
                        frmHM.txtDato3.setBackground(Color.WHITE); 
                        frmHM.rightPanel.add(frmHM.txtDato2); 
                    } else {
                    JOptionPane.showMessageDialog(frmHM.rightPanel, rb.getString("error8"));
                    }
                } else {
                    JOptionPane.showMessageDialog(frmHM.rightPanel, rb.getString("error6"));
                }
            }
            frmHM.list.clearSelection();
            frmHM.instruccion.setText(rb.getString("opcion"));
        }
        if(frmHM.list.getSelectedIndex() == 1) {
            frmHM.limpiar();
            setLocale();
            frmHM.instruccion.setText(rb.getString("nuevo"));
            frmHM.rightPanel.remove(frmHM.txtDato2);
            frmHM.txtDato1.setBackground(Color.WHITE);
            frmHM.txtDato2.setBackground(Color.WHITE);
            frmHM.txtDato3.setBackground(Color.WHITE);
            frmHM.dato1.setText(rb.getString("patente2"));
            frmHM.dato2.setText(rb.getString("fecha"));
            frmHM.dato3.setText(rb.getString("costo"));
            frmHM.rightPanel.add(frmHM.jdcFecha); 
            frmHM.btnEnviar.setVisible(true);
            frmHM.list.clearSelection();
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        int state = e.getStateChange();          
        CardLayout cl = (CardLayout)(frmHA.panelCard.getLayout());
        if(state == ItemEvent.DESELECTED){
           cl.show(frmHA.panelCard, frmHA.comboBoxItems[0]); 
        }
        if (e.getItem() == frmHA.comboBoxItems[1] && state == ItemEvent.SELECTED) {
            setLocale();
            if(ca.serviciosMes()){
                cl.show(frmHA.panelCard, (String)e.getItem());
                frmHA.txtServicios1.setText(ca.resultado[0]);
                frmHA.txtMonto1.setText(ca.resultado[1]);
            } else {
                JOptionPane.showMessageDialog(null, rb.getString("error9"));
            }
        }
        if (e.getItem() == frmHA.comboBoxItems[2] && state == ItemEvent.SELECTED) {
            setLocale();
            if(ca.serviciosSemana()){
                cl.show(frmHA.panelCard, (String)e.getItem());
                frmHA.txtServicios2.setText(ca.resultado[0]);
                frmHA.txtMonto2.setText(ca.resultado[1]);
            } else {
                JOptionPane.showMessageDialog(null, rb.getString("error9"));
            }                       
        }
        if (e.getItem() == frmHA.comboBoxItems[3] && state == ItemEvent.SELECTED) {
            setLocale();
            int reply;
            JDateChooser jdcFecha1 = new JDateChooser();
            String message1 =rb.getString("inicio");
            JDateChooser jdcFecha2 = new JDateChooser(); 
            String message2 =rb.getString("fin");        
            Object[] params = {message1,jdcFecha1,message2,jdcFecha2};
            JOptionPane.showConfirmDialog(null,params,rb.getString("fecha2"), JOptionPane.CLOSED_OPTION);       
            if(jdcFecha1.getDate() == null | jdcFecha2.getDate() == null){
                reply = JOptionPane.showConfirmDialog(null,rb.getString("error10"), 
                        rb.getString("error11"), JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.NO_OPTION) {
                    frmHA.cb.setSelectedIndex(0);
                } else {
                    frmHA.cb.setSelectedIndex(0);
                    frmHA.cb.setSelectedIndex(3);                
                }

            } else {
                Date date = jdcFecha1.getDate();
                long d = date.getTime();
                java.sql.Date fecha1 = new java.sql.Date(d);
                frmHA.info2.setText(String.valueOf(fecha1));
                date = jdcFecha2.getDate();
                d = date.getTime();
                java.sql.Date fecha2 = new java.sql.Date(d); 
                frmHA.info4.setText(String.valueOf(fecha2));
                if(fecha1.compareTo(fecha2) >=0){
                    reply = JOptionPane.showConfirmDialog(null,
                       rb.getString("error12"), rb.getString("error11"), JOptionPane.YES_NO_OPTION);
                    if(reply == JOptionPane.NO_OPTION) {
                        frmHA.cb.setSelectedIndex(0);
                    } else {
                        frmHA.cb.setSelectedIndex(0);
                        frmHA.cb.setSelectedIndex(3);                
                    }
                } else {
                    if(ca.serviciosFechas(fecha1, fecha2)){
                        cl.show(frmHA.panelCard, (String)e.getItem());
                        frmHA.txtServicios3.setText(ca.resultado[0]);
                        frmHA.txtMonto3.setText(ca.resultado[1]);
                    } else {
                        JOptionPane.showMessageDialog(null, rb.getString("error13"));
                    }
                }
            }
            
        }
        if (e.getItem() == frmHA.comboBoxItems[4] && state == ItemEvent.SELECTED) {
            setLocale();
            cl.show(frmHA.panelCard, (String)e.getItem());
            if(ca.listaClientes() != null) {
                Object fila = new Object();
                for(int i = 0; i < ca.tablaClientes.size(); i++){
                    fila = ConsultaAdministracion.tablaClientes.get(i);
                    modelo.addRow((Object[]) fila);
                }
            frmHA.jtClientes.setModel(modelo);
            } else {
                JOptionPane.showMessageDialog(null, rb.getString("error13"));
            } 
        }
        if (e.getItem() == frmHA.comboBoxItems[5] && state == ItemEvent.SELECTED) {
            cl.show(frmHA.panelCard, (String)e.getItem());
        }
        if (e.getItem() == frmHA.comboBoxItems[6] && state == ItemEvent.SELECTED) {
            cl.show(frmHA.panelCard, (String)e.getItem());
        }
        if (e.getItem() == frmHA.comboBoxItems[7] && state == ItemEvent.SELECTED) {
            cl.show(frmHA.panelCard, (String)e.getItem());
        }
        if (e.getItem() == frmHA.comboBoxItems[8]&& state == ItemEvent.SELECTED) {
            cl.show(frmHA.panelCard, (String)e.getItem());
        } 
    }
    
    public static void cambiarClave() {
        setLocale();
        JPasswordField pass1 = new JPasswordField("");
        JPasswordField pass2 = new JPasswordField("");
        pass1.setEchoChar('*');
        pass2.setEchoChar('*');
        String mensaje1 = rb.getString("escribir");
        String mensaje2 = rb.getString("repetir");
        javax.swing.JCheckBox ver = new javax.swing.JCheckBox(rb.getString("ver")); 
        ver.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {                    
                    pass1.setEchoChar((char) 0);
                    pass2.setEchoChar((char) 0);
                } else {
                    pass1.setEchoChar('*');
                    pass2.setEchoChar('*');
                }                
            }
        });
        Object[] params = {mensaje1,pass1,ver,mensaje2,pass2};
        int opcion = JOptionPane.showConfirmDialog(null,params,rb.getString("contraseñas")
                , JOptionPane.OK_CANCEL_OPTION);
        if(opcion == 0){
            if(pass1.getPassword().length == 0 | pass2.getPassword().length == 0){
                JOptionPane.showMessageDialog(null,rb.getString("blancos"));
            }  else {
                String p1 = new String(pass1.getPassword());
                String p2 = new String(pass2.getPassword());
                if(p1.equals(p2)){
                    user.setPassword(Hash.sha1(p1));
                    if(cu.cambiarClave(user)) {
                        JOptionPane.showMessageDialog(null,rb.getString("bien"));
                    } else {
                        JOptionPane.showMessageDialog(null,rb.getString("error"));
                    }    
                } else {
                    JOptionPane.showMessageDialog(null,rb.getString("diferentes"));
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, rb.getString("cancelado"));
        }
    }
    
    public static void logOut(){
        FrmLogin login = new FrmLogin();
        ConsultaUsuario consulta = new ConsultaUsuario();
        usr = new Usuario();
        Controlador ctrl = new Controlador(usr,login,consulta);
        ctrl.iniciar();
        login.setVisible(true);
    }
    
    public static void cambiarMotivo(){
        setLocale();
        ImagenTextoComboBox cbx = new ImagenTextoComboBox();
        String rosaS = rb.getString("rosa");
        String verdeS = rb.getString("verde");
        cbx.getTema();
        if(tema.equals(verdeS)) {
            cu.cambiarMotivo(user.getId(), "verde");
            Preferencias.setDefaultColors("verde");
            Preferencias.setOptionPaneColor("verde");
        } else if(tema.equals(rosaS)) {
            cu.cambiarMotivo(user.getId(), "rosa");
            Preferencias.setDefaultColors("rosa");
            Preferencias.setOptionPaneColor("rosa");
        } 
    }
    
    public static void cambiarIdioma(String vIdioma){
        user.setIdioma(vIdioma);
        cu.cambiarIdioma(user.getId(), user.getIdioma());
        Preferencias.setOptionPaneLanguaje(user.getIdioma());
    }
    
    public static void setLocale(){
        if(Controlador.user.getIdioma().equals("español")){
            locale = Locale.forLanguageTag("es-ES");
        }
        if(Controlador.user.getIdioma().equals("inglés")){
            locale = Locale.forLanguageTag("en-EN");
        }  
        rb = ResourceBundle.getBundle("vista/recursos/RecursoIdioma", locale);
    }
    
    public static void abrirHome(Usuario user) {
        ConsultaUsuario cu;
        ConsultaAdministracion ca;
        ConsultaPersonal cp;
        ConsultaDireccion cd;
        ConsultaMecanica cm;
        Controlador ctrl;
        Preferencias.preferencias(user.getMotivo(),user.getIdioma());
        switch (user.getPermisos()) {
            case 1:
                FrmHomeMecanica homeM = new FrmHomeMecanica();
                homeM.lblNombre.setText(user.getNombre());
                cm = new ConsultaMecanica();
                cu = new ConsultaUsuario();
                ctrl = new Controlador(user,homeM,cm,cu);
                homeM.setVisible(true);
                break;
            case 2:
                FrmHomeAdministracion homeA = new FrmHomeAdministracion();
                homeA.lblNombre.setText(user.getNombre());
                ca = new ConsultaAdministracion();
                cu = new ConsultaUsuario();
                ctrl = new Controlador(user,homeA,ca,cu);
                homeA.setVisible(true);
                break;
            case 3:
                FrmHomePersonal homeP = new FrmHomePersonal();
                homeP.lblNombre.setText(user.getNombre());
                cp = new ConsultaPersonal();
                cu = new ConsultaUsuario();        
                ctrl = new Controlador(user,homeP,cp,cu);
                homeP.setVisible(true);
                break;
            case 4:
                FrmHomeSistemas homeS = new FrmHomeSistemas();
                homeS.lblNombre.setText(user.getNombre());
                cu = new ConsultaUsuario();
                ctrl = new Controlador(user,homeS,cu);
                homeS.setVisible(true);
                break;
            case 5:
                FrmHomeDireccion homeD = new FrmHomeDireccion();
                homeD.lblNombre.setText(user.getNombre());
                cd = new ConsultaDireccion();
                cu = new ConsultaUsuario();
                ctrl = new Controlador(user,homeD,cd,cu);
                homeD.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Usted no tiene permiso para acceder al sistema");
        }

    }
   
}


