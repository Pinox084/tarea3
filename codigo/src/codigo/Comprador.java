package codigo;

public class Comprador {
    private int vuelto;
    private String sabor;
    
    
    public Comprador(Expendedora quiosco, Moneda coin, int seleccion){
        Bebida botella = null;
        vuelto = 0;
        Moneda x;
        do{
            x = quiosco.getVuelto();
            
            
            if(x != null){
                
                
                vuelto = vuelto + x.getValor();
                System.out.println(vuelto);
            }
            
        }while(x != null);
        
        
    }
    public String getSabor(){
        return sabor;
    }
    public int cuantoVuelto(){
        return vuelto;
    }
}
