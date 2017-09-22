
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WhackMole extends JFrame implements Runnable {
    
    private JPanel jpscore, jpboard;
    private Label lscore, ltitle, ltime;
    static private int score, time, rows = 6, columns = 7;
    private WholeButton whole[][] = new WholeButton[rows][columns];
    private Thread thread[] = new Thread[2];
    private Container c;

    static public void setScore (int newScore) {
        score = newScore;
    }

    static public int getScore () {
        return score;
    }

    public static void main(String[] args) {
        WhackMole game = new WhackMole();
    }

    public WhackMole() {
        super("Whack a mole");
        c = getContentPane();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        time = 60;
        initWholes();
        c.setLayout(new BorderLayout());
        jpscore = createNorth();
        c.add(jpscore, BorderLayout.NORTH);
        for (int rep = 0; rep < 10; rep++) {
            process();
            try { Thread.sleep(5000); } catch(Exception ex) { }
        }
        /*
        for (int i = 0; i < thread.length; i++)
            thread[i] = new Thread(this);
        for (int i = 0; i < thread.length; i++)
            thread[i].start();
        */
    }

    private void process() {
        Queue<Complex> pairs = new LinkedList<Complex>();
        createWholes(pairs);
        JPanel pcenter = createCenter();
        c.add(pcenter, BorderLayout.CENTER);
        setVisible(true);
    }

    public void run() {
        Random gen = new Random();
        Queue<Complex> pairs = new LinkedList<Complex>();
        createWholes(pairs);
        jpboard = createCenter();
        c.add(jpboard, BorderLayout.CENTER);
        pack();
        setVisible(true);
        try {
            Thread.sleep(1000 * gen.nextInt(10));
        } catch(Exception e) {
            System.out.println(e);  
        }
        cleanWholes(pairs);
        jpboard = createCenter();
        c.add(jpboard, BorderLayout.CENTER);
        pack();
        setVisible(true);
        // ltime.setText("Time: "+(time--)); // where should i put this?
    }

    private void initWholes() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                whole[i][j] = new WholeButton();
    }

    private void createWholes(Queue<Complex> pair) {
        Random gen = new Random();
        Complex z = new Complex();
        ArrayList<Integer> x = new ArrayList<Integer>(), 
            y = new ArrayList<Integer>();
        final int amount = 3;
        for (int i = 0; i < amount; i++) {
            x.add(gen.nextInt(rows));
            y.add(gen.nextInt(columns));
        }
        for (int i = 0; i < amount; i++) {
            z.setValues(x.get(i), y.get(i));
            pair.add(z);
            whole[z.re()][z.im()].changeStatus();
        }
    }

    private void cleanWholes (Queue<Complex> pair) {
        Complex z = new Complex();
        while (!pair.isEmpty()) {
            z = pair.remove();
            whole[z.re()][z.im()].changeStatus();
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

    class AddScoreHandler implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            score += 10;
            lscore.setText("Score: "+score);
        }
    }

}
