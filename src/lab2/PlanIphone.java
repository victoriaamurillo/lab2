/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author Administrator
 */
public class PlanIphone extends Plan{
    
    String email;
    double pago;
    
    public PlanIphone(int numeroTelefono, String nombreCliente) {
        super(numeroTelefono, nombreCliente);
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
    
    public String getEmail() {
        return email;
    }
}
