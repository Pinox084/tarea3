
package codigo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlComprador extends JPanel {
    
    BotonComprador breco;
    BotonComprador binsert;
    BotonComprador bvuelto;
    BotonComprador bdar1000;
    BotonComprador bdar100;
    BotonComprador bdar500;
    public ControlComprador(){
        super();
        this.setBackground(Color.blue);
        breco = new BotonComprador("Recoger Botella");      
        binsert = new BotonComprador("Insertar Moneda");
        bvuelto = new BotonComprador("Recoger Vuelto");
        bdar1000 = new BotonComprador("Dar 1000");
        bdar500 = new BotonComprador("Dar 500");
        bdar100 = new BotonComprador("Dar 100");
        breco.setBounds(301,1,50,50);
        binsert.setBounds(301,61,50,50);
        bdar1000.setBounds(301, 101, 50, 50);
        bvuelto.setBounds(301, 151, 50, 50);
        bdar500.setBounds(301,201,50,50);
        bdar100.setBounds(301,251,50,50);
        bdar1000.setBackground(Color.LIGHT_GRAY);
        bdar500.setBackground(Color.yellow);
        bdar100.setBackground(Color.ORANGE);
        binsert.setBackground(Color.MAGENTA);
        bvuelto.setBackground(Color.LIGHT_GRAY);
        add(breco);
        add(binsert);
        add(bdar1000);
        add(bvuelto);
        add(bdar500);
        add(bdar100);
    }
    
}

class BotonComprador extends JButton implements ActionListener{
    
    private String name;
    public BotonComprador(String s){
        super(s);
        name = s;
        this.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Insertar Moneda" == name){
            PanelPrincipal.p.expo.insertMoneda(PanelPrincipal.p.cliente.darDinero());
        }
        if("Dar 1000" == name){
            PanelPrincipal.p.cliente.recibirCoin(1);           
        }
        if("Dar 500" == name){
            PanelPrincipal.p.cliente.recibirCoin(2);
        }
        if("Dar 100" == name){
            PanelPrincipal.p.cliente.recibirCoin(3);
        }
        if("Recoger Botella" == name){
            PanelPrincipal.p.cliente.recogerBebida(PanelPrincipal.p.expo.getBebida());
        }
        if("Recoger Vuelto" == name){
            PanelPrincipal.p.cliente.recogerVuelto(PanelPrincipal.p.expo.getVuelto());
        }
        PanelPrincipal.p.repaint();
    }
}
