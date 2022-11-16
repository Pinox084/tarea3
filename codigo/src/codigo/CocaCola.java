package codigo;

import java.awt.Color;
import java.awt.Graphics;

public class CocaCola extends Bebida{
    
    public CocaCola(int serie){
        super(serie);
    }
    
    @Override
    public String beber(){
        return super.beber()+"cocacola";
    }
    public void paint(Graphics g){
        
        super.paint(g);
        g.setColor(Color.red);
        g.fillRect(X,Y,7,18);
        
    }
    public void setXY(int x, int y){        
        X = x;
        Y = y;
        
    }
}
