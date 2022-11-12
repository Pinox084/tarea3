package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Expendedora extends JFrame {

    private Deposito Coca;
    private Deposito Spritex;
    private Deposito Mine;
    private Deposito Fantax;
    private Depocoin caja;
    private Depocoin caja2;
    private Bebida repo;
    private Moneda insert;

    private int precioCoca;
    private int precioSprite;
    private int precioMine;
    private int precioFanta;
    private int posX;
    private int posY;
    private JButton bCoca;
    private int serievuelto;

    public Expendedora(int cantidad, int precioCoca, int precioFanta, int precioSprite, int precioMineral) {

        Coca = new Deposito();
        Spritex = new Deposito();
        Mine = new Deposito();
        Fantax = new Deposito();
        caja = new Depocoin();
        caja2 = new Depocoin();

        for (int i = 0; i < cantidad; i++) {
            Coca.addBebida(new CocaCola(i));
        }
        for (int i = 0; i < cantidad; i++) {
            Spritex.addBebida(new Sprite(i));
        }
        for (int i = 0; i < cantidad; i++) {
            Mine.addBebida(new Mineral(i));
        }
        for (int i = 0; i < cantidad; i++) {
            Fantax.addBebida(new Fanta(i));
        }
        this.precioCoca = precioCoca;
        this.precioFanta = precioFanta;
        this.precioSprite = precioSprite;
        this.precioMine = precioMineral;
        serievuelto = 0;

    }

    public void insertMoneda(Moneda coin) {
        insert = coin;
        if (insert != null) {
            System.out.println("Exito regalo");
        }
    }

    public void comprarBebida(int seleccion) throws PagoInsuficienteException, PagoIncorrectoException, NoHayBebidaException {

        switch (seleccion) {

            default:
                caja2.returncoin(insert);
                insert = null;
                throw new NoHayBebidaException("Seleccion Incorrecta");
            case 1:

                if (checkPrice(insert, precioCoca) == true) {
                    repo = Coca.getBebida();
                    if (repo == null) {
                        caja2.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    System.out.println("Coca comprada");
                    llenarVuelto(insert, precioCoca);
                    caja.returncoin(insert);
                    insert = null;
                    break;
                }

            case 2:
                if (checkPrice(insert, precioFanta) == true) {
                    repo = Fantax.getBebida();
                    if (repo == null) {
                        
                        caja2.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    System.out.println("Fanta comprada");
                    llenarVuelto(insert, precioFanta);
                    caja.returncoin(insert);
                    insert = null;
                    break;
                }

            case 3:
                if (checkPrice(insert, precioSprite) == true) {
                    repo = Spritex.getBebida();
                    
                    if (repo == null) {
                        caja2.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    
                    llenarVuelto(insert, precioSprite);
                    System.out.println("Sprite comprada");
                    caja.returncoin(insert);
                    insert = null;
                    break;
                }

            case 4:
                if (checkPrice(insert, precioMine) == true) {
                    repo = Mine.getBebida();
                    
                    if (repo == null) {
                        caja2.returncoin(caja.getCoin());
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    
                    llenarVuelto(insert, precioMine);
                    System.out.println("Mineral comprada");
                    caja.returncoin(insert);
                    insert = null;
                    break;
                }

        }

    }

    public Bebida getBebida() {
        Bebida aux = repo;
        repo = null;
        return aux;
    }

    public boolean checkPrice(Moneda coin, int precio) throws PagoInsuficienteException, PagoIncorrectoException {

        if (coin == null) {
            throw new PagoIncorrectoException("Moneda no Ingresada");
        }
        if (coin.getValor() >= precio) {
            
            return true;
            
        } else {
            System.out.println("y");
            caja2.returncoin(coin);
            throw new PagoInsuficienteException("Pago Insuficiente");
        }

    }

    public void llenarVuelto(Moneda coin, int eleccion) {

        int p = coin.getValor() - eleccion;
        System.out.println(p);
        p = p / 100;
        
        for (int i = 0; i < p; i++) {
            caja2.newCoin(serievuelto + 100);
            serievuelto++;
            System.out.println("vuelto generado X" +i);
        }
        
    }

    public Moneda getVuelto() {
        Moneda x = caja2.getCoin();
        return x;
    }
     public void paint(Graphics g, int x, int y) {
        Coca.paint(g,x,y);
        Fantax.paint(g,x+10,y);
        Spritex.paint(g,x,y+50);
        Mine.paint(g,x+10,y+50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
