
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class WholeButton extends JButton {
    ImageIcon imglive, imgdead;
    boolean itsAlive = false;
    byte stat;
    Random gen = new Random();

    
    // 0 <= Random.nextInt(n) < n
    private String randomPath() {
        return new String("img"+gen.nextInt(2)+".jpg"); 
    }

    public WholeButton() {
        imglive = new ImageIcon(randomPath());
        imgdead = new ImageIcon("dead.jpg"); 
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
            int currentScore = WhackMole.getScore() + 10;
            WhackMole.setScore(currentScore);
            try { Thread.sleep(1000); } catch (Exception ex) { }
            changeStatus();
        }
    }

    class Nothing implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // void...
        }
    }

}
