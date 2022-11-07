package codigo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Expendedora extends JFrame implements ActionListener {
    private Deposito Coca;
    private Deposito Spritex;
    private Deposito Mine;
    private Deposito Fantax;
    private Depocoin caja;
    private Depocoin caja2;
    private Bebida repo;
    private Moneda insert;
    
    private int precioCoca;
    private int precioSprite;
    private int precioMine;
    private int precioFanta;
    private int posX;
    private int posY;
    private JButton bCoca;
    
    public void insertMoneda(Moneda coin){
        insert = coin;
    }
    public Expendedora(int cantidad, int precioCoca, int precioFanta , int precioSprite, int precioMineral){
        
        Coca = new Deposito();
        Spritex = new Deposito();
        Mine = new Deposito();
        Fantax = new Deposito();
        caja = new Depocoin();
        caja2 = new Depocoin();
        
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
        JButton bCoca=new JButton("COCACOLA");
    }
    
    public void comprarBebida(int seleccion) throws PagoInsuficienteException, PagoIncorrectoException, NoHayBebidaException{
        
        
        switch(seleccion){
            
            default: 
                caja.returncoin(insert);
                throw new NoHayBebidaException("Seleccion Incorrecta"); 
            case 1:
                
                if(checkPrice(insert, precioCoca) == true){
                    repo = Coca.getBebida();
                    if(repo == null){
                        caja.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    llenarVuelto(insert, precioCoca);
                    
                }
                
            case 2:
                if(checkPrice(insert, precioFanta) == true){
                    repo = Fantax.getBebida();
                    if(repo == null){
                        caja.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    llenarVuelto(insert, precioFanta);
                    
                }
                
            case 3:
                if(checkPrice(insert, precioSprite) == true){
                    repo = Spritex.getBebida();
                    if(repo == null){
                        caja.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    llenarVuelto(insert, precioSprite);
                    
                }
            
            case 4:
                if(checkPrice(insert, precioMine) == true){
                    repo = Mine.getBebida();
                    if(repo == null){
                        caja.returncoin(insert);
                        throw new NoHayBebidaException("No Disponible en este momento");
                    }
                    llenarVuelto(insert, precioMine);
                    
                }
            
               
        }
        
    }
    public Bebida getBebida(){
        return repo;
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
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if("CocaCola" == e.getActionCommand()){
            
            try{
                comprarBebida(1);
                
            }catch(PagoIncorrectoException i){
                System.out.println(i.getMessage());
                
            }catch(PagoInsuficienteException i){
                System.out.println(i.getMessage());
                
            }catch (NoHayBebidaException i){
                System.out.println(i.getMessage());
                
            }
        
        }
    }
}
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody