package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Validator.Validator.validateNotBlank;
import static racingcar.Validator.Validator.validateNotEndsWithComma;


public class InputView {

    public InputView() {
    }

    public String carNames() {
        String input = Console.readLine();
        validateNotBlank(input);
        validateNotEndsWithComma(input);
        return input;
    }

    public int askForNumberOfRuns() {
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
