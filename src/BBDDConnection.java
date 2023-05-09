import java.sql.*;

public class BBDDConnection {
    public static ResultSet Connection(String query) {

        String urlDatos = "jdbc:mysql://localhost/BatallaDeRaces?serverTimezone=UTC";
        String usuario = "root";
        String pass = "1234";

        // Pasos a seguir cada vez que queramos usar una base de datos con eclipse

        ResultSet rs = null;
        try {
            // 1. Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente");
            // 2. Crear conexion con la base de datosw
            Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
            System.out.println("Conexion creada correctamente");
            // 3. Crear una consulta
            //query = "select * from players";
            // 4. Instanciar objeto de la clase consulta
            Statement stmnt = conn.createStatement();
            // 5. Ejecutar la consulta
            rs = stmnt.executeQuery(query);
            // Muestra los resultados por pantalla

        } catch (ClassNotFoundException e) {
            System.out.println("Driver no se ha cargado correctamente!!");
        } catch (SQLException e) {
            System.out.println("Conexion no creada correctamente!!");
            e.printStackTrace();
        }
        return rs;
    }
}
