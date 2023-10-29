package racingcar.view;

public class InputPreprocessor {

    public String[] splitInputByComma(String input) {
        return input.split(",");
    }

    public String trimInput(String input) {
        return input.trim();
    }
}
