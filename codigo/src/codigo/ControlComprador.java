
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
    BotonComprador bdarMone;
    public ControlComprador(){
        super();
        this.setBackground(Color.blue);
        breco = new BotonComprador("Recoger Botella");      
        binsert = new BotonComprador("Insertar Moneda");
        bvuelto = new BotonComprador("Recoger Vuelto");
        bdarMone = new BotonComprador("Dar Moneda");
        breco.setBounds(301,1,50,50);
        binsert.setBounds(301,61,50,50);
        bdarMone.setBounds(301, 101, 50, 50);
        bvuelto.setBounds(301, 151, 50, 50);
        add(breco);
        add(binsert);
        add(bdarMone);
        add(bvuelto);
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
        if("Dar Moneda" == name){
            PanelPrincipal.p.cliente.recibirCoin();
        }
        if("Recoger Botella" == name){
            PanelPrincipal.p.cliente.recogerBebida(PanelPrincipal.p.expo.getBebida());
        }
        if("Recoger Vuelto" == name){
            PanelPrincipal.p.cliente.recogerVuelto(PanelPrincipal.p.expo.getVuelto());
        }
    }
}
