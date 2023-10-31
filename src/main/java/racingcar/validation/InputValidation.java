package racingcar.validation;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {
    private static final String IS_NULL_CAR_NAME_ERROR_MESSAGE = "입력하지 않았습니다.";
    private static final String IS_NOT_RULE_NAME_ERROR_MESSAGE = "규칙에 맞지 않습니다";
    private static final String IS_DUPLICATE_NAME = "중복이 발생했습니다";
    private static final String IS_NOT_RANGE_NAME_ERROR_MESSAGE = "5자리 이하가 아닙니다.";
    private static final String IS_NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다.";
    private static final String IS_NOT_NUMBER_RANGE_ERROR_MESSAGE = "0보다 작을 수는 없습니다";
    private static final int LIMIT_CAR_NAME_RANGE = 5;
    private static final int IS_NOT_NUMBER_RANGE = 1;

    public String[] checkedInputValidation(String carNames) {
        isNullText(carNames);
        isNotRule(carNames);
        isDuplicationNames(carNames);
        return collectCarNames(carNames);
    }

    public int checkedInputNumberValidation(String number) {
        isNullText(number);
        isCheckedNumber(number);
        isCheckedNumberRange(number);
        return ChangeIntegerNumber(number);
    }

    private void isNullText(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException(IS_NULL_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void isNotRule(String carNames) {
        if (carNames.charAt(0) == ' ' || carNames.charAt(0) == ',') {
            throw new IllegalArgumentException(IS_NOT_RULE_NAME_ERROR_MESSAGE);
        }
    }

    private void isDuplicationNames(String carNames) {
        String[] cars = carNames.split(",");
        Set<String> collectNames = new HashSet<>();
        collectNames = putCollectNames(cars, collectNames);

        if (collectNames.size() != cars.length) {
            throw new IllegalArgumentException(IS_DUPLICATE_NAME);
        }
    }

    private Set<String> putCollectNames(String[] cars, Set<String> collectNames) {
        for (String car : cars) {
            collectNames.add(car);
        }
        return collectNames;
    }

    private String[] collectCarNames(String carNames) {
        String[] cars = carNames.split(",");
        for (String carName : cars) {
            isCheckedNameRange(carName);
        }
        return cars;
    }

    private void isCheckedNameRange(String carName) {
        if (carName.length() > LIMIT_CAR_NAME_RANGE) {
            throw new IllegalArgumentException(IS_NOT_RANGE_NAME_ERROR_MESSAGE);
        }
    }

    private void isCheckedNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException(IS_NOT_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private void isCheckedNumberRange(String number) {
        if (Integer.parseInt(number) < IS_NOT_NUMBER_RANGE) {
            throw new IllegalArgumentException(IS_NOT_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private int ChangeIntegerNumber(String number) {
        return Integer.parseInt(number);
    }
}
