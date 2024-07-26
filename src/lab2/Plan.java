/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author Administrator
 */
public abstract class Plan {
 int numeroTelefono;
 String nombreCliente;
    public Plan(int numeroTelefono, String nombreCliente){
        this.numeroTelefono=numeroTelefono;
        this.nombreCliente=nombreCliente;
    }
    
    public abstract double PagoMensual(int mins, int msjs);
    
    public int getNumero(){
        return numeroTelefono;
    }
    
    public String getNombre(){
        return nombreCliente;
    }
    public String Imprimir(){
    return "Nombre: "+nombreCliente+"\nNúmero: "+numeroTelefono;
    
    }
}
