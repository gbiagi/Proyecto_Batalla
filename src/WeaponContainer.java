import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeaponContainer {
    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
    public void createList(int id) throws SQLException {
        //Create arraylist to store the warriors from the bbdd
        //create query and save the results
        ResultSet rsWeapon = BBDDConnection.Connection("SELECT wp.WEAPON_ID,WEAPON_NAME,WEAPON_SPEED,WEAPON_STRENGHT,WEAPON_IMAGE_PATH,WEAPON_POINTS\n" +
                "FROM weapons wp, weapons_available wa where wa.warrior_id="+id+" AND wa.weapon_id = wp.weapon_id;");
        while (rsWeapon.next()) {
            weaponList.add(new Weapon(rsWeapon.getInt(1), rsWeapon.getString(2),
                    rsWeapon.getInt(3), rsWeapon.getInt(4), rsWeapon.getString(5), rsWeapon.getInt(6)));
        }
    }
    public Weapon getWeapon(int num) {
        return weaponList.get(num);
    }

}
