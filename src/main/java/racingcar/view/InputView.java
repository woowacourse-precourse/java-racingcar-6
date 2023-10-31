package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

public class InputView {

    private String[] inputNames;
    private int numberOfAttempts;

    public void setInputNames() {
        String input = userInput();
        String[] names = input.split(",");
        validateNames(names);
        this.inputNames = names;
    }

    public void setNumberOfAttempts() {
        String input = userInput();
        validateNumber(input);
        this.numberOfAttempts = Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        Validator.validateInputNumber(input);
        Validator.validateInputNumberZero(input);
    }

    private static void validateNames(String[] names) {
        for (String name : names) {
            Validator.validateInputSpace(name);
            Validator.validateInputLength(name);
        }
    }

    public String[] getInputNames() {
        return inputNames;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    private static String userInput() {
        return Console.readLine();
    }
}
