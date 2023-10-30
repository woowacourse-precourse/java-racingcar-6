package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.AttemptCountsInputValidator;
import racingcar.utils.CarNamesInputValidator;

public class InputView {
    public String inputCarNames() {
        String carNamesInput = Console.readLine();
        CarNamesInputValidator.validate(carNamesInput);
        return carNamesInput;
    }

    public int inputAttemptCounts() {
        String attemptCounts = Console.readLine();
        AttemptCountsInputValidator.validate(attemptCounts);
        return Integer.parseInt(attemptCounts);
    }
}
