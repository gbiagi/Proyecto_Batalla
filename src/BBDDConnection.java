import java.sql.*;

public class BBDDConnection {
    public static ResultSet connection(String query) {

        String urlDatos = "jdbc:mysql://localhost/BatallaDeRaces?serverTimezone=UTC";
        String usuario = "root";
        String pass = "1234";

        // Pasos a seguir cada vez que queramos usar una base de datos con eclipse

        ResultSet rs = null;
        try {
            // 1. Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver cargado correctamente");
            // 2. Crear conexion con la base de datosw
            Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
            //System.out.println("Conexion creada correctamente");
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
        return rs; // Hacemos return del ResultSet para poder tratar la salida como corresponda.
    }

    public static void insertBattle(int PLAYER_ID, int WARRIOR_ID, int WARRIOR_WEAPON_ID, int OPPONENT_ID,
                             int OPPONENT_WEAPON_ID, int INJURIES_CAUSED,int INJURIES_SUFFERED,int BATTLE_POINTS) {

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
            String update = "INSERT INTO battle (PLAYER_ID, WARRIOR_ID, WARRIOR_WEAPON_ID, OPPONENT_ID, OPPONENT_WEAPON_ID," +
                    " INJURIES_CAUSED, INJURIES_SUFFERED, BATTLE_POINTS) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(update);
            // 5. Ejecutar la consulta

            ps.setInt(1,PLAYER_ID);
            ps.setInt(2,WARRIOR_ID);
            ps.setInt(3,WARRIOR_WEAPON_ID);
            ps.setInt(4,OPPONENT_ID);
            ps.setInt(5,OPPONENT_WEAPON_ID);
            ps.setInt(6,INJURIES_CAUSED);
            ps.setInt(7,INJURIES_SUFFERED);
            ps.setInt(8,BATTLE_POINTS);
            ps.executeUpdate();
            System.out.println("Battle saved!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver no se ha cargado correctamente!!");
        } catch (SQLException e) {
            System.out.println("Conexion no creada correctamente!!");
            e.printStackTrace();
        }
    }
    public static void insertPlayer(String username, int score, int enemiesDefeated) {
        String urlDatos = "jdbc:mysql://localhost/BatallaDeRaces?serverTimezone=UTC";
        String usuario = "root";
        String pass = "1234";

        // Pasos a seguir cada vez que queramos usar una base de datos con eclipse

        ResultSet rs = null;
        try {
            // 1. Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver cargado correctamente");
            // 2. Crear conexion con la base de datosw
            Connection conn = DriverManager.getConnection(urlDatos, usuario, pass);
            //System.out.println("Conexion creada correctamente");
            // 3. Crear una consulta
            //query = "select * from players";
            // 4. Instanciar objeto de la clase consulta
            String update = "INSERT INTO players (PLAYER_NAME, SCORE, ENEMIES_SLAYED) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(update);
            // 5. Ejecutar la consulta

            ps.setString(1,username);
            ps.setInt(2,score);
            ps.setInt(3,enemiesDefeated);
            ps.executeUpdate();
            System.out.println("Player saved!");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver no se ha cargado correctamente!!");
        } catch (SQLException e) {
            System.out.println("Conexion no creada correctamente!!");
            e.printStackTrace();
        }
    }
}
