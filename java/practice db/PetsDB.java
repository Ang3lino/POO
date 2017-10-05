
import java.sql.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class PetsDB {
    private String dbname = "pets",
                   user = "root", 
                   pass = "", 
                   url = ("jdbc:mysql://localhost:3306/"+dbname);
    private LinkedList<String> tables = new LinkedList<>(),
                               attributes = new LinkedList<>(); 
    private LinkedList<Object> values = new LinkedList<>();
    Connection connection;
    Statement statement;
    ResultSet result;

    public PetsDB() {
        tables.add("dogs");
        attributes.add("name");
        attributes.add("breed");
        attributes.add("age");
        attributes.add("gender");

        values.add("pika");
        values.add("pikacho");
        values.add(99);
        values.add("hembra");

        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            insertElements();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void insertElements() throws Exception {
        String insert = "insert into "+tables.get(0)+"(";
        for (int i = 0; i < attributes.size(); i++) {
            insert += attributes.get(i);
            if (i == attributes.size() - 1)
                break;
            insert += ", ";
        }
        insert += ") values(";
        for (int i = 0; i < values.size(); i++) {
            insert += values.get(i);
            if (i == values.size() - 1)
                break;
            insert += ", ";
        }
        insert += ");";
        System.out.printf("%s", insert);
        //statement.executeUpdate(insert);
    }

    public void showAttributes() throws Exception {
        result = statement.executeQuery("select * from "+tables.get(0));
        while (result.next()) {
            System.out.println(result.getString(attributes.get(0))+", "+
                result.getString(attributes.get(1))+", "+
                result.getString(attributes.get(2))+", "+
                result.getString(attributes.get(3)));
        }
    }

    public static void main (String args[]) {
        new PetsDB();
    }
    
}