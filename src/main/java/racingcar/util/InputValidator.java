package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constant.InputConstant;
import racingcar.constant.InputDelimiter;

public class InputValidator {

    private static final String CAR_NAME_REGEX = "^[a-z]+$";
    private static final String RACE_COUNT_REGEX = "^(?:" + InputConstant.MIN_NUMBER_OF_RACE.getValue() + "|[1-9]|1\\d|"
            + InputConstant.MAX_NUMBER_OF_RACE.getValue() + ")$";


    public boolean isValidCarNameInput(String carNameInput) {
        List<String> carNames = Arrays.stream(carNameInput.split(InputDelimiter.PARTICIPANT_INPUT_DELIMITER.getValue()))
                .toList();
        if (carNames.size() < InputConstant.MIN_PARTICIPANT.getValue()
                || InputConstant.MAX_PARTICIPANT.getValue() < carNames.size()) {
            return false;
        }
        return carNames.stream().allMatch(this::isValidCarName);
    }

    private boolean isValidCarName(String carName) {
        return isValidCarNameLength(carName) && isValidCarNameFormat(carName) && isDuplicateCarNameExist(carName);
    }

    private boolean isValidCarNameLength(String carName) {
        return carName.length() <= InputConstant.CAR_NAME_LIMIT.getValue();
    }

    private boolean isDuplicateCarNameExist(String carName) {
        String[] stringToArray = carName.split(InputDelimiter.PARTICIPANT_INPUT_DELIMITER.getValue());
        Set<String> stringToSet = new HashSet<>(Set.of(stringToArray));
        return stringToArray.length == stringToSet.size();
    }

    private boolean isValidCarNameFormat(String carName) {
        return carName.matches(CAR_NAME_REGEX);
    }

    public boolean isValidTrial(String trialInput) {
        return trialInput.matches(RACE_COUNT_REGEX);
    }

}