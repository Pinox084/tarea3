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
    @Override
    public void paint(Graphics g,int x, int y){
        g.setColor(Color.red);
        g.fillRect(x,y,28,18);
    }
}
