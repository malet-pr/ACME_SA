package vista;

import controlador.Controlador;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
 
public class FrmHomeAdministracion extends Vista { 
    // Para las opciones
    public String comboBoxItems[] = new String[9];
    public JPanel panel1;
    public JPanel panelCard,card0,card1,card2,card3,card4,card5,card6,card7,card8;
    public JComboBox cb;
    // Para las tarjetas
    public JButton btnRepetir;
    public JTextField txtServicios1, txtMonto1;
    public JTextField txtServicios2, txtMonto2;
    public JTextField txtServicios3, txtMonto3;
    public JTable tblClientes;
    private JLabel lblServicios;
    private JLabel lblMonto;
    public JLabel info2,info4;
    public JTable jtClientes;

    public FrmHomeAdministracion(){
        super();
        Vista.lblTitulo.setText(rb.getString("titulo3"));
        setCardStructure();
        setCard1();
        setCard2();
        setCard3();
        setCard4();
        setOtherCards();
        addCards();
    }
           
    public void setCardStructure(){
        panel1 = new JPanel();
        panel1.setBounds(15,50,770,500);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.PAGE_AXIS));
        panel.add(panel1);
        panelCard = new JPanel(new CardLayout());
        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(COLOR_BACKGROUND_1);     
        comboBoxItems[0] = rb.getString("TARJETA0");
        comboBoxItems[1] = "     " + rb.getString("TARJETA1");
        comboBoxItems[2] = "     " + rb.getString("TARJETA2");
        comboBoxItems[3] = "     " + rb.getString("TARJETA3");
        comboBoxItems[4] = "     " + rb.getString("TARJETA4");
        comboBoxItems[5] = "     " + rb.getString("TARJETA5");
        comboBoxItems[6] = "     " + rb.getString("TARJETA6");
        comboBoxItems[7] = "     " + rb.getString("TARJETA7");
        comboBoxItems[8] = "     " + rb.getString("TARJETA8");
        cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.setBackground(COLOR_BACKGROUND_4);
        cb.setForeground(setTextColor(COLOR_BACKGROUND_4));
        cb.setFont(Preferencias.FUENTE3);
        panelBoton.add(cb); 
        panel1.add(panelBoton);
        card0 = new JPanel(); 
    }
    
    public void addCards(){
        panelCard.add(card0, comboBoxItems[0]);
        panelCard.add(card1, comboBoxItems[1]);
        panelCard.add(card2, comboBoxItems[2]);
        panelCard.add(card3, comboBoxItems[3]);
        panelCard.add(card4, comboBoxItems[4]);
        panelCard.add(card5, comboBoxItems[5]);
        panelCard.add(card6, comboBoxItems[6]);
        panelCard.add(card7, comboBoxItems[7]);
        panelCard.add(card8, comboBoxItems[8]);
        panel1.add(panelCard);
    }

    public void setCard1(){
        card1 = new JPanel();
        card1.setLayout(null);
        JLabel lblTituloCard1 = new JLabel(rb.getString("serviciosMes"));
        lblTituloCard1.setSize(770,100);
        lblTituloCard1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCard1.setVerticalAlignment(SwingConstants.CENTER);
        lblTituloCard1.setFont(Preferencias.FUENTE4);
        card1.add(lblTituloCard1);
        lblServicios = new JLabel(rb.getString("cantidad"));
        lblServicios.setBounds(150,200,200,30);
        lblServicios.setFont(Preferencias.FUENTE5);
        lblServicios.setHorizontalAlignment(SwingConstants.TRAILING);
        lblMonto = new JLabel(rb.getString("monto"));
        lblMonto.setBounds(150,250,200,30);
        lblMonto.setFont(Preferencias.FUENTE5);
        lblMonto.setHorizontalAlignment(SwingConstants.TRAILING);
        txtServicios1 = new JTextField();
        txtServicios1.setBounds(360,200,150,30);
        txtServicios1.setFont(Preferencias.FUENTE5);
        txtServicios1.setEditable(false);
        txtMonto1 = new JTextField();
        txtMonto1.setBounds(360,250,150,30);
        txtMonto1.setFont(Preferencias.FUENTE5);
        txtMonto1.setEditable(false);
        card1.add(lblServicios);
        card1.add(lblMonto);
        card1.add(txtServicios1);
        card1.add(txtMonto1);
    }

    public void setCard2(){
        card2 = new JPanel();
        card2.setLayout(null);
        JLabel lblTituloCard2 = new JLabel(rb.getString("serviciosSemana"));
        lblTituloCard2.setSize(770,100);
        lblTituloCard2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCard2.setVerticalAlignment(SwingConstants.CENTER);
        lblTituloCard2.setFont(Preferencias.FUENTE4); 
        card2.add(lblTituloCard2);
        lblServicios = new JLabel(rb.getString("cantidad"));
        lblServicios.setBounds(150,200,200,30);
        lblServicios.setFont(Preferencias.FUENTE5);
        lblServicios.setHorizontalAlignment(SwingConstants.TRAILING);
        lblMonto = new JLabel(rb.getString("monto"));
        lblMonto.setBounds(150,250,200,30);
        lblMonto.setFont(Preferencias.FUENTE5);
        lblMonto.setHorizontalAlignment(SwingConstants.TRAILING);
        txtServicios2 = new JTextField();
        txtServicios2.setBounds(360,200,150,30);
        txtServicios2.setFont(Preferencias.FUENTE5);
        txtServicios2.setEditable(false);
        txtMonto2 = new JTextField();
        txtMonto2.setBounds(360,250,150,30);
        txtMonto2.setFont(Preferencias.FUENTE5);
        txtMonto2.setEditable(false);
        card2.add(lblServicios);
        card2.add(lblMonto);
        card2.add(txtServicios2);
        card2.add(txtMonto2);
    }

    public void setCard3(){
        card3 = new JPanel();
        card3.setLayout(null);
        JLabel lblTituloCard3 = new JLabel(rb.getString("serviciosFechas"));
        lblTituloCard3.setSize(770,100);
        lblTituloCard3.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCard3.setVerticalAlignment(SwingConstants.CENTER);
        lblTituloCard3.setFont(Preferencias.FUENTE4);
        card3.add(lblTituloCard3); 
        JLabel info1 = new JLabel(rb.getString("desde"));
        info1.setBounds(200,100,60,30);
        info1.setFont(Preferencias.FUENTE5);
        JLabel info3 = new JLabel(rb.getString("hasta"));
        info3.setBounds(380,100,50,30);
        info3.setFont(Preferencias.FUENTE5);
        info2 = new JLabel();
        info2.setBounds(260,100,130,30);
        info2.setFont(Preferencias.FUENTE5);
        info4 = new JLabel();
        info4.setBounds(430,100,130,30);
        info4.setFont(Preferencias.FUENTE5); 
        card3.add(info1);
        card3.add(info2);
        card3.add(info3);
        card3.add(info4);
        lblServicios = new JLabel(rb.getString("cantidad"));
        lblServicios.setBounds(150,200,200,30);
        lblServicios.setFont(Preferencias.FUENTE5);
        lblServicios.setHorizontalAlignment(SwingConstants.TRAILING);
        lblMonto = new JLabel(rb.getString("monto"));
        lblMonto.setBounds(150,250,200,30);
        lblMonto.setFont(Preferencias.FUENTE5);
        lblMonto.setHorizontalAlignment(SwingConstants.TRAILING);
        txtServicios3 = new JTextField();
        txtServicios3.setBounds(360,200,150,30);
        txtServicios3.setFont(Preferencias.FUENTE5);
        txtServicios3.setEditable(false);
        txtMonto3 = new JTextField();
        txtMonto3.setBounds(360,250,150,30);
        txtMonto3.setFont(Preferencias.FUENTE5);
        txtMonto3.setEditable(false);
        btnRepetir = new JButton(rb.getString("repetir1"));
        btnRepetir .setBounds(350,350,100,30);
        btnRepetir .setFont(Preferencias.FUENTE6);  
        btnRepetir .addActionListener((ActionEvent e) -> {
            cb.setSelectedIndex(0);
            cb.setSelectedIndex(3); 
        });
        card3.add(lblServicios);
        card3.add(lblMonto);
        card3.add(txtServicios3);
        card3.add(txtMonto3);
        card3.add(btnRepetir );
    }

    public void setCard4(){
        card4 = new JPanel();
        card4.setLayout(null);
        JLabel lblTituloCard4 = new JLabel(rb.getString("listado"));
        lblTituloCard4.setSize(770,100);
        lblTituloCard4.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCard4.setVerticalAlignment(SwingConstants.CENTER);
        lblTituloCard4.setFont(Preferencias.FUENTE4);
        card4.add(lblTituloCard4);
        jtClientes = new JTable(Controlador.modelo);
        jtClientes.setAutoCreateColumnsFromModel(false);
        jtClientes.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        jtClientes.getTableHeader().setFont(Preferencias.FUENTE5);
        TableColumnModel columnModel = jtClientes.getColumnModel();
        columnModel.getColumn(0).setMinWidth(150);
        columnModel.getColumn(1).setMinWidth(150);
        columnModel.getColumn(2).setMinWidth(250);
        columnModel.getColumn(3).setMinWidth(120);
        columnModel.getColumn(4).setPreferredWidth(250);
        jtClientes.getColumnModel().getColumn(0).setHeaderValue(rb.getString("apellido"));
        jtClientes.getColumnModel().getColumn(1).setHeaderValue(rb.getString("nombre"));
        jtClientes.getColumnModel().getColumn(2).setHeaderValue(rb.getString("direccion"));
        jtClientes.getColumnModel().getColumn(3).setHeaderValue(rb.getString("telefono"));
        jtClientes.getColumnModel().getColumn(4).setHeaderValue(rb.getString("mail"));
        jtClientes.setFillsViewportHeight(true); 
        JScrollPane scrollPane = new JScrollPane(jtClientes);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setAutoscrolls(true);
        scrollPane.setBounds(30,80,710,360);
        card4.add(scrollPane);
    }
          
    //Card "en construcc�n"
    // FALTAN LOS PROCEDIMIENTOS EN MYSQL Y LAS CORRESPONDIENTES CONSULTAS
    public void setOtherCards(){
        card5 = emptyCards(card5);
        card6 = emptyCards(card6);
        card7 = emptyCards(card7);
        card8 = emptyCards(card8);
    }
    
    public JPanel emptyCards(JPanel panel){
        panel = new JPanel();
        panel.setLayout(null);
        JLabel lblConstruccion = new JLabel(rb.getString("construccion"));
        lblConstruccion.setBounds(260,200,400,30);
        lblConstruccion.setFont(new Font("arial",1,30));
        panel.add(lblConstruccion);
        return panel;
    }
}
