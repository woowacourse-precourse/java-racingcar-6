package racingcar.util;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import racingcar.domain.Constants;

public class Validator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");

    public static void InputRaceCount(String input) {
        if (InputCountBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getErrorMessage());
        }
        if (!InputCountNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getErrorMessage());
        }
    }

    public static void InputCarName(List<String> cars) {
        if (!InputNameLength(cars)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_NAME_LENGTH.getErrorMessage());
        }
        if (!InputNameDuplicatin(cars)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_NAME.getErrorMessage());
        }
        if (InputNameBlank(cars)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getErrorMessage());
        }
    }

    private static boolean InputCountBlank(String input) {
        return Objects.equals(input, ErrorMessage.BLANK.getErrorMessage());
    }

    private static boolean InputCountNumber(String input) {
        return NUMBER_PATTERN.matcher(input).matches();
    }

    private static boolean InputNameLength(List<String> cars) {
        return cars.stream()
                .noneMatch(name -> name.length() > Constants.NAME_SIZE);
    }

    private static boolean InputNameDuplicatin(List<String> cars) {
        return cars.stream().distinct().count() == cars.size();
    }

    private static boolean InputNameBlank(List<String> cars) {
        return cars.stream()
                .anyMatch(name -> Objects.equals(name, ErrorMessage.BLANK.getErrorMessage()));
    }

    private enum ErrorMessage {
        OVER_NAME_LENGTH("이름이 5자를 초과를 초과하지마세요"),
        DUPLICATION_NAME("중복된 이름을 입력하지마세요"),
        NOT_NUMBER("숫자를 입력하세요"),
        EMPTY_NAME("빈칸이 입력되었습니다."),
        BLANK("");

        private String errorMessage;

        ErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        private String getErrorMessage() {
            return errorMessage;
        }
    }

}
