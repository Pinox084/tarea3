package codigo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlBebida extends JPanel {

    
    BotonBebida bcoca;
    BotonBebida bsprite;
    BotonBebida bfanta;
    BotonBebida bmine;
    

    
    public ControlBebida() {
        super();
        this.setBackground(Color.yellow);
        bcoca = new BotonBebida("CocaCola");
        bsprite = new BotonBebida("Sprite");
        bfanta = new BotonBebida("Fanta");
        bmine = new BotonBebida("Mineral");
        bcoca.setBounds(1,1,50,50 );
        bsprite.setBounds(1,60,50,50);
        bfanta.setBounds(1, 101, 50, 50);
        bmine.setBounds(1, 151, 50, 50);
        add(bcoca);
        add(bsprite);
        add(bfanta);
        add(bmine);
    }

   

}

class BotonBebida extends JButton implements ActionListener{

    private String name;

    BotonBebida(String s) {

        super(s);
        name = s;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("CocaCola" == name) {
            try {
                PanelPrincipal.p.expo.comprarBebida(1);

            } catch (PagoIncorrectoException x) {
                System.out.println(x.getMessage());

            } catch (PagoInsuficienteException x) {
                System.out.println(x.getMessage());

            } catch (NoHayBebidaException x) {
                System.out.println(x.getMessage());

            }

        }
        if ("Fanta" == name) {
            try {
                PanelPrincipal.p.expo.comprarBebida(2);

            } catch (PagoIncorrectoException x) {
                System.out.println(x.getMessage());

            } catch (PagoInsuficienteException x) {
                System.out.println(x.getMessage());

            } catch (NoHayBebidaException x) {
                System.out.println(x.getMessage());

            }
        }
        if ("Sprite" == name) {
            try {
                PanelPrincipal.p.expo.comprarBebida(3);

            } catch (PagoIncorrectoException x) {
                System.out.println(x.getMessage());

            } catch (PagoInsuficienteException x) {
                System.out.println(x.getMessage());

            } catch (NoHayBebidaException x) {
                System.out.println(x.getMessage());

            }
        }
        if ("Mineral" == name) {
            try {
                PanelPrincipal.p.expo.comprarBebida(4);

            } catch (PagoIncorrectoException x) {
                System.out.println(x.getMessage());

            } catch (PagoInsuficienteException x) {
                System.out.println(x.getMessage());

            } catch (NoHayBebidaException x) {
                System.out.println(x.getMessage());

            }
        }

    }
}
