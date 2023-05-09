import java.sql.SQLException;

public class Main {
    //private Warrior player;
    private Warrior bot;
    public static void main(String[] args) throws SQLException {
        WarriorContainer iniListWarrior = new WarriorContainer();
        WeaponContainer iniListWeapon = new WeaponContainer();

        iniListWarrior.createList();
        Warrior player = iniListWarrior.getWarrior(8);
        System.out.println(player.toString());

        iniListWeapon.createList(player.getId());
    }

}