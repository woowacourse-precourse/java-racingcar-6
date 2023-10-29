package racingcar.validator;

public class GameValidator {

    private static final String ERROR = "[ERROR] ";
    private static final String TWO_CAR_ERROR_MESSAGE = ERROR + "자동차는 두 대 이상이어야 합니다.";
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = ERROR + "자동차 이름은 1글자 이상 5글자 이하만 가능합니다.";
    private static final String TRY_COUNT_ERROR_MESSAGE = ERROR + "시도 횟수는 1 이상 1000 이하의 숫자만 가능합니다.";
    private static final String TRY_COUNT_NUMBER_ERROR_MESSAGE = ERROR + "시도 횟수는 숫자여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 1000;

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

    public static void validateCarNamesLength(String carName) {

        if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {

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

    public static void validateTryCount(int tryCount) {

        if (tryCount < MIN_TRY_COUNT || tryCount > MAX_TRY_COUNT) {

            throw new IllegalArgumentException(TRY_COUNT_ERROR_MESSAGE);
        }
    }
}
