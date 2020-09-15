package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

/**
 * @author Nuria Malet
 * @version 1.0
 * @since 6/2019
 */

public class Preferencias {
    public static Color COLOR_BACKGROUND_1;
    public static Color COLOR_BACKGROUND_2;    
    public static Color COLOR_BACKGROUND_3;  
    public static Color COLOR_BACKGROUND_4; 
    
    public static Font FUENTE1,FUENTE2,FUENTE3,FUENTE4,FUENTE5,FUENTE6,FUENTE7;
    
    public static void preferencias(String opcion,String idioma){
        setFonts(opcion);
        setColors(opcion);
        setDefaultColors(opcion);
        setOptionPaneColor(opcion);
        setOptionPaneLanguaje(idioma);
    }
    
    public static void setFonts(String opcion){
	if(opcion.equals("rosa")) {
            FUENTE1 = new Font("Helvetica",3,22);
            FUENTE2 = new Font("Helvetica",1,18);
            FUENTE3 = new Font("Helvetica",4,15);
            FUENTE4 = new Font("Helvetica",1,20);
            FUENTE5 = new Font("Helvetica",1,15);
            FUENTE6 = new Font("Helvetica",3,12);
            FUENTE7 = new Font("Helvetica",3,15);
        } else if(opcion.equals("verde")) {
            FUENTE1 = new Font("Serif",3,22);
            FUENTE2 = new Font("Serif",1,18);
            FUENTE3 = new Font("Serif",4,15);
            FUENTE4 = new Font("Serif",1,20);
            FUENTE5 = new Font("Serif",1,15);
            FUENTE6 = new Font("Serif",3,12);   
            FUENTE7 = new Font("Serif",3,15);
        }        
    }
    
    public static void setColors(String opcion) {
	if(opcion.equals("rosa")) {
            COLOR_BACKGROUND_1 = Color.DARK_GRAY;
            COLOR_BACKGROUND_2 = Color.PINK;    
            COLOR_BACKGROUND_3 = Color.LIGHT_GRAY;  
            COLOR_BACKGROUND_4 = Color.GRAY; 
        } else if(opcion.equals("verde")) {
            COLOR_BACKGROUND_4 = new Color(200,40,0);
            COLOR_BACKGROUND_2 = new Color(128,255,0);    		
            COLOR_BACKGROUND_3 = new Color(160,60,0);  		
            COLOR_BACKGROUND_1 = new Color(120,20,0); 	
        }
    }
    
    public static Icon quitar = new MyIcon(COLOR_BACKGROUND_2);
    
    public static void setDefaultColors(String opcion) {
        UIManager.put("Panel.background",COLOR_BACKGROUND_2);
        UIManager.put("CheckBox.background",COLOR_BACKGROUND_2);
        UIManager.put("CheckBox.foreground",setTextColor(COLOR_BACKGROUND_2));
        UIManager.put("Label.foreground",setTextColor(COLOR_BACKGROUND_2));
        UIManager.put("ToggleButton.background", COLOR_BACKGROUND_4);
        UIManager.put("ToggleButton.foreground", setTextColor(COLOR_BACKGROUND_4));
        UIManager.put("Button.background", COLOR_BACKGROUND_4);
        UIManager.put("Button.foreground", setTextColor(COLOR_BACKGROUND_4)); 
        UIManager.put("TableHeader.background",COLOR_BACKGROUND_4);
        UIManager.put("TableHeader.foreground",setTextColor(COLOR_BACKGROUND_4));
        UIManager.put("ScrollBar.background",COLOR_BACKGROUND_3);
        UIManager.put("ScrollBar.foreground",setTextColor(COLOR_BACKGROUND_3));
    }
    
    public static void setOptionPaneColor(String opcion){
        JDialog.setDefaultLookAndFeelDecorated(false); 
        UIManager.put("OptionPane.Background", COLOR_BACKGROUND_2);
        UIManager.put("OptionPane.MessageBackground", COLOR_BACKGROUND_2);
        UIManager.put("OptionPane.border", new LineBorder(COLOR_BACKGROUND_1,4));
        UIManager.put("OptionPane.Font",FUENTE6);
        UIManager.put("OptionPane.messageForeground", setTextColor(COLOR_BACKGROUND_2));
        UIManager.put("OptionPane.questionIcon",quitar);
        UIManager.put("OptionPane.informationIcon",quitar);
        UIManager.put("OptionPane.errorIcon",quitar);
        UIManager.put("OptionPane.warningIcon",quitar);      
    }
    
    public static Color setTextColor(Color color){
        int y = color.getRed() + color.getGreen() + color.getBlue();
        if(y < 300){
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }
    
    public static void setOptionPaneLanguaje(String idioma){
        if(idioma.equals("español")){
            UIManager.put("OptionPane.yesButtonText","Si");
            UIManager.put("OptionPane.noButtonText","No");
            UIManager.put("OptionPane.cancelButtonText","Cancelar");
            UIManager.put("OptionPane.okButtonText","Aceptar"); 
        } 
        if(idioma.equals("inglés")){
            UIManager.put("OptionPane.yesButtonText","Yes");
            UIManager.put("OptionPane.noButtonText","No");
            UIManager.put("OptionPane.cancelButtonText","Cancel");
            UIManager.put("OptionPane.okButtonText","OK"); 
        }
    }
    
    public static class MyIcon implements Icon {
        Color myColor;

        public MyIcon(Color myColor) {
          this.myColor = myColor;
        }

        public int getIconWidth() {
          return 1;
        }

        public int getIconHeight() {
          return 1;
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
          g.setColor(myColor);
          g.drawRect(0, 0, 1, 1);
        }
    }
}


