package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final int CAR_NAME_LENGTH_MIN = 1;
    private static final int CAR_NAME_LENGTH_MAX = 5;
    private final static String WRONG_LENGTH_ERROR_MESSAGE = "1~5글자인 자동차 이름만 입력 가능합니다.";

    public List<String> convertStringToList(String input) {
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        isRightNameLength(carNames);
        return carNames;
    }

    public void isRightNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() < CAR_NAME_LENGTH_MIN || carName.length() > CAR_NAME_LENGTH_MAX) {
                throw new IllegalArgumentException(WRONG_LENGTH_ERROR_MESSAGE);
            }
        }
    }

}
