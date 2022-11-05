package codigo;

public class Codigo {
    public static void main(String[] args) {
       
        Expendedora prueba = new Expendedora(2,600,1100,500,400);
        Moneda billete1000 = new Moneda1000();
        Moneda billete500 = new Moneda500();
        Moneda billete100 = new Moneda100();
        System.out.println(billete1000.getSerie());
        System.out.println(billete500.getSerie());
        System.out.println(billete100.getSerie());
        System.out.println("_____________");
        
        Comprador jimmy = new Comprador(prueba, billete1000, 3);
        System.out.println(jimmy.getSabor());
        System.out.println("Vuelto :" + jimmy.cuantoVuelto());
        System.out.println("_____________");
        
        Comprador jim= new Comprador(prueba, billete500, 3);
        System.out.println(jim.getSabor());
        System.out.println("Vuelto :" + jim.cuantoVuelto());
        System.out.println("_____________");
        
        Comprador jimael= new Comprador(prueba, billete100, 3);
        System.out.println(jimael.getSabor());
        System.out.println("Vuelto :" + jimael.cuantoVuelto());
        System.out.println("_____________");
        
        Comprador jimcarlos= new Comprador(prueba, billete1000, 3);
        System.out.println(jimcarlos.getSabor());
        System.out.println("Vuelto :" + jimcarlos.cuantoVuelto());
        System.out.println("_____________");
        
        Comprador jimpierre= new Comprador(prueba, null, 4);
        System.out.println(jimpierre.getSabor());
        System.out.println("Vuelto :" + jimpierre.cuantoVuelto());
        System.out.println("_____________");
        
        Comprador jhonny= new Comprador(prueba, billete1000, 1);
        System.out.println(jhonny.getSabor());
        System.out.println("Vuelto :" + jhonny.cuantoVuelto());
        System.out.println("_____________");
    }
}
