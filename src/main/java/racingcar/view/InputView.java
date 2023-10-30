package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputValidator;

public class InputView {

    public String readCarNames() {
        String carNames = Console.readLine();
        validate(carNames);
        return carNames;
    }

    public String readTrialNumber() {
        String trialNumber = Console.readLine();
        validate(trialNumber);
        return trialNumber;
    }

    private void validate(final String input) {
        InputValidator.validateBlank(input);
        InputValidator.validateNull(input);
    }

}
