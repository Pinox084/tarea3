package codigo;

import java.awt.Color;
import java.awt.Graphics;

public class Moneda500 extends Moneda{
    public Moneda500(int serie){
        super(serie);
    }
    @Override
    public int getValor(){
        return super.getValor()+500;
    }
    @Override
    public void paint(Graphics g,int x, int y){
        g.setColor(Color.black);
        g.fillOval(x,y,50,50);
        g.setColor(Color.yellow);
        g.fillOval(x,y,48,48);
        g.setColor(Color.black);
        g.drawString(""+this.getValor(), x+10, y+20);
    }
}
