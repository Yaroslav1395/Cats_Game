package UserInterface;

import Cats.Cats;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private void userActionsPrint(){
        System.out.println("1 - Показать список кошек");
        System.out.println("2 - Добавить кошку");
        System.out.println("3 - Покормить кошку");
        System.out.println("4 - Поиграть с кошкой");
        System.out.println("5 - Отвезти к ветеринару кошку");
        System.out.println("6 - Следующий день");
        System.out.println("7 - Выйти");
    }

    public void doActions(){
        boolean isEnd = false;
        while (!isEnd){
            userActionsPrint();
            int userChooseAction = UserInput.userInputNumber("Выберите действие: ");
            switch (userChooseAction) {
                case 1 -> Cats.printCats();
                case 2 -> Cats.addNewCat();
                case 3 -> Cats.feedTheCat();
                case 4 -> Cats.playWithCat();
                case 5 -> Cats.treadCat();
                case 6 -> Cats.catsStateChange();
                case 7 -> isEnd = true;
            }
        }

    }
}
