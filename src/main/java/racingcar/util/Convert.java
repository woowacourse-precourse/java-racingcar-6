package racingcar.util;

import java.util.List;

public class Convert {

    public static List<String> stringToListUsingComma(String inputValue) {
        return List.of(inputValue.split(","));
    }

    public static Integer stringToInteger(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
