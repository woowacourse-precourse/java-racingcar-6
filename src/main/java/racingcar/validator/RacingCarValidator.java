package racingcar.validator;

import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;

public class RacingCarValidator {
    private static final String RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE = "자동차 이름은 최대 5글자입니다.";
    private static final String RACING_CAR_NAME_EMPTY_EXCEPTION_MESSAGE = "1가지 이상의 자동차 이름을 입력해야합니다.";
    private static final String RACING_CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE = "자동차 이름은 중복이 불가능합니다.";
    private static final String RACING_CAR_NAME_SPACE_EXCEPTION_MESSAGE = "자동차 이름에 공백 입력이 불가능합니다.";
    private static final String ATTEMPT_NUMBER_INPUT_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다.";
    private static final String ATTEMPT_NUMBER_INPUT_EMPTY_EXCEPTION_MESSAGE = "1 이상의 숫자를 입력해주세요";
    private static final String COMMA = ",";
    private static final Integer RACING_CAR_NAME_OVER_LENGTH=5;

    private static final Integer ZERO=0;


    public static boolean racingCarInputNameValidator(String racingCars) {
        return racingCarNameEmptyInputValidator(racingCars) &&
                racingCarNameInputContainsSpaceValidator(racingCars) &&
                racingCarNameLengthValidator(racingCars) &&
                racingCarNameDuplicationValidator(racingCars);
    }

    public static boolean attemptInputNumberValidator(String number) {
        return attemptNumberEmptyInputValidator(number) &&
                attemptInputOnlyNumberValidator(number);

    }

    /**
     * 자동차 이름이 5글자 이하인지 체크하는 예외
     */
    public static boolean racingCarNameLengthValidator(String racingCars) {
        if (Arrays.stream(racingCars.split(COMMA)).anyMatch(car -> car.length() > RACING_CAR_NAME_OVER_LENGTH)) {
            throw new IllegalArgumentException(RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        return true;
    }

    /**
     * 자동차 이름이 중복인지 체크하는 예외
     */
    public static boolean racingCarNameDuplicationValidator(String racingCars) {
        if (Arrays.stream(racingCars.split(COMMA)).distinct().count() < racingCars.split(COMMA).length) {
            throw new IllegalArgumentException(RACING_CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
        return true;
    }

    /**
     * 자동차 이름에 공백이 포함되어 있는지 체크하는 예외
     */
    public static boolean racingCarNameInputContainsSpaceValidator(String racingCars) {
        if (racingCars.codePoints().anyMatch(Character::isWhitespace)) {
            throw new IllegalArgumentException(RACING_CAR_NAME_SPACE_EXCEPTION_MESSAGE);
        }
        return true;
    }

    /**
     * 자동차 이름이 공백인지 체크하는 예외
     */
    public static boolean racingCarNameEmptyInputValidator(String racingCars) {
        if (racingCars.length() == ZERO) {
            throw new IllegalArgumentException(RACING_CAR_NAME_EMPTY_EXCEPTION_MESSAGE);
        }
        return true;
    }

    /**
     * 입력한 숫자가 문자인지 체크하는 예외
     */
    public static boolean attemptInputOnlyNumberValidator(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_INPUT_EXCEPTION_MESSAGE);
        }
    }

    /**
     * 입력한 숫자가 공백인지 체크하는 예외
     */
    public static boolean attemptNumberEmptyInputValidator(String number) {
        if (number.length() == ZERO) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_INPUT_EMPTY_EXCEPTION_MESSAGE);
        }
        return true;
    }


}
