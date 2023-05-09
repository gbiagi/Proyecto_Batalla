import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarriorContainer {

    //Create arraylist to store the warriors from the bbdd
    private static ArrayList<Warrior> WarriorList = new ArrayList<Warrior>();
    //create query and save the results
    public static void getWarriors() throws SQLException {
        ResultSet rsWarrior = BBDDConnection.Connection("Select * from warriors;");
        while(rsWarrior.next()){
            WarriorList.add(new Warrior(rsWarrior.getInt(1),rsWarrior.getString(2),rsWarrior.getInt(3),
                    rsWarrior.getInt(4),rsWarrior.getInt(5),rsWarrior.getInt(6),
                    rsWarrior.getInt(7),rsWarrior.getString(8),null,rsWarrior.getInt(9)));
        }
//        for (Warrior i : WarriorList){
//            System.out.println(i.toString());
//        }
    }


}
