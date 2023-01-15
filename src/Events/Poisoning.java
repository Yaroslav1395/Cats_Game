package Events;

import Cats.Cat;

public class Poisoning implements Eventable{
    @Override
    public void realizeEvent(Cat cat) {
        System.out.printf("Кошка по имени %s возрастом %s лет отравилась\n",
                cat.getName(), cat.getAge());
        cat.setSatietyLevel(cat.getSatietyLevel() - 30);
        cat.setMoodLevel(cat.getMoodLevel() - 30);
        cat.setHealthLevel(cat.getHealthLevel() - 30);
    }
}
