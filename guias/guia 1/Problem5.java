
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Problem5 extends JFrame
	implements ActionListener {
	JTextField numbs[] = new JTextField(20);
	JButton bmax = new JButton("max");
	JLabel lans = new JLabel(20);
	double arrayNum[] = new double[3];
	
	public Problem5() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pnorth = createNorth();
		c.add(pnorth, BorderLayout.NORTH);
		JPanel center = createCenter();
		c.add(pcenter, BorderLayout.CENTER);
		JPanel psouth = createSouth();
		c.add(psouth, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	private JPanel createNorth() {
		JPanel p = new JPanel(new GridLayout(1, 3));
		for (int i = 0; i < 3; i++) {
			p.add(numbs[i]);
		}
		return p; 
	}
	
	private JPanel createCenter() {
		JPanel p = new JPanel(new FlowLayout());
		p.add(pans);
		return p;
	}
	
	private void createSouth() {
		JPanel p = new JPanel(new FlowLayout());
		bmax.addActionListener(this);
		p.add(bmax);
		return p;
	}
	
	public void actionPerformed(ActionEvent e) {
		
	
	
	
	
	}
