package racingcar.view;

import racingcar.domain.Validator;
import racingcar.controller.RacingGame;
import racingcar.domain.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input() {
    }

    public static String carNamesInput() {
        String carNames = Console.readLine();
        Validator.checkCarNames(carNames);
        return carNames;
    }

    public static int attemptInput() {
        int numberOfAttempts = Integer.parseInt(Console.readLine());
        Validator.checkAttempt(numberOfAttempts);
        return numberOfAttempts;
    }
}
