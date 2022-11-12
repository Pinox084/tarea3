
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
    @Override
    public void paint(Graphics g,int x, int y){
        g.setColor(Color.blue);
        g.fillRect(x,y,28,18);
    }
}
