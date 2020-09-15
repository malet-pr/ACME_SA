package vista;

import javax.swing.*;

public class FrmHomePersonal extends Vista {

    private JTabbedPane pestanias;

    public FrmHomePersonal(){
        super();
        Vista.lblTitulo.setText(rb.getString("titulo1"));
        setTabbedPane();
        setPaneles();
    }
    
    // Creación de un conjunto de pestañas
    public void setTabbedPane(){   
        UIManager.put("TabbedPane.selected", COLOR_BACKGROUND_1);
        pestanias = new JTabbedPane();
        pestanias.setBounds(15, 30, 770, 520);
        pestanias.setBackground(COLOR_BACKGROUND_4);
        pestanias.setForeground(setTextColor(pestanias.getBackground())); 
        panel.add(pestanias);
    }
 
    public void setPaneles(){
        // Panel1
        JPanel panel1 = new JPanel();
        panel1.setBackground(COLOR_BACKGROUND_2);
        JLabel et_p1 = new JLabel(rb.getString("construccion"));
        panel1.add(et_p1);
        pestanias.addTab(rb.getString("v1"), panel1); 
        // Panel2
        JPanel panel2 = new JPanel();
        panel2.setBackground(COLOR_BACKGROUND_2);
        JLabel et_p2 = new JLabel(rb.getString("construccion"));
        panel2.add(et_p2);
        pestanias.addTab(rb.getString("v1"), panel2);
    }

}