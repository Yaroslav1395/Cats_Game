package UserInterface;

import Cats.*;
import FileService.FileService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class UserInterface {
    private Cats cats = new Cats();

    public UserInterface() {
    }

    public Cats getCats() {
        return cats;
    }

    public void setCats(Cats cats) {
        this.cats = cats;
    }

    private void userActionsPrint(){
        System.out.println("1 - Показать список кошек");
        System.out.println("2 - Добавить кошку");
        System.out.println("3 - Покормить кошку");
        System.out.println("4 - Поиграть с кошкой");
        System.out.println("5 - Отвезти к ветеринару кошку");
        System.out.println("6 - Следующий день");
        System.out.println("7 - Сохранить файл");
        System.out.println("8 - Считать файл");
        System.out.println("9 - Сортировать список кошек");
        System.out.println("10 - Выйти");
    }
    private void userSortActionPrint(){
        System.out.println("1 - Сортировать по среднему показателю");
        System.out.println("2 - Сортировать по имени");
        System.out.println("3 - Сортировать по возрасту");
        System.out.println("4 - Сортировать по уровню здоровья");
        System.out.println("5 - Сортировать по уровню сытости");
        System.out.println("6 - Сортировать по уровню настроения");
        System.out.println("7 - Выход");
    }

    public void doSortActions(){
        Map<Integer, Supplier<Boolean>> sortActions = new HashMap<>();
        sortActions.put(1, () -> {cats.sortedCatsByAverage(); return false;});
        sortActions.put(2, () -> {cats.sortedCatsByName(); return false;});
        sortActions.put(3, () -> {cats.sortedCatsByAge(); return false;});
        sortActions.put(4, () -> {cats.sortedCatsByHealthLevel(); return false;});
        sortActions.put(5, () -> {cats.sortedCatsBySatietyLevel(); return false;});
        sortActions.put(6, () -> {cats.sortedCatsByMoodLevel(); return false;});
        sortActions.put(7, () -> {return true;});
        boolean isEnd = false;

        while (!isEnd){
            userSortActionPrint();
            int userChooseAction = UserInput.userInputNumber("Выберите действие: ");
            isEnd = Optional.ofNullable(sortActions.get(userChooseAction)).orElse(() -> false).get();
        }
    }

    public void doActions(){
        Map<Integer, Supplier<Boolean>> actions = new HashMap<>();
        actions.put(1, () -> {cats.printCats(cats.getCats()); return false;});
        actions.put(2, () -> {cats.addNewCat(); return false;});
        actions.put(3, () -> {cats.feedTheCat(); return false;});
        actions.put(4, () -> {cats.playWithCat(); return false;});
        actions.put(5, () -> {cats.treadCat(); return false;});
        actions.put(6, () -> {cats.catsStateChange(); return false;});
        actions.put(7, () -> {FileService.writeJson(cats, "Cats.json"); return false;});
        actions.put(8, () -> {cats = FileService.readJsonFile("Cats.json"); return false;});
        actions.put(9, () -> {doSortActions(); return false;});
        actions.put(10, () -> { return true;});
        boolean isEnd = false;

        while (!isEnd){
            userActionsPrint();
            int userChooseAction = UserInput.userInputNumber("Выберите действие: ");
            isEnd = Optional.ofNullable(actions.get(userChooseAction)).orElse(() -> false).get();
        }
    }
}
