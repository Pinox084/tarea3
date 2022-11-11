package codigo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlBebida extends JPanel {

    int selection;
    BotonBebida bcoca;
    BotonBebida bsprite;
    BotonBebida bfanta;
    BotonBebida bmine;
    BotonBebida breco;

    public ControlBebida() {
        super();
        this.setBackground(Color.yellow);
        selection = 0;
        bcoca = new BotonBebida("CocaCola");
        bcoca.setBounds(1,1,50,50 );
        add(bcoca);
        bsprite = new BotonBebida("Sprite");
        bfanta = new BotonBebida("Fanta");
        bmine = new BotonBebida("Mineral");

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
