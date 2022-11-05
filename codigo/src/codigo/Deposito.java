package codigo;

import java.util.ArrayList;

public class Deposito {

    private ArrayList<Bebida> derp;

    public Deposito() {

        derp = new ArrayList();
    }

    public void addBebida(Bebida esta) {

        derp.add(esta);
    }

    public Bebida getBebida() {
        if (derp.size() == 0) {
            return null;
        }
        Bebida b = derp.remove(0);

        return b;
    }

}
