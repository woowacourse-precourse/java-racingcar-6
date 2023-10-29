package racingcar.converter;

import java.util.List;

public class RacingConverter {
    private static final String DELIMITER = ",";

    public List<String> convertToListByDelimiter(String input) {
        return List.of(input.split(DELIMITER));
    }

    public int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }
}
