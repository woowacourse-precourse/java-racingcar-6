package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

public class InputView {
    private static Validator validator;
    public InputView(Validator validator) {
        this.validator = validator;
    }

    public static String carNamesInput() {
        String carNames = Console.readLine();
        validator.validateCarNameInput(carNames);
        return carNames;
    }
    public static String numberOfAttemptsInput() {
        String numberOfAttempts = Console.readLine();
        validator.validateNumberOfAttemptsInput(numberOfAttempts);
        return numberOfAttempts;
    }
}
