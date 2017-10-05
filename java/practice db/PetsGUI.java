
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PetsGUI extends JFrame {
    private LinkedList<JLabel> lattributes = new LinkedList<>();
    private LinkedList<JTextField> tfields = new LinkedList<>();
    private LinkedList<JButton> boptions = new LinkedList<>();

    public PetsGUI() {
        super("Los perros y las perras");
        fillLists();
        Container c = getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setLayout(new BorderLayout());
        JPanel ptable = createGraphicTable();
        JPanel poptions = createGraphicOptions();
        c.add(ptable, BorderLayout.NORTH);
        c.add(poptions, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    private JPanel createGraphicOptions() {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (JButton jb: boptions)
            p.add(jb);
        return p;
    }

    private void fillLists() {
        lattributes.add(new JLabel("nombre"));
        lattributes.add(new JLabel("raza"));
        lattributes.add(new JLabel("edad"));
        lattributes.add(new JLabel("genero"));
        for (int i = 0; i < lattributes.size(); i++) 
            tfields.add(new JTextField());
        boptions.add(new JButton("Conectar"));
        boptions.add(new JButton("Insertar"));
        //boptions.get(0).addActionListener(new ConnectHandle());
        //boptions.get(1).addActionListener(new InsertHandle());
    }

    /*
    class ConnectHandle implements ActionListener {
        public void actionPerformed ()
    }
    */

    private JPanel createGraphicTable() {
        JPanel p = new JPanel();
        final int m = 4, n = 2;
        p.setLayout(new GridLayout(m, n));
        for (int i = 0, j = 0, k = 0; i < lattributes.size() + tfields.size(); i++) {
            if (i % 2 == 0)
                p.add(lattributes.get(j++));
            else 
                p.add(tfields.get(k++));
        }
        return p;
    }

    public static void main(String[] args) {
        new PetsGUI();
    }

}
