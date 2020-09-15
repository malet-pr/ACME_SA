package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;


/**
 * @author Nuria Malet
 * @version 2.0
 * @since 6/2019
 */

public class FrmHomeSistemas extends Vista {
    
    JTabbedPane pestanias;
    // Para el primer panel
    private JPanel panel1;
    public static JTextField txtNombre1; 
    public static JTextField txtLegajo1;
    public static JTextField txtUserName1;
    public static JPasswordField txtPassword1;
    public static JPasswordField txtConfirmar1;
    public static JComboBox cbxPermisos1;
    public static JButton btnRegistrar1;
    public JButton btnLimpiar1;
    // Para el segundo panel
    public static JTextField txtId2;
    public static JTextField txtNombre2;
    public static JTextField txtLegajo2;
    public static JTextField txtUserName2;
    public static JPasswordField txtPassword2;
    public static JToggleButton tbtPassword;
    public static JComboBox cbxPermisos2;
    public static JButton btnBuscar;
    public static JButton btnModificar;
    public static JButton btnEliminar;
    public JButton btnLimpiar2;   

    public FrmHomeSistemas(){
        super();
        Vista.lblTitulo.setText(rb.getString("titulo5"));
        setTabbedPane();
        setPanel1();
        setPanel2();
    }

    public void setTabbedPane(){   
        UIManager.put("TabbedPane.selected", COLOR_BACKGROUND_1);
        pestanias = new JTabbedPane();
        pestanias.setBounds(15, 30, 770, 520);
        pestanias.setBackground(COLOR_BACKGROUND_4);
        pestanias.setForeground(setTextColor(pestanias.getBackground())); 
        panel.add(pestanias);
    }
    
    public void setPanel1(){
        panel1 = new JPanel();
        panel1.setLayout(null);
        // Título
        int[] cajaT = {250, 20, 300, 25};
        setLabel(rb.getString("regUsr"),cajaT,Preferencias.FUENTE4,0,panel1);     
        // Etiquetas
        int[] caja = {100,30,200,150};
        int[] fuente = {1,15};
        setLabel(rb.getString("nombre1"),caja,Preferencias.FUENTE5,4,panel1);
        caja[1] = 80;
        setLabel(rb.getString("legajo1"),caja,Preferencias.FUENTE5,4,panel1);
        caja[1] = 130;
        setLabel(rb.getString("nombreUsr"),caja,Preferencias.FUENTE5,4,panel1);
        caja[1] = 180;
        setLabel(rb.getString("clave"),caja,Preferencias.FUENTE5,4,panel1);
        caja[1] = 230;
        setLabel(rb.getString("confirmar"),caja,Preferencias.FUENTE5,4,panel1);
        caja[1] = 280;
        setLabel(rb.getString("sector"),caja,Preferencias.FUENTE5,4,panel1);       
        // Campos de texto       
        int[] cajaTF = {310, 90, 300, 30};
        txtNombre1 = setTextField(txtNombre1,cajaTF,Preferencias.FUENTE5,panel1);
        cajaTF[1] = 140;
        txtLegajo1 = setTextField(txtLegajo1,cajaTF,Preferencias.FUENTE5,panel1);
        cajaTF[1] = 190;
        txtUserName1 = setTextField(txtUserName1,cajaTF,Preferencias.FUENTE5,panel1);        
        // Campos de password
        int[] cajaPF = {310, 240, 300, 30};
        txtPassword1 = setPasswordField(txtPassword1,cajaPF,Preferencias.FUENTE5,panel1);
        cajaPF[1] = 290;
        txtConfirmar1 = setPasswordField(txtConfirmar1,cajaPF,Preferencias.FUENTE5,panel1); 
        // Combobox
        int[] cajaCB = {310, 340, 200, 30};
        cbxPermisos1 = setComboBox(cbxPermisos1,cajaCB,Preferencias.FUENTE5,panel1);
        // Botones
        int[] cajaB = {300, 430, 100, 30};
        btnLimpiar1 = setButton(btnLimpiar1,rb.getString("limpiar"),cajaB,Preferencias.FUENTE5,panel1);
        btnLimpiar1.addActionListener((ActionEvent e) -> {
            limpiar1();
        });
        cajaB[0] = 500;
        btnRegistrar1= setButton(btnRegistrar1,rb.getString("registrar1"),cajaB,Preferencias.FUENTE5,panel1);
        // Colocar panel con su nombre
        pestanias.addTab(rb.getString("regUsuario"), panel1); 
    }
        
