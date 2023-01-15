package Cats;

import UserInterface.UserInput;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Cats {
    private static List<Cat> cats = new ArrayList<>();

    static {
        createCats();
    }

    private static void createCats(){
        cats.add(new Cat("Рыжик"));
        cats.add(new Cat("Чижик"));
        cats.add(new Cat("Толстяк"));
        cats.add(new Cat("Демон"));
        cats.add(new Cat("Пушка"));
    }

    public List<Cat> getCats() {
        return new ArrayList<>(cats);
    }

    public void setCats(List<Cat> cats) {
        Cats.cats = cats;
    }

    private static List<Cat> sortedCats(){
        return cats.stream()
                .sorted(Comparator.comparing(Cat::calculateAverage).reversed())
                .toList();
    }
    private static void printCatsHeader(){
        System.out.printf("%3s  |  %5s    |  %s  |  %s  |  %s  | %s\n",
                "#",
                "Имя",
                "Возраст",
                "Здоровье",
                "Сытость",
                "Настроение");
        System.out.println("------------------------------------------------------------------");
    }
    public static void printCats(){
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

    public static void addNewCat(){
        String catName = UserInput.userInputString("Введите имя кошки: ");
        int catAge = UserInput.userInputNumber("Введите возраст кошки: ");
        cats.add(new Cat(catName, catAge));
    }

    public static void feedTheCat(){
        String catName = UserInput.userInputString("Введите имя кошки: ");
        try{
            cats.stream().filter(cat -> cat.getName().equals(catName)).findFirst().get().feedTheCat();
        }catch (NoSuchElementException e){
            System.out.println("Такой кошки нет. Попробуйте снова");
            feedTheCat();
        }
        checkHealthLevelToDelete();
    }
    public static void playWithCat(){
        String catName = UserInput.userInputString("Введите имя кошки: ");
        try{
            cats.stream().filter(cat -> cat.getName().equals(catName)).findFirst().get().playWithCat();
        }catch (NoSuchElementException e){
            System.out.println("Такой кошки нет. Попробуйте снова");
            feedTheCat();
        }
        checkHealthLevelToDelete();
        checkSatietyLevelToDelete();
    }
    public static void treadCat(){
        String catName = UserInput.userInputString("Введите имя кошки: ");
        try{
            cats.stream().filter(cat -> cat.getName().equals(catName)).findFirst().get().treatCat();
        }catch (NoSuchElementException e){
            System.out.println("Такой кошки нет. Попробуйте снова");
            feedTheCat();
        }
    }

    public static void catsStateChange(){
        System.out.println("Прошел день");
        cats.forEach(cat -> cat.catStateChange());
        cats.forEach(cat -> cat.catStrategyPerformedReset());
    }

    private static void checkHealthLevelToDelete(){
        List<Cat> catsToRemove = cats.stream().filter(cat -> cat.getHealthLevel() <= 0).toList();
        for (Cat cat: cats) {
            System.out.printf("%s умерла", cat.getName());
        }
        cats.removeAll(catsToRemove);
    }
    private static void checkSatietyLevelToDelete(){
        List<Cat> catsToRemove = cats.stream().filter(cat -> cat.getSatietyLevel() <= -20).toList();
        for (Cat cat: cats) {
            System.out.printf("%s умерла", cat.getName());
        }
        cats.removeAll(catsToRemove);
    }

}
