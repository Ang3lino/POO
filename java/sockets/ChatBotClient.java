
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class ChatBotClient extends JFrame implements ActionListener {
    Socket s = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    JTextField tfask = new JTextField(20);
    JButton bask = new JButton("Pregunta!");
    JLabel lans = new JLabel(10);

    public ChatBotClient() throws Exception{
        super("ChatBot");
        s = new Socket("localhost", 5050);
        oos = new ObjectOutputStream(s.getOutputStream());
        ois = new ObjectInputStream(s.getInputStream());
        Container c = getContentPane();
        bask.addActionListener(this);
        c.setLayout(new FlowLayout());
        c.add(tfask);
        c.add(bask);
        c.add(lans);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String args[]) throws Exception {
       new ChatBotClient(); 
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bask) {
            try {
                oos.writeObject(tfask.getText());
                lans.setText((String) ois.readObject());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
}