package codigo;

public class Expendedora {
    Deposito Coca;
    Deposito Spritex;
    Deposito Mine;
    Deposito Fantax;
    Depocoin caja;
    
    int precioCoca;
    int precioSprite;
    int precioMine;
    int precioFanta;
    
    
    public Expendedora(int cantidad, int precioCoca, int precioFanta , int precioSprite, int precioMineral){
        
        Coca = new Deposito();
        Spritex = new Deposito();
        Mine = new Deposito();
        Fantax = new Deposito();
        caja = new Depocoin();
        
        for (int i = 0; i < cantidad; i++) {
            Coca.addBebida(new CocaCola(i));
        }
        for (int i = 0; i < cantidad; i++) {
            Spritex.addBebida(new Sprite(i));
        }
        for (int i = 0; i < cantidad; i++) {
            Mine.addBebida(new Mineral(i));
        }
        for (int i = 0; i < cantidad; i++) {
            Fantax.addBebida(new Fanta(i));
        }
        this.precioCoca = precioCoca;
        this.precioFanta = precioFanta;
        this.precioSprite = precioSprite;
        this.precioMine = precioMineral;
        
    }
    
    public Bebida comprarBebida(Moneda coin, int seleccion) throws PagoInsuficienteException, PagoIncorrectoException, NoHayBebidaException{
        
        Bebida b = null;
        switch(seleccion){
            
            default: 
                caja.returncoin(coin);
                throw new NoHayBebidaException("Seleccion Incorrecta"); 
            case 1:
                
                if(checkPrice(coin, precioCoca) == true){
                    b = Coca.getBebida();
                    if(b == null){
                        caja.returncoin(coin);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    llenarVuelto(coin, precioCoca);
                    return b;
                }
                
            case 2:
                if(checkPrice(coin, precioFanta) == true){
                    b = Fantax.getBebida();
                    if(b == null){
                        caja.returncoin(coin);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    llenarVuelto(coin, precioFanta);
                    return b;
                }
                
            case 3:
                if(checkPrice(coin, precioSprite) == true){
                    b = Spritex.getBebida();
                    if(b == null){
                        caja.returncoin(coin);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    llenarVuelto(coin, precioSprite);
                    return b ;
                }
            
            case 4:
                if(checkPrice(coin, precioMine) == true){
                    b = Mine.getBebida();
                    if(b == null){
                        caja.returncoin(coin);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    llenarVuelto(coin, precioMine);
                    return b;
                }
            
               
        }
        
        return null;
    }
    
    public boolean checkPrice(Moneda coin, int precio) throws PagoInsuficienteException, PagoIncorrectoException {
        
        if(coin == null){
            
            throw new PagoIncorrectoException("Moneda no Ingresada");
        }
        if(coin.getValor() >= precio){
            return true;
        }else{
            caja.returncoin(coin);
            
            throw new PagoInsuficienteException("Pago Insuficiente");
            
        }
        
    }
    
    public void llenarVuelto(Moneda coin, int eleccion){
        
        int p = coin.getValor()- eleccion;
        p = p/100;
        
        for (int i = 0; i < p; i++) {
            caja.newCoin();
            
        }
    }
    public Moneda getVuelto(){
        Moneda x = caja.getCoin();
        
        return x;
    }
}
