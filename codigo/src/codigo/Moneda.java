package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public abstract class Moneda extends JPanel{
    private int serie;
    private Graphics g;
    public Moneda(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
    public int getValor(){
        return 0;
    }
    public void paint(Graphics g,int x, int y){
        g.setColor(Color.yellow);
        g.fillOval(x,y,30,30);
        
    }
}
