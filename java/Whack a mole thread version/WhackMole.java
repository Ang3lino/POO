
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WhackMole extends JFrame {
    
    private JPanel jpscore, jpboard;
    private Label lscore, ltitle, ltime;
    private int score, time = 60, rows = 6, columns = 8;
    private WholeButton whole[][] = new WholeButton[rows][columns];
    private Thread thread[] = new Thread[4];
    private Container c;
   
    public static void main(String[] args) {
        WhackMole game = new WhackMole();
    }

    private void jeteate(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public WhackMole() {
        super("Whack a mole");
        c = getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setLayout(new BorderLayout());
        jpscore = createNorth();
        c.add(jpscore, BorderLayout.NORTH);
        initWholes();
        JPanel pcenter = createCenter();
        c.add(pcenter, BorderLayout.CENTER);
        pack();
        setVisible(true);
        thread[0] = new Thread(new TimeSpender());
        for (int k = 1; k < thread.length; k++)
            thread[k] = new Thread(new Estambre());
        for (int i = 0; i < thread.length; i++)
            thread[i].start();
    }

    private JPanel createCenter() {
        jpboard = new JPanel(new GridLayout(rows, columns));
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                jpboard.add(whole[i][j]);
        return jpboard;
    }

    class TimeSpender implements Runnable {
        public void run() {
            while (--time >= 0) {
                jeteate(1);
                ltime.setText("Time: "+time);
            }
            ltitle.setText("Fin del juego");
            jeteate(5);
            System.exit(0);
        }
    }

    class Estambre implements Runnable {
        public void run() {
            Random gen = new Random();
            while (time >= 0) {
                jeteate(gen.nextInt(3));
                swapWholes();
            }
        }
    }

    private void initWholes() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                whole[i][j] = new WholeButton();
    }

    private void swapWholes() {
        Random gen = new Random();
        final int amount = 4;
        for (int i = 0; i < amount; i++) 
            whole[gen.nextInt(rows)][gen.nextInt(columns)].changeStatus();
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

    class WholeButton extends JButton {
        ImageIcon imglive, imgdead, imgfail;
        boolean itsAlive = false;
        Random gen = new Random();

        // 0 <= Random.nextInt(n) < n
        private String randomPath() {
            return new String("img"+gen.nextInt(2)+".jpg"); 
        }

        public WholeButton() {
            imglive = new ImageIcon(randomPath());
            imgdead = new ImageIcon("dead.jpg"); 
            imgfail = new ImageIcon("trollDog.gif");
            if (gen.nextInt(3) == 0) {
                addActionListener(new Mole());
                itsAlive = true; 
                setIcon(imglive);
            } else {
                addActionListener(new Nothing());
                itsAlive = false;
                setIcon(null);
            }
        }

        public void changeStatus() {
            if (itsAlive){ 
                itsAlive = false;
                setIcon(null);
                addActionListener(new Nothing());
            } else {
                itsAlive = true;
                setIcon(imglive);
                addActionListener(new Mole());
            }
        }

        class Mole implements ActionListener {
            public void actionPerformed(ActionEvent ae) {
                setIcon(imgdead);
                score += 10;
                lscore.setText(String.valueOf("Score: "+score));
                // try { Thread.sleep(1000); } catch (Exception ex) { }
                changeStatus();
            }
        }

        class Nothing implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                setIcon(imgfail);
                score -= 10;
                lscore.setText(String.valueOf("Score: "+score));
            }
        }
    } 
} 
