package attack;

import java.util.*;

public class AttackReader {

    private List<TypeOfAttack> getListOfAttacks() {
        List<TypeOfAttack> list = new ArrayList<>(Arrays.stream(TypeOfAttack.values()).toList());
        return list;
    }

    private void printAttack(List<TypeOfAttack> list) {
        for (TypeOfAttack attack : list) {
           int index = list.indexOf(attack) + 1;
            System.out.format("%d. %s\n", index, attack.name() + " - " + attack.getDescription());
        }
        System.out.println();
    }

    private int getNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public Optional<TypeOfAttack> getAttackFromUser() {
        System.out.println("SELECT ATTACK: ");
        List<TypeOfAttack> list = getListOfAttacks();
        printAttack(list);
        System.out.println("0. To Surrender.");
       int number = getNumberFromUser();

        if (number == 0) {
            return Optional.empty();
        }
        if (number > getListOfAttacks().size() || number < 1) {
            System.out.println("Number is out of range.");
            return Optional.empty();
        }
        TypeOfAttack typeOfAttackFromUser = list.get(number - 1);
       return Optional.of(typeOfAttackFromUser);
    }

}