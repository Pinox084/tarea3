package codigo;

import java.awt.Color;
import java.awt.Graphics;

public class Sprite extends Bebida {

    public Sprite(int serie) {
        super(serie);
    }

    @Override
    public String beber() {
        return super.beber() + "sprite";
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.green);
        g.fillRect(X, Y, 7, 18);
    }

    public void setXY(int x, int y) {
        X = x;
        Y = y;

    }
}
