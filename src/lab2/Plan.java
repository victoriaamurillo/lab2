package lab2;
/**
 *
 * @author crist
 */

public abstract class Plan {
    
    int numeroTelefono;
    String nombreCliente;
    
    public Plan(int numeroTelefono, String nombreCliente){
        this.numeroTelefono = numeroTelefono;
        this.nombreCliente = nombreCliente;
    }
    
    public abstract double PagoMensual(int mins, int msjs);
    
    public abstract String getExtra();
    
    public int getNumero(){
        return numeroTelefono;
    }
    
    public String getNombre(){
        return nombreCliente;
    }
    
    public String Imprimir(){
        return "Nombre: " + nombreCliente + "\nNúmero: "+numeroTelefono;
    }
}
