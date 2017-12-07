import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;

import com.sun.crypto.provider.DESCipher;

public class Main extends JFrame {
    private JPanel imgCollectionJP, mainImageJP;
    private LinkedList<String> imageNames = getImageNames();
    private int imagesAmount = 40, currentPosition = 0;
    private CircularList<ImageWindowBtn> imgWinBtns = new CircularList<>(imagesAmount);
    private JScrollPane mainImageScroll = new JScrollPane();
    private Container container;
    private JLabel nameLbl = new JLabel();
    private JButton diapositiveBtn = new JButton("Diapositiva"),
                    nextBtn = new JButton("Siguiente"),
                    previousBtn = new JButton("Anterior"),
                    enterBtn = new JButton("aceptar");
    private JSlider slider;
    private JTextArea descriptionTA;

    public Main() throws Exception {
        super("Album fotografico");
        container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(createImagesCollection(), BorderLayout.SOUTH);
        initMainImage(); 
        container.add(createCenterPanel(), BorderLayout.CENTER);
        container.add(createSuperiorPanel(), BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public JPanel createCenterPanel() {
        JPanel descriptorJP = new JPanel(new GridLayout(2, 1));
        mainImageJP = new JPanel(new BorderLayout());
        descriptionTA = new JTextArea(200, 50);
        descriptorJP.add(descriptionTA);
        enterBtn.setSize(new Dimension(50, 10));
        enterBtn.addActionListener(event -> {
            imgWinBtns.getCurrent().setDescription(descriptionTA.getText());
        });
        descriptorJP.add(enterBtn);
        mainImageJP.add(mainImageScroll, BorderLayout.WEST);
        mainImageJP.add(descriptorJP, BorderLayout.EAST);
        return mainImageJP;
    }

    //Obtiene el nombre de cada imagen
    public LinkedList<String> getImageNames() throws SecurityException {
        File folder = new File("images");
        File[] listOfFiles = folder.listFiles();
        LinkedList<String> imgNames = new LinkedList<String>();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile())
                imgNames.add(listOfFiles[i].getName());
            // listOfFiles[i].isDirectory() para saber si es directorio
        }
        return imgNames;
    }

    private void initMainImage() {
        JLabel label = new JLabel();
        label.setIcon(imgWinBtns.getCurrent().getImage());
        mainImageScroll.setViewportView(label);
    }

    private JPanel createSuperiorPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        nameLbl.setText(imgWinBtns.get(imgWinBtns.getIndex()).getName());
        panel.add(nameLbl);

        diapositiveBtn.setBackground(Color.GRAY); 
        diapositiveBtn.setOpaque(true);
        diapositiveBtn.addActionListener( e -> {
            Thread diapThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        Diapositive diapositive = new Diapositive(imgWinBtns);
                        diapositive.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        diapositive.pack();
                        diapositive.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            diapThread.start();
        });
        panel.add(diapositiveBtn);
        return panel;
    }

    private JPanel createImagesCollection() throws Exception {
        JPanel mainPanel = new JPanel(new BorderLayout());
        // Una matriz de 4x10 con un espacio de 5 pixeles tanto vertical como horizontalmente
        JPanel p = new JPanel(new GridLayout(4, 10, 3, 3));
        JPanel directionPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        for (int i = 0; i < imagesAmount; i++) {
            ImageWindowBtn imgWinBtn = new ImageWindowBtn("images/" + imageNames.get(i));
            int currentPosition = i;
            imgWinBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    ImageIcon image = imgWinBtn.getImage();
                    JLabel label = new JLabel();
                    label.setIcon(image);
                    mainImageScroll.setViewportView(label);
                    mainImageJP.add(mainImageScroll, BorderLayout.CENTER);
                    container.add(mainImageJP, BorderLayout.CENTER);
                    imgWinBtns.setIndex(currentPosition);
                    descriptionTA.setText(imgWinBtns.getCurrent().getDescription());
                    nameLbl.setText(imgWinBtn.getName());
                }
            });

            imgWinBtns.enqueue(imgWinBtn);
            p.add(imgWinBtns.get(i));
        }

        nextBtn.setBackground(Color.GRAY); 
        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JLabel label = new JLabel();
                label.setIcon(imgWinBtns.next().getImage());
                mainImageScroll.setViewportView(label);
                descriptionTA.setText(imgWinBtns.getCurrent().getDescription());
                container.add(mainImageJP, BorderLayout.CENTER);
            }
        });
        
        previousBtn.setBackground(Color.GRAY); 
        previousBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JLabel label = new JLabel();
                label.setIcon(imgWinBtns.previous().getImage());
                mainImageScroll.setViewportView(label);
                descriptionTA.setText(imgWinBtns.getCurrent().getDescription());
            }
        });

        slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int proportion = (int) 15 * slider.getValue();
                ImageWindowBtn imgWinBtn = imgWinBtns.getCurrent();
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(new ImageIcon(imgWinBtn.getPath()).getImage()
                                            .getScaledInstance(proportion, proportion, Image.SCALE_DEFAULT)));
                mainImageScroll.setViewportView(label);
            }
        });

        directionPanel.add(previousBtn);
        directionPanel.add(nextBtn);
        mainPanel.add(directionPanel, BorderLayout.NORTH);
        mainPanel.add(p, BorderLayout.SOUTH);
        mainPanel.add(slider, BorderLayout.CENTER);
        return mainPanel;
    }

    public static void main(String args[]) throws Exception {
        new Main();
    }

}