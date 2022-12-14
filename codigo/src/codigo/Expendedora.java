package codigo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

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
    private int limite;

    public Expendedora(int cantidad, int precioCoca, int precioFanta, int precioSprite, int precioMineral, int x, int y) {
        limite = cantidad;
        Coca = new Deposito();
        Spritex = new Deposito();
        Mine = new Deposito();
        Fantax = new Deposito();
        caja = new Depocoin();
        caja2 = new Depocoin();
        Coca.setXY(x, y);
        Spritex.setXY(x, y + 100);
        Mine.setXY(x, y + 150);
        Fantax.setXY(x, y + 50);
        caja2.setXY(190, 540);
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
                    repo = (CocaCola) Coca.getBebida();

                    if (repo == null) {
                        caja2.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    System.out.println("Coca comprada");
                    llenarVuelto(insert, precioCoca);
                    caja.returncoin(insert);
                    insert = null;
                    repo.setXY(300, 470);

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
                    repo.setXY(300, 470);
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
                    repo.setXY(300, 470);
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
                    repo.setXY(300, 470);
                    break;
                }

        }

    }

    public Bebida getBebida() {
        Bebida aux = repo;
        repo = null;
        return aux;
    }

    public void RellenarStock() {
        if(Coca.getSize() != limite){
            Coca.Restock(1);
        }
        if(Fantax.getSize() != limite){
            Fantax.Restock(2);
        }
        if(Spritex.getSize() != limite){
            Spritex.Restock(3);
        }
        if(Mine.getSize() != limite){
            Mine.Restock(4);
        }
        
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
            System.out.println("vuelto generado X" + i);
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
        caja2.paint(g);
        Bebida aux = repo;

        if (repo != null) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(236, 468, 132, 30);
            repo.paint(g);

        }

        g.setColor(Color.green);
        g.fillRect(150,250,50,25);
        g.setColor(Color.black);
        g.drawString(""+precioCoca, 150, 260);
        g.setColor(Color.green);
        g.fillRect(150,300,50,25);
        g.setColor(Color.black);
        g.drawString(""+precioFanta, 150, 310);
        g.setColor(Color.green);
        g.fillRect(150,350,50,25);
        g.setColor(Color.black);
        g.drawString(""+precioSprite, 150, 360);
        g.setColor(Color.green);
        g.fillRect(150,400,50,25);
        g.setColor(Color.black);
        g.drawString(""+precioMine, 150, 410);
    }
}
