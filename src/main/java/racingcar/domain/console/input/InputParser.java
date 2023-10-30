package racingcar.domain.console.input;

public class InputParser {

    public String[] parseUserNames(final String input, final String delimter) {
        return input.split(delimter);
    }

    public int parseInt(final String input) {
        return Integer.parseInt(input);
    }

}
