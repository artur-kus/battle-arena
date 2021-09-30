package warrior;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Scanner;

@Entity
@Data
public class Warrior implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double hp;
    private double damage;
    private boolean alive;

    public Warrior(String name, double hp, double damage, boolean alive) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.alive = alive;
    }

    public static Warrior fromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("State your health: ");
        Double hp = scanner.nextDouble();
        System.out.println("Enter your damage: ");
        Double damage = scanner.nextDouble();
        return new Warrior(name, hp, damage, true);
    }

    @Override
    public String toString() {
        return name + ", hp: " + hp + ", damage: " + damage;
    }
}