    public void setPanel2(){ 
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        // Título
        int[] cajaT = {200, 20, 400, 25};
        setLabel(rb.getString("modificarUsuario"),cajaT,Preferencias.FUENTE4,0,panel2);     
        // Etiquetas
        int[] caja = {100,30,200,150};
        setLabel(rb.getString("legajo1"),caja,Preferencias.FUENTE5,4,panel2);
        caja[1] = 80;
        setLabel(rb.getString("nombre1"),caja,Preferencias.FUENTE5,4,panel2);
        caja[1] = 130;
        setLabel(rb.getString("nombreUsr"),caja,Preferencias.FUENTE5,4,panel2);
        caja[1] = 180;
        setLabel(rb.getString("sector"),caja,Preferencias.FUENTE5,4,panel2);
        caja[1] = 230;
        setLabel(rb.getString("clave"),caja,Preferencias.FUENTE5,4,panel2);
        caja[1] = 280;
        setLabel(rb.getString("cambiarClave"),caja,Preferencias.FUENTE5,4,panel2); 
        // Campos de texto
        int[] cajaTF = {310, 140, 300, 30};
        txtNombre2 = setTextField(txtNombre2,cajaTF,Preferencias.FUENTE5,panel2);
        cajaTF[1] = 190;
        txtUserName2 = setTextField(txtUserName2,cajaTF,Preferencias.FUENTE5,panel2);         
        cajaTF[1] = 90;
        cajaTF[2] = 180;
        txtLegajo2 = setTextField(txtLegajo2,cajaTF,Preferencias.FUENTE5,panel2);  
        cajaTF[0] = 450;
        cajaTF[1] = 340;
        cajaTF[2] = 100;
        txtId2 = setTextField(txtId2,cajaTF,Preferencias.FUENTE5,panel2);
        txtId2.setVisible(false);
        // Campo de Password
        int[] cajaPF = {310, 290, 300, 30};
        txtPassword2 = setPasswordField(txtPassword2,cajaPF,Preferencias.FUENTE5,panel2);
        txtPassword2.setEditable(false);
        // Combobox
        int[] cajaCB = {310, 240, 200, 30};
        cbxPermisos2 = setComboBox(cbxPermisos2,cajaCB,Preferencias.FUENTE5,panel2);
        // Toggle Button (no lo pongo en función porque es uno sólo)
        tbtPassword = new JToggleButton(rb.getString("si"));  
        tbtPassword.setBounds(310, 340, 100, 30);
        tbtPassword.setFont(Preferencias.FUENTE5);
        panel2.add(tbtPassword);
        tbtPassword.addActionListener((ActionEvent e) -> {
            if(tbtPassword.isSelected()){
                txtPassword2.setEditable(true);
                tbtPassword.setText(rb.getString("no"));
            } else {
                txtPassword2.setEditable(false);
                tbtPassword.setText(rb.getString("si"));
            }
        });      
        // Botones
        int[] fuenteB = {3,15};
        int[] cajaB = {550, 430, 100, 30};
        btnLimpiar2 = setButton(btnLimpiar2,rb.getString("limpiar"),cajaB,Preferencias.FUENTE5,panel2);
        btnLimpiar2.addActionListener((ActionEvent e) -> {
            limpiar2();
        });
        int[] cajaBR = {520, 90, 90, 30};
        btnBuscar = setButton(btnBuscar,rb.getString("buscar"),cajaBR,Preferencias.FUENTE5,panel2);   
        cajaB[0] = 150;
        btnModificar = setButton(btnModificar,rb.getString("modificar"),cajaB,Preferencias.FUENTE5,panel2);
        cajaB[0] = 350;
        btnEliminar = setButton(btnEliminar,rb.getString("eliminar"),cajaB,Preferencias.FUENTE5,panel2);
        // Colocar panel con su nombre
        pestanias.addTab(rb.getString("cambiar1"), panel2);
    }
             
    public void setLabel(String nombre, int[] caja, Font fuente, int alineacion, JPanel panel){
        JLabel eti = new JLabel(nombre);
        eti.setBounds(caja[0],caja[1],caja[2],caja[3]);
        eti.setFont(fuente);
        eti.setHorizontalAlignment(alineacion);
        panel.add(eti);
    }
    
    public JTextField setTextField(JTextField nombre, int[] caja, Font fuente, JPanel panel){
        nombre = new JTextField("");
        nombre.setBounds(caja[0],caja[1],caja[2],caja[3]);
        nombre.setFont(fuente);
        panel.add(nombre);
        return nombre;
    }
    
    public JPasswordField setPasswordField(JPasswordField nombre, int[] caja, Font fuente,JPanel panel){
        nombre = new JPasswordField("");
        nombre.setBounds(caja[0],caja[1],caja[2],caja[3]);
        nombre.setFont(fuente);
        panel.add(nombre);
        return nombre;
    }
    
    public JComboBox setComboBox(JComboBox nombre, int[] caja, Font fuente, JPanel panel){
        nombre = new JComboBox();
        nombre.addItem(rb.getString("selArea"));
        nombre.addItem("     " + rb.getString("mecanica"));
        nombre.addItem("     " + rb.getString("administracion"));
        nombre.addItem("     " + rb.getString("recursos"));
        nombre.addItem("     " + rb.getString("sistemas"));
        nombre.addItem("     " + rb.getString("direccion1"));
        nombre.setBounds(caja[0],caja[1],caja[2],caja[3]);
        nombre.setFont(fuente);
        panel.add(nombre);
        return nombre;
    }
    
    public JButton setButton(JButton nombre,String NOMBRE, int[] caja, Font fuente,JPanel panel){
        nombre = new JButton(NOMBRE);
        nombre.setBounds(caja[0],caja[1],caja[2],caja[3]);
        nombre.setFont(fuente);
        panel.add(nombre);
        return nombre;
    }
    
    public void limpiar1(){ 
        txtNombre1.setText("");
        txtLegajo1.setText("");
        txtUserName1.setText("");
        txtPassword1.setText("");
        txtConfirmar1.setText("");
        cbxPermisos1.setSelectedIndex(0);
        revalidate();
        repaint();
    }
    
    public void limpiar2() {
        txtNombre2.setText("");
        txtLegajo2.setText("");
        txtUserName2.setText("");
        txtPassword2.setText("");
        txtPassword2.setEditable(false);
        txtId2.setText("");
        cbxPermisos2.setSelectedIndex(0);
        tbtPassword.setSelected(false);
        tbtPassword.setText(rb.getString("si"));
    }
    
}