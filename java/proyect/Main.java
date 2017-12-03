import java.util.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.*;

// To look for: jslider, fileChooser, KeyPressed

public class Main extends JFrame {
    private JPanel imgCollectionJP;
    private LinkedList<String> imageNames = getImageNames(); 
    private int imagesAmount = 40, currentPosition = 0;
    private CircularList<ImageWindowBtn> imgWinBtns = new CircularList<>(imagesAmount);
    private JScrollPane mainImageScroll = new JScrollPane();
    private Container container;
    private JLabel nameLbl = new JLabel();
    private JButton diapositiveBtn = new JButton("Diapositiva");


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
        label.setIcon(imgWinBtns.get(0).getImage());
        mainImageScroll.setViewportView(label);
    }

    private JPanel createSuperiorPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        nameLbl.setText(imgWinBtns.get(0).getName());
        panel.add(nameLbl);
        diapositiveBtn.addActionListener(e -> {
           ///////////////////////////////////////////////////////////////////
        });
    }

    public Main() throws Exception {
        super("Album fotografico");
        container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(createImagesCollection(), BorderLayout.SOUTH);
        initMainImage(); // importante pasarle el JScrollPane mas no JPanel aqui abajo
        container.add(mainImageScroll, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private JPanel createImagesCollection() throws Exception {
        // Una matriz de 4x10 con un espacio de 5 pixeles tanto vertical como horizontalmente
        JPanel p = new JPanel(new GridLayout(4, 10, 5, 5));
        for (int i = 0; i < imagesAmount; i++) {
            ImageWindowBtn imgWinBtn = new ImageWindowBtn("images/"+imageNames.get(i));
            final int currentPosition = i;
            imgWinBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    ImageIcon image = imgWinBtn.getImage();
                    JLabel label = new JLabel();
                    label.setIcon(image);
                    mainImageScroll.setViewportView(label);
                    container.add(mainImageScroll, BorderLayout.CENTER);
                    imgWinBtns.setIndex(currentPosition);
                }
            });
            imgWinBtns.enqueue(imgWinBtn);
            p.add(imgWinBtns.get(i));
        }
        return p;
    }

    public static void main(String args[]) throws Exception {
        new Main();
    }

}