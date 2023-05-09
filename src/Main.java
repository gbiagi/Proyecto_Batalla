import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Warrior w1 = new Warrior(1,"Celebrimbor",40,4,7,7,2,"./M03_Programacio/WarriorsImages/elf/elf1.jpg",null,19);
//        Warrior w2 = new Warrior(2,"Glorfindel",40,4,7,7,2,"./M03_Programacio/WarriorsImages/elf/elf2.jpg",null,19);

        WarriorContainer.getWarriors();
    }
}