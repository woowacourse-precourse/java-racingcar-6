package racingcar.Controller;


import static racingcar.Controller.Module.Validator.validateInputIsNumber;
import static racingcar.Controller.Module.Validator.validateNameInput;
import static racingcar.View.inputView.displayGameStartMessage;
import static racingcar.View.inputView.displayPlayCountMessage;

import java.util.ArrayList;

public class RaceGame {
    public static ArrayList<String> getCarsName(){
        String CarsNameString = displayGameStartMessage();
        return validateNameInput(CarsNameString);
    }

    public static int getPlayCount(){
        return validateInputIsNumber(displayPlayCountMessage());
    }

    public static String generateDashes(int input){
        return "-".repeat(Math.max(0, input));
    }
}
