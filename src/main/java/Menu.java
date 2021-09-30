import warrior.WarriorService;

import java.util.Scanner;

public class Menu {

    private final Arena arena;
    private final WarriorService warriorService;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Arena arena, WarriorService warriorService) {
        this.arena = arena;
        this.warriorService = warriorService;
    }

    public void printMenu() {
        System.out.println("BATTLE ARENA TXT");
        System.out.println("1. Play");
        System.out.println("0. Exit");
        System.out.println();
    }

    public void start() {
        boolean run = true;

        while (run) {
            printMenu();
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    playMenu();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }

    public void printPlayMenu(){
        System.out.println("1. Add new warrior.");
        System.out.println("2. Fight");
        System.out.println("3. Show all warriors");
        System.out.println("0. Back to previous menu.");
        System.out.println();
    }

    public void playMenu() {
        boolean run = true;

        while (run) {
            printPlayMenu();
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    warriorService.saveWarriorToDb();
                    break;
                case 2:
                    arena.fights();
                    break;
                case 3:
                    warriorService.showAllWarriorsFromDb();
                    break;
                case 0:
                    run = false;
                    break;
            }
        }
    }
}