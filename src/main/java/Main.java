import attack.AttackReader;
import attack.AttackService;
import warrior.WarriorDaoImpl;
import warrior.WarriorService;

public class Main {

    public static void main(String[] args) {
        AttackReader attackReader = new AttackReader();
        WarriorDaoImpl warriorDao = new WarriorDaoImpl();
        WarriorService warriorService = new WarriorService(warriorDao);
        AttackService attackService = new AttackService(attackReader);
        Arena arena = new Arena(attackReader, warriorService, attackService);
        Menu menu = new Menu(arena, warriorService);
        menu.start();
    }

}
