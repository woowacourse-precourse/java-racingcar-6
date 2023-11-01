package racingcar.view;

import racingcar.domain.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input() {
    }

    public static String carNamesInput() {
        String carNames = Console.readLine();

        Validator.checkCarNames(carNames);
        return carNames;
    }

    public static int attemptCountInput() {
        int attemptCount = Integer.parseInt(Console.readLine());

        Validator.checkAttemptCount(attemptCount);
        return attemptCount;
    }
}
