package controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import view.InputView;
import model.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import validator.InputValidator;

public class CarRace {
    private List<Car> cars = new ArrayList<Car>();
    private InputValidator inputValidator = new InputValidator();

    private String getCarNameByInput() {
        InputView.printUserInputCarNameMessage();
        String input = readLine();
        return checkCarName(input);
    }

    private String checkCarName(String input) {
        try {
            inputValidator.checkCarNameValidate(input);
            return input;
        } catch (IllegalArgumentException e){
            throw e;
        }
    }

    private List<String> parseCarName(String input) {
        List<String> carName = Arrays.asList(input);
        return carName;
    }


}
