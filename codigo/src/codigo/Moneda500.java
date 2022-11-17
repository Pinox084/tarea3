package codigo;

import java.awt.Color;
import java.awt.Graphics;

public class Moneda500 extends Moneda{
    private int X;
    private int Y;
    public Moneda500(int serie){
        super(serie);
    }
    @Override
    public int getValor(){
        return super.getValor()+500;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.yellow);
        g.fillOval(X,Y,48,48);
        g.setColor(Color.black);
        g.drawString(""+this.getValor(), X+10, Y+20);
    }
    public void setXY(int x, int y){
        X = x;
        Y = y;
        
    }
}
