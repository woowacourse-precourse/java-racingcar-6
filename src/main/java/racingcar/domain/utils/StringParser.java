package racingcar.domain.utils;

public final class StringParser {
    private StringParser() {
    }

    // 공백제거 후, ","를 통해 구분
    public static String[] trimAndSplit(String carNamesWithCommas) {
        String trimedCarNames = carNamesWithCommas.trim();
        return trimedCarNames.split("\\s*,\\s*");
    }
}
