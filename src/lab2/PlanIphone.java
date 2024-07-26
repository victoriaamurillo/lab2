package lab2;
/**
 *
 * @author josemartin
 */
public class PlanIphone extends Plan{
    
    String email;
    double pago;
    
    public PlanIphone(int numeroTelefono, String nombreCliente, String email) {
        super(numeroTelefono, nombreCliente);
        
        this.email = email;
        pago = 22;
    }
    
    @Override
    public double PagoMensual(int mins, int msjs) {
        
        pago += (0.4 * mins) + (0.1 * msjs);
        return pago;
    }
    
    @Override
    public String Imprimir(){
        return super.Imprimir() + "\nEmail: " + email;
    }
    
    @Override
    public String getExtra() {
        return email;
    }
}
