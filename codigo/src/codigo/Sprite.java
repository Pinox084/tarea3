
package codigo;

import java.awt.Color;
import java.awt.Graphics;


public class Sprite extends Bebida{
    public Sprite(int serie){
        super(serie);
    }
    @Override
    public String beber(){
        return super.beber()+"sprite";
    }
    @Override
    public void paint(Graphics g,int x, int y){
        g.setColor(Color.green);
        g.fillRect(x+50,y,28,18);
    }
}
