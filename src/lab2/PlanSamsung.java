package lab2;

import java.util.ArrayList;

/**
 *
 * @author Cristopher
 */
public class PlanSamsung extends Plan {
    
    String pin;
    ArrayList<String> bbm;
    double precio;
    
    public PlanSamsung(int numero, String nombre, String pin){
        super(numero, nombre);
        
        this.pin = pin;
        bbm = new ArrayList<>();
        precio = 40;
    }
    
    @Override
    public double PagoMensual(int mins, int msgs) {
        if(mins>200)
            precio += (mins - 200)*0.8;
        if(msgs>300)
            precio += (msgs - 300)*0.2;
        return precio;
    }
    
    @Override
    public String Imprimir() {
        return super.Imprimir() + "\nPin: " + pin;
    }
    
    public void agregarPinAmigo(String pin) {
        int lista = 0;
        for(int cont=0;cont<bbm.size();cont++){
            if(bbm.get(cont).equals(pin)){
               lista = 1;
            }
        }
        
        if(lista == 0)
            bbm.add(pin);
    }
    
    @Override
    public String getExtra() {
        return pin;
    }  
}
