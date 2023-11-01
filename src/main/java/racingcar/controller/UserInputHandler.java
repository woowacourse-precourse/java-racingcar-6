package racingcar.controller;

import racingcar.constants.AppConstants;
import racingcar.view.GameOutput;
import racingcar.view.UserInput;

import java.util.List;

public class UserInputHandler {
    public List<String> getCarNameList() {
        String names = getInputCarName();
        return separateNames(names);
    }

    private String getInputCarName() {
        GameOutput.printInputCarName();
        return UserInput.getUserInputForCarNames();
    }

    private List<String> separateNames(String names) {
        List<String> nameList = List.of(names.split(AppConstants.INPUT_DELIMITER));
        return nameList;
    }
}
