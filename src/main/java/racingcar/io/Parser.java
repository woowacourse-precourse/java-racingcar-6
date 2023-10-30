package racingcar.io;

public class Parser {
    private static final String CAR_NAME_SEPARATOR = ",";

    public String[] parseCarNames(String line) {
        return line.split(CAR_NAME_SEPARATOR);
    }

    public int parseInt(String integer) {
        return Integer.parseInt(integer);
    }
}
