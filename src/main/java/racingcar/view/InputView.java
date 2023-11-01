package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Validator.Validator.validateNotBlank;

public class InputView {

    public InputView() {
    }

    public String getAllCarNames() {
        String input = Console.readLine();
        validateNotBlank(input);
        validateNotEndsWithComma(input);
        return input;
    }

    private void validateNotEndsWithComma(String input) {
        int namesLength = input.length();
        if (isEndWithComma(input, namesLength)) {
            throw new IllegalArgumentException(",로 끝나면 안됩니다.");
        }
    }

    private boolean isEndWithComma(String input, int inputLength) {
        return input.charAt(inputLength - 1) == ',';
    }

    public int getNumberOfRounds() {
        String input = Console.readLine();
        int number = convertInt(input);
        return number;
    }

    private int convertInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

}
