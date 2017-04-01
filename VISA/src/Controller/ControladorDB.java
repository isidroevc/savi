
package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
 public class ControladorDB {
    public static Connection getConexion(){
        //primero hay que verificar que si esta el controlador de la base de datos
        Connection connection = null;
        try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		return null;
	}
	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/agencia","root", "");

	} catch (SQLException e) {
		return null;
	}
        return connection;
    }
}
