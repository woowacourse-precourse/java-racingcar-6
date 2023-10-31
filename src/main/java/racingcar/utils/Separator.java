package racingcar.utils;

public class Separator {

    private static final String SEPARATE_REGEX = ",";

    private Separator() {}

    public static String[] separateStringByRegex(String carNames) {
        return carNames.split(SEPARATE_REGEX, -1);
    }
}
