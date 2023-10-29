package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.CarNamesInputValidator;

public class Input {
    public String inputCarNames() {
        String carNamesInput = Console.readLine();
        CarNamesInputValidator.validate(carNamesInput);
        return carNamesInput;
    }

    public long inputAttemptCounts() {
        return Long.parseLong(Console.readLine());
    }
}
