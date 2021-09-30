package attack;

public enum TypeOfAttack {
    QUICK("70% chance", 70.0, 1.2d), NORMAL("45% chance", 45.0, 1.5d), POWER("25% chance", 25.0, 2.0d);

    private final String description;
    private final Double chanceOnAttack;
    private final Double damageMultiplier;


    TypeOfAttack(String description, double chanceOnAttack, double damageMultiplier) {
        this.description = description;
        this.chanceOnAttack = chanceOnAttack;
        this.damageMultiplier = damageMultiplier;
    }

    public String getDescription() {
        return description;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public double getChanceOnAttack() {
        return chanceOnAttack;
    }
}
