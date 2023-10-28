package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.InputConstant;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String CAR_NAME_REGEX = "^[a-z]+$";
    private static final String RACE_COUNT_REGEX = "^(?:" + InputConstant.MIN_NUMBER_OF_RACE.getValue() + "|[1-9]|1\\d|"
            + InputConstant.MAX_NUMBER_OF_RACE.getValue() + ")$";


    public boolean isValidCarNameInput(String carNameInput) {
        List<String> carNames = Arrays.stream(carNameInput.split(DELIMITER)).toList();
        if (carNames.size() < InputConstant.MIN_PARTICIPANT.getValue()
                || InputConstant.MAX_PARTICIPANT.getValue() < carNames.size()) {
            return false;
        }
        return carNames.stream().allMatch(this::isValidCarName);
    }

    private boolean isValidCarName(String carName) {
        return isValidCarNameLength(carName) && isValidCarNameFormat(carName);
    }

    private boolean isValidCarNameLength(String carName) {
        return carName.length() <= InputConstant.CAR_NAME_LIMIT.getValue();
    }

    private boolean isValidCarNameFormat(String carName) {
        return carName.matches(CAR_NAME_REGEX);
    }

    public boolean isValidTrial(String trialInput) {
        return trialInput.matches(RACE_COUNT_REGEX);
    }

}