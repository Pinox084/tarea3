package codigo;

import java.util.ArrayList;

public class Depocoin{

    private ArrayList<Moneda> monedero;
    private int t;

    public Depocoin() {

        monedero = new ArrayList();
        t = 1000 + 200;
    }

   
    public void returncoin(Moneda coin){
        monedero.add(coin); //recibe una moneda ya creada
    }
    public void newCoin(int i) {
       
        monedero.add(new Moneda100(i)); //generar vuelto
       
    }
   
    public Moneda getCoin() {
        if (monedero.size() == 0) {
            return null;
        }
        Moneda x = monedero.remove(monedero.size()-1); //retornar ultima moneda
       
        return x;
    }
    
    public int darTamaño(){
        return monedero.size();
    }

}

