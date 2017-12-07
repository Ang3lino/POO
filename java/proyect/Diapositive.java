import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Diapositive extends JFrame {
	Container container = getContentPane();
	JLabel label;
	JButton nextBtn, previousBtn;
	Thread auto;

	public Diapositive(CircularList<ImageWindowBtn> images) 
	throws Exception {
		super("Diapositiva");
		label = new JLabel();
		//Configuracion del boton siguiente
		nextBtn = new JButton("Siguiente");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				label.setIcon(images.next().getImage());
				container.add(label, BorderLayout.CENTER);
			}
		});
		//Configuracion del boton anterior
		previousBtn = new JButton("Anterior");
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				label.setIcon(images.previous().getImage());
				container.add(label, BorderLayout.CENTER);
			}
		});
		
		auto = new Thread(new Runnable() {
			public void run() {
				try {
					while (true) {
						label.setIcon(images.next().getImage());
						add(label, BorderLayout.CENTER);
						Thread.sleep(5000);
						//images.next();
						//images.previous();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		container.setLayout(new BorderLayout());
		label.setIcon(images.get(images.getIndex()).getImage());
		container.add(label, BorderLayout.CENTER);
		container.add(nextBtn, BorderLayout.EAST);
		container.add(previousBtn, BorderLayout.WEST);
		auto.start();
	}

}