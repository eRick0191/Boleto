package Boleto;
import java.util.Scanner;

public class Boletos {
    //Atributos
    private int iD;
    private String nombre;
    private double precio;
    private int tipo;
    private String fecha;
    private String destino;
    
    //Metodos
    //Constructor Vacío
    public Boletos () {
        this.iD = 0;
        this.nombre = "";
        this.precio = 0;
        this.tipo = 0;
        this.fecha = "";
        this.destino = "";
    }
    
    //Constructor Parametro
    public Boletos (int iD, String nombre, double precio,int tipo, String fecha, String destino){
        this.iD = iD;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.fecha = fecha;
        this.destino = destino;
    }
    
    //Constructor Copia
    public Boletos (Boletos Bol){
        this.iD = Bol.iD;
        this.nombre = Bol.nombre;
        this.precio = Bol.precio;
        this.tipo = Bol.tipo;
        this.fecha = Bol.fecha;
        this.destino = Bol.destino;
    }

    /**
     * @return the ID
     */
    private int iD() {
        return iD;
    }

    /**
     * @param ID the ID to set
     */
    private void setiD(int iD) {
        this.iD = iD;
    }

    /**
     * @return the Nombre
     */
    private String getnombre() {
        return nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    private void setnombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the Precio
     */
    private double getprecio() {
        return precio;
    }

    /**
     * @param Precio the Precio to set
     */
    private void setprecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the Tipo
     */
    private int gettipo() {
        return tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    private void settipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the Fecha
     */
    private String getfecha() {
        return fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    private void setfecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the Destino
     */
    private String getdestino() {
        return destino;
    }

    /**
     * @param Destino the Destino to set
     */
    private void setdestino(String destino) {
        this.destino = destino;
    }
    
    public void capturarInformacion (){
        Scanner s = new Scanner(System.in);
        System.out.println("Nombre: ");
        this.nombre = s.nextLine();
        System.out.println("Fecha: ");
        this.fecha = s.nextLine();
        System.out.println("Destino: ");
        this.destino = s.nextLine();
        System.out.println("Numero de boleto: ");
        this.iD = s.nextInt();
        System.out.println("Precio: ");
        this.precio = s.nextDouble();
        System.out.println("Tipo de viaje: ");
        this.tipo = s.nextInt();
        
    }
    
    public double obtenerSubtotal (){
        if(this.Tipo == 2){
             return this.precio *1.8;
        }else{
            return this.precio;
        }
    }
    
    public double obtenerIVA () {
        return this.obtenerSubtotal()*.16;
    }
    
    public double obtenerDescuento (int edad){
        if (edad > 60){
            return this.obtenerSubtotal()/2;
        }else{
            return 0;
        }
    }
    
    
    public double obtenerTotal (int e){
        double total = obtenerSubtotal() + obtenerIVA() - obtenerDescuento(e);
        return total;
    }
    
    public void imprimir (){
        Scanner s = new Scanner(System.in);
        System.out.println("Edad: ");
        int edad = s.nextInt();
        System.out.println("Nombre: "+this.nombre);
        System.out.println("No. Boleto: "+this.iD);
        System.out.println("Precio: "+this.precio);
        System.out.println("Tipo de viaje: "+this.tipo);
        System.out.println("Fecha: "+this.fecha);
        System.out.println("Destino: "+this.destino);
        System.out.println("Subtotal: "+obtenerSubtotal());
        System.out.println("Impuesto: "+obtenerIVA());
        System.out.println("Descuento: "+obtenerDescuento(edad));
        System.out.println("Total: "+obtenerTotal(edad));
    }
    
    
}
