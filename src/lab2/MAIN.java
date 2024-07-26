
// VICTORIA, CRISTOPHER, JOSE MARTIN

package lab2;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author victoria
 */
public class MAIN {
    
    public static void main(String[] args) {
        
        tigo tigo = new tigo();
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Gestión de planes", JLabel.CENTER);
        frame.add(titulo, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1, 10, 10)); 
        frame.add(panel, BorderLayout.CENTER);
        Componentes(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void Componentes(JPanel panel) {
        JButton agregar = crearBoton("Agregar plan");
        panel.add(agregar);
        agregar.addActionListener(e -> agregarPlan());

        JButton pagar = crearBoton("Pago plan");
        panel.add(pagar);
        pagar.addActionListener(e -> pagoPlan());

        JButton amigo = crearBoton("Agregar amigo");
        panel.add(amigo);
        amigo.addActionListener(e -> agregarAmigo());

        JButton lista = crearBoton("Listar planes");
        panel.add(lista);
        lista.addActionListener(e -> listarPlanes());

        JButton salir = crearBoton("Salir");
        panel.add(salir);
        salir.addActionListener(e -> System.exit(0));
    }

    private static JButton crearBoton(String text) {
        JButton boton = new JButton(text);
        boton.setPreferredSize(new Dimension(200, 50));
        boton.setBackground(new Color(0, 225, 0));
        return boton;
    }
    
    private static void agregarPlan() {
        JTextField numeroTelefono = new JTextField(5);
        JTextField nombre = new JTextField(5);
        JTextField extra = new JTextField(5);
        JTextField tipo = new JTextField(5);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("Número de teléfono:"));
        panel.add(numeroTelefono);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombre);
        panel.add(new JLabel("Dato extra (Email o PIN):"));
        panel.add(extra);
        panel.add(new JLabel("Tipo de plan (IPHONE o SAMSUNG):"));
        panel.add(tipo);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Agregar plan", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            int numeroTel = Integer.parseInt(numeroTelefono.getText());
            String Nombre = nombre.getText();
            String datoExtra = extra.getText();
            String Tipo = tipo.getText().toUpperCase();
            tigo.agregarPlan(numeroTel, Nombre, datoExtra, Tipo);
        }
    }
    
    private static void pagoPlan() {
        JTextField numeroTelefono = new JTextField(5);
        JTextField mins = new JTextField(5);
        JTextField msgs = new JTextField(5);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5));
        panel.add(new JLabel("Número de Teléfono:"));
        panel.add(numeroTelefono);
        panel.add(new JLabel("Minutos Usados:"));
        panel.add(mins);
        panel.add(new JLabel("Mensajes Usados:"));
        panel.add(msgs);
        
        int result = JOptionPane.showConfirmDialog(null, panel,
                "Pago plan", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            int numeroTel = Integer.parseInt(numeroTelefono.getText());
            int Mins = Integer.parseInt(mins.getText());
            int Msgs = Integer.parseInt(msgs.getText());
            double pago = tigo.pagoPlan(numeroTel, Mins, Msgs);
            
            if (pago != -1) {
                JOptionPane.showMessageDialog(null, "El pago mensual es: $" + pago);
            } else {
                JOptionPane.showMessageDialog(null, "Numero de telefono no existe");
            }
        }
    }

    private static void agregarAmigo() {
        JTextField numero = new JTextField(5);
        JTextField pin = new JTextField(5);
        
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(2, 2, 5, 5));
        myPanel.add(new JLabel("Número de Teléfono:"));
        myPanel.add(numero);
        myPanel.add(new JLabel("PIN del Amigo:"));
        myPanel.add(pin);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Agregar Amigo", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int numeroTelefono = Integer.parseInt(numero.getText());
            String Pin = pin.getText();
            tigo.agregarAmigo(numeroTelefono, Pin);
        }
    }
    
    private static void listarPlanes() {
        JTextArea textArea = new JTextArea(tigo.lista());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(380, 200));
        
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Planes", 
                JOptionPane.INFORMATION_MESSAGE);
    }
}
