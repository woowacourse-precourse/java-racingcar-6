package racingcar.domain;

import racingcar.exception.UserInputException;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<String> carName = new ArrayList<>();
    private UserInputException userInputException;

    public static List<String> createCarName(String userInput) {
        for (String name : userInput.split(",")) {
            UserInputException.isLength(name);
            UserInputException.isMoreThan(name);
            UserInputException.isDuplicate(name);
            UserInputException.isComma(name);
            UserInputException.isBlank(name);
            carName.add(name);
        }
        return carName;
    }

}
