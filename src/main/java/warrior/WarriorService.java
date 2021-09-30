package warrior;

import java.util.List;
import java.util.Scanner;

public class WarriorService {
    private static final String filepath = "src/main/resources/ListOfWarriors.txt";
    private final WarriorDaoImpl warriorDao;

    public WarriorService(WarriorDaoImpl warriorDao) {
        this.warriorDao = warriorDao;
    }


//    public List<Warrior> addWarriorToList() {
//        List<Warrior> warriors = new ArrayList<>();
//        warriors.add(Warrior.fromUserInput());
//        return warriors;
//    }

    //    public void saveObjectToFile(List<Warrior> warriors) {
//        int index = warriors.size() - 1;
//
//        try {
//            var fileWriter = new FileWriter(filepath, true);
//            var writer = new BufferedWriter(fileWriter);
//            writer.write(String.valueOf(warriors.get(index)));
//            writer.write("\n");
//            writer.close();
//
//        } catch (IOException e) {
//            System.out.println("List with warriors doesn't exist.");
//        }
//        System.out.println("Warrior " + warriors.get(index).getName() + ", has been saved.\n");
//    }

    public void saveWarriorToDb() {
        Warrior warrior = Warrior.fromUserInput();
        WarriorDao warriorDao = new WarriorDaoImpl();
        warriorDao.save(warrior);
        warriorDao.cleanUp();
        System.out.println("Warrior " + warrior.getName() + ", saved.");
    }

    public void showAllWarriorsFromDb() {
       List<Warrior> list = warriorDao.findAll();
        System.out.println("LIST OF WARRIORS:");
        for (Warrior warrior : list) {
            int index = list.indexOf(warrior) + 1;
            System.out.printf("%d. %s\n", index, warrior.toString());
        }
    }

    public Warrior selectWarrior(){
        showAllWarriorsFromDb();
        System.out.println("\nChoose your warrior: ");
        Scanner scanner = new Scanner(System.in);
        Long out = scanner.nextLong();
        System.out.println("You choose: " +  warriorDao.get(out));
        return warriorDao.get(out);
    }


}
