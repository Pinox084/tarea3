package codigo;

import java.awt.Graphics;
import java.util.ArrayList;

public class Deposito {

    private ArrayList<Bebida> derp;
    private int X;
    private int Y;

    private int seriebebi;

    public Deposito() {

        derp = new ArrayList();
        seriebebi = 0;
    }

    public void addBebida(Bebida esta) {
        esta.setXY(X + ((derp.size()) * 10), Y);
        derp.add(esta);
        seriebebi++;
    }

    public void Restock(int caso) {
        

        switch (caso) {

            case 1:
                addBebida(new CocaCola(seriebebi));
                break;
                
            case 2:

                addBebida(new Fanta(seriebebi));
                break;

            case 3:

                addBebida(new Sprite(seriebebi));
                break;
            case 4:

                addBebida(new Mineral(seriebebi));
                break;
        }
        seriebebi++;

    }
    
    public int getSize(){
        return derp.size();
    }

    

    public Bebida getBebida() {
        if (derp.size() == 0) {
            return null;
        }
        Bebida b = derp.remove(derp.size() - 1);

        return b;
    }

    public void paint(Graphics g) {
        for (int i = 0; i < derp.size(); i++) {
            derp.get(i).paint(g);
        }

    }

    public void setXY(int x, int y) {

        X = x;
        Y = y;
    }
}
