package Cats;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Cats {
    private List<Cat> cats = new ArrayList<>();

    public Cats() {
        createCats();
    }

    private void createCats(){
        cats = List.of(
                new Cat("Рыжик"),
                new Cat("Чижик"),
                new Cat("Толстяк"),
                new Cat("Демон"),
                new Cat("Пушка")
        );
    }

    public List<Cat> getCats() {
        return new ArrayList<Cat>(this.cats);
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    private List<Cat> sortedCats(){
        return cats.stream()
                .sorted(Comparator.comparing(Cat::calculateAverage).reversed())
                .toList();
    }
    private void printCatsHeader(){
        System.out.printf("%3s  |  %5s    |  %s  |  %s  |  %s  | %s\n",
                "#",
                "Имя",
                "Возраст",
                "Здоровье",
                "Сытость",
                "Настроение");
        System.out.println("------------------------------------------------------------------");
    }
    public void printCats(){
        printCatsHeader();
        List<Cat> sortedCats = sortedCats();
        sortedCats.forEach(cat -> {
            System.out.printf("%3s  |%-2s%-7s  |  %4s     |  %5s     |  %5s    | %5s\n",
                    sortedCats.indexOf(cat) + 1,
                    "",
                    cat.getName(),
                    cat.getAge(),
                    cat.getHealthLevel(),
                    cat.getSatietyLevel(),
                    cat.getMoodLevel());
            System.out.println("------------------------------------------------------------------");
        });
    }
}
