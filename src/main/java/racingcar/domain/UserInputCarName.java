package racingcar.domain;

import racingcar.exception.UserInputException;

import java.util.ArrayList;
import java.util.List;

public class UserInputCarName {
    private List<String> carName = new ArrayList<>();
    private UserInputException userInputException;

    public List<String> createCarName(String userInput) {
        List<String> carNameList = stringToList(userInput);
        UserInputException.isDuplicate(carNameList);
        UserInputException.isMoreThan(carNameList);
        return carName;
    }

    public List<String> stringToList(String userInput) {
        for (String name : userInput.split(",")) {
            UserInputException.isLength(name);
            UserInputException.isComma(name);
            UserInputException.isBlank(name);
            carName.add(name);
        }
        return carName;
    }

}
