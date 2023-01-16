package Cats;

import UserInterface.UserInput;

import java.util.*;


public class Cats {
    private List<Cat> cats = new ArrayList<>();

    public Cats() {
        createCats();
    }

    private void createCats(){
        cats.add(new Cat("Рыжик"));
        cats.add(new Cat("Чижик"));
        cats.add(new Cat("Толстяк"));
        cats.add(new Cat("Демон"));
        cats.add(new Cat("Пушка"));
    }

    public List<Cat> getCats() {
        return new ArrayList<>(cats);
    }

    public void setCats(List<Cat> cats) {this.cats = cats;
    }

    public void sortedCatsByAverage(){
        List<Cat> sortedByAverage =  cats.stream()
                .sorted(Comparator.comparing(Cat::calculateAverage).reversed())
                .toList();
        printCats(sortedByAverage);
    }

    public void sortedCatsByAge(){
        List<Cat> sortedByAverage =  cats.stream()
                .sorted(Comparator.comparing(Cat::getAge).reversed())
                .toList();
        printCats(sortedByAverage);
    }
    public void sortedCatsByName(){
        List<Cat> sortedByAverage =  cats.stream()
                .sorted(Comparator.comparing(Cat::getName).reversed())
                .toList();
        printCats(sortedByAverage);
    }
    public void sortedCatsBySatietyLevel(){
        List<Cat> sortedByAverage =  cats.stream()
                .sorted(Comparator.comparing(Cat::getSatietyLevel).reversed())
                .toList();
        printCats(sortedByAverage);
    }
    public void sortedCatsByMoodLevel(){
        List<Cat> sortedByAverage =  cats.stream()
                .sorted(Comparator.comparing(Cat::getMoodLevel).reversed())
                .toList();
        printCats(sortedByAverage);
    }
    public void sortedCatsByHealthLevel(){
        List<Cat> sortedByAverage =  cats.stream()
                .sorted(Comparator.comparing(Cat::getHealthLevel).reversed())
                .toList();
        printCats(sortedByAverage);
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

    public void printCats(List<Cat> cats){
        printCatsHeader();
        cats.forEach(cat -> {
            System.out.printf("%3s  |%-2s%-7s  |  %4s     |  %5s     |  %5s    | %5s\n",
                    cats.indexOf(cat) + 1,
                    "",
                    cat.getName(),
                    cat.getAge(),
                    cat.getHealthLevel(),
                    cat.getSatietyLevel(),
                    cat.getMoodLevel());
            System.out.println("------------------------------------------------------------------");
        });
    }

    public void addNewCat(){
        String catName = UserInput.userInputString("Введите имя кошки: ");
        int catAge = UserInput.userInputNumber("Введите возраст кошки: ");
        cats.add(new Cat(catName, catAge));
    }

    public void feedTheCat(){
        String catName = UserInput.userInputString("Введите имя кошки: ");
        try{
            cats.stream().filter(cat -> cat.getName().equals(catName)).findFirst().get().feedTheCat();
        }catch (NoSuchElementException e){
            System.out.println("Такой кошки нет. Попробуйте снова");
            feedTheCat();
        }
        checkHealthLevelToDelete();
        checkSatietyLevelToDelete();
    }
    public void playWithCat(){
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
    public void treadCat(){
        String catName = UserInput.userInputString("Введите имя кошки: ");
        try{
            cats.stream().filter(cat -> cat.getName().equals(catName)).findFirst().get().treatCat();
        }catch (NoSuchElementException e){
            System.out.println("Такой кошки нет. Попробуйте снова");
            feedTheCat();
        }
    }

    public void catsStateChange(){
        System.out.println("Прошел день");
        cats.forEach(cat -> cat.catStateChange());
        cats.forEach(cat -> cat.catStrategyPerformedReset());
    }

    private void checkHealthLevelToDelete(){
        List<Cat> catsToRemove = cats.stream().filter(cat -> cat.getHealthLevel() <= 0).toList();
        for (Cat cat: catsToRemove) {
            System.out.printf("%s погибла\n", cat.getName());
        }
        cats.removeAll(catsToRemove);
    }
    private void checkSatietyLevelToDelete(){
        List<Cat> catsToRemove = cats.stream().filter(cat -> cat.getSatietyLevel() <= -20).toList();
        for (Cat cat: catsToRemove) {
            System.out.printf("%s погибла\n", cat.getName());
        }
        cats.removeAll(catsToRemove);
    }

}
