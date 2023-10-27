package racingcar.exception;


import java.util.Arrays;

public class CarValidator {

    private static final int MAX_LENGTH = 5;
    private static final char SEPARATOR = ',';
    private static final String REGEX_SEPARATOR = ",";
    private static final String CONSECUTIVE_SEPARATOR = ",,";
    private static final String KOREAN_SEPARATOR = "콤마";

    private static final String ERROR = "[ERROR] 자동차 이름은 ";
    private static final String ERROR_BLANK = ERROR + "공백을 허용하지 않습니다.";
    private static final String ERROR_MAX_LENGTH = ERROR + "최대 " + MAX_LENGTH + "글자 입니다.";
    private static final String ERROR_COMMA_START = ERROR + KOREAN_SEPARATOR + "('" + SEPARATOR + "')로 시작할 수 없습니다.";
    private static final String ERROR_COMMA_END = ERROR + KOREAN_SEPARATOR + "('" +SEPARATOR + "')로 끝날수 없습니다.";
    private static final String ERROR_CONSECUTIVE_COMMA = ERROR + "연속된 " + KOREAN_SEPARATOR + "('" + SEPARATOR +"')을 허용하지 않습니다.";


    public static void validate(String input) {
        validateBlankException(input);
        validateNamesLengthGreaterThanFive(input);
        validateCarNamesStartWithCommaException(input);
        validateCarNamesEndWithCommaException(input);
        validateConsecutiveCommaException(input);
    }

    private static void validateBlankException(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static void validateNamesLengthGreaterThanFive(String input) {
        String[] splitList = input.split(REGEX_SEPARATOR);

        Arrays.stream(splitList)
                .filter(carName -> carName.length() > MAX_LENGTH)
                .forEach(carName -> {
                    throw new IllegalArgumentException(ERROR_MAX_LENGTH);
                });
    }

    private static void validateCarNamesStartWithCommaException(String input) {
        if (input.charAt(0) == SEPARATOR) {
            throw new IllegalArgumentException(ERROR_COMMA_START);
        }
    }

    private static void validateCarNamesEndWithCommaException(String input) {
        if (input.charAt(input.length() - 1) == SEPARATOR) {
            throw new IllegalArgumentException(ERROR_COMMA_END);
        }
    }

    private static void validateConsecutiveCommaException(String input) {
        if (input.contains(CONSECUTIVE_SEPARATOR)) {
            throw new IllegalArgumentException(ERROR_CONSECUTIVE_COMMA);
        }
    }
}
