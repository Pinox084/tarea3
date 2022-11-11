package codigo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelPrincipal extends JFrame{
    
    public static PanelPrincipal p;
    public Expendedora expo;
    public Comprador cliente;
    private ControlBebida panel;
    
    public PanelPrincipal(){
        super();
        p = this;
        this.setTitle("SIMULADOR EXPENDEDORA");
        
        panel = new ControlBebida();
        add(panel, BorderLayout.CENTER);
        panel.setBounds(0, 0, 200, 300);
        
        setLayout(null);
        setSize(800,600); 
        setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        expo = new Expendedora(5,800,600,600,500);
        /*cliente = new Comprador();*/
    }
    
    
}
