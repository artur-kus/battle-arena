package warrior;

import java.util.List;

public interface WarriorDao {

    void save(Warrior warrior);
    Warrior get(Long id);
    void cleanUp();
    List<Warrior> findAll();
}
