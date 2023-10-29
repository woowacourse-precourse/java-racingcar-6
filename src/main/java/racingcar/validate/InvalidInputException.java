package racingcar.validate;

import java.util.ArrayList;
import java.util.List;

public class InvalidInputException {
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력값이 비었습니다.";
    private static final String NULL_EXCEPTION_MESSAGE = "입력값이 null입니다.";
    private static final String BLANK_NAME_EXCEPTION_MESSAGE = "자동차 이름은 공백일 수 없습니다.";
    private static final String SINGLE_CAR_EXCEPTION_MESSAGE = "자동차 수는 2이상이여야만 경주가 가능합니다.";
    private static final String CAR_NAME_OVER_LIMIT_EXCEPTION_MESSAGE = "자동차 이름은 5글자를 초과할 수 없습니다.";
    private static final String DUPLICATION_EXCEPTION_MESSAGE = "동일한 자동차 이름을 여러번 입력할 수 없습니다.";
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "이동 시도 횟수는 숫자여야 합니다.";
    private static final String NOT_NATURAL_NUMBER_EXCEPTION_MESSAGE = "이동 시도 횟수는 1이상이어야 합니다.";


    public void checkInput(String input) {
        isEmpty(input);
        isNull(input);

        String[] carNames = input.split(",");
        isBlankName(carNames);
        isSingleCar(carNames);
        isCarNameOverLimit(carNames);
        isDuplication(carNames);
    }

    public void checkTimes(String times) {
        isEmpty(times);
        isNull(times);
        isNumber(times);
        isNaturalNumber(times);
    }

    private void isEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }
    }

    private void isNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
        }
    }

    private void isBlankName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException(BLANK_NAME_EXCEPTION_MESSAGE);
            }
        }
    }

    private void isSingleCar(String[] carNames) {
        if (carNames.length == 1) {
            throw new IllegalArgumentException(SINGLE_CAR_EXCEPTION_MESSAGE);
        }
    }

    private void isCarNameOverLimit(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_OVER_LIMIT_EXCEPTION_MESSAGE);
            }
        }
    }

    private void isDuplication(String[] carNames) {
        List<String> carNameList = new ArrayList<>();
        for (String carName : carNames) {
            if (carNameList.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATION_EXCEPTION_MESSAGE);
            }
            carNameList.add(carName);
        }
    }

    private void isNumber(String times) {
        try {
            Integer.parseInt(times);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void isNaturalNumber(String times) {
        int intTimes = Integer.parseInt(times);
        if (intTimes < 1) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
