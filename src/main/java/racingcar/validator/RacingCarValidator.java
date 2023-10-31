package racingcar.validator;

import java.util.Arrays;

public class RacingCarValidator {
    private static final String RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "자동차 이름은 최대 5글자입니다.";
    private static final String RACING_CAR_NAME_EMPTY_EXCEPTION_MESSAGE = "1가지 이상의 자동차 이름을 입력해야합니다.";
    private static final String RACING_CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "자동차 이름은 중복이 불가능합니다.";
    private static final String RACING_CAR_NAME_SPACE_EXCEPTION_MESSAGE = "자동차 이름에 공백 입력이 불가능합니다.";
    private static final String ATTEMPT_NUMBER_INPUT_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String ATTEMPT_NUMBER_INPUT_EMPTY_EXCEPTION_MESSAGE = "1 이상의 숫자를 입력해주세요";
    private static final String ATTEMPT_NUMBER_INPUT_MIN_VALUE_EXCEPTION_MESSAGE = "0보다 큰 숫자를 입력할 수 있습니다.";

    private static final String COMMA = ",";
    private static final Integer RACING_CAR_NAME_OVER_LENGTH = 5;
    private static final Integer ZERO = 0;

    public static boolean racingCarNameInputValidator(String racingCars) {
        return racingCarNameEmptyInputValidator(racingCars) &&
                racingCarNameInputContainsSpaceValidator(racingCars) &&
                racingCarNameLengthValidator(racingCars) &&
                racingCarNameDuplicationValidator(racingCars);
    }

    public static boolean numberAttemptsInputValidator(String number) {
        return numberAttemptsEmptyInputValidator(number) &&
                numberAttemptsInputOnlyNumberValidator(number) &&
                numberAttemptsInputMinValueValidator(number);

    }

    public static boolean racingCarNameLengthValidator(String racingCars) {
        if (Arrays.stream(racingCars.split(COMMA)).anyMatch(car -> car.length() > RACING_CAR_NAME_OVER_LENGTH)) {
            throw new IllegalArgumentException(RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static boolean racingCarNameDuplicationValidator(String racingCars) {
        if (Arrays.stream(racingCars.split(COMMA)).distinct().count() < racingCars.split(COMMA).length) {
            throw new IllegalArgumentException(RACING_CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static boolean racingCarNameInputContainsSpaceValidator(String racingCars) {
        if (racingCars.codePoints().anyMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException(RACING_CAR_NAME_SPACE_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static boolean racingCarNameEmptyInputValidator(String racingCars) {
        if (racingCars.length() == ZERO) {
            throw new IllegalArgumentException(RACING_CAR_NAME_EMPTY_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static boolean numberAttemptsInputOnlyNumberValidator(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static boolean numberAttemptsInputMinValueValidator(String number) {
        if (Integer.parseInt(number) <= 0) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_INPUT_MIN_VALUE_EXCEPTION_MESSAGE);
        }
        return true;
    }

    public static boolean numberAttemptsEmptyInputValidator(String number) {
        if (number.length() == ZERO) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_INPUT_EMPTY_EXCEPTION_MESSAGE);
        }
        return true;
    }
}
