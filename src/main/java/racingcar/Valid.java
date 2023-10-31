package racingcar;

import java.util.*;

public class Valid {

    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final String ERROR_MSG = "[ERROR] ";

    public static void isNull(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MSG + "입력 값이 공백입니다.");
        }
    }

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MSG + "시도 횟수는 숫자여야 합니다.");
        }
    }

    public static boolean checkNames(String[] names) {
        List<String> nameList = Arrays.asList(names);

        for (String name : nameList) {
            if (name.trim().length() > MAX_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(ERROR_MSG + "자동차 이름은 최대 5글자입니다.");
            }
        }

        if (new HashSet<>(nameList).size() != nameList.size()) {
            throw new IllegalArgumentException(ERROR_MSG + "중복된 이름을 입력했습니다.");
        }

        return true;
    }
}
