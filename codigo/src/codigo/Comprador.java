package codigo;

public class Comprador {

    private int vuelto;
    private String sabor;
    private Depocoin bolsillo;
    private Deposito bolsa;
    private int t;

    public Comprador() {
        bolsillo = new Depocoin();
        bolsa = new Deposito();
        vuelto = 0;
        t = 1000 + 200;

    }

    public void recogerBebida(Bebida mia) {
        bolsa.addBebida(mia);
        if (mia != null) {
            System.out.println("Exito recoger bebida");
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

    public void recibirCoin() {
        t = t + 1;
        bolsillo.returncoin(new Moneda1000(t)); //regalar moneda a comprador
        System.out.println("success");

    }

    public String getSabor() {
        return sabor;
    }

    public int cuantoVuelto() {
        return vuelto;
    }
}
