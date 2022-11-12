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
    public void paint(Graphics g,int x, int y){
        g.setColor(Color.orange);
        g.fillRect(x+50,y,28,18);
    }
}

