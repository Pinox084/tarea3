package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito {

    private ArrayList<Bebida> derp;
    private int X;
    private int Y;
    private int n;

    public Deposito() {

        derp = new ArrayList();
        
    }

    public void addBebida(Bebida esta) {
        esta.setXY(X+((derp.size())*10),Y);
        derp.add(esta);
        
    }

    public Bebida getBebida() {
        if (derp.size() == 0) {
            return null;
        }
        Bebida b = derp.remove(derp.size()-1);

        return b;
    }
    public void paint(Graphics g){
        for(int i=0; i<derp.size();i++){    
           derp.get(i).paint(g);
        }
        
    }
    public void setXY(int x, int y){
        
        X = x;
        Y = y;
    }
}
