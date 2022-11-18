package codigo;

import java.awt.Graphics;

public class Comprador {
    private Depocoin bolsillo;
    private Deposito bolsa;
    private int t;

    public Comprador() {
        bolsillo = new Depocoin();
        bolsa = new Deposito();
        bolsa.setXY(600, 200);
        bolsillo.setXY(720,500);
        t = 1000 + 200;

    }

    public void recogerBebida(Bebida mia) {
        
        if (mia != null) {
            System.out.println("Exito recoger bebida");
            mia.setXY(600, 500);
            bolsa.addBebida(mia);
        } else {
            System.out.println("No Hay Bebida");
        }
    }

    public Moneda darDinero() {
        return bolsillo.getCoin(); //inserta moneda
    }

    public void recogerVuelto(Moneda coin) {
        if (coin != null) {
            bolsillo.returncoin(coin);
            System.out.println(coin.getSerie() + "Moneda recogida");
        }

    }

    public void recibirCoin(int n) {
        t = t + 1;
        switch(n){
                case 1:
                    bolsillo.returncoin(new Moneda1000(t)); //regalar moneda a comprador
                    System.out.println("success 1000");
                    break;
                    
                case 2:
                    bolsillo.returncoin(new Moneda500(t)); //regalar moneda a comprador
                    System.out.println("success 500");
                    break;
                case 3:
                    bolsillo.returncoin(new Moneda100(t)); //regalar moneda a comprador
                    System.out.println("success 100");
                    break;
        }
    }

    public void getSabor() {
        if(bolsa.getSize() != 0){
            Bebida aux = tomarBebida();
            String frase = aux.beber();
            System.out.println(frase);
            aux = null;
        }
        
    }
    public Bebida tomarBebida(){
       
        return bolsa.getBebida();
    }


    
    public void paint(Graphics g){
        bolsillo.paint(g);
        bolsa.paint(g);
    }
}
