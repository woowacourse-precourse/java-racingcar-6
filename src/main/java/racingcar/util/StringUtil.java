package racingcar.util;

import java.util.List;

public class StringUtil {
    private static final String DELIMITER = ",";

    public List<String> convertToListByDelimiter(String input) {
        return List.of(input.split(DELIMITER));
    }

    public int convertToPositiveInt(String input) {
        int number = convertToInt(input);
        if (number < 1) {
            throw new IllegalArgumentException("0보다 커야 합니다.");
        }
        return number;
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
