import java.sql.SQLException;

public class Main {
    //private Warrior player;
    private Warrior bot;
    public static void main(String[] args) throws SQLException {
        WarriorContainer iniListWarrior = new WarriorContainer();
        WeaponContainer iniListWeapon = new WeaponContainer();

        iniListWarrior.createList();
        Warrior player = iniListWarrior.getWarrior(8);
        Warrior bot = iniListWarrior.getWarrior((int) (1+Math.random()*iniListWarrior.getList().size()));

        System.out.println(bot.toString());
        System.out.println(player.toString());

        iniListWeapon.createList(player.getId());
        player.setWeapon(iniListWeapon.getWeapon(3));

        iniListWeapon.createList(bot.getId());
        bot.setWeapon(iniListWeapon.getWeapon(2));

        System.out.println("bot = " + bot.toString());
        System.out.println("player = " + player.toString());
    }

}