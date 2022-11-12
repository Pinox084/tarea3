package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito {

    private ArrayList<Bebida> derp;

    public Deposito() {

        derp = new ArrayList();
    }

    public void addBebida(Bebida esta) {

        derp.add(esta);
    }

    public Bebida getBebida() {
        if (derp.size() == 0) {
            return null;
        }
        Bebida b = derp.remove(0);

        return b;
    }
    public void paint(Graphics g,int x, int y){
        for(int i=0; i<derp.size();i++){
           derp.get(i).paint(g,(i)+10, y);
        }
    }
}
