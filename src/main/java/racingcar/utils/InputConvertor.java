package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class InputConvertor {
    private static final String COMMA_SEPARATOR = ",";
    private static final int MAX_NAME_LENGTH = 5;

    public static String[] separateInputToNames(String userInput) {
        String[] split = userInput.split(COMMA_SEPARATOR);
        List<String> validNames = new ArrayList<>();

        for (String name : split) {
            name = name.trim();
            if (name.length() <= MAX_NAME_LENGTH) {
                validNames.add(name);
            } else {
                throw new IllegalArgumentException("이름의 제한 길이를 초과했습니다.");
            }
        }
        return validNames.toArray(new String[0]);
    }

    public static int parseTryCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    public static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
