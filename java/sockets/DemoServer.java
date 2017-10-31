
import java.io.*;
import java.net.*;
import java.util.*;

public class DemoServer {

    // javac -cp . DemoServer.java // cp hace referencia a class path
    // java -cp . DemoServer 

    // javac -cp . DemoClient.java
    // java -cp . DemoClient
    // cmd en ESCOM 

    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        ServerSocket ss = new ServerSocket(5050);
        Socket s = null;
        try {
            s = ss.accept();
            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            String name = (String) ois.readObject();
            String greet = "" + new Date();
            //     greet = "Hello! "+name;
            oos.writeObject(greet);
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (oos != null)
                oos.close();
            if (ois != null)
                ois.close();
            if (s != null)
                s.close();
            System.out.println("Connection closed");
        }
    }
}
