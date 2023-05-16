import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarriorContainer {
    //Creamos una ArrayList para guardar los personajes desde la base de datos.
    private ArrayList<Warrior> warriorList = new ArrayList<Warrior>();

    public void createList() throws SQLException {
        // Mediante una query y la clase BBDDConnection, guardamos los personajes.
        ResultSet rsWarrior = BBDDConnection.connection("Select * from warriors;");
        while (rsWarrior.next()) {
            warriorList.add(new Warrior(rsWarrior.getInt(1), rsWarrior.getString(2), rsWarrior.getInt(3),
                    rsWarrior.getInt(4), rsWarrior.getInt(5), rsWarrior.getInt(6),
                    rsWarrior.getInt(7), rsWarrior.getString(8), null, rsWarrior.getInt(9)));
            }
        }
    public Warrior getWarrior(int num) {
        return warriorList.get(num);
    }

    public ArrayList<Warrior> getList(){
        return warriorList;
    };

}
