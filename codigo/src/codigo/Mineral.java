
package codigo;


public class Mineral extends Bebida{
    public Mineral(int serie){
        super(serie);
    }
    @Override
    public String beber(){
        return super.beber()+"agua mineral";
    }
}
