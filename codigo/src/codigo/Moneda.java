package codigo;
public abstract class Moneda {
    private int serie;
    public Moneda(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
    public int getValor(){
        return 0;
    }
}
