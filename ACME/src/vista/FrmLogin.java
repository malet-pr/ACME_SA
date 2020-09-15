package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 5/2019
 */

public class FrmLogin extends JFrame {

    private JPanel panel;
    private JLabel lblUserName;
    private JLabel lblPassword;
    public static JPasswordField txtPassword;
    public static JTextField txtUserName;
    public JButton btnLogIn; 
     
    public FrmLogin() {
        initComponents();
    }
    
    private void initComponents() {
        setVentana();
        setPanel();
        setComponents();
    }
      
    private void setVentana() {
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(500, 400);
        int x = screenSize.width/2 - 200; 
        int y = screenSize.height/2 - 150;
        this.setLocation(x,y);
        this.setTitle("LOG IN");
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
    }
    
    private void setPanel() {
        panel = new JPanel();  
        panel.setBounds(12, 15, 470, 340);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    
    private void setComponents() {
        
        lblUserName = new JLabel("Usuario: ");
        lblUserName.setBounds(50, 60, 130, 30);
        lblUserName.setOpaque(false);
        lblUserName.setFont(new Font("Helvetica",3,20));
        panel.add(lblUserName);
        
        txtUserName = new JTextField("");
        txtUserName.setBounds(180, 60, 215, 30);
        txtUserName.setOpaque(true);
        txtUserName.setFont(new Font("Helvetica",4,18));
        panel.add(txtUserName);
        
        lblPassword = new JLabel("Contraseña: ");
        lblPassword.setBounds(50, 120, 130, 30);
        lblPassword.setOpaque(false);
        lblPassword.setFont(new Font("Helvetica",3,20));
        panel.add(lblPassword);
        
        txtPassword = new JPasswordField("");
        txtPassword.setBounds(180, 120, 215, 30);
        txtPassword.setOpaque(true);
        txtPassword.setEchoChar('*');
        txtPassword.setFont(new Font("Helvetica",4,18));
        panel.add(txtPassword);        
        
        btnLogIn = new JButton("Log In"); 
        btnLogIn.setBounds(190, 240, 100,40);
        btnLogIn.setBackground(Color.DARK_GRAY);
        btnLogIn.setForeground(Color.WHITE);
        btnLogIn.setFont(new Font("arial",3,20));
        panel.add(btnLogIn);
        
        JCheckBox ver = new JCheckBox("Ver Contraseña"); 
        ver.setBounds(180,160,150,20);
        ver.setBackground(Color.PINK);
        ver.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {                    
                    txtPassword.setEchoChar((char) 0);
                } else {
                    txtPassword.setEchoChar('*');
                }                
            }
        });
        panel.add(ver); 
    }
         
}
