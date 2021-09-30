import attack.AttackReader;
import attack.AttackService;
import warrior.Warrior;
import warrior.WarriorService;

public class Arena {
    private final AttackReader attackReader;
    private final WarriorService warriorService;
    private final AttackService attackService;

    public Arena(AttackReader attackReader, WarriorService warriorService, AttackService attackService) {
        this.attackReader = attackReader;
        this.warriorService = warriorService;
        this.attackService = attackService;
    }

//    public void fight() {
//        Warrior warrior1 = warriorService.selectWarrior();
//        Warrior warrior2 = warriorService.selectWarrior();
//        while (warrior1.isAlive() || warrior2.isAlive()) {
//            if (warrior1.getHp() > 0 && warrior2.getHp() > 0) {
//                warrior1.setHp(warrior1.getHp() - warrior2.getDamage());
//                System.out.println(warrior1);
//                warrior2.setHp(warrior2.getHp() - warrior1.getDamage());
//                System.out.println(warrior2);
//            } else if (warrior1.getHp() <= 0) {
//                warrior1.setAlive(false);
//                System.out.println(warrior2.getName() + ", is winner with: " + warrior2.getHp() + "hp.");
//                break;
//            } else {
//                warrior2.setAlive(false);
//                System.out.println(warrior1.getName() + ", is winner with: " + warrior1.getHp() + "hp.\n");
//                break;
//            }
//        }
//    }

    public void fightBanner(){
        System.out.println("  __ _       _     _       _ \n" +
                " / _(_) __ _| |__ | |_    / \\\n" +
                "| |_| |/ _` | '_ \\| __|  /  /\n" +
                "|  _| | (_| | | | | |_  /\\_/ \n" +
                "|_| |_|\\__, |_| |_|\\__| \\/   \n" +
                "       |___/                 \n");
    }

    public void fights() {
        Warrior warrior1 = warriorService.selectWarrior();
        Warrior warrior2 = warriorService.selectWarrior();
        System.out.println();
        fightBanner();
        System.out.println("Turn: " + warrior2);
        System.out.println("      " + warrior1);
        while (warrior1.getHp() > 0 && warrior2.getHp() > 0) {
            attackService.chooseAttackAndCalculateChanceToHit(warrior1, warrior2);
            System.out.println("Turn: " + warrior1);
            System.out.println("      " + warrior2);
            attackService.chooseAttackAndCalculateChanceToHit(warrior2, warrior1);
            System.out.println("Turn: " + warrior2);
            System.out.println("      " + warrior1);
//            if (attackReader.getAttackFromUser().isEmpty()) {
//                System.out.println("Surrender");
//                break;
//            }
            whenWarriorIsDeath(warrior1, warrior2);
        }
    }

    public void whenWarriorIsDeath(Warrior warrior1, Warrior warrior2) {
        if (warrior1.getHp() <= 0) {
            warrior1.setAlive(false);
            System.out.println("\n" + warrior2.getName() + " is win a battle with " + warrior2.getHp() + "hp.\n");
        } else if (warrior2.getHp() <= 0) {
            warrior2.setAlive(false);
            System.out.println("\n" + warrior1.getName() + " is win a battle with " + warrior1.getHp() + "hp.\n");
        }
    }
}


