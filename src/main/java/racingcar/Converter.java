package racingcar;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private Converter() {
    }

    public static int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }

    }

    public static List<String> stringToList(String s) {
        return Arrays.stream(s.split(",")).toList();
    }
}
