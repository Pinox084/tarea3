
package codigo;


public class Sprite extends Bebida{
    public Sprite(int serie){
        super(serie);
    }
    @Override
    public String beber(){
        return super.beber()+"sprite";
    }
}
