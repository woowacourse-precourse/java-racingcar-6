package racingcar.domain;

import racingcar.exception.UserCarNameInputException;

import java.util.ArrayList;
import java.util.List;

public class UserInputCarName {
    private List<String> carName = new ArrayList<>();
    private UserCarNameInputException userCarNameInputException;

    public List<String> createCarName(String userInput) {
        List<String> carNameList = stringToList(userInput);
        UserCarNameInputException.isDuplicate(carNameList);
        UserCarNameInputException.isMoreThan(carNameList);
        return carName;
    }

    public List<String> stringToList(String userInput) {
        for (String name : userInput.split(",")) {
            UserCarNameInputException.isLength(name);
            UserCarNameInputException.isComma(name);
            UserCarNameInputException.isBlank(name);
            carName.add(name);
        }
        return carName;
    }

}
