package vista;

import controlador.Controlador;
import controlador.ImagenTextoComboBox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JSeparator;

public abstract class Vista extends JFrame implements ActionListener, MouseListener {
    // Para las preferencias;  
    protected Color COLOR_BACKGROUND_1 = Preferencias.COLOR_BACKGROUND_1;
    protected Color COLOR_BACKGROUND_2 = Preferencias.COLOR_BACKGROUND_2;
    protected Color COLOR_BACKGROUND_3 = Preferencias.COLOR_BACKGROUND_3;
    protected Color COLOR_BACKGROUND_4 = Preferencias.COLOR_BACKGROUND_4;
    protected Color COLOR_FOREGROUND;
    // Para la ventana
    protected JPanel panel;
    protected JMenuBar mb;
    protected JMenu menu;
    protected JMenuItem mi1,mi2,mi3;
    public static JLabel lblNombre;
    public static JLabel lblTitulo;

    // Para el idioma
    protected JLabel lblIngles, lblEspanol;
    protected Locale locale;
    public static ResourceBundle rb;
    
    public Vista(){
        setLocale();
        setVentana();
        setIcons();
        setTitulo();
        setMenu();
    }
    
    public void setLocale(){
        if(Controlador.user.getIdioma().equals("español")){
            locale = Locale.forLanguageTag("es-ES");
        }
        if(Controlador.user.getIdioma().equals("inglés")){
            locale = Locale.forLanguageTag("en-EN");
        }  
        rb = ResourceBundle.getBundle("vista/recursos/RecursoIdioma", locale);
    }
          
    public void setVentana(){
        setUndecorated(true);
        this.setResizable(false);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(800, 600);
        int x = screenSize.width/2 - 400; 
        int y = screenSize.height/2 - 300;
        setLocation(x,y);
        setVisible(true);
        this.setBackground(COLOR_BACKGROUND_3);
        panel = new JPanel();
        panel.setBackground(COLOR_BACKGROUND_3);
        panel.setLayout(null);
        getContentPane().add(panel);
    }   
                     
    public void setTitulo(){
        lblTitulo = new JLabel();
        lblTitulo.setBounds(200,0,280,30);
        lblTitulo.setFont(Preferencias.FUENTE1);
        lblTitulo.setBackground(COLOR_BACKGROUND_3);
        lblTitulo.setForeground(setTextColor(COLOR_BACKGROUND_3));
        panel.add(lblTitulo);
        lblNombre = new JLabel();
        lblNombre.setBounds(470,0,270,30);
        lblNombre.setFont(Preferencias.FUENTE1);
        lblNombre.setBackground(COLOR_BACKGROUND_3);
        lblNombre.setForeground(setTextColor(COLOR_BACKGROUND_3));
        panel.add(lblNombre);
    }
    
    public void setIcons() { 
        lblIngles = new JLabel();       
        lblIngles.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().
                getResource("/vista/imagenes/usFlag.png")).getImage().
                getScaledInstance(30, 20, Image.SCALE_SMOOTH)));
        lblIngles.setBounds(720,0,30,30);
        lblIngles.addMouseListener(this);
        lblEspanol = new JLabel();       
        lblEspanol.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().
                getResource("/vista/imagenes/argFlag.png")).getImage().
                getScaledInstance(30, 20, Image.SCALE_SMOOTH)));   
        lblEspanol.setBounds(760,0,30,30);
        lblEspanol.addMouseListener(this);
        panel.add(lblIngles);
        panel.add(lblEspanol);
    }    
    
    public void setMenu(){
        mb = new JMenuBar();
        setJMenuBar(mb);
        mb.setBackground(COLOR_BACKGROUND_3);
        menu = new JMenu(rb.getString("ajustes"));
        menu.setFont(Preferencias.FUENTE2);
        menu.setForeground(setTextColor(COLOR_BACKGROUND_3));
        mb.add(menu);
        mi1=new JMenuItem(rb.getString("contraseña"));
        mi1.setFont(Preferencias.FUENTE3);
        mi1.setBackground(COLOR_BACKGROUND_4);
        mi1.setForeground(setTextColor(COLOR_BACKGROUND_4));
        mi1.addActionListener(this);
        menu.add(mi1);
        mi2=new JMenuItem(rb.getString("cambiar"));
        mi2.setFont(Preferencias.FUENTE3);
        mi2.setBackground(COLOR_BACKGROUND_4);
        mi2.setForeground(setTextColor(COLOR_BACKGROUND_4));
        mi2.addActionListener(this);
        menu.add(mi2);
        menu.add(new JSeparator());
        mi3=new JMenuItem(rb.getString("salir"));
        mi3.setFont(Preferencias.FUENTE3);
        mi3.setBackground(COLOR_BACKGROUND_4);
        mi3.setForeground(setTextColor(COLOR_BACKGROUND_4));
        mi3.addActionListener(this);     
        menu.add(mi3); 
        panel.add(mb);  
    }
    
    public Color setTextColor(Color color){
        int y = color.getRed() + color.getGreen() + color.getBlue();
        if(y < 390){
            return COLOR_FOREGROUND = Color.WHITE;
        } else {
            return COLOR_FOREGROUND = Color.BLACK;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== mi1) {
            Controlador.cambiarClave();
        }
        if (e.getSource()== mi2) {
            Controlador.cambiarMotivo();
            if(ImagenTextoComboBox.tema == null) {
                JOptionPane.showMessageDialog(null,rb.getString("elegir"));
            } else {
                dispose();
            }    
        }
        if (e.getSource()== mi3) {
            Controlador.logOut();
            dispose();
        }                
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == lblIngles){
            Controlador.cambiarIdioma("inglés");
            dispose();
        }
        if(e.getSource() == lblEspanol){
            Controlador.cambiarIdioma("español");
            dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
 
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {       
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
