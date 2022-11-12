package codigo;
import java.awt.Color;
import java.awt.Graphics;


public abstract class Bebida{
    private int serie;
    public Bebida(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
    public String beber(){
        return "sabor: ";
    }
    public void paint(Graphics g, int x, int y) {
        g.setColor(Color.black);
        g.fillRect(x,y,30,20);
    }
}
