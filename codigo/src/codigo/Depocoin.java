package codigo;

import java.util.ArrayList;

public class Depocoin{

    private ArrayList<Moneda> monedero;

    public Depocoin() {

        monedero = new ArrayList();
    }

   
    public void returncoin(Moneda coin){
        monedero.add(coin);
    }
    public void newCoin() {
       
        monedero.add(new Moneda100());
       
    }
   
    public Moneda getCoin() {
        if (monedero.size() == 0) {
            return null;
        }
        Moneda x = monedero.remove(0);
       
        return x;
    }

}
