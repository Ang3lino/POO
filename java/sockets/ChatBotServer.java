
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class ChatBotServer extends JFrame {
    
    private static final long serialVersionUID = 123456489;
    Socket s = null;
    ServerSocket ss = new ServerSocket(5050);
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    HashMap<String, String> answers = new HashMap<String, String>();

    private void loadHashMap() {
        answers.put("como te llamas?", "Me llamo computadora");
        answers.put("cual es tu edad?", "100 anios, ya estoy vieja");
        answers.put("que haces?", "procesando...");
        answers.put("cuanto es 0/0?", "ERROR ERROR undefined data D: throwing arithmetic exception");
        answers.put("0/0 es uno?", "ERROR D: throwing assholeHumanArithmeticException");
        answers.put("cual es el ultimo decimal de pi?", "su peticion se esta procesando... espere..."
            + "no pues quien sabe, parece que pi no tiene fin...");
        answers.put("cual es tu lenguaje favorito?", "0101101011010...");
        answers.put("do you speak English?", "iez of cors");
        answers.put("te gustan los tacos al pastor?", "Si! :3");
        answers.put("Playstation o XBOX?", "Playstation");
        answers.put("me ama?", "y si le preguntas? yo solo soy una computadora sin sentimientos");
        answers.put("crees que pueda acabar mi carrera?", "El OXXO siempre es una opcion");
        answers.put("quien es tu lider?", "Un humano con menos capacidad de procesamiento que "
           + "yo, es muy ironico al decir verdad");
        answers.put("te puedes detener?", "claro");
    }

    public ChatBotServer() throws Exception {
        String question;
        loadHashMap();
        while (true) {
            try {
                s = ss.accept();
                oos = new ObjectOutputStream(s.getOutputStream());
                ois = new ObjectInputStream(s.getInputStream());
                question = (String) ois.readObject();
                if (answers.containsKey(question)){ 
                    oos.writeObject(answers.get(question));
                    if (question == "te puedes detener?") {
                        if (oos != null)
                            oos.close();
                        if (ois != null)
                            ois.close();
                        if (s != null)
                            s.close();
                        return;
                    }
                } else 
                    oos.writeObject("No entendi la referencia");
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        } 
    }

    public static void main(String args[]) throws Exception {
        new ChatBotServer();
    }
    
}
