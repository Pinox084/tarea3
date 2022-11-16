
package codigo;

import java.awt.Color;
import java.awt.Graphics;


public class Mineral extends Bebida{
    
    public Mineral(int serie){
        super(serie);
    }
    @Override
    public String beber(){
        return super.beber()+"agua mineral";
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(X,Y,7,18);
        
    }
    public void setXY(int x, int y){        
        X = x;
        Y = y;
        
    }
}
