package racingcar.mapper;

import java.util.List;
import java.util.Objects;

public class InputMapper {

    private static final String INVALID_INPUT_MESSAGE = "유효하지 않은 입력값입니다.";
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자만 입력해주세요.";
    private static final String NOT_POSITIVE_NUMBER_MESSAGE = "양수만 입력해주세요.";

    public static List<String> mapToNameList(String input) {
        checkInputNonNull(input);

        return List.of(input.split(getNameListDelimiter().getShape()));
    }

    public static Delimiter getNameListDelimiter() {
        return Delimiter.NAME;
    }

    public static int mapToPositiveNumber(String input) {
        checkInputNonNull(input);

        return parsePositiveInt(input);
    }

    private static void checkInputNonNull(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static int parsePositiveInt(String input) {
        int parsed = parseInt(input);
        checkPositiveNumber(parsed);

        return parsed;
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static void checkPositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_MESSAGE);
        }
    }
}
