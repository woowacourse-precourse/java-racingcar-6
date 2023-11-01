package racingcar.model.validator;

import java.util.List;
import racingcar.constants.GameInfo;

public class CommonValidator {

    public static boolean validateCarNameLength(String carName) {
        int length = carName.length();
        return length >= GameInfo.MIN_CAR_NAME_LENGTH && length <= GameInfo.MAX_CAR_NAME_LENGTH;
    }

    public static boolean validateCarNameBlank(String carName) {
        return !carName.trim().isEmpty();
    }

    public static boolean validateCarNameUnderBar(String carName) {
        return !carName.contains(GameInfo.CAR_DUPLICATED_SEPARATOR);
    }

    public static boolean validateRoundNumRange(String roundNum) {
        int numInt = Integer.parseInt(roundNum);
        return numInt >= GameInfo.MIN_ROUND_NUM && numInt <= GameInfo.MAX_ROUND_NUM;
    }

    public static boolean validateIsNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
