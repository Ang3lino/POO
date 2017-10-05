
import java.sql.*;
import java.util.*;

public class PetsDB {
    private String dbname = "pets",
                   user = "root", 
                   pass = "", 
                   url = ("jdbc:mysql://localhost:3306/"+dbname);
    private LinkedList<String> tables = new LinkedList<>(),
                               attributes = new LinkedList<>();

    public PetsDB() {
        tables.add("dogs");
        attributes.add("name");
        attributes.add("breed");
        attributes.add("age");
        attributes.add("gender");

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select * from "+tables.get(0));
            while (result.next()) {
                System.out.println(result.getString(attributes.get(0))+", "+
                    result.getString(attributes.get(1))+", "+
                    result.getString(attributes.get(2))+", "+
                    result.getString(attributes.get(3)));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public static void main (String args[]) {
        new PetsDB();
    }
    
}