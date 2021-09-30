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

    public void fightBanner(){
        System.out.println("  __ _       _     _       _ \n" +
                " / _(_) __ _| |__ | |_    / \\\n" +
                "| |_| |/ _` | '_ \\| __|  /  /\n" +
                "|  _| | (_| | | | | |_  /\\_/ \n" +
                "|_| |_|\\__, |_| |_|\\__| \\/   \n" +
                "       |___/                 \n");
    }

    public void fights() {
        Warrior turnWarrior = warriorService.selectWarrior();
        Warrior otherWarrior = warriorService.selectWarrior();
        System.out.println();
        fightBanner();
        while (true) {
            turn(turnWarrior, otherWarrior);
            if(checkGameOver(turnWarrior, otherWarrior)) break;
            turn(otherWarrior, turnWarrior);
            if(checkGameOver(turnWarrior, otherWarrior)) break;
//            if (attackReader.getAttackFromUser().isEmpty()) {
//                System.out.println("Surrender");
//                break;
//            }
            whenWarriorIsDeath(warrior1, warrior2);
        }
    }

    public void whenWarriorIsDeath(Warrior turnWarrior, Warrior otherWarrior) {
        if (turnWarrior.getHp() <= 0) {
            turnWarrior.setAlive(false);
            System.out.println("\n" + otherWarrior.getName() + " is win a battle with " + otherWarrior.getHp() + "hp.\n");
        } else if (otherWarrior.getHp() <= 0) {
            otherWarrior.setAlive(false);
            System.out.println("\n" + turnWarrior.getName() + " is win a battle with " + turnWarrior.getHp() + "hp.\n");
        }
    }
}


