package controlador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import vista.Preferencias;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 6/2019
 */

public class ImagenTextoComboBox extends JFrame{

    public ImageIcon rosa = new ImageIcon(new javax.swing.ImageIcon(getClass().
                getResource("/vista/imagenes/paletaRosa.png")).getImage().
                getScaledInstance(80, 30, Image.SCALE_SMOOTH));
    public ImageIcon verde = new ImageIcon(new javax.swing.ImageIcon(getClass().
                getResource("/vista/imagenes/paletaVerde.png")).getImage().
                getScaledInstance(80, 30, Image.SCALE_SMOOTH));
    public static Icon noIcon = new Preferencias.MyIcon(Color.WHITE);
    public static String tema;
    public JComboBox cbxTema;
    private String rosaS = vista.Vista.rb.getString("rosa");
    private String verdeS = vista.Vista.rb.getString("verde");
    private String mensaje = vista.Vista.rb.getString("elija");
    private String mensaje1 = vista.Vista.rb.getString("elija2");
    private String mensaje2 = vista.Vista.rb.getString("elija1");
    
    public ImagenTextoComboBox(){
        cbxTema = new JComboBox();
        cbxTema.setPreferredSize(new Dimension(150,30));
        cbxTema.setModel(populate());
        cbxTema.addActionListener((ActionEvent e) -> {
            tema = ((ImagenTexto) cbxTema.getSelectedItem()).getTexto();
        });
        cbxTema.setRenderer(new ImagenTextoRenderer());
    }
    
    public void getTema(){
        Object[] params = {mensaje2,cbxTema};
        JOptionPane.showConfirmDialog(null,params,mensaje1,JOptionPane.DEFAULT_OPTION);       
    }
    
    private DefaultComboBoxModel populate(){
        DefaultComboBoxModel dm = new DefaultComboBoxModel();
        dm.addElement(new ImagenTexto(mensaje,noIcon));
        dm.addElement(new ImagenTexto(rosaS,rosa));
        dm.addElement(new ImagenTexto(verdeS,verde));
        return dm;
    }
}

class ImagenTextoRenderer extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        ImagenTexto it = (ImagenTexto) value;
        setText(it.getTexto());
        setIcon(it.getImgagen()); 
        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());
        return this;
    }
}

class ImagenTexto {
    private Icon imgagen;
    private String texto;

    public ImagenTexto(String texto,Icon imgagen) {
        this.texto = texto;
        this.imgagen = imgagen;
    }

    public Icon getImgagen() {
        return imgagen;
    }

    public void setImgagen(Icon imgagen) {
        this.imgagen = imgagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
}


