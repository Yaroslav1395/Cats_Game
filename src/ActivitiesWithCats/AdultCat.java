package ActivitiesWithCats;

import Cats.Cat;
import Events.Events;

import java.util.Random;

public class AdultCat implements Activable{
    private final int reduce = 5;
    private final int increase = 5;
    private boolean isPerformed;
    private final Random random = new Random();

    public void setPerformed(boolean performed) {
        isPerformed = performed;
    }

    @Override
    public void feedTheCat(Cat cat) {
        int randomNumber = random.nextInt(5) + 1;

        if(!isPerformed && randomNumber == 1){
            Events.eventRealize(1, cat);
            isPerformed = true;
        } else if (!isPerformed) {
            System.out.printf("Вы покормили кошку по имени %s возрастом %s лет\n",
                    cat.getName(), cat.getAge());
            cat.setSatietyLevel(cat.getSatietyLevel() + reduce);
            cat.setMoodLevel(cat.getMoodLevel() + reduce);
            isPerformed = true;
        }else {
            System.out.printf("Вы уже кормили кошку по имени %s возрастом %s лет\n",
                    cat.getName(), cat.getAge());
        }
    }

    @Override
    public void playWithCat(Cat cat) {
        int randomNumber = random.nextInt(2) + 1;

        if(!isPerformed && randomNumber == 1){
            Events.eventRealize(1, cat);
            isPerformed = true;
        } else if (!isPerformed) {
            System.out.printf("Вы поиграли с кошкой по имени %s возрастом %s лет\n",
                    cat.getName(), cat.getAge());
            cat.setHealthLevel(cat.getHealthLevel() + reduce);
            cat.setMoodLevel(cat.getMoodLevel() + reduce);
            cat.setSatietyLevel(cat.getSatietyLevel() - increase);
            isPerformed = true;
        }else {
            System.out.printf("Вы уже играли с кошкой по имени %s возрастом %s лет\n",
                    cat.getName(), cat.getAge());
        }
    }

    @Override
    public void treatCat(Cat cat) {
        if(!isPerformed){
            System.out.printf("Вы отвезли к ветеринару кошку по имени %s возрастом %s лет\n",
                    cat.getName(), cat.getAge());
            cat.setHealthLevel(cat.getHealthLevel() + reduce);
            cat.setMoodLevel(cat.getMoodLevel() - increase);
            cat.setSatietyLevel(cat.getSatietyLevel() - increase);
            isPerformed = true;
        }else {
            System.out.printf("Вы уже отвозили к ветеринару кошку по имени %s возрастом %s лет\n",
                    cat.getName(), cat.getAge());
        }
    }
}
