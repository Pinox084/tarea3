package codigo;

import java.awt.Color;
import java.awt.Graphics;

public class Moneda1000 extends Moneda{
    public Moneda1000(int serie){
        super(serie);
    }
    @Override
    public int getValor(){
        return super.getValor()+1000;
    }
    @Override
    public void paint(Graphics g,int x, int y){
        g.setColor(Color.black);
        g.fillOval(x,y,50,50);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(x,y,48,48);
        g.setColor(Color.black);
        g.drawString(""+this.getValor(), x+10, y+20);
    }
}
