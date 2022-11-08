package codigo;
public abstract class Moneda {
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
