package codigo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
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
        expo = new Expendedora(5,1000,500,600,100,250,250);
        cliente = new Comprador();
        ImageIcon img2 = new ImageIcon("pooh.jpg");
        JLabel pooh = new JLabel();
        pooh.setBounds(500, 200, 200, 300);
        pooh.setIcon(new ImageIcon(img2.getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH)));
        add(pooh);
        panel = new ControlBebida();
        panel2 = new ControlComprador();
        panel.setBounds(0, 0, 150, 150);
        panel2.setBounds(840, 0, 150, 250);
        add(panel, BorderLayout.CENTER);
        add(panel2, BorderLayout.CENTER);
        setLayout(null);
        setBackground(Color.white);
        setSize(1000,800); 
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    public void paint(Graphics g){
        
        super.paint(g);
        cliente.paint(g);
        expo.paint(g);
        
    }
}
