package racingcar.validator;

public class GameValidator {

    private static final String ERROR = "[ERROR] ";
    private static final String TWO_CAR_ERROR_MESSAGE = ERROR + "자동차는 두 대 이상이어야 합니다.";
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = ERROR + "자동차 이름은 1글자 이상 5글자 이하만 가능합니다.";
    private static final String TRY_COUNT_NUMBER_ERROR_MESSAGE = ERROR + "시도 횟수는 숫자여야 합니다.";
    private static final String DELIMITER = ",";

    private GameValidator() {
    }


    public static void validateCarNumberIsOverTwo(String cars) {

        if (!cars.contains(DELIMITER)) {

            throw new IllegalArgumentException(TWO_CAR_ERROR_MESSAGE);
        }
    }

    public static void validateZeroCarName(String cars) {

        if (cars.endsWith(DELIMITER)) {

            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateIsNumber(String tryCount) {

        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRY_COUNT_NUMBER_ERROR_MESSAGE);
        }
    }
}
