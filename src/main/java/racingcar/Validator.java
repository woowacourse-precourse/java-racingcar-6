package racingcar;

import racingcar.common.ErrorCode;
import racingcar.common.Rule;

public class Validator {

    public static void validateCarNameArray(String[] carNameArray) throws IllegalArgumentException {
        if (carNameArray.length == 0) {
            throw new IllegalArgumentException(ErrorCode.INPUT_WRONG_CAR_NAME_EMPTY.getMessage());
        }
        for (String s : carNameArray) {
            if (s.length() > Rule.MAX_CAR_NAME_LENGTH.getValue()) {
                throw new IllegalArgumentException(ErrorCode.INPUT_WRONG_CAR_NAME_LENGTH.getMessage());
            }
            if (s.isEmpty()) {
                throw new IllegalArgumentException(ErrorCode.INPUT_WRONG_CAR_NAME_EMPTY.getMessage());
            }
        }
    }

    public static void validateMoveCount(String moveCountString) throws IllegalArgumentException {
        try {
            Integer.parseInt(moveCountString);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.INPUT_WRONG_NUMBER.getMessage());
        }

    }
}
