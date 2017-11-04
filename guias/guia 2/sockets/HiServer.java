
import java.util.*;
import java.io.*;
import java.net.*;

public class HiServer {

    ServerSocket ss;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    Socket s;

    private void closeShit() throws Exception {
        if (s != null) 
            s.close();
        if (ois != null) 
            ois.close();
        if (oos != null) 
            oos.close();
    }

    public HiServer() throws Exception {
        ss = new ServerSocket(5050);
        s = null;
        ois = null;
        oos = null;
        while (true) {
            System.out.println("Antes");
            s = ss.accept();
            ois = new ObjectInputStream(s.getInputStream());
            System.out.println("Despues");
            oos = new ObjectOutputStream(s.getOutputStream());
            String buf = (String) ois.readObject();
            if (buf == "quit") 
                closeShit();
            oos.writeObject("Hola, mundo");
        }
    }

    public static void main(String[] args) {
        try {
           new HiServer();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
