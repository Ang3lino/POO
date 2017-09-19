
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Problem5 extends JFrame
	implements ActionListener {
	JTextField tfnum[] = new JTextField[3];
	JButton bmax = new JButton("max");
	JLabel lans = new JLabel();
	double arrayNum[] = new double[3];
	final double infty = 99999999;
	
	public Problem5() {
		super("Numero mas grande");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pnorth = createNorth();
		c.add(pnorth, BorderLayout.NORTH);
		JPanel pcenter = createCenter();
		c.add(pcenter, BorderLayout.CENTER);
		JPanel psouth = createSouth();
		c.add(psouth, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	private JPanel createNorth() {
        JPanel p = new JPanel(new GridLayout(1, 3));
		for (int i = 0; i < 3; i++) {
            tfnum[i] = new JTextField(10);
            p.add(tfnum[i]);
		}
		return p; 
	}
	
	private JPanel createCenter() {
		JPanel p = new JPanel(new FlowLayout());
		p.add(lans);
		return p;
	}
	
	private JPanel createSouth() {
		JPanel p = new JPanel(new FlowLayout());
		bmax.addActionListener(this);
		p.add(bmax);
		return p;
	}
	
	public void actionPerformed(ActionEvent e) {
		try { 
			for (int i = 0; i < tfnum.length; i++) 
				arrayNum[i] = Double.valueOf(tfnum[i].getText());
		} catch (Exception exception) {
			lans.setText("Existen etiquetas vacias.");
		}		
		double max = -infty;
        int pos = 0;
        for (int i = 0; i < tfnum.length; i++) {
            if (arrayNum[i] > max) {
                max = arrayNum[i];
                pos = i;
            } 
        } 
        lans.setText(String.valueOf(arrayNum[pos]));
		pack();
    }
    
    public static void main(String[] args) {
        new Problem5();
    }
}
