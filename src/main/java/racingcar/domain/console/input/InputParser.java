package racingcar.domain.console.input;

public class InputParser {

    private InputParser() {
    }

    public static InputParser newInstance() {
        return new InputParser();
    }

    public String[] parseUserNames(final String input, final String delimiter) {
        return input.split(delimiter);
    }

    public int parseInt(final String input) {
        return Integer.parseInt(input);
    }

}
