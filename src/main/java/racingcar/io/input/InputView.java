package racingcar.io.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {

    public String inputCarNames() {
        String carNames = Console.readLine();
        InputValidator.validateDivisionCarNames(carNames);
        return carNames;
    }

    public String inputAttemptCount() {
        String attemptCount = Console.readLine();
        InputValidator.validateNumeric(attemptCount);
        return attemptCount;
    }
}
