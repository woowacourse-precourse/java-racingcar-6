package racingcar.util;

import java.util.List;

public class Converter {

    private static final String COMMA = ",";

    private Converter() {
    }

    public static List<String> splitWithCommaAndConvertToList(final String string) {
        String[] splitString = string.split(COMMA);
        return List.of(splitString);
    }
}
