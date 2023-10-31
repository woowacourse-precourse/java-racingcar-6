package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class InputConvertor {
    private static final String COMMA_SEPARATOR = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_LENGTH_EXCEED = "이름의 제한 길이를 초과했습니다.";
    private static final String INVALID_NATURAL_NUMBER = "유효한 숫자를 입력해주세요.";
    private static final String INVALID_TRY_COUNT = "시도 횟수는 1 이상이어야 합니다.";

    public static String[] separateInputToNames(String userInput) {
        String[] split = userInput.split(COMMA_SEPARATOR);
        List<String> validNames = new ArrayList<>();

        for (String name : split) {
            name = name.trim();
            checkNameLength(name);
            validNames.add(name);
        }
        return validNames.toArray(new String[0]);
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEED);
        }
    }

    public static int parseTryCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER);
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT);
        }
    }
}
