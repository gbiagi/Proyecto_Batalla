import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.logging.SocketHandler;

public class PruebaBBDD {
    public static void main(String[] args) throws SQLException {
        ResultSet rs1 = BBDDConnection.Connection("Select * from players");
        while (rs1.next()) {
            System.out.println("ID="+rs1.getInt(1)+"  Nombre="+rs1.getString(2)+"  Score="+rs1.getInt(3)+"  Enemies Slayed="+rs1.getInt(4));
    }
}
}
