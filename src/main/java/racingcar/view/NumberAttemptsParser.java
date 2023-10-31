package racingcar.view;

public class NumberAttemptsParser implements InputParser {

    @Override
    public Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
