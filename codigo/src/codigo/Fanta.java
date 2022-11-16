package codigo;

import java.awt.Color;
import java.awt.Graphics;


public class Fanta extends Bebida{
    public Fanta(int serie){
        super(serie);
    }
    @Override
    public String beber(){
        return super.beber()+"fanta";
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.orange);
        g.fillRect(X,Y,7,18);
        
    }
    public void setXY(int x, int y){        
        X = x;
        Y = y;
        
    }
}

