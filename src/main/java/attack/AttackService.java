package attack;

import warrior.Warrior;

import java.util.Random;

public class AttackService {

    private final AttackReader attackReader;
    private final Random random = new Random();


    public AttackService(AttackReader attackReader) {
        this.attackReader = attackReader;
    }


    public void chooseAttackAndCalculateChanceToHit(Warrior warrior1, Warrior warrior2) {
        attackReader.getAttackFromUser().ifPresentOrElse(attackReader -> {
            int number = random.nextInt(100);
            if (number > attackReader.getChanceOnAttack()){
                System.out.println("You miss, opponent tour.\n");
            } else if (number < attackReader.getChanceOnAttack()){
                defineHp(warrior1, warrior2, attackReader);
            }
        }, () -> System.out.println(warrior1.getName() + ", was surrender.\n"));
    }

    public void defineHp(Warrior turnWarrior, Warrior otherWarrior, TypeOfAttack attack){
        double damageWhenHit = otherWarrior.getDamage() * attack.getDamageMultiplier();
        double postAttackDamage = turnWarrior.getHp() - (damageWhenHit);
        turnWarrior.setHp(postAttackDamage);
        System.out.println(otherWarrior.getName() + ", hit " + turnWarrior.getName() + " and deal him: " + damageWhenHit + " damage. " + turnWarrior.getName() + " have " +  turnWarrior.getHp() + " hp.\n");
    }


}