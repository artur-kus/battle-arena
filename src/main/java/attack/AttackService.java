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

    public void defineHp(Warrior warrior1, Warrior warrior2, TypeOfAttack attack){
        double damageWhenHit = warrior2.getDamage() * attack.getDamageMultiplier();
        double postAttackDamage = warrior1.getHp() - (damageWhenHit);
        warrior1.setHp(postAttackDamage);
        System.out.println(warrior2.getName() + ", hit " + warrior1.getName() + " and deal him: " + damageWhenHit + " damage. " + warrior1.getName() + " have " +  warrior1.getHp() + " hp.\n");
    }


}