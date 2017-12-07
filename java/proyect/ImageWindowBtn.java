import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageWindowBtn extends JButton {
    private ImageIcon image;
    private BufferedImage myPicture;
    private String path, description;
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static double width = screenSize.getWidth(), 
                          height = screenSize.getHeight();

    public void setDescription(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }

    public ImageIcon getImage() {
        return image;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return path.substring(7);
    }

    public ImageWindowBtn(String _path) throws Exception {
        path = _path;
        myPicture = ImageIO.read(new File(path));
        image = new ImageIcon(myPicture);
        // Ajustamos la dimension de cada boton
        setPreferredSize(new Dimension((int) height / 4 - 100,(int) width / 10 - 100));
        setIcon(image);
    }

    public ImageWindowBtn(String path, int x, int y) throws Exception {
        myPicture = ImageIO.read(new File(path));
        image = new ImageIcon(myPicture);
        // Ajustamos la dimension de cada boton
       setPreferredSize(new Dimension(x, y));
        setIcon(image);
    }
}