
// Problema 1.- Codificar un servidor que cuando un cliente se conecte le envie la cadena "Hola Mundo"

import java.util.*;
import java.io.*;
import java.net.Socket;

public class HiClient {

    public static void main(String[] args) throws Exception {
        Socket s = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            s = new Socket("localhost", 5050);
            ois = new ObjectInputStream(s.getInputStream());
            oos = new ObjectOutputStream(s.getOutputStream());
            System.out.println("antes");
            oos.writeObject("Angel");
            System.out.println("despues");
            System.out.println((String) ois.readObject());
            if (s != null)
                s.close();
            if (ois != null)
                ois.close();
            if (oos != null)
                oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
