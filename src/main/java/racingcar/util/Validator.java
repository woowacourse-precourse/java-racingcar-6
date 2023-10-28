package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final int CAR_NAME_LENGTH_MIN = 1;
    private static final int CAR_NAME_LENGTH_MAX = 5;
    private static final String WRONG_LENGTH_ERROR_MESSAGE = "1~5글자인 자동차 이름만 입력 가능합니다.";
    private static final String SPACE = " ";
    private static final String SPACE_ERROR_MESSAGE = "자동차 이름에는 공백이 있으면 안됩니다.";
    private static final String CAR_NAME_DUPLICATE_ERROR = "자동차 목록은 중복이 없어야 합니다.";
    private static final String ROUND_NUMBER_WRONG_ERROR = "시도할 횟수는 숫자여야 합니다.";

    public List<String> convertStringToList(String input) {
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        validate(carNames);
        return carNames;
    }

    public void convertStringToInt(String input) {
        isInteger(input);
    }

    public void validate(List<String> carNames) {
        for (String carName : carNames) {
            isRightNameLength(carName);
            isNotContainSpace(carName);
        }
        isNotDuplicate(carNames);
    }

    public void isRightNameLength(String carName) {
        if (carName.length() < CAR_NAME_LENGTH_MIN || carName.length() > CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(WRONG_LENGTH_ERROR_MESSAGE);
        }
    }

    public void isNotContainSpace(String carName) {
        if (carName.contains(SPACE)) {
            throw new IllegalArgumentException(SPACE_ERROR_MESSAGE);
        }
    }
    public void isNotDuplicate(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR);
        }
    }

    public void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ROUND_NUMBER_WRONG_ERROR);
        }
    }

}
