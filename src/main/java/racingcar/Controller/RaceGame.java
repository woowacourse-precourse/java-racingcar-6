package racingcar.Controller;


import static racingcar.Controller.Module.Validator.validateNameInput;
import static racingcar.View.inputView.displayGameStartMessage;

import java.util.ArrayList;

public class RaceGame {
    public static ArrayList<String> getCarsName(){
        String CarsNameString = displayGameStartMessage();
        return validateNameInput(CarsNameString);
    }

}
