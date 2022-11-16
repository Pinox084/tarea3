package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
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
    private int serievuelto;
    private int X;
    private int Y;
    

    public Expendedora(int cantidad, int precioCoca, int precioFanta, int precioSprite, int precioMineral, int x, int y) {

        Coca = new Deposito();
        Spritex = new Deposito();
        Mine = new Deposito();
        Fantax = new Deposito();
        caja = new Depocoin();
        caja2 = new Depocoin();

        for (int i = 0; i < cantidad; i++) { 
            Coca.addBebida(new CocaCola(i));
            Coca.setXY(x,y);
            
        }
        for (int i = 0; i < cantidad; i++) {
            Spritex.addBebida(new Sprite(i));
            Spritex.setXY(x, y+100);
            
        }
        for (int i = 0; i < cantidad; i++) {
            Mine.addBebida(new Mineral(i));
            Mine.setXY(x, y+150);
        }
        for (int i = 0; i < cantidad; i++) {
            Fantax.addBebida(new Fanta(i));
            Fantax.setXY(x, y+50);
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
                    repo = (CocaCola) Coca.getBebida();

                    if (repo == null) {
                        caja2.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    System.out.println("Coca comprada");
                    llenarVuelto(insert, precioCoca);
                    caja.returncoin(insert);
                    insert = null;
                    repo.setXY(700,500);
                    
                    break;
                }

            case 2:
                if (checkPrice(insert, precioFanta) == true) {
                    repo = (Fanta) Fantax.getBebida();
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
                    repo = (Sprite) Spritex.getBebida();
                    
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
                    repo = (Mineral) Mine.getBebida();
                    
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
        repaint();
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
     public void paint(Graphics g) {
        
        Coca.paint(g);
        Fantax.paint(g);
        Spritex.paint(g);
        Mine.paint(g);
        
        Bebida aux = repo;
        
        if( repo != null){
            System.out.println("Mensaje" + repo.getXY());
            repo.paint(g);
            
        }
        System.out.println("Estoy aqui 1");
        
        //caja2.paint(g, x+10, y+600);
        
        
    }
}
