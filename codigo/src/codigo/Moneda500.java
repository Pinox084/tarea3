package codigo;
public class Moneda500 extends Moneda{
    public Moneda500(int n){
        super(n);
    }
    @Override
    public int getValor(){
        return super.getValor()+500;
    }
    
}
