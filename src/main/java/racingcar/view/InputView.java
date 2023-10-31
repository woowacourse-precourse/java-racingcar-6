package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.utils.Utils;
import racingcar.validator.Validator;

public class InputView {
    public static int inputAttemptCount() {
        String attemptCount = Console.readLine();
        return Integer.parseInt(attemptCount);
    }

    public static List<String> inputCarName() {
        String carNames = Console.readLine();
        Validator.validateSeparatedByComma(carNames);

        List<String> separatedCarNames = Utils.splitAndToList(carNames);
        Validator.validateCarNameLength(separatedCarNames);

        return separatedCarNames;
    }
}
