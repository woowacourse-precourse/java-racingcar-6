package racingcar.util;

public class StringFormatter {
    private StringFormatter() {
    }

    public static String raceResultFormat(String name, String position) {
        return String.format("%s : %s%n", name, position);
    }

    public static String winnerFormat(String winner) {
        return String.format("최종 우승자 : %s", winner);
    }
}
