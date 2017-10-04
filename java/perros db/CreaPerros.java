import java.sql.*;

// mysql --password=gatito --user=root
public class CreaPerros {

	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "Perracos"; // Era test
		Connection con;
		String createString;
		String driverClassName = "com.mysql.jdbc.Driver";
		createString = "create table perro " 
			+ "(Nombre varchar(50), " 
			+ "Raza varchar(50), " 
			+ "Edad int, " 
			+
		//"imagen LONGBLOB"+
			"Genero varchar(15))";

		Statement stmt;
		try {
			Class.forName(driverClassName);
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			// La contrasenia antes era gatito xD
			con = DriverManager.getConnection(url + dbName, "root", "");
			stmt = con.createStatement();
			stmt.executeUpdate(createString);
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

	}
}
