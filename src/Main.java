import java.sql.SQLException;

public class Main {
    //private Warrior player;
    private Warrior bot;
    public static void main(String[] args) throws SQLException {
        Warrior player;

//        WarriorContainer iniListWarrior = new WarriorContainer();
//        WeaponContainer iniListWeapon = new WeaponContainer();
//
//        iniListWarrior.createList();
//        iniListWeapon.createList(1);
        WarriorsFrame selectWarrior = new WarriorsFrame();
        player = selectWarrior.getWarrior();
        System.out.println(player.toString());

        //System.out.println(selectWarrior.getWarrior()+"********");

        //new WeaponsFrame();

//
//        Warrior bot = iniListWarrior.getWarrior((int) (1+Math.random()*iniListWarrior.getList().size()));
//
//        System.out.println(bot.toString());
//        System.out.println(player.toString());
//
//        iniListWeapon.createList(player.getId());
//        player.setWeapon(iniListWeapon.getWeapon(3));
//
//        iniListWeapon.createList(bot.getId());
//        bot.setWeapon(iniListWeapon.getWeapon(2));
//
//        System.out.println("bot = " + bot.toString());
//        System.out.println("player = " + player.toString());

        //WeaponsFrame frame1 = new WeaponsFrame();
    }

}