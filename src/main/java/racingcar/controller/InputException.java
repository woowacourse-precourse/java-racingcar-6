package racingcar.controller;

import racingcar.view.Message.ExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InputException {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int MIN_CAR_COUNT = 2;

    public void checkInputRoundError(String inputRoundLengthString) {
        checkPossibleStringToInt(inputRoundLengthString);
        checkNonPositiveRoundError(Integer.parseInt(inputRoundLengthString));
    }

    public void checkInputCarNameArrayError(ArrayList<String> carNameArray) {
        //개수 1개 이하
        checkLessTwoCarCount(carNameArray);
        //car이름이 공백
        checkBlankCarName(carNameArray);
        //중복
        checkDuplicateCarName(carNameArray);
        // 이름 5자 초과
        checkLengthOfCarName(carNameArray);
    }

    private void checkLessTwoCarCount(ArrayList<String> carNameArray) {
        if (isLessTwoCarCount(carNameArray)) {
            throw new IllegalArgumentException(ExceptionMessage.LESS_TWO_CAR_COUNT_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isLessTwoCarCount(ArrayList<String> carNameArray) {
        if (carNameArray.size() < MIN_CAR_COUNT) {
            return true;
        }
        return false;
    }

    private void checkBlankCarName(ArrayList<String> carNameArray) {
        if (isBlankCarName(carNameArray)) {
            throw new IllegalArgumentException(ExceptionMessage.BLANK_OR_NULL_CAR_NAME_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isBlankCarName(ArrayList<String> carNameArray) {
        for (String carName : carNameArray) {
            if (carName.isEmpty() || isSpaceBar(carName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSpaceBar(String carName) {
        for (int i = 0; i < carName.length(); i++) {
            if (!Character.isWhitespace(carName.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void checkDuplicateCarName(ArrayList<String> carNameArray) {
        if (isDuplicateCarName(carNameArray)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_CAT_NAME_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isDuplicateCarName(ArrayList<String> carNameArray) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNameArray) {
            if (!uniqueCarNames.add(carName)) {
                return true;
            }
        }
        return false;
    }

    private void checkLengthOfCarName(ArrayList<String> carNameArray) {
        if (isOverMaxLengthCarName(carNameArray)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_OVER_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isOverMaxLengthCarName(ArrayList<String> carNameArray) {
        for (String carName : carNameArray) {
            if (carName.length() > CAR_NAME_MAX_LENGTH) {
                return true;
            }
        }
        return false;
    }

    private void checkNonPositiveRoundError(int inputRoundLengthInt) {
        if (!isNonPositiveRoundInt(inputRoundLengthInt)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_INTEGER_ROUND_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isNonPositiveRoundInt(int inputRoundLengthInt) {
        return inputRoundLengthInt > 0;
    }

    private void checkPossibleStringToInt(String inputRoundLengthString) {
        if (inputRoundLengthString.isEmpty() || !isNumeric(inputRoundLengthString)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_STRING_ROUND_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isNumeric(String inputRoundLengthString) {
        try {
            Integer.parseInt(inputRoundLengthString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
