package codigo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PanelPrincipal extends JFrame{
    
    public static PanelPrincipal p;
    public Expendedora expo;
    public Comprador cliente;
    private ControlBebida panel;
    private ControlComprador panel2;
    private JLabel expendedora;
    
    public PanelPrincipal(){
        super();
        p = this;
        ImageIcon img = new ImageIcon("expendedora.jpg");
        JLabel imagen = new JLabel();
        imagen.setBounds(180, 100, 300, 400);
        imagen.setIcon(new ImageIcon(img.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH)));
        expendedora = imagen;
        add(expendedora);
        this.setTitle("SIMULADOR EXPENDEDORA");
        expo = new Expendedora(5,500,600,600,500,250,250);
        cliente = new Comprador();
        panel = new ControlBebida();
        panel2 = new ControlComprador();
        panel.setBounds(0, 0, 150, 150);
        panel2.setBounds(840, 0, 150, 200);
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.CENTER);
        
        setLayout(null);
        setSize(1000,600); 
        setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    public void paint(Graphics g){
        super.paint(g);
        expo.paint(g);
        
    }
}
