public class Arena {

    Warrior warrior1 = new Warrior("Hubert", 100, 8, true);
    Warrior warrior2 = new Warrior("Olgierd", 120, 6, true);


    public void fight() {
        String result;
        boolean alive = true;

        while (warrior1.isAlive() || warrior2.isAlive()) {
            if (warrior1.getHp() > 0 && warrior2.getHp() > 0) {
                warrior1.setHp(warrior1.getHp() - warrior2.getDamage());
                System.out.println(warrior1);
                warrior2.setHp(warrior2.getHp() - warrior1.getDamage());
                System.out.println(warrior2);
            } else if (warrior1.getHp() <= 0) {
                warrior1.setAlive(false);
                System.out.println(warrior2.getName() + ", is winner with: " + warrior2.getHp() + "hp.");
                break;
            } else {
                warrior2.setAlive(false);
                System.out.println(warrior1.getName() + ", is winner with: " + warrior1.getHp() + "hp.");
                break;
            }
        }
    }
}
