package racingcar.util;

import static racingcar.constant.RaceConfig.CONVERTING_SIGNS;

public class StringFormatter {
    private StringFormatter() {
    }

    public static String raceResultFormat(String name, int position) {
        return String.format("%s : %s%n", name, convertPositionToSigns(position));
    }

    public static String winnerFormat(String winner) {
        return String.format("최종 우승자 : %s", winner);
    }

    private static String convertPositionToSigns(int position) {
        return CONVERTING_SIGNS.repeat(position);
    }
}
