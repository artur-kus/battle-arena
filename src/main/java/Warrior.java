import lombok.Data;

@Data
public class Warrior {
    private String name;
    private int hp;
    private int damage;
    private TypeOfAttack typeOfAttack;
    private boolean alive;

    public Warrior(String name, int hp, int damage, boolean alive) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.alive = alive;
    }
}
