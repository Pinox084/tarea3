package codigo;
public class Moneda100 extends Moneda{
    public Moneda100(int n){
        super(n);
    }
    public int getValor(){
        return super.getValor()+100;
    }
}
