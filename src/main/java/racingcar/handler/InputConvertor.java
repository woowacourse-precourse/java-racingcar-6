package racingcar.handler;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {
    static final String COMMA_DELIMITER = ",";
    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";

    public List<String> splitByComma(String input) {
        return Arrays.stream(input.split(COMMA_DELIMITER))
            .map(name -> name.replaceAll(SPACE, EMPTY_STRING))
            .toList();
    }

    public int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}
