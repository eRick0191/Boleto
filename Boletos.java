package Boleto;
import java.util.Scanner;

public class Boletos {
    //Atributos
    private int ID;
    private String Nombre;
    private double Precio;
    private int Tipo;
    private String Fecha;
    private String Destino;
    
    //Metodos
    //Constructor Vacío
    public Boletos () {
        this.ID = 0;
        this.Nombre = "";
        this.Precio = 0;
        this.Tipo = 0;
        this.Fecha = "";
        this.Destino = "";
    }
    
    //Constructor Parametro
    public Boletos (int ID, String Nombre, double Precio,int Tipo, String Fecha, String Destino){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Tipo = Tipo;
        this.Fecha = Fecha;
        this.Destino = Destino;
    }
    
    //Constructor Copia
    public Boletos (Boletos Bol){
        this.ID = Bol.ID;
        this.Nombre = Bol.Nombre;
        this.Precio = Bol.Precio;
        this.Tipo = Bol.Tipo;
        this.Fecha = Bol.Fecha;
        this.Destino = Bol.Destino;
    }

    /**
     * @return the ID
     */
    private int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    private void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Nombre
     */
    private String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    private void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Precio
     */
    private double getPrecio() {
        return Precio;
    }

    /**
     * @param Precio the Precio to set
     */
    private void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    /**
     * @return the Tipo
     */
    private int getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    private void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the Fecha
     */
    private String getFecha() {
        return Fecha;
    }

    /**
     * @param Fecha the Fecha to set
     */
    private void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    /**
     * @return the Destino
     */
    private String getDestino() {
        return Destino;
    }

    /**
     * @param Destino the Destino to set
     */
    private void setDestino(String Destino) {
        this.Destino = Destino;
    }
    
    public void capturarInformacion (){
        Scanner s = new Scanner(System.in);
        System.out.println("Nombre: ");
        this.Nombre = s.nextLine();
        System.out.println("Fecha: ");
        this.Fecha = s.nextLine();
        System.out.println("Destino: ");
        this.Destino = s.nextLine();
        System.out.println("Numero de boleto: ");
        this.ID = s.nextInt();
        System.out.println("Precio: ");
        this.Precio = s.nextDouble();
        System.out.println("Tipo de viaje: ");
        this.Tipo = s.nextInt();
        
    }
    
    public double obtenerSubtotal (){
        if(this.Tipo == 2){
             return this.Precio *1.8;
        }else{
            return this.Precio;
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
        System.out.println("Nombre: "+this.Nombre);
        System.out.println("No. Boleto: "+this.ID);
        System.out.println("Precio: "+this.Precio);
        System.out.println("Tipo de viaje: "+this.Tipo);
        System.out.println("Fecha: "+this.Fecha);
        System.out.println("Destino: "+this.Destino);
        System.out.println("Subtotal: "+obtenerSubtotal());
        System.out.println("Impuesto: "+obtenerIVA());
        System.out.println("Descuento: "+obtenerDescuento(edad));
        System.out.println("Total: "+obtenerTotal(edad));
    }
    
    
}
