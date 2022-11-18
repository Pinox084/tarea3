package codigo;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Depocoin{

    private ArrayList<Moneda> monedero;
    private int t;
    private int X;
    private int Y;

    public Depocoin() {

        monedero = new ArrayList();
        t = 1000 + 200;
    }

   
    public void returncoin(Moneda coin){
        int aux = monedero.size();
        coin.setXY(X+(aux*10), Y);
        monedero.add(coin); //recibe una moneda ya creada
        
    }
    public Moneda getMoneda(){
        return monedero.get(monedero.size()-1);
    }
    public void newCoin(int i) {
        Moneda100 chaucha = new Moneda100(i);
        int aux = monedero.size();
        chaucha.setXY(X+(aux*10), Y);
        monedero.add(chaucha); //PARA MONEDAS DE CIEN DEL VUELTO
    }
    public Moneda getCoin() {
        if (monedero.size() == 0) {
            return null;
        }
        Moneda x = monedero.remove(monedero.size()-1);
        return x;
    }
    public void paint(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(X,Y,300,50);
        for(int i=0; i<monedero.size();i++){
           monedero.get(i).paint(g);
        }
    }
    public void setXY(int x, int y){
        X=x;
        Y=y;
    }


}

