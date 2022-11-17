package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class Moneda extends JPanel{
    private int serie;
    private Graphics g;
    private int X;
    private int Y;
    public Moneda(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
    public int getValor(){
        return 0;
    }
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillOval(X,Y,50,50);
    }
    public void setXY(int x, int y){
        X = x;
        Y = y;
        
    }
}
