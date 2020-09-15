package vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */
 
public class FrmHomeMecanica extends Vista {

    public static JLabel instruccion;
    public static JComponent leftPanel,rightPanel;
    public static JList list;
    public static JLabel dato1,dato2,dato3;
    public static JTextField txtDato1,txtDato2,txtDato3;
    public static String fecha;
    public static JDateChooser jdcFecha;
    public static JButton btnEnviar;
    
    public FrmHomeMecanica(){
        super();
        Vista.lblTitulo.setText(rb.getString("titulo4"));
        setPanel();
        setLeftPanel();
        setRightPanel();
    } 
        
    // Crea el panel de base
    public void setPanel() {
        JPanel panel1 = new JPanel();
        panel1.setBounds(15,30,770,530);
        panel1.setLayout(null);
        panel.add(panel1);
        // Creaci�n del splitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setBounds(0,0,770,550);     
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
        splitPane.setDividerLocation(0.25);
        panel1.add(splitPane); 
    }    
        
    // Crea el panel izquierdo
    public void setLeftPanel(){
        leftPanel.setBackground(COLOR_BACKGROUND_1);
        String listData[] = {rb.getString("buscarDuenio"),rb.getString("cargarServicio")};
        list = new JList(listData);
        list.setBackground(COLOR_BACKGROUND_1);
        list.setForeground(setTextColor(COLOR_BACKGROUND_1));
        list.setFont(Preferencias.FUENTE7);
        leftPanel.add(list);
    }

    // Armado lado derecho
    public void setRightPanel(){
        // Armado del panel
        rightPanel.setLayout(null);
        // Colocaci�n de T�tulo
        instruccion = new JLabel();
        instruccion.setText(rb.getString("opcion"));
        instruccion.setFont(Preferencias.FUENTE4);
        instruccion.setBounds(170,50,250,50);
        rightPanel.add(instruccion);
        // Etiquetas
        dato1 = new JLabel();
        dato1.setBackground(COLOR_BACKGROUND_2);
        dato1.setBounds(130,150,100,30);
        dato2 = new JLabel();
        dato2.setBackground(COLOR_BACKGROUND_2);
        dato2.setBounds(130,200,100,30);
        dato3 = new JLabel();
        dato3.setBackground(COLOR_BACKGROUND_2);
        dato3.setBounds(130,250,100,30);
        // Campos de texto
        txtDato1 = new JTextField();
        txtDato1.setBounds(250,150,200,30);
        txtDato1.setBorder(null);
        txtDato1.setBackground(COLOR_BACKGROUND_2);
        txtDato2 = new JTextField();
        txtDato2.setBounds(250,200,200,30);
        txtDato2.setBorder(null);
        txtDato2.setBackground(COLOR_BACKGROUND_2);
        txtDato3 = new JTextField();
        txtDato3.setBounds(250,250,200,30);
        txtDato3.setBorder(null);
        txtDato3.setBackground(COLOR_BACKGROUND_2);
        // Selector de Fecha
        jdcFecha = new JDateChooser();
        jdcFecha.setBounds(250,200,200,30);  
        // Bot�n
        btnEnviar = new JButton(rb.getString("cargar"));
        btnEnviar.setBounds(250,300,100,30);    
        btnEnviar.setVisible(false);
        // COLOCAR COMPONENTES EN EL PANEL
        rightPanel.add(dato1);
        rightPanel.add(dato2);
        rightPanel.add(dato3);
        rightPanel.add(txtDato1);
        rightPanel.add(txtDato3);
        rightPanel.add(btnEnviar);               
    }
     
    public static void limpiar(){
        txtDato1.setText("");
        txtDato2.setText("");
        txtDato3.setText("");
        dato1.setText("");
        dato2.setText("");
        dato3.setText("");
        jdcFecha.setDate(null);
        txtDato1.setBorder(null);
        txtDato2.setBorder(null);
        txtDato3.setBorder(null);
        txtDato1.setBackground(Preferencias.COLOR_BACKGROUND_2);
        txtDato2.setBackground(Preferencias.COLOR_BACKGROUND_2);
        txtDato3.setBackground(Preferencias.COLOR_BACKGROUND_2);
        rightPanel.remove(jdcFecha);
        btnEnviar.setVisible(false);
        instruccion.setText(rb.getString("opcion"));
    }
    
}