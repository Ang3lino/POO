
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WhackMole extends JFrame implements Runnable {
    
    private JPanel jpscore, jpboard;
    private Label lscore, ltitle, ltime;
    private int score, time, rows = 6, columns = 7;
    private JButton whole[][] = new JButton[rows][columns];
    private Thread thread[] = new Thread[5];

    public void run() {
        // I'm gonna put code here in a moment...
        Random gen = new Random();
        try {
            Thread.sleep(100 * gen.nextInt(10));
        } catch(Exception e) {
            System.out.println(e);  
        }
        createWhole();
        jpboard = createCenter();
        c.add(jpboard, BorderLayout.CENTER);
        pack();
        setVisible(true);
        ltime.setText("Time: "+(time--));
 
    }

    public WhackMole() {
        super("Whack a mole");
        Container c = getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        time = 60;
        for (Thread x : thread)
            x = new Thread(this);
        c.setLayout(new BorderLayout());
        jpscore = createNorth();
        c.add(jpscore, BorderLayout.NORTH);
        while (time >= 0)
            process(c);
    }

    private void process(Container c) {
        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println(e);  
        }
        createWhole();
        jpboard = createCenter();
        c.add(jpboard, BorderLayout.CENTER);
        pack();
        setVisible(true);
        ltime.setText("Time: "+(time--));
    }

    private void createWhole() {
        Random gen = new Random();
        for (int i = 0; i < rows; i++) { 
            for (int j = 0; j < columns; j++) {
                if (gen.nextInt(10) <= 1) {
                    whole[i][j] = new JButton(new ImageIcon(((new ImageIcon("trump.jpg"))
                        .getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH)));
                    whole[i][j].addActionListener(new AddScoreHandler());
                }
                else 
                    whole[i][j] = new JButton();
            }
        }
    }

    private JPanel createNorth() {
        jpscore = new JPanel(new BorderLayout());
        lscore = new Label("Score: 0");
        ltitle = new Label("Whack a mole");
        ltime = new Label("Time: 60s");
        jpscore.add(lscore, BorderLayout.WEST);
        jpscore.add(ltitle, BorderLayout.CENTER); 
        jpscore.add(ltime, BorderLayout.EAST);
        return jpscore;
    }

    private JPanel createCenter() {
        jpboard = new JPanel(new GridLayout(rows, columns));
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                jpboard.add(whole[i][j]);
        return jpboard;
    }

    public static void main(String[] args) {
        WhackMole game = new WhackMole();
    }

    class AddScoreHandler implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            score += 10;
            lscore.setText("Score: "+score);
        }
    }

}
