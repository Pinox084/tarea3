package codigo;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

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
    public Moneda getMoneda(){
        return monedero.get(monedero.size()-1);
    }
    public void newCoin(int i) {
        monedero.add(new Moneda100(i)); //PARA MONEDAS DE CIEN DEL VUELTO
    }
    public Moneda getCoin() {
        if (monedero.size() == 0) {
            return null;
        }
        Moneda x = monedero.remove(monedero.size()-1);
        return x;
    }
    public void paint(Graphics g,int x, int y){
        g.setColor(Color.darkGray);
        g.fillRect(x,y,300,50);
        for(int i=0; i<monedero.size();i++){
           monedero.get(i).paint(g,x+(i*10), y);
        }
    }

}

