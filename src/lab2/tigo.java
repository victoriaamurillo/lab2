package lab2;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author josemartin
 */
public class tigo {
    
    static ArrayList<Plan> plans;
    static String text;
    
    public tigo() {
        plans = new ArrayList<>();
        text = "";
    }
    
    public static void agregarPlan(int numeroTel, String nombre, String extra, String tipo) {
        
        if (!busqueda(numeroTel, extra, tipo)) {
                if (tipo.equals("IPHONE")) {
                    PlanIphone iphone = new PlanIphone(numeroTel, nombre, extra);
                    plans.add(iphone);

                } else if (tipo.equals("SAMSUNG")) {
                    PlanSamsung samsung = new PlanSamsung(numeroTel, nombre, extra);
                    plans.add(samsung);
                }
            
        } else {
            JOptionPane.showMessageDialog(null, "El numero ya existe", 
                            null, JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static boolean busqueda(int numeroTel, String datoExtra, String tipo) {
        boolean estado = false;
        
        for (Plan plan : plans) {
            if (plan.getNumero() == numeroTel || plan.getExtra() == datoExtra)
                estado = true;
        }
        return estado;
    }
    
    public static double pagoPlan(int numeroTel, int mins, int msgs) {
        double pago = 0;
        
        for (Plan plan : plans) {
            if (plan.getNumero() == numeroTel)
                pago = plan.PagoMensual(mins, msgs);
        }
        return pago;
    }
    
    public static void agregarAmigo(int numeroTel, String pin) {
        
        for (Plan plan : plans) {
            if (plan.getNumero() == numeroTel)
                if (plan instanceof PlanSamsung planSamsung)
                    planSamsung.agregarPinAmigo(pin);
        }
    }
    
    public static String lista() {
        int iphone = 0, samsung = 0;
        
        for (Plan plan : plans) {
            text += plan.Imprimir() + "\n";
            
            if (plan instanceof PlanIphone) {
                iphone += 1;
            } else if (plan instanceof PlanSamsung) {
                samsung += 1;
            }
        }
        
            JOptionPane.showMessageDialog(null, "IPHONE: " + iphone + "\nSAMSUNG: "
            + samsung, null, JOptionPane.INFORMATION_MESSAGE);
        
        return text;
        
    }
}
