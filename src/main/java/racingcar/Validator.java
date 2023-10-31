package racingcar;

import racingcar.common.ErrorCode;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCarNameArray(String[] carNameArray) throws IllegalArgumentException {
        for (String s : carNameArray) {
            if (s.length() > MAX_CAR_NAME_LENGTH) {
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
