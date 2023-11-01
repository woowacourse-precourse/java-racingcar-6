package racingcar.validator;

import static racingcar.ConstantValue.MAX_LEN_OF_CAR_NAME;
import static racingcar.ConstantValue.MIN_NUM_OF_CAR;
import static racingcar.ConstantValue.MIN_NUM_OF_MATCHES;
import static racingcar.validator.ErrorMessage.BLANK;
import static racingcar.validator.ErrorMessage.DUPLICATE;
import static racingcar.validator.ErrorMessage.EXCEED_MAX_LEN_OF_CAR_NAME;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_CAR;
import static racingcar.validator.ErrorMessage.LESS_THAN_MIN_NUM_OF_MATCHES;
import static racingcar.validator.ErrorMessage.NOT_INTEGER;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    // carList 관련 유효성 검사
    public static void validateCarListString(String carListString) {
        validateName(carListString);
        validateDuplicateName(carListString);
        validateLenOfCar(carListString);
        for (String car : carListString.split(",")) {
            validateLenOfCarName(car);
        }
    }

    public static void validateName(String carListString) {
        if (carListString.contains(",,") || carListString.charAt(carListString.length() - 1) == ',') {
            throw new IllegalArgumentException(BLANK);
        }
        String[] carList = carListString.split(",");
        for (String car : carList) {
            car = car.replaceAll("\\s", "");
            if (car.isEmpty()) {
                throw new IllegalArgumentException(BLANK);
            }
        }
    }

    public static void validateDuplicateName(String carListString) {
        String[] carList = carListString.split(",");
        Set<String> carSet = new HashSet<>();

        for (String car : carList) {
            if (carSet.contains(car)) {
                throw new IllegalArgumentException(DUPLICATE);
            }
            carSet.add(car);
        }
    }

    public static void validateLenOfCar(String carListString) {
        String[] carList = carListString.split(",");
        if (carList.length < MIN_NUM_OF_CAR) {
            throw new IllegalArgumentException(LESS_THAN_MIN_NUM_OF_CAR);
        }
    }

    public static void validateLenOfCarName(String car) {
        if (car.length() > MAX_LEN_OF_CAR_NAME) {
            throw new IllegalArgumentException(EXCEED_MAX_LEN_OF_CAR_NAME);
        }
    }

    // 경기 횟수 관련 유효성 검사
    public static void validateNumOfMatches(String number) {
        validateStringToInteger(number);
        validateRangeOfMatches(number);
    }

    public static void validateStringToInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER);
        }
    }

    public static void validateRangeOfMatches(String number) {
        int numOfMatches = Integer.parseInt(number);
        if (numOfMatches < MIN_NUM_OF_MATCHES) {
            throw new IllegalArgumentException(LESS_THAN_MIN_NUM_OF_MATCHES);
        }
    }
}
