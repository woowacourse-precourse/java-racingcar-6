package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Validator;

public class InputView {
    private final Validator validator = new Validator();

    public String carNameInput() {
        String carNames = Console.readLine();
        validator.validateCarNameInput(carNames);
        return carNames;
    }

    public String numberOfAttempsInput() {
        String numberOfAttemps = Console.readLine();
        validator.validatenumberOfAttempsInput(numberOfAttemps);
        return numberOfAttemps;
    }
}
