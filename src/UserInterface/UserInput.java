package UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public static String userInputString(String massage){
        System.out.print(massage);
        Scanner scanner = new Scanner(System.in);
        String userInput;
        try {
            userInput = scanner.nextLine();

            if(!(isNumericDouble(userInput)) && !(isNumericInt(userInput))){
                return userInput;
            }else {
                throw new NumberFormatException();
            }
        }catch (NumberFormatException e){
            System.out.println("Ввели цифру вместо строки. Попробуйте снова");
            userInput = userInputString(massage);
        }
        return userInput;
    }

    public static int userInputNumber(String massage){
        System.out.print(massage);
        Scanner scanner = new Scanner(System.in);
        int userNumber;
        try {
            userNumber = scanner.nextInt();
            return userNumber;
        } catch (ClassCastException | InputMismatchException e){
            System.out.println("Ввели дробное число или строку. Попробуйте снова");
            userNumber = userInputNumber(massage);
        }
        return userNumber;
    }

    public static boolean isNumericInt(String string){
        try{
            Integer.parseInt(string);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    public static boolean isNumericDouble(String string){
        try{
            Double.parseDouble(string);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
