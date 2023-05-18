import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeaponContainer {
    //Creamos una ArrayList para guardar las armas desde la base de datos.
    private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
    public void createList(int id) throws SQLException {
        // Mediante una query y la clase BBDDConnection, guardamos las armas.
        ResultSet rsWeapon = BBDDConnection.connection("SELECT wp.WEAPON_ID,WEAPON_NAME,WEAPON_SPEED,WEAPON_STRENGHT,WEAPON_IMAGE_PATH,WEAPON_POINTS\n" +
                "FROM weapons wp, weapons_available wa where wa.warrior_id="+id+" AND wa.weapon_id = wp.weapon_id;");
        while (rsWeapon.next()) {
            weaponList.add(new Weapon(rsWeapon.getInt(1), rsWeapon.getString(2),
                    rsWeapon.getInt(3), rsWeapon.getInt(4), rsWeapon.getString(5), rsWeapon.getInt(6)));
        }
    }
    public Weapon getWeapon(int num) {
        return weaponList.get(num);
    }

    public ArrayList<Weapon> getList(){
        return weaponList;
    };

}
