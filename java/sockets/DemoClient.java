
import java.io.*;
import java.net.*;

public class DemoClient {

    public static void main(String[] args) throws Exception {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        Socket s = null;
        try {
            s = new Socket("localhost", 5050);
            oos = new ObjectOutputStream(s.getOutputStream());
            ois = new ObjectInputStream(s.getInputStream());
            oos.writeObject("Angel");
            String ret = (String) ois.readObject();
            System.out.println(ret);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null)
                oos.close();
            if (ois != null)
                ois.close();
            if (s != null)
                s.close();
        }
    }
}