package racingcar.controller;

import racingcar.constants.AppConstants;
import racingcar.utils.InputValidationUtil;
import racingcar.view.GameOutput;
import racingcar.view.UserInput;
import java.util.List;

public class UserInputHandler {
    public List<String> getCarNameList() {
        String names = getUserCarName();
        return separateNames(names);
    }

    private String getUserCarName() {
        GameOutput.printInputCarName();
        return UserInput.getUserInputForCarNames();
    }

    private List<String> separateNames(String names) {
        if (names == null) {
            throw new IllegalArgumentException(AppConstants.ERR_PLEASE_ENTER_NAME_VALUE);
        }
        List<String> nameList = List.of(names.split(AppConstants.INPUT_DELIMITER));
        InputValidationUtil.validateCarNameList(nameList);
        return nameList;
    }
}