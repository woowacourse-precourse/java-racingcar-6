package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

public class InputView {
    private final Validator validator;
    public InputView(Validator validator) {
        this.validator = validator;
    }

    public String carNamesInput() {
        String carNames = Console.readLine();
        validator.validateCarNameInput(carNames);
        return carNames;
    }
    public String numberOfAttemptsInput() {
        String numberOfAttempts = Console.readLine();
        validator.validateNumberOfAttemptsInput(numberOfAttempts);
        return numberOfAttempts;
    }
}
