
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Test extends JFrame {
    JPanel p = new JPanel();
    JScrollPane scrollPane = new JScrollPane();

    public Test() {
        setLayout(new BorderLayout());
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String args[]) throws Exception {
        int i = 0;
        if (++i == 0);
        System.out.println(i);
    }
}