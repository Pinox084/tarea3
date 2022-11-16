package codigo;
import java.awt.Color;
import java.awt.Graphics;


public abstract class Bebida{
    private int serie;
    protected int X;
    protected int Y;
    
    

    public Bebida(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
    public String beber(){
        return "sabor: ";
    }
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(X,Y,10,20);
        
        
    }
    public void setXY(int x, int y){
        X = x;
        Y = y;
        
        
    }
    public String getXY(){
        return "POsicion" + X + Y;
    }
   

}
