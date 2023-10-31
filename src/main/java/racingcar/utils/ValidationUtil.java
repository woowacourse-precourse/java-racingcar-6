package racingcar.utils;

import racingcar.constant.ErrorMessage;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidationUtil {
    private static final int MIN_RACING_CAR_COUNT = 2;
    private static final int MIN_ATTEMPT_COUNT = 0;
    private static final int MAX_LENGTH = 5;
    private static final String REGEXP_ONLY_NUMBER = "^[\\d]*$";
    private static final Pattern numberPattern = Pattern.compile(REGEXP_ONLY_NUMBER);

    private ValidationUtil() {
    }

    public static void racingCarValidator(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
        }
        if(!isInMaxLength(input)){
            throw new IllegalArgumentException(ErrorMessage.MAX_LENGTH_ERROR_MESSAGE);
        }
    }

    // 입력된 자동차가 2대보다 작을 경우
    public static void racingCarCountValidator(String[] catList) {
        if (catList.length < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.RACING_CAR_COUNT_ERROR_MESSAGE, MIN_RACING_CAR_COUNT));
        }
    }

    public static void duplicationValidator(String[] carList) {
        long distinctCount = Arrays.stream(carList)
                .distinct()
                .count();

        if (distinctCount < carList.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ERROR_MESSAGE);
        }
    }

    public static void attemptValidator(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_ERROR_MESSAGE);
        }
        if(!isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR_MESSAGE);
        }

        if (isLessThanMinCount(input)) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.LESS_THAN_MIN_COUNT_ERROR_MESSAGE, MIN_ATTEMPT_COUNT));
        }
    }

    private static boolean isInMaxLength(String input) {
        return input.length() <= MAX_LENGTH;
    }

    private static boolean isNumber(String input) {
        return numberPattern.matcher(input).find();
    }

    private static boolean isLessThanMinCount(String input) {
        int count = Integer.parseInt(input);
        return count <= MIN_ATTEMPT_COUNT;
    }
}
