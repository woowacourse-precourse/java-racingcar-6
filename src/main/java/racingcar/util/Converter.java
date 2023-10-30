package racingcar.util;

public class Converter {
    private static final String COMMA = ",";

    public static String[] splitCarNameWithComma(String inputCarNames) {
        return inputCarNames.split(COMMA);
    }
}
