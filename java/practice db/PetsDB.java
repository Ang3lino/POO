
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

    private void fillLists() {
        tables.add("dogs");
        attributes.add("name");
        attributes.add("breed");
        attributes.add("age");
        attributes.add("gender");
    }

    public PetsDB() {
        fillLists();
        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public PetsDB(String _user, String _pass, String _url) {
        fillLists();
        user = _user;
        pass = _pass;
        url = _url+dbname;
        try {
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void insertValues(LinkedList<Object> values) throws Exception {
        String insert = "insert into "+tables.get(0)+"(";
        for (int i = 0; i < attributes.size(); i++) {
            insert += attributes.get(i);
            if (i == attributes.size() - 1)
                break;
            insert += ", ";
        }
        insert += ") values(";
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) instanceof String) {
                insert += "'";
                insert += values.get(i);
                insert += "'";
            } else if (values.get(i) instanceof Integer)
                insert += values.get(i);
            if (i == values.size() - 1)
                break;
            insert += ", ";
        }
        insert += ");";
        System.out.printf("%s", insert);
        statement.executeUpdate(insert);
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
    
}