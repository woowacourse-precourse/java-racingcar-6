package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class InputView {
    private final InputValidator validator;

    public InputView(InputValidator validator) {
        this.validator = validator;
    }

    public String inputCarNames() {
        String carNames = Console.readLine();
        validator.validate(carNames);
        return carNames;
    }

    public String inputTryCount() {
        String tryCount = Console.readLine();
        validator.validate(tryCount);
        return tryCount;
    }
}
